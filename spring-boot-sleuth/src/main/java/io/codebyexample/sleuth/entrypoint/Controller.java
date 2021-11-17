package io.codebyexample.sleuth.entrypoint;

import io.codebyexample.sleuth.core.entity.Greeting;
import io.codebyexample.sleuth.core.usecase.GreetUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huypva
 */
@RestController
public class Controller {

  @Autowired
  GreetUseCase greetUseCase;

  @GetMapping("/greet")
  public Greeting greet(@RequestParam(name = "name") String name) {
    return greetUseCase.greet(name);
  }
}
