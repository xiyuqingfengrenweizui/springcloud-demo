package weizuiren.cloud.weizuirencloudsboot.user.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import weizuiren.cloud.weizuirencloudsboot.user.dto.UserDto;
import weizuiren.cloud.weizuirencloudsboot.user.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 获取用户信息的分页数据
     *
     * @param pageable 分页参数
     * @return 分页数据
     */
    Page<User> getPage(Pageable pageable);

    /**
     * 加载指定ID的用户信息
     *
     * @param id 用户主键
     * @return
     */
    User load(Long id);

    /**
     * 保存或更新用户信息
     *
     * @param userDto
     */
    User save(UserDto userDto);

    /**
     * 删除指定Id的用户信息
     *
     * @param id 所要删除的用户主键
     */
    void delete(Long id);

    /**
     * 查询前几个用户
     * @param maxResult
     * @return
     */
    List<User> findTopUser(int maxResult);


}
