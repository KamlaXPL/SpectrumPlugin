package me.kamlax.spectrum.helper;


import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * @author KamlaX on 26.02.2020
 */

public class ItemBuilder {

    public ItemBuilder() {
    }

    private ItemStack itemStack = new ItemStack(Material.AIR);

    private ItemMeta itemMeta = itemStack.getItemMeta();

    public ItemBuilder setMaterial(Material material) {
        itemStack.setType(material);
        return this;
    }

    public ItemBuilder addEnchant(Enchantment enchantment, int level) {
        itemStack.addEnchantment(enchantment, level);
        return this;
    }

    public ItemStack build() {
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
