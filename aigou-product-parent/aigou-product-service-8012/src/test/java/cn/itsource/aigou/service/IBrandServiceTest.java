package cn.itsource.aigou.service;

import cn.itsource.aigou.ProductServiceApplication8012;
import cn.itsource.aigou.domain.Brand;
import cn.itsource.aigou.query.BrandQuery;
import cn.itsource.aigou.utils.PageList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductServiceApplication8012.class)
public class IBrandServiceTest {
    @Autowired
    private IBrandService brandService;
    @Test
    public void queryPage() {
        PageList<Brand> list = brandService.queryPage(new BrandQuery());
        list.getRows().forEach(e-> System.out.println(e));
    }
}