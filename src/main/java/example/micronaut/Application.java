package example.micronaut;

import io.micronaut.context.ApplicationContext;
import io.micronaut.context.annotation.Property;
import io.micronaut.runtime.Micronaut;
import jakarta.inject.Singleton;

@Singleton
@Property(name="REGISTRY_HOST", value="test-host")
public class Application {
    public static void main(String[] args) {
        ApplicationContext ctx = Micronaut.build(args).mainClass(Application.class).banner(false).start();
    }
}