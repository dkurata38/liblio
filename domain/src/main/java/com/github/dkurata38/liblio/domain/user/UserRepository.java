package com.github.dkurata38.liblio.domain.user;

import java.util.Optional;

public interface UserRepository {
    /**
     * @param username not {@code null}
     * @return user
     */
    Optional<User> findByUsername(Username username);

    /**
     * @param user not {@code null}
     */
    void create(User user);
}
