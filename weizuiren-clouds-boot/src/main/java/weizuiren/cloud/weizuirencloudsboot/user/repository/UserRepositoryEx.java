package weizuiren.cloud.weizuirencloudsboot.user.repository;

import weizuiren.cloud.weizuirencloudsboot.user.entity.User;

import java.util.List;

/**
 * 用户信息RepositoryEx扩展接口
 *
 * @author weizuiren
 */
public interface UserRepositoryEx {

    List<User> findTopUser(int maxResult);

}
