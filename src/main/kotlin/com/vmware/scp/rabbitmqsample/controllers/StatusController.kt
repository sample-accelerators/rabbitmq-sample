package com.vmware.scp.rabbitmqsample.controllers

import com.vmware.scp.rabbitmqsample.configuration.RabbitMQClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController;
import java.lang.Exception
import java.util.*


@RestController
class StatusController() {

    @GetMapping("/status")
    @Throws(Exception::class)
    fun status(): Boolean {
        return true  
    }
}
