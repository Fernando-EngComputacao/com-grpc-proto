package pt.ipb.sys.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import pt.ipb.proto.HelloRequest;
import pt.ipb.proto.HelloResponse;
import pt.ipb.proto.HelloServiceGrpc;

public class Client {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc
                .newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(
                HelloRequest.newBuilder()
                        .setFirstName("Sistemas")
                        .setLastName("Distribuídos")
                        .build()
        );

        System.out.println(helloResponse.getGreeting());
        channel.shutdown();
    }
}
