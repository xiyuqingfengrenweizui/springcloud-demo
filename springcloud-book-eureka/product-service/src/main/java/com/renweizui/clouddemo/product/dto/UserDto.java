package com.renweizui.clouddemo.product.dto;

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

    public UserDto() {
    }

    public UserDto(Long id, String nickname, String avatar) {
        this.id = id;
        this.nickname = nickname;
        this.avatar = avatar;
    }

    @Override
    public String toString() {

        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }


}
