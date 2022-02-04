package cl.schedulator.api.configuration;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientConfiguration {
    private String baseUrl;
    private String uri;

    private  WebClientConfiguration(String url, String uri) {
        this.baseUrl = url;
        this.uri = uri;
    }

    public static WebClientConfiguration configureClient(String baseUrl, String uri){
        return new WebClientConfiguration(baseUrl, uri);
    }

    public WebClient createClient() {
        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }


}
