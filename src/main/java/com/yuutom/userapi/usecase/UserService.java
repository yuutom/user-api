package com.yuutom.userapi.usecase;

import com.yuutom.userapi.entity.User;
import com.yuutom.userapi.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User create(String userId, String password) {
        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isPresent()) {
            throw new DuplicateUserException("duplicate user" + existingUser.get().getUserId());
        }
        User user = new User(){{
            setUserId(userId);
            setPassword(password);
            setNickname(userId);
        }};
        userRepository.insert(user);
        return user;
    }

    public User getUser(String userId, String password) {
        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isEmpty()) {
            throw new UserNotExistException("not exist user");
        }
        return existingUser.get();
    }

//    public Topic subscribe(long ownerPublisherId, String topicName, long subscriberId) {
//        Topic targetTopic = topicRepository.findByPublisherIdAndTopicName(ownerPublisherId, topicName)
//            .orElseThrow(() -> new TopicNotExistException("The target topic does not exist."));
//
//        boolean hasAlreadyExists = topicRepository.existsTopicSubscription(targetTopic.getTopicId(), targetTopic.getOwnerPublisherId(), subscriberId);
//        if (hasAlreadyExists) {
//            throw new DuplicateSubscriptionException("Subscription already exists");
//        }
//
//        topicRepository.insertSubscription(targetTopic.getTopicId(), targetTopic.getOwnerPublisherId(), subscriberId);
//        return targetTopic;
//    }

    public static class DuplicateUserException extends RuntimeException {
        public DuplicateUserException(String message) {
            super(message);
        }
    }

    public static class UserNotExistException extends RuntimeException {
        public UserNotExistException(String message) {
            super(message);
        }
    }

    public static class DuplicateSubscriptionException extends RuntimeException {
        public DuplicateSubscriptionException(String message) {
            super(message);
        }
    }

    public static class UnauthorizedTopicException extends RuntimeException {
        public UnauthorizedTopicException(String message) {
            super(message);
        }
    }

    public static class NotSubscribeTopicException extends RuntimeException {
        public NotSubscribeTopicException(String message) {
            super(message);
        }
    }
}
