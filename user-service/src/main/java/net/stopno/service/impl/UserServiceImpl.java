package net.stopno.service.impl;

import net.stopno.domain.User;
import net.stopno.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    public static final List<User> USERS = new ArrayList<User>(){{
        this.add(new User("1","1"));
        this.add(new User("2","2"));
        this.add(new User("3","3"));
        this.add(new User("4","4"));
        this.add(new User("5","5"));
        this.add(new User("6","6"));
        this.add(new User("7","7"));
    }};

    @Override
    public void create(User user) {
        USERS.add(user);
    }

    @Override
    public List<User> getUserByIds(List<String> ids) {
        return USERS.stream().filter(u -> ids.contains(u.getId())).collect(Collectors.toList());
    }

    @Override
    public User getByUsername(String name) {
        return StringUtils.isNotEmpty(name)?
                USERS.stream().filter(u -> name.equals(u.getName())).findFirst().get():
                null;
    }

    @Override
    public void update(User user) {
        if(user != null){
            User origin_user = USERS.stream().filter(u -> user.getId().equals(u.getId())).findFirst().get();
            USERS.add(user);
            USERS.remove(origin_user);
        }
    }

    @Override
    public void delete(String id) {
        if(StringUtils.isNotEmpty(id)){
            User origin_user = USERS.stream().filter(u -> id.equals(u.getId())).findFirst().get();
            USERS.remove(origin_user);
        }
    }

    @Override
    public User getUser(String id) {
        if(StringUtils.isNotEmpty(id)){
            User origin_user = USERS.stream().filter(u -> id.equals(u.getId())).findFirst().get();
            return origin_user;
        }
        return null;
    }
}
