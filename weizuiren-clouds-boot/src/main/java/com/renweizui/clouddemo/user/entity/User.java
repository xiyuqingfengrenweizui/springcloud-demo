package com.renweizui.clouddemo.user.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 用户信息实体
 *
 * @PackageName:weizuiren.cloud.weizuirencloudsboot.user.entity
 * @ClassName:User
 * @Description:
 * @Author: justin zheng
 * @Date: 2019/9/23 10:05
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue
    /**用户id，数据库主键*/
    private Long id;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 用户头像
     */
    private String avatar;

    @Override
    public String toString() {

        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }


}
