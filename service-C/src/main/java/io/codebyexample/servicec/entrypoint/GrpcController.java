package io.codebyexample.servicec.entrypoint;

import io.codebyexample.servicec.proto.v1.GreetRequest;
import io.codebyexample.servicec.proto.v1.GreetResponse;
import io.codebyexample.servicec.proto.v1.ServiceCGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * @author huypva
 */
@Slf4j
@GrpcService
public class GrpcController extends ServiceCGrpc.ServiceCImplBase {

  @Override
  public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
    log.info("ServiceC.greet " + request.getId());
    GreetResponse response = GreetResponse.newBuilder()
        .setMessage("Message C")
        .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

}
