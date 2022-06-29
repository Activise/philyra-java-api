package io.activise.philyra.codec;

import java.util.Collections;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.pojo.PropertyCodecProvider;
import org.bson.codecs.pojo.PropertyCodecRegistry;
import org.bson.codecs.pojo.TypeWithTypeParameters;

import io.activise.philyra.mapping.EntityMappingProvider;

@SuppressWarnings({ "all" })
public class MongoInterfaceCodecProvider implements PropertyCodecProvider {
  @Inject
  EntityMappingProvider mappingProvider;

  @Override
  public <T> Codec<T> get(TypeWithTypeParameters<T> type, PropertyCodecRegistry registry) {
    var target = mappingProvider.getTarget(type.getType());

    if (!target.isPresent()) {
      return null;
    }

    var valueCodec = registry.get(new TypeWithoutTypeParameters(target.get()));
    return new InterfaceToImplementationCodec(type.getType(), valueCodec);
  }

  private static class TypeWithoutTypeParameters<T> implements TypeWithTypeParameters<T> {
    private Class<T> type;

    public TypeWithoutTypeParameters(Class<T> type) {
      this.type = type;
    }

    @Override
    public Class<T> getType() {
      return type;
    }

    @Override
    public List<? extends TypeWithTypeParameters<?>> getTypeParameters() {
      return Collections.emptyList();
    }
  }

  private static final class InterfaceToImplementationCodec<T> implements Codec {
    private final Class encoderClass;
    private final Codec codec;

    private InterfaceToImplementationCodec(Class<?> encoderClass, Codec<T> codec) {
      this.encoderClass = encoderClass;
      this.codec = codec;
    }

    @Override
    public void encode(BsonWriter writer, Object object, EncoderContext encoderContext) {
      if (object != null) {
        codec.encode(writer, object, encoderContext);
      } else {
        writer.writeNull();
      }
    }

    @Override
    public Object decode(BsonReader reader, DecoderContext context) {
      return codec.decode(reader, context);
    }

    @Override
    public Class<?> getEncoderClass() {
      return encoderClass;
    }
  }
}
