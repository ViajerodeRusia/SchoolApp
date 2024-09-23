CREATE TABLE grades (
    id SERIAL PRIMARY KEY,
    student_id BIGINT NOT NULL,
    attendance_score INT NOT NULL,
    participation_score INT NOT NULL,
    term VARCHAR(255) NOT NULL,
    CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES students(id)
);