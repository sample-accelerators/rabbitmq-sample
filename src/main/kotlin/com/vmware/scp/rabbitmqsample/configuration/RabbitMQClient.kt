package com.vmware.scp.rabbitmqsample.configuration

import org.slf4j.LoggerFactory
import org.springframework.amqp.AmqpException
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.lang.Exception


@Component
class RabbitMQClient(private val template: RabbitTemplate) {
    private val log = LoggerFactory.getLogger(this.javaClass)

    @Value("\${exchangeName}")
    private val exchangeName = defaultExchangeName

    @Value("\${routingKey}")
    private val routingKey = defaultRoutingKey

    @Throws(PublishException::class)
    fun send(message: String) {
        log.info("Sending: {}", message)
        try {
            template.convertAndSend(exchangeName, routingKey, message)
        } catch (e: AmqpException) {
            throw PublishException("Could not publish message: $message", e)
        }
    }

    fun receive(): String {
        val message = template.receive(1000)
        return String(message!!.body)
    }

    class PublishException internal constructor(message: String?, e: Throwable?) :
        Exception(message, e)
}
