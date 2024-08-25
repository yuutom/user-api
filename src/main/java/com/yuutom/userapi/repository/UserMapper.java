package com.yuutom.userapi.repository;

import com.yuutom.userapi.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    void insert(User user);
//    void insertSubscription(long topicId, long ownerPublisherId, long subscriberId);
    Optional<User> findById(String userId);
//    List<Topic> findByTopicName(String topicName);
//    boolean existsByTopicIdAndSubscriberId(long topicId, long ownerPublisherId, long subscriberId);
//    boolean isExistTopicSubscription(String topicName, long ownerPublisherId, long subscriberId);
}
