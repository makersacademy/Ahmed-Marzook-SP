SET search_path TO public;

CREATE TABLE users (
    user_id INTEGER PRIMARY KEY,
    first_name text NOT NULL,
    last_name text NOT NULL,
    email text NOT NULL,
    password text
);

CREATE SEQUENCE users_seq INCREMENT 1 MINVALUE 1 NO MAXVALUE START WITH 4 CACHE 20 OWNED BY users.user_id;

create table authority
(
    authority_id INTEGER PRIMARY KEY,
    role TEXT NOT NULL
);

CREATE SEQUENCE authority_seq INCREMENT 1 MINVALUE 1 NO MAXVALUE START WITH 4 CACHE 20 OWNED BY authority.authority_id;

create table user_authority 
(
    user_authority_id INTEGER,
    user_id INTEGER
);


INSERT INTO public.authority (authority_id ,role) VALUES (1, 'ROLE_ADMIN');
INSERT INTO public.authority (authority_id ,role) VALUES (2, 'ROLE_VIEW_USER');
INSERT INTO public.authority (authority_id ,role) VALUES (3, 'ROLE_USER');

INSERT INTO public.user_authority (user_authority_id, user_id) VALUES (1, 1);
INSERT INTO public.user_authority (user_authority_id, user_id) VALUES (2, 2);
INSERT INTO public.user_authority (user_authority_id, user_id) VALUES (3, 3);

INSERT INTO public.users (user_id, first_name, last_name, email, password) VALUES (1 ,'Ahmed', 'Marzook', 'm4marzook@gmail.com', '$2a$10$v9lzh6agsPb7qJJHnjOEvOfVG02A/xRdzceuh1rJsvKA19W8P3Qbe');
INSERT INTO public.users (user_id, first_name, last_name, email, password) VALUES (2 ,'Geralt', 'Haute-Bellegarde', 'geralt@kaer-morhen.com', '$2a$10$yhEswXxtT58jOMgjK4i/cOBKc4o634/.QHMpizF1vELhxDrmmv4kG');
INSERT INTO public.users (user_id, first_name, last_name, email, password) VALUES (3 ,'Jhon', 'Shepard', 'jhon@n7.com', '$2a$10$3EvwF1WARUrABMt9uLXe5uTc1mPsIXPrQWzVeXEi8tWS/mLRrt2ba');