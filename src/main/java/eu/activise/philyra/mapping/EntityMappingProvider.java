package eu.activise.philyra.mapping;

import java.util.Optional;

public interface EntityMappingProvider {
  Optional<Class<?>> getTarget(Class<?> type);
}
