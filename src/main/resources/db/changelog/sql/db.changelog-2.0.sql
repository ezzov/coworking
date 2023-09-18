--liquibase formatted sql

--changeset anna:20
CREATE TABLE IF NOT EXISTS coworking (
                           id BIGINT PRIMARY KEY,
                           name VARCHAR(255),
                           address VARCHAR(255)
);

--changeset anna:21
CREATE TABLE IF NOT EXISTS room (
                      id BIGINT PRIMARY KEY,
                      capacity INTEGER,
                      price DECIMAL,
                      coworking_id BIGINT,
                      FOREIGN KEY (coworking_id) REFERENCES coworking (id)
);

--changeset anna:22
CREATE TABLE IF NOT EXISTS booking (
                         id BIGINT PRIMARY KEY,
                         client VARCHAR(255) NOT NULL,
                         startDate TIMESTAMP NOT NULL,
                         endDate TIMESTAMP NOT NULL,
                         room_id BIGINT,
                         FOREIGN KEY (room_id) REFERENCES room (id)
);

--changeset anna:23
CREATE SEQUENCE IF NOT EXISTS coworking_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

--changeset anna:24
CREATE SEQUENCE IF NOT EXISTS room_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;


--changeset anna:25
CREATE SEQUENCE IF NOT EXISTS booking_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

--changeset anna:26
INSERT INTO coworking (id, name, address)
VALUES (1, 'Coworking Space A', '123 Main St'),
       (2, 'Coworking Space B', '456 Elm St');


--changeset anna:27
ALTER TABLE booking
    ALTER COLUMN id SET DEFAULT nextval('booking_id_seq'::regclass);

--changeset anna:28
ALTER TABLE room
    ALTER COLUMN id SET DEFAULT nextval('room_id_seq'::regclass);


--changeset anna:29
ALTER TABLE coworking
    ALTER COLUMN id SET DEFAULT nextval('coworking_id_seq'::regclass);

--changeset anna:30
INSERT INTO room (id, price, capacity, coworking_id)
VALUES (1, 1000, 10, 1),
       (2, 2000, 20, 1),
       (3, 1500, 15, 2),
       (4, 500, 5, 2);

--changeset anna:31
INSERT INTO booking (id, client, startDate, endDate, room_id)
VALUES (1, 'Sarah Davis', '2023-09-22 13:00:00', '2023-09-22 15:00:00', 2),
       (2, 'Robert Wilson', '2023-09-25 11:30:00', '2023-09-27 11:30:00', 3);