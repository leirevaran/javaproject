CREATE TABLE QUESTIONS(
	
	title VARCHAR(1500) NOT NULL,
	difficulty int
)

ALTER TABLE QUESTIONS ADD CONSTRAINT question_pk PRIMARY KEY (title)
ALTER TABLE QUESTIONS ADD COLUMN question_id INT;
ALTER TABLE QUESTIONS DROP CONSTRAINT question_pk;
ALTER TABLE QUESTIONS ADD CONSTRAINT question_pk PRIMARY KEY (question_id)

CREATE TABLE TOPICS (
  name VARCHAR(255) NOT NULL,
  title VARCHAR(10)
)

ALTER TABLE TOPICS DROP COLUMN title
ALTER TABLE TOPICS ADD COLUMN f_question_id INT;
ALTER TABLE TOPICS ADD CONSTRAINT question_fk FOREIGN KEY (f_question_id) REFERENCES QUESTIONS(question_id) ON DELETE SET NULL;
ALTER TABLE TOPICS ADD CONSTRAINT topic_pk PRIMARY KEY (name, f_question_id);


-- all in one scripts:

CREATE TABLE public.questions
(
    title character varying(1500) COLLATE pg_catalog."default" NOT NULL,
    difficulty integer,
    question_id integer NOT NULL,
    CONSTRAINT question_pk PRIMARY KEY (question_id)
)

CREATE TABLE public.topics
(
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    f_question_id integer NOT NULL,
    CONSTRAINT topic_pk PRIMARY KEY (name, f_question_id),
    CONSTRAINT question_fk FOREIGN KEY (f_question_id)
        REFERENCES public.questions (question_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE SET NULL
)


CREATE SEQUENCE question_id_seq;
ALTER TABLE QUESTIONS ALTER question_id SET DEFAULT NEXTVAL('question_id_seq');



