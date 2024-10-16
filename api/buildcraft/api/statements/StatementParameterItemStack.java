/** Copyright (c) 2011-2015, SpaceToad and the BuildCraft Team http://www.mod-buildcraft.com
 *
 * BuildCraft is distributed under the terms of the Minecraft Mod Public License 1.0, or MMPL. Please check the contents
 * of the license located in http://www.mod-buildcraft.com/MMPL-1.0.txt */
package buildcraft.api.statements;

import buildcraft.api.core.render.ISprite;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StatementParameterItemStack implements IStatementParameter {
    // needed because ItemStack.EMPTY doesn't have @Nonnull applied to it :/
    @Nonnull
    private static final ItemStack EMPTY_STACK;

    /** Immutable parameter that has the {@link ItemStack#EMPTY} as it's {@link #stack}. */
    public static final StatementParameterItemStack EMPTY;

    static {
        ItemStack stack = ItemStack.EMPTY;
        if (stack == null) throw new Error("Somehow ItemStack.EMPTY was null!");
        EMPTY_STACK = stack;
        EMPTY = new StatementParameterItemStack();
    }

    @Nonnull
    protected final ItemStack stack;

    public StatementParameterItemStack() {
        stack = EMPTY_STACK;
    }

    public StatementParameterItemStack(@Nonnull ItemStack stack) {
        this.stack = stack;
    }

    public StatementParameterItemStack(CompoundNBT nbt) {
        ItemStack read = ItemStack.of(nbt.getCompound("stack"));
        if (read.isEmpty()) {
            stack = EMPTY_STACK;
        } else {
            stack = read;
        }
    }

    @Override
    public void writeToNbt(CompoundNBT compound) {
        if (!stack.isEmpty()) {
            CompoundNBT tagCompound = new CompoundNBT();
            stack.save(tagCompound);
            compound.put("stack", tagCompound);
        }
    }

    @Override
    public ISprite getSprite() {
        return null;
    }

    @Override
    @Nonnull
    public ItemStack getItemStack() {
        return stack;
    }

    @Override
    public StatementParameterItemStack onClick(
            IStatementContainer source, IStatement stmt, ItemStack stack, StatementMouseClick mouse
    ) {
        if (stack.isEmpty()) {
            return EMPTY;
        } else {
            ItemStack newStack = stack.copy();
            newStack.setCount(1);
            return new StatementParameterItemStack(newStack);
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof StatementParameterItemStack) {
            StatementParameterItemStack param = (StatementParameterItemStack) object;

            return ItemStack.matches(stack, param.stack);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(stack);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public ITextComponent getDescription() {
        throw new UnsupportedOperationException("Don't call getDescription directly!");
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public String getDescriptionKey() {
        throw new UnsupportedOperationException("Don't call getDescription directly!");
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public List<ITextComponent> getTooltip() {
        if (stack.isEmpty()) {
            return ImmutableList.of();
        }
        List<ITextComponent> tooltip = stack.getTooltipLines(null, ITooltipFlag.TooltipFlags.NORMAL);
        if (!tooltip.isEmpty()) {
            tooltip.set(0, new StringTextComponent(stack.getRarity().color.toString()).append(tooltip.get(0)));
            for (int i = 1; i < tooltip.size(); i++) {
                tooltip.set(i, new StringTextComponent(TextFormatting.GRAY.toString()).append(tooltip.get(i)));
            }
        }
        return tooltip;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public List<String> getTooltipKey() {
        if (stack.isEmpty()) {
            return ImmutableList.of();
        }
        List<ITextComponent> tooltip = stack.getTooltipLines(null, ITooltipFlag.TooltipFlags.NORMAL);
        List<String> toolTipRet = new ArrayList<>(tooltip.size());
        if (!tooltip.isEmpty()) {
            toolTipRet.set(0, new StringTextComponent(stack.getRarity().color.toString()).append(tooltip.get(0)).getString());
            for (int i = 1; i < tooltip.size(); i++) {
                toolTipRet.set(i, new StringTextComponent(TextFormatting.GRAY.toString()).append(tooltip.get(i)).getString());
            }
        }
        return toolTipRet;
    }

    @Override
    public String getUniqueTag() {
        return "buildcraft:stack";
    }

    @Override
    public IStatementParameter rotateLeft() {
        return this;
    }

    @Override
    public IStatementParameter[] getPossible(IStatementContainer source) {
        return null;
    }
}
