package com.yuutom.userapi.repository;

import com.yuutom.userapi.entity.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {
    private final SqlSessionTemplate sqlSessionTemplate;
    public UserRepository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public void insert(User user) {
        getMapper().insert(user);
    }

    public Optional<User> findById(String userId){
        return getMapper().findById(userId);
    }

    public void update(User user) {
        getMapper().update(user);
    }

    public void delete(User user) {
        getMapper().delete(user);
    }

    private UserMapper getMapper() {
        return this.sqlSessionTemplate.getMapper(UserMapper.class);
    }
}
