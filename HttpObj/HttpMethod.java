package info.zpss.SimpleHttpServer.HttpObj;

public enum HttpMethod {
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE"),
    HEAD("HEAD"),
    OPTIONS("OPTIONS"),
    TRACE("TRACE"),
    CONNECT("CONNECT");

    private final String name;

    HttpMethod(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static HttpMethod fromString(String name) {
        for (HttpMethod method : HttpMethod.values())
            if (method.name.equalsIgnoreCase(name))
                return method;
        return null;
    }
}
