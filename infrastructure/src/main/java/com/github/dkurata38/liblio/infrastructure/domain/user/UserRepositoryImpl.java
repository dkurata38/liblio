package com.github.dkurata38.liblio.infrastructure.domain.user;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.github.dkurata38.liblio.domain.user.MailAddress;
import com.github.dkurata38.liblio.domain.user.Password;
import com.github.dkurata38.liblio.domain.user.User;
import com.github.dkurata38.liblio.domain.user.UserId;
import com.github.dkurata38.liblio.domain.user.UserRepository;
import com.github.dkurata38.liblio.domain.user.Username;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserRecordMapper userRecordMapper;

    @Override
    public Optional<User> findByUsername(@NonNull Username username) {
        return Optional.ofNullable(userRecordMapper.selectByUsername(username.getValue()))
            .map(this::from);
    }

    @Override
    public void create(@NonNull User user) {
        userRecordMapper.insert(from(user));
    }

    User from(UserRecord userRecord) {
        return new User(
            new UserId(userRecord.getUserId()),
            new Username(userRecord.getUsername()),
            new Password(userRecord.getPassword()),
            new MailAddress(userRecord.getMailAddress())
        );
    }

    UserRecord from(User user) {
        UserRecord userRecord = new UserRecord();
        userRecord.setUserId(user.getUserId().getValue());
        userRecord.setUsername(user.getUsername().getValue());
        userRecord.setPassword(user.getPassword().getValue());
        userRecord.setMailAddress(user.getMailAddress().getValue());
        return userRecord;
    }
}
