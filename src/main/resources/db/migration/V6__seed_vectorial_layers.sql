INSERT INTO capas_vectoriales (id, actuacion_id, capa_template_id, estado_actual, tecnico_asignado_id, observacion, rehabilitada_desde_omitida, created_at, updated_at)
SELECT uuid_generate_v4(), a.id, ct.id, 'OBSERVADA', 'gustvald@gmail.com', 'Archivo no cumple formato', FALSE, NOW(), NOW()
FROM actuaciones a
JOIN capas_template ct ON ct.codigo_capa = 'CAPA-001'
WHERE a.numero_actuacion = 'ACT-001';

INSERT INTO capas_vectoriales (id, actuacion_id, capa_template_id, estado_actual, tecnico_asignado_id, observacion, rehabilitada_desde_omitida, created_at, updated_at)
SELECT uuid_generate_v4(), a.id, ct.id, 'APROBADA', 'gustvald@gmail.com', 'Archivo correcto', FALSE, NOW(), NOW()
FROM actuaciones a
JOIN capas_template ct ON ct.codigo_capa = 'CAPA-002'
WHERE a.numero_actuacion = 'ACT-002';
