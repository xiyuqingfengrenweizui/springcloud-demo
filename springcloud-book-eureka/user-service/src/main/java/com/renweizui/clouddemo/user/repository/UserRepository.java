package com.renweizui.clouddemo.user.repository;

import com.renweizui.clouddemo.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户信息Repository
 *
 * @author weizuiren
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryEx {
}
