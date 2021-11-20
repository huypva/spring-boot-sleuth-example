package io.codebyexample.serviceb.entrypoint;

import brave.sampler.Sampler;
import io.codebyexample.serviceb.core.entity.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huypva
 */
@Slf4j
@RestController
public class Controller {

  @Bean
  public Sampler defaultSampler() {
    return Sampler.ALWAYS_SAMPLE;
  }

  @GetMapping("/greet/{id}")
  public Greeting greet(@PathVariable(name = "id") int id) {
    log.info("ServiceB.greet");
    return new Greeting(1, "MessageB");
  }
}
