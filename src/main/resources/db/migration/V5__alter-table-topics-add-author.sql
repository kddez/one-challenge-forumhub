ALTER TABLE topics
ADD author_id BIGINT,
ADD CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES users(user_id);
