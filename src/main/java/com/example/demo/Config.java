package com.example.demo;

import org.springframework.boot.actuate.health.CompositeHealthIndicator;
import org.springframework.boot.actuate.health.DefaultHealthIndicatorRegistry;
import org.springframework.boot.actuate.health.HealthAggregator;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.HealthIndicatorRegistry;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "monitoring")
public class Config {
  private Long id;

  @Bean
  public HealthIndicator healthIndicator(HealthAggregator healthAggregator) {
    HealthIndicatorRegistry healthIndicatorRegistry = new DefaultHealthIndicatorRegistry();
    return new CompositeHealthIndicator(healthAggregator, healthIndicatorRegistry);
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
