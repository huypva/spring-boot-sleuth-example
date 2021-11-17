package io.codebyexample.sleuth.core.usecase;

import io.codebyexample.sleuth.core.entity.Greeting;

/**
 * @author huypva
 */
public interface GreetUseCase {

  Greeting greet(String name);
}
