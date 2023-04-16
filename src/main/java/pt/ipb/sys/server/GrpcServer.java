package pt.ipb.sys.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import pt.ipb.sys.service.HelloServiceImpl;

import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8080)
                .addService(new HelloServiceImpl()).build();

        server.start();
        server.awaitTermination();

    }
}
