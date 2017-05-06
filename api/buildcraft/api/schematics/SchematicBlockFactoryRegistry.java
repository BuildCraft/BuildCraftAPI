package buildcraft.api.schematics;

import buildcraft.api.core.BuildCraftAPI;
import com.google.common.collect.ImmutableList;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;

public class SchematicBlockFactoryRegistry {
    private static final Set<SchematicBlockFactory<?>> FACTORIES = new TreeSet<>();

    public static <S extends ISchematicBlock<S>> void registerFactory(String name,
                                                                      int priority,
                                                                      Predicate<SchematicBlockContext> predicate,
                                                                      Function<SchematicBlockContext, S> create,
                                                                      Class<S> clazz) {
        FACTORIES.add(new SchematicBlockFactory<>(
                BuildCraftAPI.nameToResourceLocation(name),
                priority,
                predicate,
                create,
                clazz
        ));
    }

    public static List<SchematicBlockFactory<?>> getFactories() {
        return ImmutableList.copyOf(FACTORIES);
    }

    @Nonnull
    public static SchematicBlockFactory<?> getFactoryByInstance(ISchematicBlock<?> instance) {
        return FACTORIES.stream()
                .filter(schematicBlockFactory -> schematicBlockFactory.clazz == instance.getClass())
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    @Nonnull
    public static SchematicBlockFactory<?> getFactoryByName(ResourceLocation name) {
        return FACTORIES.stream()
                .filter(schematicBlockFactory -> schematicBlockFactory.name.equals(name))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
