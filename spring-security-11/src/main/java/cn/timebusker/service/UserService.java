package cn.timebusker.service;

import cn.timebusker.model.UserEntity;

public interface UserService {

    boolean insert(UserEntity userEntity);

    UserEntity getByUsername(String username);
}
