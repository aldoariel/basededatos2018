-- Table: clientes

--DROP TABLE clientes;

CREATE TABLE clientes
(
  id bigint NOT NULL,
  nombre character varying(100) NOT NULL,
  CONSTRAINT clientes_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE clientes
  OWNER TO postgres;
