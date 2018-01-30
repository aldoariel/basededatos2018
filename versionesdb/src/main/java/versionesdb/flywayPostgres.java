/*
 * 
 * flyway.driver=org.postgresql.Driver
flyway.url=jdbc:postgresql://localhost:5432/analisis
flyway.password=dragon
flyway.locations=filesystem:src/main/resources/db/migration/
flyway.sqlMigrationPrefix=v
flyway.sqlMigrationSeparator=__
flyway.sqlMigrationSuffix=.sql
flyway.validateOnMigrate=true
flyway.baseline-on-migrate=true

//clean install flyway:migrate

 */