package buildcraft.api.statements;

import net.minecraft.util.Direction;

public interface IActionInternalSided extends IAction {
    void actionActivate(Direction side, IStatementContainer source, IStatementParameter[] parameters);
}
