CREATE TABLE cars (
    id SERIAL NOT NULL,
    model VARCHAR(255),
    license_plate VARCHAR(255),
    color VARCHAR(255),
    year INT,
    fine_amount NUMERIC,
    available BOOLEAN DEFAULT TRUE,
    PRIMARY KEY (id),
    UNIQUE(license_plate)
);


CREATE TABLE clients (
    id SERIAL NOT NULL,
    name VARCHAR(255),
    address VARCHAR(255),
    contact VARCHAR(255),
    cpf VARCHAR(255),
    PRIMARY KEY (id),
    UNIQUE(cpf)
);


CREATE TABLE rentals (
    id SERIAL NOT NULL,
    client_cpf VARCHAR(255) NULL,
    car_license_plate VARCHAR(255) NULL,
    date_rental TIMESTAMP DEFAULT NOW(),
    rented BOOLEAN DEFAULT TRUE,
    PRIMARY KEY (id),
    CONSTRAINT fk_client
      FOREIGN KEY(client_cpf) 
      REFERENCES clients(cpf)
      ON DELETE SET NULL,
    CONSTRAINT fk_car
      FOREIGN KEY(car_license_plate) 
      REFERENCES cars(license_plate)
      ON DELETE SET NULL
);
