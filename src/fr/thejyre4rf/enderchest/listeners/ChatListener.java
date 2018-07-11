package fr.thejyre4rf.enderchest.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import fr.thejyre4rf.enderchest.Main;
import fr.thejyre4rf.enderchest.utils.Config;

public class ChatListener implements Listener {
	
	private Main main;
	
	public ChatListener(Main main){
		this.main = main;
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		Config cfg = main.playerEcDataMap.get(e.getPlayer());
		if(main.waitAnvil.containsKey(e.getPlayer())){
			String name = e.getMessage();
			e.setCancelled(true);
			switch(main.waitAnvil.get(e.getPlayer())){
				case 8:
					cfg.setEnderChestName8(name);
					main.waitAnvil.remove(e.getPlayer());
					break;
				case 7:
					cfg.setEnderChestName7(name);
					main.waitAnvil.remove(e.getPlayer());
					break;
				case 6:
					cfg.setEnderChestName6(name);
					main.waitAnvil.remove(e.getPlayer());
					break;
				case 5:
					cfg.setEnderChestName5(name);
					main.waitAnvil.remove(e.getPlayer());
					break;
				case 4:
					cfg.setEnderChestName4(name);
					main.waitAnvil.remove(e.getPlayer());
					break;
				case 3:
					cfg.setEnderChestName3(name);
					main.waitAnvil.remove(e.getPlayer());
					break;
				case 2:
					cfg.setEnderChestName2(name);
					main.waitAnvil.remove(e.getPlayer());
					break;
				case 1:
					cfg.setEnderChestName1(name);
					main.waitAnvil.remove(e.getPlayer());
					break;
				case 0:
					cfg.setEnderChestName0(name);
					main.waitAnvil.remove(e.getPlayer());
					break;
				default:
					main.waitAnvil.remove(e.getPlayer());
			}
		}
	}
	
}
