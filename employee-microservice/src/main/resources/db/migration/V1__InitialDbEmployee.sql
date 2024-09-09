

CREATE TYPE role_enum AS ENUM ('CLIENT', 'MANAGER', 'RECEPTIONIST');

CREATE TABLE position
(
    position_id UUID PRIMARY KEY,
    description   VARCHAR(150)   NOT NULL,
    weekly_salary DECIMAL(10, 2) NOT NULL
);

CREATE TABLE employee
(
    employee_id UUID PRIMARY KEY,
    fullname   VARCHAR(150) NOT NULL,
    email      VARCHAR(150) NOT NULL UNIQUE,
    position_id UUID,
    establishment_id UUID,
    entry_date DATE         NOT NULL,
    status     VARCHAR(50)  NOT NULL,
    username   VARCHAR(100) NOT NULL UNIQUE,
    password   VARCHAR(100) NOT NULL,
    role role_enum NOT NULL,
    CONSTRAINT fk_position FOREIGN KEY (position_id) REFERENCES position (position_id)
);

CREATE TABLE salary_payment
(
    salary_payment_id UUID PRIMARY KEY,
    employee_id UUID NOT NULL,
    payment_date TIMESTAMP NOT NULL,
    CONSTRAINT fk_employee FOREIGN KEY (employee_id) REFERENCES employee (employee_id)
);
