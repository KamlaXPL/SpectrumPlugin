package me.kamlax.spectrum.helper;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

/**
 * @author KamlaX on 26.02.2020
 */

public final class ItemBuilder {

    private final ItemStack itemStack;

    public ItemBuilder(final ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public static ItemBuilder of(final ItemStack itemStack) {
        return new ItemBuilder(itemStack);
    }

    public ItemBuilder addEnchant(Enchantment enchantment, int level) {
        itemStack.addEnchantment(enchantment, level);
        return this;
    }

    public ItemStack build() {
        return itemStack;
    }
}