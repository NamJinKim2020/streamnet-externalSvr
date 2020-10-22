package streamnet;

import streamnet.config.kafka.KafkaProcessor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverRegistered_Mailing(@Payload Registered registered){

        if(registered.isMe()){
            System.out.println("##### listener Mailing : " + registered.toJson());

            System.out.println("$$$$$$ Registration Mailing Address : " + registered.getEmail() +
                    " $$$$$ Name : " + registered.getName() + " $$$$$");
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverWithdrawn_Mailing(@Payload Withdrawn withdrawn){

        if(withdrawn.isMe()){
            System.out.println("##### listener Mailing : " + withdrawn.toJson());

            System.out.println("$$$$$$ Withdrawal Mailing Address : " + withdrawn.getEmail() +
                    " $$$$$ Phone No : " + withdrawn.getPhone() + " $$$$$");
        }
    }

}
