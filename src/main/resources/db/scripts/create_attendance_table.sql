CREATE TABLE attendance (
    id SERIAL PRIMARY KEY,
    student_id BIGINT NOT NULL,
    date DATE NOT NULL,
    status VARCHAR(50) NOT NULL,
    CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES students(id)
);