package ecall.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import ecall.config.kafka.KafkaProcessor;
import ecall.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    DispatchRepository dispatchRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Called'"
    )
    public void wheneverCalled_GetHelp(@Payload Called called) {
        Called event = called;
        System.out.println("\n\n##### listener GetHelp : " + called + "\n\n");

        // Sample Logic //
        Dispatch.getHelp(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CallCanceled'"
    )
    public void wheneverCallCanceled_Malfunction(
        @Payload CallCanceled callCanceled
    ) {
        CallCanceled event = callCanceled;
        System.out.println(
            "\n\n##### listener Malfunction : " + callCanceled + "\n\n"
        );

        // Sample Logic //
        Dispatch.malfunction(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
