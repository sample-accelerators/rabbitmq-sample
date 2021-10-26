package com.vmware.scp.rabbitmqsample.configuration

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
        info = Info(
                title = "Sensors Application",
                version = "0.2.0",
                description = "The application used to get the status of the very important sensor",))
public class OpenApiConfig {
}