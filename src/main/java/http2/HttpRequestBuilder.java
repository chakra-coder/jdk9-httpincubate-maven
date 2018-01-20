package http2;

import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.io.FileNotFoundException;
import java.net.URI;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.concurrent.Flow;

public class HttpRequestBuilder {

    HttpRequestBuilder() throws FileNotFoundException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://openjdk.java.net/"))
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyProcessor.fromFile(Paths.get("file.json")))
                .build();
    }
}