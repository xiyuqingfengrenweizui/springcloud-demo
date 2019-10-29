package com.renweizui.clouddemo.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * JWTToken用户认证校验过滤器
 *
 * @author justin.zheng
 * @date 2019/10/29 10:54
 */
@Component
public class JWTTokenFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(JWTTokenFilter.class);

    private static final int FILTER_ORDER = 1;
    private static final String FILTER_TYPE = "pre";

    /**
     * 返回过滤器类型
     *
     * @return pre
     */
    @Override
    public String filterType() {
        return FILTER_TYPE;
    }

    /**
     * 返回过滤器执行顺序，值越小约早执行
     *
     * @return 1
     */
    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    /**
     * 返回是否执行run方法，true执行，false不执行
     *
     * @return true, 始终过滤
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器需要执行的业务
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //实现过滤逻辑
        this.parseJWTToken();
        return null;
    }

    /**
     * 具体的JWT Token解析及校验
     */
    private void parseJWTToken() {
        logger.info("====parseJWTToken============");

//        throw new RuntimeException("error");
    }



}
