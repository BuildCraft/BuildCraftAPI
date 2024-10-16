package buildcraft.api.statements;

import net.minecraft.util.Direction;

public interface ITriggerInternalSided extends ITrigger {
    boolean isTriggerActive(Direction side, IStatementContainer source, IStatementParameter[] parameters);
}
