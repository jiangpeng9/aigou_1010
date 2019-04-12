package cn.itsource.aigou.common.service;


import cn.itsource.aigou.common.AjaxResult;
import cn.itsource.aigou.document.ProductDoc;
import cn.itsource.aigou.utils.PageList;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

public interface IEsService  {
    void addOne(ProductDoc productDoc);

    void addAll(List<ProductDoc> productDocList);

    void delOne(Long id);

    void delAll();

    void findOne(Long id);

    PageList<ProductDoc> queryProducts(Map<String, String> params);
}
