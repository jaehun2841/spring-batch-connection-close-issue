package com.example.test.spring_batch

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TestJobConfiguration(
  private val jobBuilderFactory: JobBuilderFactory,
  private val stepBuilderFactory: StepBuilderFactory
) {

  @Bean
  fun testJob(): Job {
    return jobBuilderFactory.get("testJob")
      .start(testStep())
      .build()
  }

  @Bean
  fun testStep(): Step {
    val testList = (1..100_000).map { it }.toList()
    return stepBuilderFactory.get("testStep")
      .chunk<Int, Int>(100)
      .reader(DelayedItemReader(testList))
      .writer {
        it.forEach { int ->
          print("$int ")
        }
      }
      .build()
  }
}