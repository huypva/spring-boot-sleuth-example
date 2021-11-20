package io.codebyexample.servicea.dataprovider.servicec;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author huypva
 * */
@Slf4j
//@Component
public class ServiceCClientMock implements ServiceCClient {

  @Override
  public String greet(int id) {
    return "Mock";
  }
}
