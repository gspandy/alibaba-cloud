package com.springframework.user.api.impl;

import com.springframework.user.api.UserServiceRemote;
import com.springframework.user.api.domain.dto.UserDTO;
import com.springframework.user.api.domain.vo.UserVO;
import com.springframework.user.domain.po.UserDO;
import com.springframework.user.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author summer
 * 2018/11/20
 */
@RestController
public class UserServiceRemoteImpl implements UserServiceRemote {

    private final UserService userService;

    @Autowired
    public UserServiceRemoteImpl(UserService userService) {
        this.userService = userService;
    }

    /**
     * @param username 根据用户名查询用户信息
     * @return
     */
    @Override
    public UserVO getByUserName(@RequestParam("username") String username) {
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        UserDO byUserName = userService.getByUserName(username);
        if (Objects.nonNull(byUserName)) {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(byUserName, userVO);
            return userVO;
        }
        return null;
    }
}