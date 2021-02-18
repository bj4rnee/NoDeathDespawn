package dev.bjarne.noDeathDespawn;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener{

	public eventHandler eH;
	
	public void onEnable() {
		getLogger().info(makeColors("&dNoDeathDespawn V1.0 has been enabled"));
		eH = new eventHandler();
		Bukkit.getPluginManager().registerEvents(eH, this);
		eH.setMain(this);
	}
	
	public void onDisable() {
		getLogger().info(makeColors("&dNoDeathDespawn V1.0 has been disabled"));
	}
	
	/**Method to transform Minecraft color codes
	 * 
	 * @param s
	 * @return
	 */
	public static String makeColors(String s) {
		String replaced = s.replaceAll("&0", "" + ChatColor.BLACK).replaceAll("&1", "" + ChatColor.DARK_BLUE)
				.replaceAll("&2", "" + ChatColor.DARK_GREEN).replaceAll("&3", "" + ChatColor.DARK_AQUA)
				.replaceAll("&4", "" + ChatColor.DARK_RED).replaceAll("&5", "" + ChatColor.DARK_PURPLE)
				.replaceAll("&6", "" + ChatColor.GOLD).replaceAll("&7", "" + ChatColor.GRAY)
				.replaceAll("&8", "" + ChatColor.DARK_GRAY).replaceAll("&9", "" + ChatColor.BLUE)
				.replaceAll("&a", "" + ChatColor.GREEN).replaceAll("&b", "" + ChatColor.AQUA)
				.replaceAll("&c", "" + ChatColor.RED).replaceAll("&d", "" + ChatColor.LIGHT_PURPLE)
				.replaceAll("&e", "" + ChatColor.YELLOW).replaceAll("&f", "" + ChatColor.WHITE)
				.replaceAll("&r", "" + ChatColor.RESET).replaceAll("&l", "" + ChatColor.BOLD)
				.replaceAll("&o", "" + ChatColor.ITALIC).replaceAll("&k", "" + ChatColor.MAGIC)
				.replaceAll("&m", "" + ChatColor.STRIKETHROUGH).replaceAll("&n", "" + ChatColor.UNDERLINE)
				.replaceAll("\\\\", " ");
		return replaced;
	}
}
