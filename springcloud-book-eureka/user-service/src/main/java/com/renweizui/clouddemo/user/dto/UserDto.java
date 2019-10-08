package com.renweizui.clouddemo.user.dto;

import com.renweizui.clouddemo.user.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * 用户信息包
 *
 * @author weizuiren
 */
@ApiModel
@Getter
@Setter
@NoArgsConstructor
public class UserDto implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户id，数据库主键
     */
    @ApiModelProperty(value = "用户主键Id")
    private Long id;
    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称")
    private String nickname;
    /**
     * 用户头像
     */
    @ApiModelProperty(value = "用户头像")
    private String avatar;

    /**
     * 数据来源端口，用于测试ribbon
     */
    @ApiModelProperty(value = "数据来源端口")
    private int userServicePort;

    public UserDto(User user,int userServicePort) {
        if (null != user) {
            this.id = user.getId();
            this.avatar = user.getAvatar();
            this.nickname = user.getNickname();
            this.userServicePort = userServicePort;
        }
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", userServicePort='" + userServicePort + '\'' +
                '}';
    }
}
