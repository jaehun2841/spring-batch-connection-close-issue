package com.example.test.spring_batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import kotlin.system.exitProcess

@SpringBootApplication
@EnableBatchProcessing
class SpringBatchConnectionTestApplication

fun main(args: Array<String>) {
    exitProcess(
      SpringApplication.exit(SpringApplication.run(SpringBatchConnectionTestApplication::class.java, *args))
    )
}

