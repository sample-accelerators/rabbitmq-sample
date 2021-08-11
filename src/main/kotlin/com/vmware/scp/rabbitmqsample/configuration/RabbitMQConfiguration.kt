package com.vmware.scp.rabbitmqsample.configuration

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.core.RabbitAdmin
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfiguration {

    @Value("\${spring.rabbitmq.template.default-receive-queue}")
    private val queueName = defaultQueue

    @Bean
    fun admin(template: RabbitTemplate): RabbitAdmin {
        return RabbitAdmin(template)
    }

    @Bean
    fun defaultQueue(): Queue {
        return Queue(queueName)
    }

    @Bean
    fun defaultQueueBinding(template: RabbitTemplate): Binding {
        return Binding(queueName, Binding.DestinationType.QUEUE, template.exchange, template.routingKey, null)
    }

}