CREATE TABLE topics (
    topic_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL UNIQUE,
    message TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50),
    course_id BIGINT,
    FOREIGN KEY (course_id) REFERENCES courses(course_id),
    UNIQUE KEY unique_message (message(255))
);
