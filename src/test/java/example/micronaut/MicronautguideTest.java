package example.micronaut;

import example.micronaut.config.ConfluentConfiguration;
import io.micronaut.context.annotation.Property;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

@MicronautTest
class MicronautguideTest {

    @Inject
    EmbeddedApplication<?> application;
    

    @Test
    @Property(name="REGISTRY_HOST", value="test-host")
    @Property(name="REGISTRY_API_KEY", value="test-key")
    @Property(name="REGISTRY_API_SECRET", value="test-secret")
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
        ConfluentConfiguration config = application.getApplicationContext().getBean(ConfluentConfiguration.class);
        assert config != null;
    }

}
