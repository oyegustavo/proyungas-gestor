-- Insert sample technical evaluations
INSERT INTO evaluaciones_tecnicas (id, capa_id, tecnico_id, version_capa_id, resultado, observacion, created_at)
SELECT uuid_generate_v4(), ct.id, uuid_generate_v4(), lv.id, 'APROBADO', 'Evaluación técnica satisfactoria', NOW()
FROM capas_template ct
JOIN versiones_capa lv ON lv.capa_id = ct.id
WHERE ct.codigo_capa = 'CAPA-001'
LIMIT 1;

INSERT INTO evaluaciones_tecnicas (id, capa_id, tecnico_id, version_capa_id, resultado, observacion, created_at)
SELECT uuid_generate_v4(), ct.id, uuid_generate_v4(), lv.id, 'RECHAZADO', 'Documentación incompleta', NOW()
FROM capas_template ct
JOIN versiones_capa lv ON lv.capa_id = ct.id
WHERE ct.codigo_capa = 'CAPA-002'
LIMIT 1;