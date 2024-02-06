package com.origemite.authserver.mq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TbProducer {

    private final KafkaProducer kafkaProducer;

    public void testsave(){

        kafkaProducer.send("origemitedb","");
    }

}
