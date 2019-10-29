package com.renweizui.clouddemo.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * zuul全局异常处理过滤器
 *
 * @author justin.zheng
 * @date 2019/10/29 11:38
 */
@Component
public class GlobalExceptionFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionFilter.class);

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //核心就是将错误信息设置到RequestContext中
        RequestContext requestContext = RequestContext.getCurrentContext();

        Throwable throwable = requestContext.getThrowable();
        logger.error("[GlobalExceptionFilter] error message:{}", throwable.getCause().getMessage());

        requestContext.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        requestContext.set("error.exception", throwable.getCause());
        return null;
    }
}
