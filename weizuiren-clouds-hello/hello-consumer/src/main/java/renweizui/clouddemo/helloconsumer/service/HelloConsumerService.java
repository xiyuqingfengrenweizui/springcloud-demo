package renweizui.clouddemo.helloconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import renweizui.clouddemo.helloconsumer.service.fallback.HelloConsumerServiceFallback;

/**
 * @author justin.zheng
 * @date 2019/10/8 14:36
 */
@FeignClient(value = "hello-provider",fallback = HelloConsumerServiceFallback.class)
public interface HelloConsumerService {

    @GetMapping(value = "/hello/{name}")
    String hello(@PathVariable String name);
}
