package net.stopno.service;

import net.stopno.domain.CommonResult;
import net.stopno.domain.User;

import java.util.concurrent.Future;

public interface UserService {

    CommonResult<User> getUser(String id);

    CommonResult<User> getUserException(String id);

    CommonResult<User> getUserCommand(String id);

    CommonResult<User> getUserCache(String id);

    CommonResult<User> removeCache(String id);

    Future<User> getUserFuture(String id);

}
