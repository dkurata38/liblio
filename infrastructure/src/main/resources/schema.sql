DROP TABLE IF EXISTS "user";
CREATE TABLE "user"
(
    user_id      VARCHAR(255) PRIMARY KEY,
    username     VARCHAR(255) NOT NULL UNIQUE,
    password     VARCHAR(255) NOT NULL,
    mail_address VARCHAR(255) NOT NULL,
    created_at   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

DROP TABLE IF EXISTS library;
CREATE TABLE library
(
    library_id          VARCHAR(255) PRIMARY KEY,
    name                VARCHAR(255) NOT NULL,
    phone_number        VARCHAR(20),
    postal_code         VARCHAR(8)   NOT NULL,
    administrative_area VARCHAR(4)   NOT NULL,
    address_line        VARCHAR(255) NOT NULL,
    created_at          TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at          TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

DROP TABLE IF EXISTS librarian;
CREATE TABLE librarian
(
    librarian_id VARCHAR(255) PRIMARY KEY,
    library_id   VARCHAR(255) NOT NULL,
    username     VARCHAR(255) NOT NULL UNIQUE,
    password     VARCHAR(255) NOT NULL,
    created_at   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);


