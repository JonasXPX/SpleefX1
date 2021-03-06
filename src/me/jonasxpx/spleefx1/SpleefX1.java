package me.jonasxpx.spleefx1;

import java.util.logging.Level;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

public class SpleefX1 extends JavaPlugin{

	private static WorldGuardPlugin wg = null;
	public static PluginManager pluginManager;
	private static SpleefX1 instance;
	
	@Override
	public void onEnable() {
		SpleefX1.instance = this;
		wg = getWorldGuardPlugin();
		pluginManager = getServer().getPluginManager();
		if(wg == null){
			getLogger().log(Level.SEVERE, "Plugin desativado, Dependencia 'WorldGuard' necessario!.");
			getServer().getPluginManager().disablePlugin(this);
		}
	}
	
	public static SpleefX1 getInstance(){return instance;}
	
	private WorldGuardPlugin getWorldGuardPlugin(){
		if(getServer().getPluginManager().getPlugin("WorldGuard") != null)
			return ((WorldGuardPlugin)getServer().getPluginManager().getPlugin("WorldGuard"));
		return null;
	}
	
	
	public static WorldGuardPlugin getWorldGuard(){
		return wg;
	}
	
	
}
