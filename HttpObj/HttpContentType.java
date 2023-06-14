package info.zpss.SimpleHttpServer.HttpObj;

public enum HttpContentType {
    TEXT_HTML("text/html"),
    TEXT_CSS("text/css"),
    TEXT_PLAIN("text/plain"),
    TEXT_JAVASCRIPT("text/javascript"),
    IMAGE_JPEG("image/jpeg"),
    IMAGE_PNG("image/png"),
    IMAGE_GIF("image/gif"),
    IMAGE_BMP("image/bmp"),
    IMAGE_X_ICON("image/x-icon"),
    IMAGE_SVG_XML("image/svg+xml"),
    IMAGE_WEBP("image/webp"),
    APPLICATION_JAVASCRIPT("application/javascript"),
    APPLICATION_OCTET_STREAM("application/octet-stream");

    private final String name;

    HttpContentType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static HttpContentType fromString(String extension) {
        switch (extension.toLowerCase()) {
            case "css":
                return TEXT_CSS;
            case "txt":
                return TEXT_PLAIN;
            case "js":
                return TEXT_JAVASCRIPT;
            case "jpg":
            case "jpeg":
                return IMAGE_JPEG;
            case "png":
                return IMAGE_PNG;
            case "gif":
                return IMAGE_GIF;
            case "bmp":
                return IMAGE_BMP;
            case "ico":
                return IMAGE_X_ICON;
            case "svg":
                return IMAGE_SVG_XML;
            case "webp":
                return IMAGE_WEBP;
            case "html":
            case "htm":
            default:
                return TEXT_HTML;
        }
    }
}
