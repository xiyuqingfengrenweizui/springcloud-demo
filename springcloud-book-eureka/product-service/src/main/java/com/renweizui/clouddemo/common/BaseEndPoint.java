package com.renweizui.clouddemo.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @PackageName:weizuiren.cloud.weizuirencloudsboot.common
 * @ClassName:BaseEndPoint
 * @Description:
 * @Author: justin zheng
 * @Date: 2019/9/23 13:40
 */
public class BaseEndPoint {

    protected Logger logger = LoggerFactory.getLogger(BaseEndPoint.class);

    protected DataResponse success() {
        return new DataResponse();
    }

    protected <T> DataResponse<T> success(T data) {
        return new DataResponse(data);
    }

}
