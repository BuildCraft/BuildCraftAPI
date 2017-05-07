package buildcraft.api.schematics;

import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SchematicEntityFactory<S extends ISchematicEntity<S>> implements Comparable<SchematicEntityFactory> {
    @Nonnull
    public final ResourceLocation name;
    public final int priority;
    @Nonnull
    public final Predicate<SchematicEntityContext> predicate;
    @Nonnull
    public final Supplier<S> supplier;

    public SchematicEntityFactory(@Nonnull ResourceLocation name,
                                  int priority,
                                  @Nonnull Predicate<SchematicEntityContext> predicate,
                                  @Nonnull Supplier<S> supplier) {
        this.name = name;
        this.priority = priority;
        this.predicate = predicate;
        this.supplier = supplier;
    }

    @Override
    public int compareTo(@Nonnull SchematicEntityFactory o) {
        return priority != o.priority
                ? Integer.compare(priority, o.priority)
                : name.toString().compareTo(o.name.toString());
    }
}
