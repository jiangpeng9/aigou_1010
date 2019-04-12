package cn.itsource.aigou.common;

import cn.itsource.aigou.document.ProductDoc;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EsClientCallBackFactory implements FallbackFactory<EsClient> {
    @Override
    public EsClient create(Throwable throwable) {
        return new EsClient() {
            @Override
            public AjaxResult addOne(ProductDoc productDoc) {
                return null;
            }

            @Override
            public AjaxResult addAll(List<ProductDoc> productDocList) {
                return null;
            }

            @Override
            public AjaxResult delOne(Long id) {
                return null;
            }

            @Override
            public AjaxResult delAll() {
                return null;
            }

            @Override
            public AjaxResult findOne(Long id) {
                return null;
            }
        };
    }
}