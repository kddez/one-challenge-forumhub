create table replies(

        reply_id BIGINT AUTO_INCREMENT PRIMARY KEY,
        message VARCHAR(255) NOT NULL,
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        topic_id BIGINT,
        FOREIGN KEY (topic_id) REFERENCES topics(topic_id)

)