package io.codebyexample.servicea.dataprovider.servicec;

import io.codebyexample.servicea.proto.v1.GreetRequest;
import io.codebyexample.servicea.proto.v1.GreetResponse;
import io.codebyexample.servicea.proto.v1.ServiceCGrpc.ServiceCBlockingStub;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Repository;

/**
 * @author huypva
 * */
@Slf4j
@Repository
public class ServiceCClientImpl implements ServiceCClient {

  @GrpcClient("servicec")
  private ServiceCBlockingStub serviceCBlockingStub;

  @Override
  public MessageC greet(int id) {
    GreetRequest request = GreetRequest.newBuilder()
        .setId(id)
        .build();

    GreetResponse response = this.serviceCBlockingStub.greet(request);
    return new MessageC(response.getMessage());
  }
}
