package br.com.yfsmsystem.producer.configuration;


import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
class DirectConfig {

    private final QueueConfig operationRabbit;

    //Create Exchange, type direct
    @Bean
    public Exchange directExchange() {
        return ExchangeBuilder
                .directExchange("ExchangeDirect")
                .durable(true)
                .build();
    }

    //Create Queues
    @Bean
    public Binding firstDirectBinding() {
        return BindingBuilder
                .bind(operationRabbit.firstQueue())
                .to(directExchange())
                .with("TO-FIRST-QUEUE")
                .noargs();

    }

    @Bean
    public Binding secondDirectBinding() {
        return BindingBuilder
                .bind(operationRabbit.secondQueue())
                .to(directExchange())
                .with("TO-SECOND-QUEUE")
                .noargs();
    }
}