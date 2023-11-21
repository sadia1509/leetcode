package designpattern.creational;

import common.*;

// BUILDER DESIGN PATTERN
// URL class representing the product
class URL {
    private String protocol;
    private String domain;
    private int port;
    private String path;
    private String query;

    // Private constructor to enforce the use of the builder
    private URL(UrlBuilder builder) {
        this.protocol = builder.protocol;
        this.domain = builder.domain;
        this.port = builder.port;
        this.path = builder.path;
        this.query = builder.query;
    }

    // Other methods for using the URL object
    @Override
    public String toString() {
        return protocol + "://" + domain + ":" + port + path + "?" + query;
    }

    // Builder class
    static class UrlBuilder {
        private String protocol = "http"; // Default to HTTP
        private String domain;
        private int port = 80; // Default port for HTTP
        private String path = "";
        private String query = "";

        public UrlBuilder(String domain) {
            this.domain = domain;
        }

        public UrlBuilder setProtocol(String protocol) {
            this.protocol = protocol;
            return this;
        }

        public UrlBuilder setPort(int port) {
            this.port = port;
            return this;
        }

        public UrlBuilder setPath(String path) {
            this.path = path;
            return this;
        }

        public UrlBuilder setQuery(String query) {
            this.query = query;
            return this;
        }

        public URL build() {
            return new URL(this);
        }
    }
}

// Client code
public class Builder {
    public static void main() {
        Logs.println("==========( Builder )==========");
        // Using the builder to create a URL object
        URL url = new URL.UrlBuilder("example.com")
                .setProtocol("https")
                .setPort(443)
                .setPath("/resource")
                .setQuery("param1=value1&param2=value2")
                .build();
        // Displaying the constructed URL
        Logs.println("Constructed URL: " + url);
        Logs.lineBreak(1);
    }
}

