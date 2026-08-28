INSERT INTO notificaciones_email (id, actuacion_id, capa_id, capa_template_id, destinatario_id, tipo_evento, estado_envio, intentos, created_at, enviado_at)
SELECT uuid_generate_v4(), a.id, cv.id, ct.id, 'juan.perez@example.com', 'CAPA_OBSERVADA', 'ENVIADO', 1, NOW(), NOW()
FROM actuaciones a
JOIN capas_vectoriales cv ON cv.actuacion_id = a.id
JOIN capas_template ct ON ct.id = cv.capa_template_id
WHERE a.numero_actuacion = 'ACT-001';

INSERT INTO notificaciones_email (id, actuacion_id, capa_id, capa_template_id, destinatario_id, tipo_evento, estado_envio, intentos, created_at, enviado_at)
SELECT uuid_generate_v4(), a.id, cv.id, ct.id, 'maria.gomez@example.com', 'CAPA_APROBADA', 'ENVIADO', 1, NOW(), NOW()
FROM actuaciones a
JOIN capas_vectoriales cv ON cv.actuacion_id = a.id
JOIN capas_template ct ON ct.id = cv.capa_template_id
WHERE a.numero_actuacion = 'ACT-002';
