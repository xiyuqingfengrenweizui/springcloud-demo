package renweiuzi.clouddemo.helloprovider.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author justin.zheng
 * @date 2019/10/8 14:12
 */
@Api
@RestController
@RequestMapping("/hello")
public class HelloProviderEndPoint {

    @ApiOperation(value = "hello",notes ="hello" ,httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "name",dataType = "String",paramType = "path",required = true)
    })
    @GetMapping(value = "/{name}")
    public String hello(@PathVariable String name){
        return String.format("Hello,%s-provider",name);
    }

}
