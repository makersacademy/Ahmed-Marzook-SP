CREATE EXTENSION IF NOT EXISTS pgcrypto;

SET search_path TO public;

CREATE TABLE user_table (
    user_id INT PRIMARY KEY,
    first_name text NOT NULL,
    last_name text NOT NULL,
    email text NOT NULL,
    password text,
    view BOOLEAN,
    edit BOOLEAN
);

INSERT INTO public.user_table (user_id, first_name, last_name, email, password, view, edit) VALUES (1, 'Ahmed', 'Marzook', 'm4marzook@gmail.com', 'bob', true, true);
INSERT INTO public.user_table (user_id, first_name, last_name, email, password, view, edit) VALUES (2, 'Geralt', 'Haute-Bellegarde', 'geralt@kaer-morhen.com', 'wolf', true, true);
INSERT INTO public.user_table (user_id, first_name, last_name, email, password, view, edit) VALUES (3, 'Jhon', 'Shepard', 'jhon@n7.com', 'masseffect', null, null);