package cn.itsource.common;

import cn.itsource.aigou.common.CommonApplication8022;
import cn.itsource.aigou.common.repository.EsRepository;
import cn.itsource.aigou.document.ProductDoc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CommonApplication8022.class)
public class EsTest {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Test
    public void jTest()throws Exception{
        //创建索引 做映射
        elasticsearchTemplate.createIndex(ProductDoc.class);
        //做映射
        elasticsearchTemplate.putMapping(ProductDoc.class);
    }
}
