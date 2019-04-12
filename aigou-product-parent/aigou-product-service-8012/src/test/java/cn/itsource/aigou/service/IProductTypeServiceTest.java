package cn.itsource.aigou.service;

import cn.itsource.aigou.ProductServiceApplication8012;
import cn.itsource.aigou.domain.ProductType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductServiceApplication8012.class)
public class IProductTypeServiceTest {
    @Autowired
    private IProductTypeService productTypeService;
    @Test
    public void treeData() {
        List<ProductType> list = productTypeService.treeData();
        list.forEach(e-> System.out.println(e));
    }
}