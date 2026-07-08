-- Insert sample layer templates
INSERT INTO capas_template (id, codigo_capa, label, requerida, orden, descripcion, activa, created_at, tipo_plan_id)
SELECT uuid_generate_v4(), 'CAPA-001', 'Capa Ambiental', TRUE, 1, 'Evaluación ambiental inicial', TRUE, NOW(), tp.id
FROM tipo_plan tp WHERE tp.codigo = 'PLAN_A';

INSERT INTO capas_template (id, codigo_capa, label, requerida, orden, descripcion, activa, created_at, tipo_plan_id)
SELECT uuid_generate_v4(), 'CAPA-002', 'Capa Técnica', TRUE, 2, 'Revisión técnica del predio', TRUE, NOW(), tp.id
FROM tipo_plan tp WHERE tp.codigo = 'PLAN_B';

INSERT INTO capas_template (id, codigo_capa, label, requerida, orden, descripcion, activa, created_at, tipo_plan_id)
SELECT uuid_generate_v4(), 'CAPA-003', 'Capa Documental', FALSE, 3, 'Documentación complementaria', TRUE, NOW(), tp.id
FROM tipo_plan tp WHERE tp.codigo = 'PLAN_C';
