package br.com.bbarros.pocgrpc.service;

import br.com.bbarros.pocgrpc.CustomerRequest;
import br.com.bbarros.pocgrpc.CustomerResponse;
import br.com.bbarros.pocgrpc.CustomerServiceGrpc;
import io.grpc.stub.StreamObserver;

public class CustomerServiceImpl extends CustomerServiceGrpc.CustomerServiceImplBase {
    @Override
    public void create(CustomerRequest request, StreamObserver<CustomerResponse> responseObserver) {
        if(request.getName() == null || request.getName().isEmpty())
        {
//            responseObserver.onError(new RpcException("Nome é obrigatório"));
//            responseObserver.onCompleted();
            throw new IllegalArgumentException("Nome em branco.");
        }
        CustomerResponse customerResponse = CustomerResponse.newBuilder().setCustomerId(1L).build();
        responseObserver.onNext(customerResponse);
        responseObserver.onCompleted();
    }
}
