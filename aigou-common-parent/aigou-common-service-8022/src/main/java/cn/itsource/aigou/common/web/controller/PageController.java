package cn.itsource.aigou.common.web.controller;

import cn.itsource.aigou.common.PageClient;
import cn.itsource.aigou.common.util.VelocityUtils;
import cn.itsource.aigou.constant.GlobalConstant;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/common")
@RestController
public class PageController implements PageClient {

    @Override
    @RequestMapping(value = "/page",method = RequestMethod.POST)
    public void creatPage(@RequestBody Map<String, Object> params) {
        //调用工具类方法
        //    public static final String MODEL_DATA="model_data";
        //    //String templateFilePathAndName, String targetFilePathAndName 模板的路径
        //    public static final String TEMPLATE_PATH="template_path";
        //    public static final String TARGET_PATH="target_path";
        Object model_data = params.get(GlobalConstant.MODEL_DATA);
        String template_path = (String) params.get(GlobalConstant.TEMPLATE_PATH);
        String target_path = (String) params.get(GlobalConstant.TARGET_PATH);
        VelocityUtils.staticByTemplate(model_data, template_path, target_path);
    }
}
