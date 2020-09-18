package net.stopno.service.impl;

import net.stopno.domain.CommonResult;
import net.stopno.domain.User;
import net.stopno.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceFallbackImpl implements UserService {


    @Override
    public CommonResult create(User user) {
        User defaultUser = new User("-1", "defaultUser");
        return new CommonResult<>(defaultUser);
    }

    @Override
    public CommonResult<User> getUser(String id) {
        User defaultUser = new User("-1", "defaultUser");
        return new CommonResult<>(defaultUser);
    }

    @Override
    public CommonResult<List<User>> getUserByIds(List<String> ids) {
        User defaultUser = new User("-1", "defaultUser");
        return new CommonResult<List<User>>(new ArrayList<User>(){{this.add(defaultUser);}});
    }

    @Override
    public CommonResult<User> getByUsername(String username) {
        User defaultUser = new User("-1", "defaultUser");
        return new CommonResult<>(defaultUser);
    }

    @Override
    public CommonResult update(User user) {
        return new CommonResult("调用失败，服务被降级",500);
    }

    @Override
    public CommonResult delete(String id) {
        return new CommonResult("调用失败，服务被降级",500);
    }
}
