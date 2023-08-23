CREATE TABLE IF NOT EXISTS users (
    id VARCHAR(36) PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_groups (
    id VARCHAR(36) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_group_membership (
    user_id VARCHAR(36) NOT NULL,
    group_id VARCHAR(36) NOT NULL,
    PRIMARY KEY (user_id, group_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (group_id) REFERENCES user_groups(id)
);

CREATE TABLE IF NOT EXISTS group_user_membership (
    group_id VARCHAR(36) NOT NULL,
    user_id VARCHAR(36) NOT NULL,
    PRIMARY KEY (group_id, user_id),
    FOREIGN KEY (group_id) REFERENCES user_groups(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS group_attributes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    group_id VARCHAR(36) NOT NULL,
    attribute_key VARCHAR(255) NOT NULL,
    attribute_value VARCHAR(255) NOT NULL,
    FOREIGN KEY (group_id) REFERENCES user_groups(id)
);

CREATE TABLE IF NOT EXISTS user_attributes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(36) NOT NULL,
    attribute_key VARCHAR(255) NOT NULL,
    attribute_value VARCHAR(255) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);



INSERT INTO users (id, name)
VALUES ('1B5D1E9A-16C2-4E40-AC3A-3B0F14E40C05', 'edin');

INSERT INTO user_attributes (user_id, attribute_key, attribute_value)
VALUES ('1B5D1E9A-16C2-4E40-AC3A-3B0F14E40C05', 'level', 'admin');
