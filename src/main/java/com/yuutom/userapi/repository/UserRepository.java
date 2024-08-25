package com.yuutom.userapi.repository;

import com.yuutom.userapi.entity.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
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

//    public List<Topic> findByTopicName(String topicName) {
//        return getMapper().findByTopicName(topicName);
//    }
//
//    public boolean existsTopicSubscription(long topicId, long ownerPublisherId, long subscriberId){
//        return getMapper().existsByTopicIdAndSubscriberId(topicId, ownerPublisherId, subscriberId);
//    }
//
//    public void insertSubscription(long topicId, long ownerPublisherId, long subscriberId){
//        getMapper().insertSubscription(topicId, ownerPublisherId, subscriberId);
//    }
//
//    public boolean isExistTopicSubscription(String topicName, long ownerPublisherId, long subscriberId) {
//        return getMapper().isExistTopicSubscription(topicName, ownerPublisherId, subscriberId);
//    }

    private UserMapper getMapper() {
        return this.sqlSessionTemplate.getMapper(UserMapper.class);
    }
}
