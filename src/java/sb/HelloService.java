package sb;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope( value = ConfigurableBeanFactory.SCOPE_PROTOTYPE/*,
        proxyMode = ScopedProxyMode.TARGET_CLASS*/)
public class HelloService {

    HelloService() {
        System.out.println("Constructor of HelloService");
    }

    public void printString() {
        System.out.println("printString of HelloService");
    }
}
