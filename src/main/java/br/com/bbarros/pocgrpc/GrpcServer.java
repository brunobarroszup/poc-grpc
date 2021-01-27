package br.com.bbarros.pocgrpc;

import br.com.bbarros.pocgrpc.handle.ExceptionHandler;
import br.com.bbarros.pocgrpc.service.CustomerServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(8080)
                .addService(new HelloServiceImpl())
                .addService(new CustomerServiceImpl())
                .intercept(new ExceptionHandler())
                .build();

        server.start();
        System.out.println("gRPC Server started, listening on port:" + server.getPort());
        server.awaitTermination();
    }
}
