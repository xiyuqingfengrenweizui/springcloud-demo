package com.renweizui.clouddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableZuulProxy
@EnableSwagger2
@SpringBootApplication
public class ZuulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class, args);
    }

//    /**
//     * 自定义路由规则
//     * 将 servicename-vx -> /vx/servicename
//     * @return
//     */
//    @Bean
//    public PatternServiceRouteMapper serviceRouteMapper(){
////        String pattern = "servicename-v1";
//        //将
//        String pattern = "(?<name>^.+)-(?<version>v.+$)";
//        String route ="{version}/${name}";
//        return new PatternServiceRouteMapper(pattern,route);
//    }

}
