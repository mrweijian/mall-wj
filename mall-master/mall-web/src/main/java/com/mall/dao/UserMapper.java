package com.mall.dao;

import com.mall.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    UserEntity selectUser(String entity);
}
