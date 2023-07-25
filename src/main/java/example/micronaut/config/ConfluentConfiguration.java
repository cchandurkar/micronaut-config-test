package example.micronaut.config;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.convert.format.MapFormat;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Serdeable
@ConfigurationProperties("confluent")
public class ConfluentConfiguration {

    private List<ConfluentConfig> config;

    @Getter
    @Setter
    @Serdeable
    public static class ConfluentConfig {
        private String name;
        private String host;
        private KafkaConfig kafka;
        private List<Map<String, String>> secrets = new ArrayList<>();
    }

    @Getter
    @Setter
    @Serdeable
    public static class KafkaConfig {
        @MapFormat(transformation = MapFormat.MapTransformation.FLAT)
        private Map<String, String> secrets = new HashMap<>();
    }



}
