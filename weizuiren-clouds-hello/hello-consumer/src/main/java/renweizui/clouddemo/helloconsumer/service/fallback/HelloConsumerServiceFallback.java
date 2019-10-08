package renweizui.clouddemo.helloconsumer.service.fallback;

import org.springframework.stereotype.Component;
import renweizui.clouddemo.helloconsumer.service.HelloConsumerService;

/**
 * HelloConsumerService降级实现
 * @author justin.zheng
 * @date 2019/10/8 14:38
 */
@Component
public class HelloConsumerServiceFallback implements HelloConsumerService {
    @Override
    public String hello(String name) {
        return String.format("Hello,%s!-fallback",name);
    }
}
