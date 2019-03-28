package cn.itsource.aigou.web.controller;

import cn.itsource.aigou.common.AjaxResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/plat")
public class PlatTestController {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public AjaxResult test(){
        Map<String,String> map = new HashMap<>();
        map.put("12","zz" );
        return AjaxResult.me().setSuccess(false).setMsg("失败").setObject(map);
    }
}
