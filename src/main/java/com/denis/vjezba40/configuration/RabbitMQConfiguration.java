package com.denis.vjezba40.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {
    @Bean
    public Exchange directExchange() {
        return ExchangeBuilder.directExchange("DIRECT_EXCHANGE").build();
    }

    @Bean
    public Exchange fanoutExchange() {
        return ExchangeBuilder.fanoutExchange("FANOUT_EXCHANGE").build();
    }

    @Bean Exchange topicExchange() {
        return ExchangeBuilder.topicExchange("TOPIC_EXCHANGE").build();
    }

    @Bean
    public Queue footballQueue() {
        return QueueBuilder.durable("football").build();
    }

    @Bean
    public Queue basketballQueue() {
        return QueueBuilder.durable("basketball").build();
    }

    @Bean
    public Binding footballBindingD(Queue footballQueue, DirectExchange exchange) {
        return BindingBuilder.bind(footballQueue).to(exchange).with("football");
    }

    @Bean
    public Binding basketballBindingD(Queue basketballQueue, DirectExchange exchange) {
        return BindingBuilder.bind(basketballQueue).to(exchange).with("basketball");
    }

    @Bean
    public Binding footballBindingF(Queue footballQueue, FanoutExchange exchange) {
        return BindingBuilder.bind(footballQueue).to(exchange);
    }

    @Bean
    public Binding basketballBindingF(Queue basketballQueue, FanoutExchange exchange) {
        return BindingBuilder.bind(basketballQueue).to(exchange);
    }

    @Bean
    public Binding footballBindingT(Queue footballQueue, TopicExchange exchange) {
        return BindingBuilder.bind(footballQueue).to(exchange).with("sport.football.#");
    }

    @Bean
    public Binding basketballQueueT(Queue basketballQueue, TopicExchange exchange) {
        return BindingBuilder.bind(basketballQueue).to(exchange).with("sport.basketball.#");
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }
}
