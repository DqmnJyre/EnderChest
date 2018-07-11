package fr.thejyre4rf.enderchest;

/**
 * @author DqmnJyre
 *
 */

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.thejyre4rf.enderchest.commands.EnderChestCommand;
import fr.thejyre4rf.enderchest.gui.listener.EnderChestListener;
import fr.thejyre4rf.enderchest.gui.listener.ItemSelectorListener;
import fr.thejyre4rf.enderchest.gui.listener.OpenEnderChestListener;
import fr.thejyre4rf.enderchest.gui.listener.SelectorListener;
import fr.thejyre4rf.enderchest.listeners.ChatListener;
import fr.thejyre4rf.enderchest.listeners.JoinListener;
import fr.thejyre4rf.enderchest.utils.Config;

public class Main extends JavaPlugin {

	public Map<Player, Config> playerEcDataMap = new HashMap<>();
	public Map<Player, Integer> waitCloseGUI = new HashMap<>();
	public Map<Player, Integer> waitSelectGUI = new HashMap<>();
	public Map<Player, Integer> waitAnvil = new HashMap<>();
	
	public void onEnable(){
		System.out.println("§6Le plugin Enderchest est actif");
		System.out.println("§aDévelopper par DqmnJyre pour DrWasazi");
		registerEvents();
		getCommand("purplesac").setExecutor(new EnderChestCommand(this));
		for(Player pls : Bukkit.getOnlinePlayers()){
			Config cfg = new Config(this, pls);
			if(cfg.hasPlayerData()){
				playerEcDataMap.put(pls, cfg);
				return;
			}
			
		}
	}
	
	public void registerEvents(){
		PluginManager pm = Bukkit.getPluginManager();
		
		pm.registerEvents(new EnderChestListener(this), this);
		pm.registerEvents(new ItemSelectorListener(this), this);
		pm.registerEvents(new OpenEnderChestListener(this), this);
		pm.registerEvents(new SelectorListener(this), this);
		
		pm.registerEvents(new ChatListener(this), this);
		pm.registerEvents(new JoinListener(this), this);

	}
	
	public void onDisable(){
		
	}
}
