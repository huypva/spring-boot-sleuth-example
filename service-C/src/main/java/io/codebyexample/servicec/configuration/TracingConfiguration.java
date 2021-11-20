package io.codebyexample.servicec.configuration;

import brave.Tracing;
import brave.grpc.GrpcTracing;
import io.grpc.ServerInterceptor;
import net.devh.boot.grpc.server.interceptor.GrpcGlobalServerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huypva
 */
@Configuration
public class TracingConfiguration {

  @Bean
  public GrpcTracing grpcTracing(Tracing tracing) {
    return GrpcTracing.create(tracing);
  }

  @Bean
  @GrpcGlobalServerInterceptor
  ServerInterceptor grpcServerSleuthInterceptor(GrpcTracing grpcTracing) {
    return grpcTracing.newServerInterceptor();
  }

}
