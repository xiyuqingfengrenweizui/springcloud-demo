package renweizui.clouddemo.helloconsumer.api;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import renweizui.clouddemo.helloconsumer.service.HelloConsumerService;

/**
 * @author justin.zheng
 * @date 2019/10/8 14:30
 */
@RestController
@RequestMapping("/hello")
public class HelloConsumerEndPoint {

    @Autowired
    private HelloConsumerService helloConsumerService;

    @ApiOperation(value = "hello", notes = "hello", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "参数", dataType = "String", paramType = "path", required = true)
    })
    @GetMapping(value = "/{name}")
    public String hello(@PathVariable String name) {
        return helloConsumerService.hello(name);
//        return String.format("Hello,%s -hello-consumer", name);
    }

}
