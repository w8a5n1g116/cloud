package net.stopno.service;

import net.stopno.domain.CommonResult;
import net.stopno.domain.User;
import net.stopno.service.impl.UserServiceFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "user-service",fallback = UserServiceFallbackImpl.class)
public interface UserService {

    @PostMapping("/user/create")
    CommonResult create(@RequestBody User user);

    @GetMapping("/user/{id}")
    CommonResult<User> getUser(@PathVariable String id);

    @GetMapping("/user/getUserByIds")
    CommonResult<List<User>> getUserByIds(@RequestParam List<String> ids) ;

    @GetMapping("/user/getByUsername")
    CommonResult<User> getByUsername(@RequestParam String username);

    @PostMapping("/user/update")
    CommonResult update(@RequestBody User user);

    @PostMapping("/user/delete/{id}")
    CommonResult delete(@PathVariable String id);

}
