package me.kamlax.spectrum.helper;

import com.sun.istack.internal.NotNull;
import org.bukkit.ChatColor;

/**
 * @author KamlaX on 26.02.2020
 */

public final class ChatColorHelper {

    private ChatColorHelper() {
    }

    @NotNull
    public static String fixColor(String message){
        return ChatColor.translateAlternateColorCodes('&', message)
                .replace(">>", "»")
                .replace("<<", "«");
    }
}
