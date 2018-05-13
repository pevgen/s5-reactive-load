package ml.pevgen.reactive.load.web;

import io.micrometer.core.annotation.Timed;
import ml.pevgen.reactive.load.dto.XmlRequest;
import ml.pevgen.reactive.load.dto.XmlRequestMsg;
import ml.pevgen.reactive.load.dto.XmlResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/load")
@Timed("load-resource")
public class LoadResource {

    @GetMapping("/test")
    public Mono<String> testGetPlain() {
        return Mono.just("current time:" + LocalDateTime.now());
    }

    @PostMapping(value = "/test", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public Mono<String> testPostPlain() {
        return Mono.just("current time:" + LocalDateTime.now());
    }

    @PostMapping(value = "/test/xml", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public Mono<XmlResponse> testPostXml() {
        XmlResponse response = new XmlResponse();
        response.setId("id:" + LocalDateTime.now());
        response.setName("name:" + LocalDateTime.now());
        return Mono.just(response);
    }


    /**
     * Example of request
     *
     * <xmlRequest>
     *   <id>id:2018-05-09T10:06:59.809</id>
     *   <name>name:2018-05-09T10:06:59.809</name>
     * </xmlRequest>
     */
    @PostMapping(value = "/test/xml-request", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public Mono<XmlResponse> testPostXml(@RequestBody XmlRequest request) {
        XmlResponse response = new XmlResponse();
        response.setId(request.getId());
        response.setName("name:" + LocalDateTime.now());
        return Mono.just(response);
    }

    @PostMapping(value = "/test/xml-request-msg", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public Mono<XmlResponse> testPostXmlMsg(@RequestBody XmlRequestMsg request) {
        XmlResponse response = new XmlResponse();
        response.setId(request.getField().toString());
        response.setName("name:" + LocalDateTime.now());
        return Mono.just(response).delaySubscription(Duration.ofMillis(3000));
    }
}
