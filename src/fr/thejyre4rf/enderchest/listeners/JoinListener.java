package fr.thejyre4rf.enderchest.listeners;

/**
 * @author DqmnJyre
 *
 */

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.thejyre4rf.enderchest.Main;
import fr.thejyre4rf.enderchest.utils.Config;

public class JoinListener implements Listener {

	private Main main;

	public JoinListener(Main main) {
		this.main = main;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		Config playerEcDataMap = new Config(main, player);
		if (!(playerEcDataMap.hasPlayerData())) {
			playerEcDataMap.setContent();
			main.playerEcDataMap.put(player, playerEcDataMap);
		} else {
			main.playerEcDataMap.put(player, playerEcDataMap);
		}
	}
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e){
		main.playerEcDataMap.remove(e.getPlayer());
	}
}
