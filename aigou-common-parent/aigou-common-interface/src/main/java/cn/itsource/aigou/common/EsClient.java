package cn.itsource.aigou.common;

import cn.itsource.aigou.document.ProductDoc;
import cn.itsource.aigou.utils.PageList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@RequestMapping("/common")
@FeignClient(value = "COMMON-PROVIDER",fallbackFactory = EsClientCallBackFactory.class)
public interface EsClient {
    @RequestMapping(value = "/es",method = RequestMethod.POST)
    AjaxResult addOne(@RequestBody ProductDoc productDoc);

    @RequestMapping(value = "/esall",method = RequestMethod.POST)
    AjaxResult addAll(@RequestBody List<ProductDoc> productDocList);

    @RequestMapping(value = "/es/{id}",method = RequestMethod.DELETE)
    AjaxResult delOne(@PathVariable("id") Long id);

    @RequestMapping(value = "/esall",method = RequestMethod.DELETE)
    AjaxResult delAll();

    @RequestMapping(value = "/es/{id}",method = RequestMethod.GET)
    AjaxResult findOne(@PathVariable("id") Long id);

    @RequestMapping(value = "/queryProducts",method = RequestMethod.POST)
    PageList<ProductDoc> queryProducts(@RequestBody Map<String, String> params);
}
