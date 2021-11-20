package io.codebyexample.servicea.entrypoint;

import brave.sampler.Sampler;
import io.codebyexample.servicea.core.entity.Greeting;
import io.codebyexample.servicea.core.usecase.GreetUseCase;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huypva
 */
@Setter
@Slf4j
@RestController
public class Controller {

  @Autowired
  GreetUseCase greetUseCase;

  @Bean
  public Sampler defaultSampler() {
    return Sampler.ALWAYS_SAMPLE;
  }

  @GetMapping("/greetb/{id}")
  public Greeting greetB(@PathVariable(name = "id") int id) {
    log.info("GreetB");
    return greetUseCase.greetB(id);
  }

  @GetMapping("/greetc/{id}")
  public Greeting greetC(@PathVariable(name = "id") int id) {
    log.info("GreetC");
    return greetUseCase.greetC(id);
  }
}
