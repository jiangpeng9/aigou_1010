package cn.itsource.aigou.common.web.controller;

import cn.itsource.aigou.common.AjaxResult;
import cn.itsource.aigou.common.EsClient;
import cn.itsource.aigou.common.service.IEsService;
import cn.itsource.aigou.document.ProductDoc;
import cn.itsource.aigou.utils.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/common")
public class EsController implements EsClient{
    @Autowired
    private IEsService esService;


    @Override
    @RequestMapping(value = "/es",method = RequestMethod.POST)
    public AjaxResult addOne(@RequestBody ProductDoc productDoc){
        try {
            esService.addOne(productDoc);
            return AjaxResult.me().setMsg("上架成功");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return AjaxResult.me().setMsg("上架失败").setSuccess(false);
        }
    }
    @Override
    @RequestMapping(value = "/esall",method = RequestMethod.POST)
    public AjaxResult addAll(@RequestBody List<ProductDoc> productDocList){
        try {
            esService.addAll(productDocList);
            return AjaxResult.me().setMsg("上架成功");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return AjaxResult.me().setMsg("上架失败").setSuccess(false);
        }
    }
    @Override
    @RequestMapping(value = "/es/{id}",method = RequestMethod.DELETE)
    public AjaxResult delOne(@PathVariable("id") Long id){
        try {
            esService.delOne(id);
            return AjaxResult.me().setMsg("下架成功");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return AjaxResult.me().setMsg("下架失败").setSuccess(false);
        }
    }
    @Override
    @RequestMapping(value = "/esall",method = RequestMethod.DELETE)
    public AjaxResult delAll(){
        try {
            esService.delAll();
            return AjaxResult.me().setMsg("下架成功");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return AjaxResult.me().setMsg("下架失败").setSuccess(false);
        }
    }
    @Override
    @RequestMapping(value = "/es/{id}",method = RequestMethod.GET)
    public AjaxResult findOne(@PathVariable("id") Long id){
        try {
            esService.findOne(id);
            return AjaxResult.me().setMsg("操作成功");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return AjaxResult.me().setMsg("操作失败").setSuccess(false);
        }
    }
    @RequestMapping(value = "/queryProducts",method = RequestMethod.POST)
    @Override
    public PageList<ProductDoc> queryProducts(@RequestBody Map<String, String> params) {

        return esService.queryProducts(params);
    }
}
