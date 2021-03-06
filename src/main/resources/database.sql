-- Table: users
CREATE TABLE users (
    id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
)
    ENGINE = InnoDB;

-- Table: roles
CREATE TABLE roles (
    id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
)
    ENGINE = InnoDB;

-- Table for mapping user and roles: user_roles
CREATE TABLE user_roles (
    user_id INT NOT NULL,
    role_id INT NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id),

    UNIQUE (user_id, role_id)
)
    ENGINE = InnoDB;

-- Insert data

INSERT INTO users VALUES (1, 'admin', 'admin', 35, 'admin@mail.ru', 'admin');
INSERT INTO users VALUES (2, 'user', 'user', 30, 'user@mail.ru', 'user');

INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_roles VALUES (1, 1);
INSERT INTO user_roles VALUES (1, 2);
INSERT INTO user_roles VALUES (2, 1);