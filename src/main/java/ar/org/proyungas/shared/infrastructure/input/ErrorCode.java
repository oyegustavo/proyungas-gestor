package ar.org.proyungas.shared.infrastructure.input;


public enum ErrorCode {
  INTERNAL_ERROR(100, "An internal error ocurred", "INTERNAL_ERROR"),
  BAD_REQUEST_ERROR(101, "Bad request", "BAD_REQUEST_ERROR"),
  DATABASE_ERROR(102, "Database Error", "DATABASE_ERROR"),
  REST_CLIENT_ERROR(103, "Unexpected rest client error", "REST_CLIENT_ERROR"),
  NOT_FOUND_ERROR(104, "Not Found Error", "NOT_FOUND_ERROR"),
  EXTERNAL_SERVICE_ERROR(105, "External service error", "EXTERNAL_SERVICE_ERROR"),
  PLAN_TYPE_NOT_FOUND(106, "Plan Type Not Found Error", "PLAN_TYPE_NOT_FOUND_ERROR"),
  FORBIDDEN_ACTION_APPLICANT(107, "Forbidden Action Applicant", "FORBIDDEN_ACTION_APPLICANT"),
  INET_ADDRESS_ERROR(108, "Inet Address Error", "INET_ADDRESS_ERROR"),
  AUDIT_REQUIRED_FIELD_ERROR(109, "Audit required field Error", "AUDIT_REQUIRED_FIELD_ERROR"),
  USER_NOT_FOUND(110, "User Not Found Error", "USER_NOT_FOUND_ERROR"),
  USER_BAD_REQUEST(111, "User Bad Request Error", "USER_BAD_REQUEST_ERROR"),
  INVALID_DATE_RANGE(112, "Invalid Date Range", "INVALID_DATE_RANGE"),
  AUDIT_LOG_BAD_REQUEST(113, "Audit Log Bad Request Error", "AUDIT_LOG_BAD_REQUEST"),
  INVALID_ACTION_ERROR(114,"Invalid Action Error","INVALID_ACTION_ERROR"),
  INVALID_VECTORIAL_LAYER_ERROR(115,"Invalid Vectorial Layer Error","INVALID_VECTORIAL_LAYER_ERROR"),
  INVALID_STATUS_PROGRESSION_ERROR(116,"Invalid Status Progression Error","INVALID_STATUS_PROGRESSION_ERROR"),
  EMAIL_NOTIFICATION_ERROR(117,"Email Notification Error","EMAIL_NOTIFICATION_ERROR"),
  ACTION_NOT_FOUND(118, "Action Not Found Error", "ACTION_NOT_FOUND"),
  INVALID_FILTER(119, "Invalid search filter", "INVALID_FILTER"),
  REPEATED_ACTION_NUMBER_ERROR(120, "Repeated Action Number", "REPEATED_ACTION_NUMBER_ERROR"),
  INVALID_FILTER_TYPE_ERROR(121, "Filter type not valid", "INVALID_FILTER_TYPE_ERROR"),
  LAYER_TEMPLATE_NOT_FOUND_ERROR(122,"Layer Template Not Found Error","LAYER_TEMPLATE_NOT_FOUND_ERROR"),
  LAYER_VERSION_NOT_FOUND_ERROR(123, "Layer Version Not Found Error", "LAYER_VERSION_NOT_FOUND_ERROR"),
  VECTORIAL_LAYER_NOT_FOUND(124, "Vectorial Layer Not Found", "VECTORIAL_LAYER_NOT_FOUND"),
  MALFORMED_FILTER_EXCEPTION(125, "Malformed Filter Error", "MALFORMED_FILTER_EXCEPTION"),
  JSON_SERIALIZER_ERROR(126, "Json Serializer Error", "JSON_SERIALIZER_ERROR"),
  INVALID_USER_ERROR(127,"Invalid User Error","INVALID_USER_ERROR"),
  ROLE_NOT_FOUND_ERROR(128,"Role Not Found Error","ROLE_NOT_FOUND_ERROR"),
  INVALID_ACTION_APPLICANT_ERROR(129,"Invalid Action Applicant Error","INVALID_ACTION_APPLICANT_ERROR");


  private final int value;
  private final String reason;
  private final String code;

  ErrorCode(int value, String reason, String code) {
    this.value = value;
    this.reason = reason;
    this.code = code;
  }

  public int value() {
    return this.value;
  }

  public String getReason() {
    return this.reason;
  }

  public String getCode() {
    return this.code;
  }
}
