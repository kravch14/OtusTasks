package properties;

import java.util.Optional;

public class GetProperty {

    public static Optional<String> getProp(String propertyName) {
        return Optional.ofNullable(System.getProperty(propertyName));
        //return Optional.ofNullable(System.getProperty(propertyName)).isPresent()?Optional.ofNullable(System.getProperty(propertyName)):Optional.ofNullable(System.getenv(propertyName));
    }
}