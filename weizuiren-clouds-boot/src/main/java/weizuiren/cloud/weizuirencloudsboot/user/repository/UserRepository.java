package weizuiren.cloud.weizuirencloudsboot.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import weizuiren.cloud.weizuirencloudsboot.user.entity.User;

/**
 * 用户信息Repository
 *
 * @author weizuiren
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryEx {
}
