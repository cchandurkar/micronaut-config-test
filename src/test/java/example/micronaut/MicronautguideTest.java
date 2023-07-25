package example.micronaut;

import example.micronaut.config.ConfluentConfiguration;
import io.micronaut.context.annotation.Property;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

import java.util.List;
import java.util.Map;

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
        ConfluentConfiguration confluent = application.getApplicationContext().getBean(ConfluentConfiguration.class);

        // Assertion Passes
        Map<String, String> confluentSecrets = confluent.getConfig().get(0).getSecrets().get(0);
        assert confluentSecrets.get("api_key").equals("test-key");
        assert confluentSecrets.get("api_secret").equals("test-secret");

        // Following Assertion Fails
        Map<String, String> kafkaSecrets = confluent.getConfig().get(0).getKafka().getSecrets();
        assert kafkaSecrets.get("api_key").equals("test-key");
        assert kafkaSecrets.get("api_secret").equals("test-secret");
    }

}
