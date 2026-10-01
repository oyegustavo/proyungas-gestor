-- Seed roles
INSERT INTO roles (role) VALUES
('ROLE_ADMIN'),
('ROLE_SOLICITANTE'),
('ROLE_USER');

-- Seed users
INSERT INTO usuarios (cuit_cuil, nombre_completo, email, password, estado)
VALUES
('20-12345678-9', 'Juan Pérez', 'juan.perez@example.com', '$2a$10$abc...', true),
('27-98765432-1', 'María Gómez', 'maria.gomez@example.com', '$2a$10$xyz...', true);

-- Assign roles to users
INSERT INTO users_roles (usuario_id, rol_id)
SELECT u.id, r.id FROM usuarios u, roles r
WHERE u.cuit_cuil = '20-12345678-9' AND r.role = 'ROLE_ADMIN';

INSERT INTO users_roles (usuario_id, rol_id)
SELECT u.id, r.id FROM usuarios u, roles r
WHERE u.cuit_cuil = '27-98765432-1' AND r.role = 'ROLE_SOLICITANTE';

-- Seed plan types
INSERT INTO tipo_plan (id, codigo, nombre, grupo, descripcion, activo, fecha_desde, created_at, updated_at)
VALUES
(uuid_generate_v4(), 'PLAN_A', 'Plan Ambiental', 'Grupo A', 'Evaluación ambiental inicial', true, NOW(), NOW(), NOW()),
(uuid_generate_v4(), 'PLAN_B', 'Plan Técnico', 'Grupo B', 'Revisión técnica del predio', true, NOW(), NOW(), NOW());

-- Seed actions
INSERT INTO actuaciones (id, numero_actuacion, tipo_plan_id, propietario_predio, solicitante_id, cargado_por_id, estado_derivado, created_at, updated_at)
SELECT uuid_generate_v4(), 'ACT-001', tp.id, 'Propietario 1', u.id, 'USER-001', 'PENDIENTE', NOW(), NOW()
FROM tipo_plan tp, usuarios u
WHERE tp.codigo = 'PLAN_A' AND u.cuit_cuil = '27-98765432-1';

INSERT INTO actuaciones (id, numero_actuacion, tipo_plan_id, propietario_predio, solicitante_id, cargado_por_id, estado_derivado, created_at, updated_at)
SELECT uuid_generate_v4(), 'ACT-002', tp.id, 'Propietario 2', u.id, 'USER-002', 'DERIVADO', NOW(), NOW()
FROM tipo_plan tp, usuarios u
WHERE tp.codigo = 'PLAN_B' AND u.cuit_cuil = '20-12345678-9';

-- Seed layer templates
INSERT INTO capas_template (id, codigo_capa, label, requerida, orden, descripcion, activa, created_at, tipo_plan_id)
SELECT uuid_generate_v4(), 'CAPA-001', 'Capa Ambiental', true, 1, 'Evaluación ambiental inicial', true, NOW(), tp.id
FROM tipo_plan tp WHERE tp.codigo = 'PLAN_A';

INSERT INTO capas_template (id, codigo_capa, label, requerida, orden, descripcion, activa, created_at, tipo_plan_id)
SELECT uuid_generate_v4(), 'CAPA-002', 'Capa Técnica', true, 2, 'Revisión técnica del predio', true, NOW(), tp.id
FROM tipo_plan tp WHERE tp.codigo = 'PLAN_B';
