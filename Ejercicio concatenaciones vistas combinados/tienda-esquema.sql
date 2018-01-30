/*
  Ejemplos correspondientes a
  "BASE DE DATOS II
  analisis 2018-1
  ejercicios de base de datos dados en clases"
*/

BEGIN;
-- [CREACIoN DE DOMINIOS]
CREATE DOMAIN d_dni AS INTEGER CONSTRAINT r_d_dni CHECK (VALUE > 0);
CREATE DOMAIN d_cod_pieza AS CHAR(6);
CREATE DOMAIN d_num_ped AS INTEGER CONSTRAINT r_d_num_ped CHECK (VALUE > 0 AND VALUE < 100000);
CREATE DOMAIN d_ciudad AS CHAR(10) CHECK (VALUE IN ('Castellon', 'Valencia', 'Alicante'));
CREATE DOMAIN d_color AS CHAR(10) DEFAULT 'Otro' CONSTRAINT r_d_color CHECK (VALUE IN ('Blanco', 'Negro', 'Rojo', 'Verde', 'Azul', 'Amarillo', 'Otro'));
CREATE DOMAIN d_precio AS NUMERIC (10,2)  CONSTRAINT r1_d_precio CHECK(VALUE > 0) CONSTRAINT r2_d_precio NOT NULL;
CREATE DOMAIN d_peso AS NUMERIC (5,3)  CONSTRAINT r_d_peso CHECK (VALUE > 0);
CREATE DOMAIN d_cantidad AS SMALLINT CONSTRAINT r1_d_cantidad CHECK (VALUE > 0) CONSTRAINT r2_d_cantidad NOT NULL;

-- [CREACIoN DE TABLAS]
CREATE TABLE proveedor (dni d_dni CONSTRAINT cp_proveedor PRIMARY KEY,nombre VARCHAR(25) NOT NULL, direccion VARCHAR (40), ciudad VARCHAR(20));
CREATE TABLE pieza (codigo d_cod_pieza CONSTRAINT cp_pieza PRIMARY KEY,descr VARCHAR(40) NOT NULL, color d_color, peso d_peso, CONSTRAINT r1_check CHECK ((color = 'Rojo' AND peso < 100) OR (color <> 'Rojo')));
CREATE TABLE oferta (dni d_dni, codigo d_cod_pieza, precio d_precio, CONSTRAINT cp_oferta PRIMARY KEY (dni,codigo));
CREATE TABLE cliente (dni d_dni CONSTRAINT cp_cliente PRIMARY KEY, nombre VARCHAR (25) NOT NULL, direccion VARCHAR(40), ciudad d_ciudad NOT NULL);
CREATE TABLE pedido (numero d_num_ped CONSTRAINT cp_pedido PRIMARY KEY, fecha DATE NOT NULL, cliente d_dni NOT NULL, proveedor d_dni, pieza d_cod_pieza, cantidad d_cantidad);

-- [INTEGRIDAD REFERENCIAL]
ALTER TABLE oferta ADD CONSTRAINT caj_ofertaprov FOREIGN KEY (dni) REFERENCES proveedor (dni) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE oferta ADD CONSTRAINT caj_ofertapieza FOREIGN KEY (codigo) REFERENCES pieza (codigo) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE pedido ADD CONSTRAINT caj_pedidocliente FOREIGN KEY (cliente) REFERENCES cliente (dni) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE pedido ADD CONSTRAINT caj_pedidooferta FOREIGN KEY (proveedor, pieza) REFERENCES oferta (dni, codigo) ON DELETE SET NULL ON UPDATE CASCADE;

END;



