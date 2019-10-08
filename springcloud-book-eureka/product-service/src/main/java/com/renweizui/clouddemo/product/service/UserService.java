package com.renweizui.clouddemo.product.service;

import com.renweizui.clouddemo.common.DataResponse;
import com.renweizui.clouddemo.product.dto.UserDto;
import com.renweizui.clouddemo.product.service.impl.fallback.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 用户服务
 *
 * @author justin.zheng
 * @date 2019/10/8 21:03
 */
@FeignClient(value = "user-service",fallback = UserServiceFallback.class)
public interface UserService {

    @GetMapping("/users/{id}")
    DataResponse<UserDto> load(@PathVariable Long id);

}
