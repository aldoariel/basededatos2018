3.1. Roles, privilegios y perfiles 

--mostrar privilegios del usario actual sobre rutinas 
Select * from information_schema.routine_privileges;
--conceder privilegios
GRANT [privilegio] ON [objeto] TO [usuario];
--ejemplo
grant insert on tabla_01 to postgres;
--quitar privilegio
REVOKE [privilegio] ON [objeto] FROM [usuario];
--ejemplo
-------
--grupos de roles
--crear un role
CREATE ROLE [nombre_del_grupo];
--ejemplo
create role role_bd2;
--conceder un privilegio a un role
grant insert on tabla_01 to role_bd2;
-- hacer que un usuario sea parte de una role
GRANT [nombre_del_grupo] TO [usuario];
--ejemplo
grant role_bd2 to postgres;
--quitar a un usuario de una role
REVOKE [nombre_del_grupo] FROM [usuario];
--ejemplo
revoke role_bd2 from postgres;

3.5. Sistemas de recuperación – Archivos históricos (logs de la BD) 

3.6. Backup y Restore 
--ayuda con bk
pg_dump –-help
--bk linea de comandos
pg_dump -Fc -v -c -f postgres.backup -U postgres -W postgres
--restaurar
pg_restore --help
--linea de comando para restaurar
pg_restore –d postgres -Fc –v –c –U postgres –W postgres.backup

listar funciones
Select * from information_schema.routines;
--tabla de privilegios
Select * from information_schema.table_privileges;
--listar las tablas
Select * from information_schema.tables;
--listar vistas
Select * from information_schema.views;
--3.2. Creación de usuarios 
---crear usuario
CREATE USER [nombre de usuario] WITH PASSWORD ‘[clave de usurio]’;
--eliminar usuario
DROP USER [nombre de usuario];
--3.3. Creación de vistas con propósitos de seguridad

