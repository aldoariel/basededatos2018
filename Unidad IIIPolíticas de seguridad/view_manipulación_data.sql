-- Este código esta hecho para ejecutarlo por parte

CREATE OR REPLACE VIEW vista3 AS
	SELECT * FROM (SELECT nom_alu,ced_alu,ape_alu FROM alumnos
	UNION
	SELECT nom_alu,ced_alu,ape_alu FROM alumnas) AS todos_alumnos;


--SELECT * FROM vista3

DROP RULE IF EXISTS insertar_vista_alumnos ON vista3;
CREATE OR REPLACE RULE insertar_vista_alumnos AS ON INSERT 
TO vista3
DO INSTEAD INSERT INTO alumnas (nom_alu,ape_alu,ced_alu) VALUES (NEW.nom_alu,NEW.ape_alu,NEW.ced_alu);


-- Para insertar alumnas
DROP RULE IF EXISTS insertar_vista_alumnas ON vista3;
CREATE OR REPLACE RULE insertar_vista_alumnas AS ON INSERT 
TO vista3
DO INSTEAD INSERT INTO alumnas (nom_alu,ape_alu,ced_alu) 
	SELECT NEW.nom_alu, NEW.ape_alu,NEW.ced_alu WHERE NEW.nom_alu IN ('Maria','Carla','Flor');


-- Para insertar alumnos
DROP RULE IF EXISTS insertar_vista_alumnos ON vista3;
CREATE OR REPLACE RULE insertar_vista_alumnos AS ON INSERT 
TO vista3
DO INSTEAD INSERT INTO alumnos (nom_alu,ape_alu,ced_alu) 
	SELECT NEW.nom_alu, NEW.ape_alu,NEW.ced_alu WHERE NEW.nom_alu IN ('Marco','Luis','Jesus');
	
--INSERT INTO vista3 (nom_alu,ced_alu,ape_alu) VALUES ('Marco',814811,'Marin')

-- Regla para modifificar la vista en vez de modificar, registra
DROP RULE IF EXISTS update_vista_alumnas ON vista3;
CREATE OR REPLACE RULE update_vista_alumnas AS ON UPDATE 
TO vista3
DO INSTEAD INSERT INTO alumnas (nom_alu,ape_alu,ced_alu) 
	SELECT NEW.nom_alu, NEW.ape_alu,NEW.ced_alu WHERE NEW.nom_alu IN ('Maria Teresa','Luisa','Carla');

--UPDATE vista3 SET nom_alu = 'Maria Teresa', ced_alu = 59999516 WHERE ced_alu = 123456;



-- Regla para modifificar la vista, TAMBIEN al modificar, registra
DROP RULE IF EXISTS update_insert_vista_alumnas ON vista3;
CREATE OR REPLACE RULE update_insert_vista_alumnas AS ON UPDATE 
TO vista3
DO ALSO INSERT INTO alumnas (nom_alu,ape_alu,ced_alu) 
	SELECT NEW.nom_alu, NEW.ape_alu,NEW.ced_alu+99 WHERE NEW.nom_alu IN ('Maria Gonzales','Luisa','Carla');

UPDATE vista3 SET nom_alu = 'Maria Gonzales' WHERE ced_alu = 123456;


-- Regla para modifificar los registros de la vista 

DROP RULE IF EXISTS update_vista_alumnas ON vista3;

CREATE OR REPLACE RULE update_vista_alumnas AS ON UPDATE 
TO vista3
DO INSTEAD  UPDATE alumnas SET nom_alu = NEW.nom_alu, ape_alu = NEW.ape_alu WHERE ced_alu = NEW.ced_alu

UPDATE vista3 SET nom_alu = 'Abiagail Miranda' WHERE ced_alu = 59999516;


-- Regla para eliminar los registros de la vista
DROP RULE IF EXISTS delete_vista_alumnas ON vista3;

CREATE OR REPLACE RULE delete_vista_alumnas AS ON DELETE 
TO vista3
DO INSTEAD DELETE FROM alumnas WHERE ced_alu = old.ced_alu

DELETE FROM vista3  WHERE ced_alu = 59999515;









