package example.micronaut.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.context.annotation.ConfigurationBuilder;
import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.context.annotation.EachProperty;
import io.micronaut.core.convert.format.MapFormat;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Builder;
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
        private Map<String, Map<String, String>> kafka = new HashMap<>();

        @MapFormat(transformation = MapFormat.MapTransformation.FLAT)
        private List<Map<String, String>> secrets = new ArrayList<>();

        public String getId(){
            return host + ":" + name;
        }

    }

//    @Getter
//    @Setter
//    @Serdeable
//    public static class KafkaConfig {
//        @MapFormat(transformation = MapFormat.MapTransformation.FLAT)
//        private Map<String, String> secrets = new HashMap<>();
//    }



}
