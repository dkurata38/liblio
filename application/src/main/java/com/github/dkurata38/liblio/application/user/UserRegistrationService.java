package com.github.dkurata38.liblio.application.user;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.github.dkurata38.liblio.domain.user.MailAddress;
import com.github.dkurata38.liblio.domain.user.Password;
import com.github.dkurata38.liblio.domain.user.User;
import com.github.dkurata38.liblio.domain.user.UserId;
import com.github.dkurata38.liblio.domain.user.UserRepository;
import com.github.dkurata38.liblio.domain.user.Username;

@Service
@RequiredArgsConstructor
public class UserRegistrationService {
    private final UserRepository userRepository;

    public UserId register(@NonNull Username username, @NonNull Password password, @NonNull MailAddress mailAddress) {
        Optional<User> byUsername = Optional.ofNullable(userRepository.findByUsername(username));
        if (byUsername.isPresent()) {
            throw new IllegalArgumentException();
        }
        UserId userId = UserId.generate();
        User user = new User(userId, username, password, mailAddress);
        userRepository.create(user);
        return userId;
    }
}
