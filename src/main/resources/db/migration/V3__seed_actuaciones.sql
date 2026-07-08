-- Insert sample actuaciones (actions)
INSERT INTO actuaciones (id, numero_actuacion, tipo_plan_id, propietario_predio, solicitante_id, cargado_por_id, estado_derivado, created_at, updated_at)
SELECT uuid_generate_v4(), 'ACT-001', tp.id, 'Juan Pérez', 'SOLICITANTE-123', 'USER-001', 'PENDIENTE', NOW(), NOW()
FROM tipo_plan tp WHERE tp.codigo = 'PLAN_A';

INSERT INTO actuaciones (id, numero_actuacion, tipo_plan_id, propietario_predio, solicitante_id, cargado_por_id, estado_derivado, created_at, updated_at)
SELECT uuid_generate_v4(), 'ACT-002', tp.id, 'María Gómez', 'SOLICITANTE-456', 'USER-002', 'DERIVADO', NOW(), NOW()
FROM tipo_plan tp WHERE tp.codigo = 'PLAN_B';
