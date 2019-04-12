package cn.itsource.aigou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("cn.itsource.aigou.mapper")
@EnableFeignClients(basePackages ="cn.itsource.aigou.common")
public class ProductServiceApplication8012 {
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication8012.class);
    }
}
