package buildcraft.api.schematics;

import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import java.util.function.Function;
import java.util.function.Predicate;

public class SchematicBlockFactory<S extends ISchematicBlock<S>> implements Comparable<SchematicBlockFactory> {
    @Nonnull
    public final ResourceLocation name;
    public final int priority;
    @Nonnull
    public final Predicate<SchematicBlockContext> predicate;
    @Nonnull
    public final Function<SchematicBlockContext, S> create;
    @Nonnull
    public final Class<S> clazz;

    public SchematicBlockFactory(@Nonnull ResourceLocation name,
                                 int priority,
                                 @Nonnull Predicate<SchematicBlockContext> predicate,
                                 @Nonnull Function<SchematicBlockContext, S> create,
                                 @Nonnull Class<S> clazz) {
        this.name = name;
        this.priority = priority;
        this.predicate = predicate;
        this.create = create;
        this.clazz = clazz;
    }

    @Override
    public int compareTo(@Nonnull SchematicBlockFactory o) {
        return priority != o.priority
                ? Integer.compare(priority, o.priority)
                : name.toString().compareTo(o.name.toString());
    }
}
