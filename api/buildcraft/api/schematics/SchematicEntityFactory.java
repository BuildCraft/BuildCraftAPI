package buildcraft.api.schematics;

import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import java.util.function.Function;
import java.util.function.Predicate;

public class SchematicEntityFactory<S extends ISchematicEntity<S>> implements Comparable<SchematicEntityFactory> {
    @Nonnull
    public final ResourceLocation name;
    public final int priority;
    @Nonnull
    public final Predicate<SchematicEntityContext> predicate;
    @Nonnull
    public final Function<SchematicEntityContext, S> create;
    @Nonnull
    public final Class<S> clazz;

    public SchematicEntityFactory(@Nonnull ResourceLocation name,
                                  int priority,
                                  @Nonnull Predicate<SchematicEntityContext> predicate,
                                  @Nonnull Function<SchematicEntityContext, S> create,
                                  @Nonnull Class<S> clazz) {
        this.name = name;
        this.priority = priority;
        this.predicate = predicate;
        this.create = create;
        this.clazz = clazz;
    }

    @Override
    public int compareTo(@Nonnull SchematicEntityFactory o) {
        return priority != o.priority
                ? Integer.compare(priority, o.priority)
                : name.toString().compareTo(o.name.toString());
    }
}
