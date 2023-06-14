package info.zpss.SimpleHttpServer.HttpObj;

public enum HttpStatus {
    OK(200, "OK"),
    NO_CONTENT(204, "No Content"),
    PARTIAL_CONTENT(206, "Partial Content"),
    MOVED_PERMANENTLY(301, "Moved Permanently"),
    FOUND(302, "Found"),
    SEE_OTHER(303, "See Other"),
    NOT_MODIFIED(304, "Not Modified"),
    TEMPORARY_REDIRECT(307, "Temporary Redirect"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable");

    private final int code;
    private final String reason;

    HttpStatus(int code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    public int getCode() {
        return code;
    }

    public String getReason() {
        return reason;
    }

    public static HttpStatus fromCode(int code) {
        for (HttpStatus status : HttpStatus.values())
            if (status.code == code)
                return status;
        int firstDigit = code / 100;
        if (firstDigit == 2)
            return OK;
        if (firstDigit == 3)
            return MOVED_PERMANENTLY;
        if (firstDigit == 4)
            return NOT_FOUND;
        return INTERNAL_SERVER_ERROR;
    }
}
