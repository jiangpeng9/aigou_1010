package cn.itsource.aigou.common;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/common")
@FeignClient(value = "COMMON-PROVIDER",fallbackFactory = PageClientCallBackFactory.class)
public interface PageClient {
    @RequestMapping(value = "page",method = RequestMethod.POST)
    public void creatPage(@RequestBody Map<String,Object> params);
}
