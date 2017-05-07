package buildcraft.api.schematics;

import buildcraft.api.core.BuildCraftAPI;
import com.google.common.collect.ImmutableList;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SchematicEntityFactoryRegistry {
    private static final Set<SchematicEntityFactory<?>> FACTORIES = new TreeSet<>();

    public static <S extends ISchematicEntity<S>> void registerFactory(String name,
                                                                       int priority,
                                                                       Predicate<SchematicEntityContext> predicate,
                                                                       Supplier<S> supplier) {
        FACTORIES.add(new SchematicEntityFactory<>(
                BuildCraftAPI.nameToResourceLocation(name),
                priority,
                predicate,
                supplier
        ));
    }

    public static List<SchematicEntityFactory<?>> getFactories() {
        return ImmutableList.copyOf(FACTORIES);
    }

    @Nonnull
    public static SchematicEntityFactory<?> getFactoryByInstance(ISchematicEntity<?> instance) {
        return FACTORIES.stream()
                .filter(schematicEntityFactory -> schematicEntityFactory.supplier.get().getClass() == instance.getClass())
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    @Nonnull
    public static SchematicEntityFactory<?> getFactoryByName(ResourceLocation name) {
        return FACTORIES.stream()
                .filter(schematicEntityFactory -> schematicEntityFactory.name.equals(name))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
