import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@EnableEurekaClient
@Component
public class GreeterServiceConsumer {
    @Autowired
    private EurekaClient client;

    public void greet(String name) {
        final InstanceInfo instanceInfo = client.getNextServerFromEureka("my-service-name", false);(1)
        final ManagedChannel channel = ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(), instanceInfo.getPort())
                .usePlaintext(true)
                .build(); (2)
        final GreeterServiceGrpc.GreeterServiceFutureStub stub = GreeterServiceGrpc.newFutureStub(channel); (3)
        stub.greet(name); (4)

    }
}