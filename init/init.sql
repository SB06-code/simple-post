CREATE TABLE post (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    author VARCHAR(255) NOT NULL,
    title VARCHAR(50) NOT NULL,
    content VARCHAR(1000) NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    view_count INTEGER NOT NULL DEFAULT 0
);

CREATE TABLE post_tags (
    post_id BIGINT NOT NULL,
    tag VARCHAR(255),
    CONSTRAINT fk_post_tags_on_post
        FOREIGN KEY (post_id)
            REFERENCES post (id)
);