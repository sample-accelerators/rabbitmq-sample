package com.vmware.scp.rabbitmqsample.controllers

import com.vmware.scp.rabbitmqsample.configuration.RabbitMQClient
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import java.lang.Exception
import java.util.*


@Controller
class InfoController(private val rabbitMQClient: RabbitMQClient) {
    private var open = false;

    @GetMapping("/")
    @Throws(Exception::class)
    fun mainPage(model: Model): String {
        try {
            val message = "Generated message: " + UUID.randomUUID().toString()
            rabbitMQClient.send(message)
            val receivedMessage: String = rabbitMQClient.receive()

            open = !open
            model.addAttribute("open", open)
            model.addAttribute("message_sent", message)
            model.addAttribute("message_received", receivedMessage)
            model.addAttribute("connection_status", "Connected and sent message:)")
        } catch (e: Exception) {
            e.printStackTrace()
            model.addAttribute("connection_status", "Failed: " + e.message)
        }
        return "info"
    }
}
