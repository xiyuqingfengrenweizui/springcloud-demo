package com.renweizui.clouddemo.product.service.impl.fallback;

import com.renweizui.clouddemo.common.DataResponse;
import com.renweizui.clouddemo.product.dto.UserDto;
import com.renweizui.clouddemo.product.service.UserService;
import org.springframework.stereotype.Component;

/**
 * UserService降级实现
 *
 * @author justin.zheng
 * @date 2019/10/8 21:06
 */
@Component
public class UserServiceFallback implements UserService {
    @Override
    public DataResponse<UserDto> load(Long id) {
        UserDto userDto = new UserDto(0L,"nickname","/猪.png",0);
        return new DataResponse<>(userDto);
    }
}
