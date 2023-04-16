package pt.ipb.sys.service;

import io.grpc.stub.StreamObserver;
import pt.ipb.proto.HelloRequest;
import pt.ipb.proto.HelloResponse;
import pt.ipb.proto.HelloServiceGrpc;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    private Object gretting;

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String greeting = new StringBuilder()
                .append("Hello, ")
                .append(request.getFirstName())
                .append(" ")
                .append(request.getLastName()).toString();

        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();

       responseObserver.onNext(response);
       responseObserver.onCompleted();
    }
}
