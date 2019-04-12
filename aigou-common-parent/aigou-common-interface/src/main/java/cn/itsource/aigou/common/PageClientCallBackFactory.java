package cn.itsource.aigou.common;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PageClientCallBackFactory implements FallbackFactory<PageClient> {
    @Override
    public PageClient create(Throwable throwable) {
        return new PageClient() {
            @Override
            public void creatPage(Map<String, Object> params) {

            }
        };
    }
}
