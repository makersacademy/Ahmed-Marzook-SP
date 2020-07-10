SET search_path
TO public;

CREATE TABLE users
(
  user_id INTEGER PRIMARY KEY,
  first_name text NOT NULL,
  last_name text NOT NULL,
  email text NOT NULL,
  password text,
  authority text
);

CREATE SEQUENCE users_seq
INCREMENT 1 MINVALUE 1 NO MAXVALUE START
WITH 4 CACHE 20 OWNED BY users.user_id;

CREATE TABLE quiz
(
  quiz_id INTEGER PRIMARY KEY,
  title text,
  description text
);

CREATE SEQUENCE quiz_seq
INCREMENT 1 MINVALUE 1 NO MAXVALUE START
WITH 4 CACHE 20 OWNED BY quiz.quiz_id;

CREATE TABLE questions
(
  question_id INTEGER PRIMARY KEY,
  question_title text,
  answers JSONB,
  quiz_id INTEGER REFERENCES quiz(quiz_id) ON DELETE CASCADE
);

CREATE SEQUENCE question_seq
INCREMENT 1 MINVALUE 1 NO MAXVALUE START
WITH 4 CACHE 20 OWNED BY questions.question_id;

CREATE TABLE results
(
  result_id INTEGER PRIMARY KEY,
  score INTEGER,
  quiz_id INTEGER REFERENCES quiz(quiz_id) ON DELETE CASCADE,
  users_id INTEGER REFERENCES users(user_id) ON DELETE CASCADE
);

CREATE SEQUENCE results_seq
INCREMENT 1 MINVALUE 1 NO MAXVALUE START
WITH 4 CACHE 20 OWNED BY results.result_id;

INSERT INTO public.users
  (user_id, first_name, last_name, email, password, authority)
VALUES
  (1 , 'Ahmed', 'Marzook', 'm4marzook@gmail.com', '$2a$10$v9lzh6agsPb7qJJHnjOEvOfVG02A/xRdzceuh1rJsvKA19W8P3Qbe', 'ROLE_ADMIN');
INSERT INTO public.users
  (user_id, first_name, last_name, email, password, authority)
VALUES
  (2 , 'Geralt', 'Haute-Bellegarde', 'geralt@kaer-morhen.com', '$2a$10$yhEswXxtT58jOMgjK4i/cOBKc4o634/.QHMpizF1vELhxDrmmv4kG', 'ROLE_VIEW_USER');
INSERT INTO public.users
  (user_id, first_name, last_name, email, password, authority)
VALUES
  (3 , 'Jhon', 'Shepard', 'jhon@n7.com', '$2a$10$3EvwF1WARUrABMt9uLXe5uTc1mPsIXPrQWzVeXEi8tWS/mLRrt2ba', 'ROLE_USER');

INSERT INTO public.quiz
  (quiz_id, title, description)
VALUES
  (1, 'London Quiz', 'London is located in the UK and is the capital City.');

INSERT INTO public.quiz
  (quiz_id, title, description)
VALUES
  (2, 'Earth Quiz', 'Quiz about the planet Earth');

INSERT INTO public.quiz
  (quiz_id, title, description)
VALUES
  (3, 'Asian Quiz', 'Quiz about Asian Countries');

INSERT INTO public.questions
  (question_id, question_title, answers, quiz_id)
VALUES
  (1, 'Population of London', '[{
      "answerTitle":"9 Million",
      "correct":true
   },{
      "answerTitle":"5 Million",
      "correct":false
   },{
      "answerTitle":"6 Million",
      "correct":false
   },{
      "answerTitle":"3 Million",
      "correct":false
   }]', 1);

INSERT INTO public.questions
  (question_id, question_title, answers, quiz_id)
VALUES
  (2, 'The City of London building 20 Fenchurch Street is better known by which nickname?', '[
  {
    "answerTitle": "Shard",
    "correct": false
  },
  {
    "answerTitle": "Gherkin",
    "correct": false
  },
  {
    "answerTitle": "The Walkie Talkie",
    "correct": true
  },
  {
    "answerTitle": "Fenchurch Tower",
    "correct": false
  }
]', 1);

INSERT INTO public.questions
  (question_id, question_title, answers, quiz_id)
VALUES
  (3, 'In which London neighbourhood can you find ‘Little Portugal’?', '[
  {
    "answerTitle": "Wellington",
    "correct": false
  },
  {
    "answerTitle": "Stockwell",
    "correct": true
  },
  {
    "answerTitle": "Harrow",
    "correct": false
  },
  {
    "answerTitle": "Waterloo",
    "correct": false
  }
]', 1);