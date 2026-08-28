-- Insert sample audit logs
INSERT INTO log_auditoria (id, usuario_id, tipo_accion, entidad_tipo, entidad_id, estado_anterior, estado_nuevo, ip_cliente, user_agent, created_at)
SELECT uuid_generate_v4(), 'USER-001', 'CREATE', 'Actuacion', a.id,
       '{}'::jsonb, jsonb_build_object('estado_derivado', a.estado_derivado),
       '192.168.1.10', 'Mozilla/5.0', NOW()
FROM actuaciones a
WHERE a.numero_actuacion = 'ACT-001';

INSERT INTO log_auditoria (id, usuario_id, tipo_accion, entidad_tipo, entidad_id, estado_anterior, estado_nuevo, ip_cliente, user_agent, created_at)
SELECT uuid_generate_v4(), 'USER-002', 'UPDATE', 'Actuacion', a.id,
       jsonb_build_object('estado_derivado', 'PENDIENTE'),
       jsonb_build_object('estado_derivado', a.estado_derivado),
       '192.168.1.11', 'Mozilla/5.0', NOW()
FROM actuaciones a
WHERE a.numero_actuacion = 'ACT-002';
