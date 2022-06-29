package io.activise.philyra.mapping;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public interface EntityMappingProvider {
  Optional<Class<?>> getTarget(Class<?> type);

  public static class HashMapEntityMappingProvider implements EntityMappingProvider {
    protected Map<Class<?>, Class<?>> mappingIndex = new HashMap<>();

    @Override
    public Optional<Class<?>> getTarget(Class<?> type) {
      return Optional.ofNullable(mappingIndex.get(type));
    }
  }
}
