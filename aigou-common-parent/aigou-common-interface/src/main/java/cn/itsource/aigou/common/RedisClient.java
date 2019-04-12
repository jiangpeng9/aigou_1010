package cn.itsource.aigou.common;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@RequestMapping("/common")
@FeignClient(value = "COMMON-PROVIDER",fallbackFactory = RedisClientCallBackFactory.class)
public interface RedisClient {
    @RequestMapping(value = "/redis",method = RequestMethod.POST)
    public void set(@RequestParam("key") String key, @RequestParam("value") String value);
    @RequestMapping(value = "/redis/{key}",method =RequestMethod.GET )
    public String get(@PathVariable("key") String key);
}
