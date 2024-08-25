package com.yuutom.userapi.repository;

import com.yuutom.userapi.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {
    void insert(User user);
    Optional<User> findById(String userId);

    int update(User user);

    void delete(User user);
}
