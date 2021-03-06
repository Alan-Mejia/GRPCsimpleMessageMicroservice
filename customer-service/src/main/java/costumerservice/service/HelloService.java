package costumerservice.service;

import org.springframework.beans.factory.annotation.Autowired;

import grpc.HelloReply;
import grpc.HelloRequest;
import grpc.MyServiceGrpc.MyServiceImplBase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloService extends MyServiceImplBase{

	@Override
	public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver)  {
		System.out.println("Metodo Accionado desde el otro servicio");

		HelloReply response = HelloReply.newBuilder()
                .setMessage(request.getName() + "Saludos")
                .build();
		responseObserver.onNext(response);
        responseObserver.onCompleted();
	}
}
