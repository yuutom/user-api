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

    public User updateUser(String userId, String password, String nickname, String comment, String userIdPathParam) {
        if (!userId.equals(userIdPathParam)) {
            throw new NoPermissionException("no permission update");
        }
        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isEmpty()) {
            throw new UserNotExistException("not exist user");
        }
        User user = new User(){{
            setUserId(userId);
            setPassword(password);
            setNickname(nickname);
            setComment(comment);
        }};
        userRepository.update(user);
        return user;
    }

    public void deleteUser(String userId, String password) {
        User user = new User(){{
            setUserId(userId);
            setPassword(password);
            setNickname(userId);
        }};
        userRepository.delete(user);
    }

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

    public static class NoPermissionException extends RuntimeException {
        public NoPermissionException(String message) {
            super(message);
        }
    }
}
