package com.renweizui.clouddemo.user.service.impl;

import com.renweizui.clouddemo.user.dto.UserDto;
import com.renweizui.clouddemo.user.entity.User;
import com.renweizui.clouddemo.user.repository.UserRepository;
import com.renweizui.clouddemo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @PackageName:weizuiren.cloud.weizuirencloudsboot.user.service.impl
 * @ClassName:UserServiceImpl
 * @Description:
 * @Author: justin zheng
 * @Date: 2019/9/23 13:22
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> getPage(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }


    @Override
    public User load(Long id) {
        User user  = null;
        Optional<User> optionalUser = this.userRepository.findById(id);
        if(optionalUser.isPresent()){
            user = optionalUser.get();
        }
        return user;
//        return this.userRepository.findById(id).get();
    }

    @Override
    @Transactional
    public User save(UserDto userDto) {
        User user = this.load(userDto.getId());
        if (user == null) {
            user = new User();
        }
        user.setAvatar(userDto.getAvatar());
        user.setNickname(userDto.getNickname());
        return this.userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public List<User> findTopUser(int maxResult) {
        return this.userRepository.findTopUser(maxResult);
    }
}
