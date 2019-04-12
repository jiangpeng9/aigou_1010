package cn.itsource.aigou.common.service.impl;

import cn.itsource.aigou.common.repository.EsRepository;
import cn.itsource.aigou.common.service.IEsService;
import cn.itsource.aigou.document.ProductDoc;
import cn.itsource.aigou.utils.PageList;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EsServiceImpl implements IEsService {
    @Autowired
    private EsRepository esRepository;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Override
    public void addOne(ProductDoc productDoc) {
        esRepository.save(productDoc);
    }

    @Override
    public void addAll(List<ProductDoc> productDocList) {
        esRepository.saveAll(productDocList);
    }

    @Override
    public void delOne(Long id) {
        esRepository.deleteById(id);
    }

    @Override
    public void delAll() {
        esRepository.deleteAll();
    }

    @Override
    public void findOne(Long id) {
        esRepository.findById(id);
    }

    @Override
    public PageList<ProductDoc> queryProducts(Map<String, String> params) {
        //获取params参数
        Long brandId = Long.valueOf(params.get("brandId"));
        String keyword = params.get("keyword");
        Long priceMax = Long.valueOf(params.get("priceMax"));
        Integer page = Integer.valueOf(params.get("page"));
        Long priceMin = Long.valueOf(params.get("priceMin"));
        Long productType = Long.valueOf(params.get("productType"));
        Integer rows = Integer.valueOf(params.get("rows"));
        String sortField = params.get("sortField");
        String sortType = params.get("sortType");
        //创建一个QueryBuilder
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        //设置条件
        //得到一个Query 执行查询
        //query
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

        boolQueryBuilder.must(QueryBuilders.matchQuery("all",keyword ));
        List<QueryBuilder> filter = boolQueryBuilder.filter();
        filter.add(QueryBuilders.termQuery("productTypeId", productType));
        filter.add(QueryBuilders.termQuery("brandId", brandId));
        String priceMax1=params.get("priceMax");
        Long priceMax =null;
        if (!StringUtils.isEmpty(priceMax1)){
            priceMax = Long.valueOf(priceMax1);
        }
        String priceMin1=params.get("priceMin");
        Long priceMin =null;
        if (!StringUtils.isEmpty(priceMin1)){
            priceMin = Long.valueOf(priceMin1);
        }
        if (priceMax!=null&&priceMin!=null){
            if (priceMax <0){
                priceMax=0L;
            }
            if (priceMin <0){
                priceMin=0L;
            }
            filter.add(QueryBuilders.rangeQuery("minPrice").lte(priceMin));
            filter.add(QueryBuilders.rangeQuery("maxPrice").gte(priceMax));
        }

        builder.withQuery(boolQueryBuilder);

        //sort
        String esFieldSort="saleCount";
        if(!StringUtils.isEmpty(esFieldSort)){
            switch (sortField) {
                case "xl":
                    esFieldSort = "saleCount";
                    break;
                case "xp":
                    esFieldSort = "onSaleTime";
                    break;
                case "pl":
                    esFieldSort = "commentCount";
                    break;
                case "rq":
                    esFieldSort = "viewCount";
                    break;
                case "jg":
                    esFieldSort = "minPrice";
                    break;
                    default:
                        esFieldSort="saleCount";
            }
        }
        SortOrder sortTypeEs=SortOrder.ASC;
        if(!StringUtils.isEmpty(sortType)){
            if (sortType.equals("desc")){
                sortTypeEs=SortOrder.DESC;
            }
        }
        builder.withSort(SortBuilders.fieldSort(esFieldSort).order(sortTypeEs));
        //from
        //size
        builder.withPageable(PageRequest.of(page-1,rows ));
        NativeSearchQuery build = builder.build();

        AggregatedPage<ProductDoc> employees = elasticsearchTemplate.queryForPage(build, ProductDoc.class);
        List<ProductDoc> content = employees.getContent();
        PageList<ProductDoc> pageList = new PageList<>();
        pageList.setRows(content);
        pageList.setTotal(employees.getTotalElements());
        return pageList;
    }
}
