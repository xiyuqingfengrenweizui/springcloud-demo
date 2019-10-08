package com.renweizui.clouddemo.user.repository.impl;

import com.renweizui.clouddemo.user.entity.User;
import com.renweizui.clouddemo.user.repository.UserRepositoryEx;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * 用户管理扩展实现，不需要增加@Component等注解
 * @PackageName:weizuiren.cloud.weizuirencloudsboot.user.repository.impl
 * @ClassName:UserRepositoryImpl
 * @Description:
 * @Author: justin zheng
 * @Date: 2019/9/23 12:59
 */
public class UserRepositoryImpl implements UserRepositoryEx {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findTopUser(int maxResult) {
        Query query = this.entityManager.createQuery("select u from User u", User.class);
        query.setMaxResults(maxResult);
        return query.getResultList();
    }
}
