-- Insert sample plan type history
INSERT INTO historial_tipos_plan (id, tipo_plan_id, usuario_id, accion, comentario, datos_previos, created_at)
SELECT uuid_generate_v4(), tp.id, uuid_generate_v4(), 'CREATE',
       'Plan creado para conservación ambiental',
       '{}'::jsonb, NOW()
FROM tipo_plan tp WHERE tp.codigo = 'PLAN_A';

INSERT INTO historial_tipos_plan (id, tipo_plan_id, usuario_id, accion, comentario, datos_previos, created_at)
SELECT uuid_generate_v4(), tp.id, uuid_generate_v4(), 'UPDATE',
       'Se modificó la descripción del plan técnico',
       jsonb_build_object('descripcion', 'Plan técnico anterior'), NOW()
FROM tipo_plan tp WHERE tp.codigo = 'PLAN_C';
