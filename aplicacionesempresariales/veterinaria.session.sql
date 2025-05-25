SELECT * FROM perfil;


SELECT * FROM usuario;


-- List all tables in the 'gestorVeterinariasv2' schema
SELECT table_name
FROM information_schema.tables
WHERE table_schema = 'gestorVeterinariasv2';

-- Insert profiles if they do not already exist
INSERT INTO perfil (id, perfil)
SELECT uuid(), 'Administrador'
WHERE NOT EXISTS (SELECT 1 FROM perfil WHERE perfil = 'Administrador');

INSERT INTO perfil (id, perfil)
SELECT uuid(), 'Cliente'
WHERE NOT EXISTS (SELECT 1 FROM perfil WHERE perfil = 'Cliente');

INSERT INTO perfil (id, perfil)
SELECT UUID(), 'Medico'
WHERE NOT EXISTS (SELECT 1 FROM perfil WHERE perfil = 'Medico');