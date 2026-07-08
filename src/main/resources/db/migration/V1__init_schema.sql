-- Enable UUID extension if not already
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Table: tipo_plan
CREATE TABLE tipo_plan (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    codigo VARCHAR(50) NOT NULL,
    nombre VARCHAR(200) NOT NULL,
    grupo VARCHAR(100) NOT NULL,
    descripcion TEXT,
    activo BOOLEAN NOT NULL,
    fecha_desde TIMESTAMP,
    fecha_hasta TIMESTAMP,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

-- Table: actuaciones
CREATE TABLE actuaciones (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    numero_actuacion VARCHAR(30) NOT NULL,
    tipo_plan_id UUID NOT NULL REFERENCES tipo_plan(id),
    propietario_predio VARCHAR(300) NOT NULL,
    solicitante_id VARCHAR(255) NOT NULL,
    cargado_por_id VARCHAR(255),
    estado_derivado VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    deleted_at TIMESTAMP
);

-- Table: capas_template
CREATE TABLE capas_template (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    codigo_capa VARCHAR(100) NOT NULL,
    label VARCHAR(200) NOT NULL,
    requerida BOOLEAN NOT NULL,
    orden INT NOT NULL,
    descripcion TEXT,
    activa BOOLEAN NOT NULL,
    created_at TIMESTAMP NOT NULL,
    tipo_plan_id UUID NOT NULL REFERENCES tipo_plan(id)
);

-- Table: actuaciones_capas
CREATE TABLE actuaciones_capas (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    actuacion_id UUID NOT NULL REFERENCES actuaciones(id) ON DELETE CASCADE,
    capa_template_id UUID NOT NULL REFERENCES capas_template(id),
    estado_actual VARCHAR(20) NOT NULL,
    tecnico_asignado_id UUID,
    version_actual_id UUID,
    rehabilitada_desde_omitida BOOLEAN NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

-- Table: versiones_capa
CREATE TABLE versiones_capa (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    capa_id UUID NOT NULL REFERENCES capas_template(id),
    numero_version INT NOT NULL,
    formato VARCHAR(20) NOT NULL,
    nombre_original VARCHAR(500) NOT NULL,
    ruta_minio TEXT NOT NULL,
    bucket_minio VARCHAR(100) NOT NULL,
    tamanio_bytes BIGINT NOT NULL,
    hash_sha256 VARCHAR(64) NOT NULL,
    sistema_coords VARCHAR(50),
    subido_por_id UUID NOT NULL,
    created_at TIMESTAMP NOT NULL
);

-- Table: historial_estados_capa
CREATE TABLE historial_estados_capa (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    capa_id UUID NOT NULL REFERENCES capas_template(id),
    estado_anterior VARCHAR(20),
    estado_nuevo VARCHAR(20) NOT NULL,
    accion VARCHAR(50) NOT NULL,
    usuario_id UUID NOT NULL,
    observacion TEXT,
    version_capa_id UUID REFERENCES versiones_capa(id),
    created_at TIMESTAMP NOT NULL
);

-- Table: notificaciones_email
CREATE TABLE notificaciones_email (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    actuacion_id UUID NOT NULL REFERENCES actuaciones(id) ON DELETE CASCADE,
    capa_id UUID REFERENCES capas_template(id),
    destinatario_id UUID NOT NULL,
    tipo_evento VARCHAR(60) NOT NULL,
    estado_envio VARCHAR(20) NOT NULL,
    intentos INT NOT NULL,
    celery_task_id VARCHAR(100),
    created_at TIMESTAMP NOT NULL,
    enviado_at TIMESTAMP
);

-- Table: log_auditoria
CREATE TABLE log_auditoria (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    usuario_id UUID,
    tipo_accion VARCHAR(80) NOT NULL,
    entidad_tipo VARCHAR(50),
    entidad_id UUID,
    estado_anterior JSONB,
    estado_nuevo JSONB,
    ip_cliente INET,
    user_agent TEXT,
    created_at TIMESTAMP NOT NULL
);

-- Table: historial_tipos_plan
CREATE TABLE historial_tipos_plan (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    tipo_plan_id UUID NOT NULL REFERENCES tipo_plan(id),
    usuario_id UUID NOT NULL,
    accion VARCHAR(50) NOT NULL,
    comentario TEXT NOT NULL,
    datos_previos JSONB,
    created_at TIMESTAMP NOT NULL
);

-- Table: evaluaciones_tecnicas
CREATE TABLE evaluaciones_tecnicas (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    capa_id UUID NOT NULL REFERENCES capas_template(id),
    tecnico_id UUID NOT NULL,
    version_capa_id UUID NOT NULL REFERENCES versiones_capa(id),
    resultado VARCHAR(20) NOT NULL,
    observacion TEXT,
    created_at TIMESTAMP NOT NULL
);

-- Table: capas_vectoriales
CREATE TABLE capas_vectoriales (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    actuacion_id UUID NOT NULL REFERENCES actuaciones(id) ON DELETE CASCADE,
    capa_template_id UUID NOT NULL REFERENCES capas_template(id),
    estado_actual VARCHAR(20) NOT NULL,
    tecnico_asignado_id UUID,
    version_actual_id UUID,
    rehabilitada_desde_omitida BOOLEAN NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

