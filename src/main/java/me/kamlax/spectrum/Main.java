package me.kamlax.spectrum;

import me.kamlax.spectrum.listener.SpectrumListener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author KamlaX on 27.02.2020
 */
public class Main extends JavaPlugin {
    public Main() {
        Main.plugin = this;
    }
    private static Main plugin;
    @Override
    public void onEnable() {
        Main.plugin = this;
        getServer().getPluginManager().registerEvents( new SpectrumListener(), this);
    }
}