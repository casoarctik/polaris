-- DROP SCHEMA polaris_db_a;

CREATE SCHEMA polaris_db_a AUTHORIZATION pg_database_owner;

-- DROP SEQUENCE polaris_db_a.item_id_seq;

CREATE SEQUENCE polaris_db_a.item_id_seq
	INCREMENT BY 5
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1000
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE polaris_db_a.item_id_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE polaris_db_a.item_id_seq TO postgres;

-- DROP SEQUENCE polaris_db_a.ticket_id_seq;

CREATE SEQUENCE polaris_db_a.ticket_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE polaris_db_a.ticket_id_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE polaris_db_a.ticket_id_seq TO postgres;

-- DROP SEQUENCE polaris_db_a.user_account_id_seq;

CREATE SEQUENCE polaris_db_a.user_account_id_seq
	INCREMENT BY 5
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 100
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE polaris_db_a.user_account_id_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE polaris_db_a.user_account_id_seq TO postgres;
-- polaris_db_a.category definition

-- Drop table

-- DROP TABLE polaris_db_a.category;

CREATE TABLE polaris_db_a.category (
	id int2 NOT NULL,
	categoryname varchar(255) NOT NULL,
	CONSTRAINT category_pkey PRIMARY KEY (id),
	CONSTRAINT uk_e4o36fyfp4h0qgosori7ry67g UNIQUE (categoryname)
);

-- Permissions

ALTER TABLE polaris_db_a.category OWNER TO postgres;
GRANT ALL ON TABLE polaris_db_a.category TO postgres;


-- polaris_db_a.status definition

-- Drop table

-- DROP TABLE polaris_db_a.status;

CREATE TABLE polaris_db_a.status (
	id int2 NOT NULL,
	code varchar(255) NOT NULL,
	CONSTRAINT status_pkey PRIMARY KEY (id),
	CONSTRAINT uk_90n0sv25slo1kmu0tcakhjjed UNIQUE (code)
);

-- Permissions

ALTER TABLE polaris_db_a.status OWNER TO postgres;
GRANT ALL ON TABLE polaris_db_a.status TO postgres;


-- polaris_db_a.user_account definition

-- Drop table

-- DROP TABLE polaris_db_a.user_account;

CREATE TABLE polaris_db_a.user_account (
	id int8 NOT NULL,
	create_at timestamp NOT NULL,
	update_at timestamp NOT NULL,
	administrator bool NOT NULL DEFAULT false,
	email varchar(255) NOT NULL,
	first_name varchar(30) NOT NULL,
	last_name varchar(50) NOT NULL,
	moderator bool NOT NULL DEFAULT false,
	month_seniority int4 NULL DEFAULT 0,
	user_password varchar(20) NOT NULL,
	premium bool NOT NULL,
	user_name varchar(20) NOT NULL,
	CONSTRAINT uk_hl02wv5hym99ys465woijmfib UNIQUE (email),
	CONSTRAINT uk_n581kgbdmb1ruhd047l51wn0a UNIQUE (user_name),
	CONSTRAINT user_account_pkey PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE polaris_db_a.user_account OWNER TO postgres;
GRANT ALL ON TABLE polaris_db_a.user_account TO postgres;


-- polaris_db_a.ticket definition

-- Drop table

-- DROP TABLE polaris_db_a.ticket;

CREATE TABLE polaris_db_a.ticket (
	id bigserial NOT NULL,
	create_at timestamp NOT NULL,
	update_at timestamp NOT NULL,
	code varchar(10) NOT NULL,
	category_id int2 NULL,
	status_id int2 NULL,
	user_id int8 NOT NULL,
	CONSTRAINT ticket_pkey PRIMARY KEY (id),
	CONSTRAINT fk3g2gmlm6p2o4hc5oggcvq51x3 FOREIGN KEY (category_id) REFERENCES polaris_db_a.category(id),
	CONSTRAINT fk7h1wcba93khggbl1ahgwjlssu FOREIGN KEY (status_id) REFERENCES polaris_db_a.status(id),
	CONSTRAINT fkgvmqq8j059h42lt9embrssv8 FOREIGN KEY (user_id) REFERENCES polaris_db_a.user_account(id)
);

-- Permissions

ALTER TABLE polaris_db_a.ticket OWNER TO postgres;
GRANT ALL ON TABLE polaris_db_a.ticket TO postgres;


-- polaris_db_a.movie definition

-- Drop table

-- DROP TABLE polaris_db_a.movie;

CREATE TABLE polaris_db_a.movie (
	id int8 NOT NULL,
	create_at timestamp NOT NULL,
	update_at timestamp NOT NULL,
	"path" varchar(255) NOT NULL,
	title varchar(50) NOT NULL,
	category_id int2 NOT NULL,
	ticket_id int8 NULL,
	tmdb_id int8 NOT NULL,
	CONSTRAINT movie_pkey PRIMARY KEY (id),
	CONSTRAINT fk_98y64u3pjex21gi2l5n3ws82r FOREIGN KEY (ticket_id) REFERENCES polaris_db_a.ticket(id),
	CONSTRAINT fk_dwm65tb1coltr8gwc6at24jrm FOREIGN KEY (category_id) REFERENCES polaris_db_a.category(id)
);

-- Permissions

ALTER TABLE polaris_db_a.movie OWNER TO postgres;
GRANT ALL ON TABLE polaris_db_a.movie TO postgres;


-- polaris_db_a.serie definition

-- Drop table

-- DROP TABLE polaris_db_a.serie;

CREATE TABLE polaris_db_a.serie (
	id int8 NOT NULL,
	create_at timestamp NOT NULL,
	update_at timestamp NOT NULL,
	"path" varchar(255) NOT NULL,
	title varchar(50) NOT NULL,
	category_id int2 NOT NULL,
	ticket_id int8 NULL,
	episodes_count int4 NOT NULL,
	season_count int4 NOT NULL,
	tmdb_id int8 NOT NULL,
	CONSTRAINT serie_pkey PRIMARY KEY (id),
	CONSTRAINT fk_dhn0xd0ojta2c9soc50kos7fd FOREIGN KEY (ticket_id) REFERENCES polaris_db_a.ticket(id),
	CONSTRAINT fk_fjdcfwd6q4qdid28kl2ag1qoq FOREIGN KEY (category_id) REFERENCES polaris_db_a.category(id)
);

-- Permissions

ALTER TABLE polaris_db_a.serie OWNER TO postgres;
GRANT ALL ON TABLE polaris_db_a.serie TO postgres;




-- Permissions

GRANT ALL ON SCHEMA polaris_db_a TO pg_database_owner;
