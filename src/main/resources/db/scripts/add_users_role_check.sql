ALTER TABLE users
ADD CONSTRAINT users_role_check
CHECK (role IN ('TEACHER', 'STUDENT'));