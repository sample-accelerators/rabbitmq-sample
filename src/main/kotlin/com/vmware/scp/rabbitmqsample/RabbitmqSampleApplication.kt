package com.vmware.scp.rabbitmqsample

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class RabbitmqSampleApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(RabbitmqSampleApplication::class.java, *args)
        }
    }
}