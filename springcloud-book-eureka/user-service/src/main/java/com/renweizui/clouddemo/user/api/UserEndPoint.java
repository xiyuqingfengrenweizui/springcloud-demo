package com.renweizui.clouddemo.user.api;

import com.renweizui.clouddemo.common.BaseEndPoint;
import com.renweizui.clouddemo.common.DataResponse;
import com.renweizui.clouddemo.common.HttpMethod;
import com.renweizui.clouddemo.user.dto.UserDto;
import com.renweizui.clouddemo.user.entity.User;
import com.renweizui.clouddemo.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户管理的Endpoint
 *
 * @PackageName:weizuiren.cloud.weizuirencloudsboot.user.api
 * @ClassName:UserEndPoint
 * @Description:
 * @Author: justin zheng
 * @Date: 2019/9/23 13:24
 */
@Api(value = "UserEndPoint", description = "用户管理相关API")
@RestController
@RequestMapping(value = "/users")
public class UserEndPoint extends BaseEndPoint {


    //注入当前服务端口
    @Value("${server.port}")
    private int userServerPort = 0;

    @Autowired
    private UserService userService;

    /**
     * 获取用户分页数据
     *
     * @param pageable
     * @return
     */
    @ApiOperation(value = "获取用户分页数据", notes = "获取用户分页数据", httpMethod = HttpMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码，从0开始,默认为0表示第1页", dataType = "int", paramType = "query", required = false),
            @ApiImplicitParam(name = "size", value = "页容量,默认20", dataType = "int", paramType = "query", required = false),
            @ApiImplicitParam(name = "sort", value = "排序,格式为:prop,prop(,asc|desc)的方式组织，如sort=name&sort=nickname,desc", dataType = "String", paramType = "query", required = false)
    })
    @GetMapping(value = "")
    public DataResponse<List<UserDto>> findAll(Pageable pageable) {

        List<UserDto> list = new ArrayList<>();

        Page<User> page = this.userService.getPage(pageable);
        if (null != page) {
            list = page.getContent().stream().map(user -> new UserDto(user,userServerPort)).collect(Collectors.toList());
        }
        return this.success(list);

    }


    /**
     * 查询前几条数据
     *
     * @param num
     * @return
     */
    @ApiOperation(value = "查询前几条数据", notes = "查询前几条数据", httpMethod = HttpMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(defaultValue = "10", name = "num", value = "返回的条数", dataType = "int", paramType = "path", required = true)
    })
    @GetMapping(value = "/top/{num}")
    public DataResponse<List<UserDto>> findTopUser(@PathVariable int num) {

        List<UserDto> list = new ArrayList<>();

        List<User> topUser = this.userService.findTopUser(num);

        if (null != topUser && topUser.size() > 0) {
            list = topUser.stream().map(user->new UserDto(user,userServerPort)).collect(Collectors.toList());
        }
        return this.success(list);

    }

    /**
     * 获取用户详情
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "获取用户详情", notes = "获取用户详情", httpMethod = HttpMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户主键", name = "id", dataType = "int", paramType = "path", required = true)
    })
    @GetMapping(value = "/{id}")
    public DataResponse<UserDto> detail(@PathVariable Long id) {
        User user = this.userService.load(id);
        return this.success(null != user ? new UserDto(user,userServerPort) : null);
    }

    /**
     * 更新用户详情
     *
     * @param id
     * @param userDto
     * @return
     */
    @ApiOperation(value = "更新用户详情", notes = "更新用户详情", httpMethod = HttpMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户主键Id", dataType = "int", paramType = "path", required = true),
            @ApiImplicitParam(name = "userDto", value = "用户详情数据", dataType = "UserDto", paramType = "body", required = true)
    })
    @PostMapping("/{id}")
    public DataResponse<UserDto> update(@PathVariable Long id, @RequestBody UserDto userDto) {
        userDto.setId(id);
        User user = this.userService.save(userDto);
        return this.success(new UserDto(user,userServerPort));
    }


    //删除用户
    @ApiOperation(value = "删除指定Id的用户", notes = "删除指定Id的用户", httpMethod = HttpMethod.DELETE)
    @ApiImplicitParams(
            @ApiImplicitParam(value = "所要删除的用户的主键", name = "id", dataType = "int", paramType = "path", required = true)
    )
    @DeleteMapping(value = "/{id}")
    public DataResponse delete(@PathVariable(value = "id") Long id) {
        this.userService.delete(id);
        return this.success();
    }


}
