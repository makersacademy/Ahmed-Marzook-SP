CREATE EXTENSION IF NOT EXISTS pgcrypto;

SET search_path TO public;

CREATE TABLE users (
    user_id INTEGER PRIMARY KEY,
    first_name text NOT NULL,
    last_name text NOT NULL,
    email text NOT NULL,
    password text,
    view BOOLEAN,
    edit BOOLEAN
);

create table roles
(
    role_id INTEGER PRIMARY KEY,
    role TEXT NOT NULL,
    user_id int NOT NULL REFERENCES public.users(user_id) ON DELETE CASCADE
);

INSERT INTO public.users (user_id, first_name, last_name, email, password, view, edit) VALUES (1, 'Ahmed', 'Marzook', 'm4marzook@gmail.com', 'X0L0Ecj589qedNluxMbNew==', true, true);
INSERT INTO public.users (user_id, first_name, last_name, email, password, view, edit) VALUES (2, 'Geralt', 'Haute-Bellegarde', 'geralt@kaer-morhen.com', 'mqbazSPAvqdrgYApOEDgIw==', true, false);
INSERT INTO public.users (user_id, first_name, last_name, email, password, view, edit) VALUES (3, 'Jhon', 'Shepard', 'jhon@n7.com', '+d8bj1QN4kx/dB/eUQJR5A==', false, false);