package cn.itsource.aigou.common.repository;

import cn.itsource.aigou.document.ProductDoc;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EsRepository extends ElasticsearchRepository<ProductDoc,Long> {
}
