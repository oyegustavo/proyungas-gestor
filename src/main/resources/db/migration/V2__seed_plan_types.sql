-- Insert sample plan types
INSERT INTO tipo_plan (id, codigo, nombre, grupo, descripcion, activo, fecha_desde, created_at, updated_at)
VALUES
(uuid_generate_v4(), 'PLAN_A', 'Plan de Conservación', 'Conservación', 'Plan orientado a la conservación ambiental', TRUE, NOW(), NOW(), NOW()),
(uuid_generate_v4(), 'PLAN_B', 'Plan de Desarrollo', 'Desarrollo', 'Plan orientado al desarrollo urbano', TRUE, NOW(), NOW(), NOW()),
(uuid_generate_v4(), 'PLAN_C', 'Plan Técnico', 'Técnico', 'Plan de evaluación técnica de predios', TRUE, NOW(), NOW(), NOW());