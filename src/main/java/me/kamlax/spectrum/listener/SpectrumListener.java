package me.kamlax.spectrum.listener;

import me.kamlax.spectrum.helper.ChatColorHelper;
import me.kamlax.spectrum.helper.ItemBuilder;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * @author KamlaX on 26.02.2020
 */

public class SpectrumListener implements Listener {

    private final ItemStack sword, helmet, boots, skull;

    public SpectrumListener() {
        sword = new ItemBuilder()
                .setMaterial(Material.DIAMOND_SWORD)
                .addEnchant(Enchantment.DAMAGE_ALL, 3)
                .build();
        helmet = new ItemBuilder()
                .setMaterial(Material.DIAMOND_HELMET)
                .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10)
                .addEnchant(Enchantment.DURABILITY, 10)
                .build();
        boots = new ItemBuilder()
                .setMaterial(Material.DIAMOND_BOOTS)
                .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10)
                .addEnchant(Enchantment.DURABILITY, 10)
                .build();
        skull = new ItemBuilder()
                .setMaterial(Material.SKULL_ITEM)
                .build();
    }

    public void spawnSpectrum(Location location) {
        final Skeleton spectrum = (Skeleton) location.getWorld().spawnEntity(location, EntityType.SKELETON.WITHER);
        spectrum.setCustomName(ChatColorHelper.fixColor("&8>> &9&lBoss &8<<"));
        spectrum.setMaxHealth(100.0);
        spectrum.setHealth(100);
        spectrum.getEquipment().setHelmet(helmet);
        spectrum.getEquipment().setBoots(boots);
        spectrum.getEquipment().setItemInHand(sword);
        spectrum.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999999, 1));
    }

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        final boolean rightclick = e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK;
        if(p.getItemInHand() != null
                && rightclick
                && p.getItemInHand().getType().equals(skull)
                && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColorHelper.fixColor("&8>> &9&lBoss &8<<"))) {
            p.getInventory().remove(skull);
            spawnSpectrum(p.getLocation());
            p.sendTitle("", ChatColorHelper.fixColor("&8>> &bZrespiono &9Boss'a &8<<"));
        }
    }

    @EventHandler
    public void onDeath(EntityDeathEvent e) {
        final Entity entity = e.getEntity();
        if (e.getEntity().getKiller() instanceof Player &&
                entity instanceof Skeleton && (entity).getCustomName() != null &&
                (entity).getCustomName().equalsIgnoreCase(ChatColorHelper.fixColor("&8>> &9&lBoss &8<<"))) {
            e.getDrops().clear();
            e.getEntity().getKiller().sendTitle("", ChatColorHelper.fixColor("&8>> &7Zabiles &9Boss'a &8<<"));
        }
    }
}
