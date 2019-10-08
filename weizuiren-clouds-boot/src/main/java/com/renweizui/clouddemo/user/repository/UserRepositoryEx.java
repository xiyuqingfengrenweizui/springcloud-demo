package com.renweizui.clouddemo.user.repository;

import com.renweizui.clouddemo.user.entity.User;

import java.util.List;

/**
 * 用户信息RepositoryEx扩展接口
 *
 * @author weizuiren
 */
public interface UserRepositoryEx {

    List<User> findTopUser(int maxResult);

}
