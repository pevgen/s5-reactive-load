package ml.pevgen.reactive.load.publisher;

import reactor.core.publisher.Mono;


public class MessagePublisher {

    public static Mono<String> ff(final String message) {

        Mono<String> bridge = Mono.create(sink -> {
            System.out.println("complete");
            sink.success("Request meassge :" + message);
//           myMessageProcessor.register(
//                   new MyMessageListener<String>() {
//
//                       public void onMessage(List<String> messages) {
//                           for(String s : messages) {
//                               sink.next(s);
//                           }
//                       }
//                   });
//           sink.onRequest(n -> {
//               List<String> messages = myMessageProcessor.request(n);
//               for(String s : message) {
//                   sink.next(s);
//               }
//           });
        });
        return bridge;
    }
}
