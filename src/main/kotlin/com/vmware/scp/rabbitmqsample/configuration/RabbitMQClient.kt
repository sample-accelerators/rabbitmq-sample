package com.vmware.scp.rabbitmqsample.configuration

import org.slf4j.LoggerFactory
import org.springframework.amqp.AmqpException
import org.springframework.amqp.core.Message
import org.springframework.amqp.core.MessageProperties
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component


@Component
class RabbitMQClient(private val template: RabbitTemplate) {
    private val log = LoggerFactory.getLogger(this.javaClass)

    val Message.stringContent: String
        get() {
            val noReply = "[message body absent]".toByteArray(Charsets.UTF_8)
            val messageBody = body ?: noReply
            return String(messageBody, Charsets.UTF_8)
        }

    @Throws(PublishException::class)
    fun send(message: String) {
        log.debug("Sending: {}", message)
        val outgoingMessage = Message(message.toByteArray(Charsets.UTF_8), MessageProperties())
        try {
            template.send(outgoingMessage)
        } catch (e: AmqpException) {
            throw PublishException("Could not publish message: $message", e)
        }
    }

    fun receive(): String {
        log.debug("Attempting to receive message from the default queue")
        val message = template.receive(1000)?.stringContent
        log.debug("Received message: {}", message)
        return message ?: "[No message received]"
    }

    class PublishException internal constructor(message: String?, e: Throwable?) :
        Exception(message, e)
}
