package fr.thejyre4rf.enderchest.gui.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import fr.thejyre4rf.enderchest.Main;
import fr.thejyre4rf.enderchest.gui.SelectorGUI;

public class OpenEnderChestListener implements Listener{
	
	private Main main;
	public OpenEnderChestListener(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onOpen(PlayerInteractEvent e){
		if(e.getClickedBlock() == null)
				return;
		if(e.getClickedBlock().getType() == Material.ENDER_CHEST){
			if(e.getAction() == Action.LEFT_CLICK_BLOCK){
				return;
			}
			e.setCancelled(true);
			new SelectorGUI().openGUI(e.getPlayer(), main);
		}
	}

}
