package ar.org.proyungas.shared.infrastructure.utils;

public enum EmailTemplateType {
    CAPA_OBSERVADA("capa_observada.ftl", "Observación en su actuación"),
    CAPA_APROBADA("capa_aprobada.ftl", "Capa aprobada en su actuación"),
    CAPA_OMITIDA("capa_omitida.ftl", "Capa marcada como OMITIDA"),
    ACTUACION_PENDIENTE("actuacion_pendiente.ftl", "Recepción de actuación"),
    EXPEDIENTE_APROBADO("expediente_aprobado.ftl", "Expediente aprobado"),
    RECARGA_CAPA("recarga_capa.ftl", "Nueva versión de capa observada"),
    ALTA_USUARIO("alta_usuario.ftl", "Alta de usuario en SGV");

    private final String templateFile;
    private final String defaultSubject;

    EmailTemplateType(String templateFile, String defaultSubject) {
        this.templateFile = templateFile;
        this.defaultSubject = defaultSubject;
    }

    public String getTemplateFile() {
        return templateFile;
    }

    public String getDefaultSubject() {
        return defaultSubject;
    }
}
