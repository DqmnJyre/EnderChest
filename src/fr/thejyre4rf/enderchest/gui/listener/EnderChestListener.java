package fr.thejyre4rf.enderchest.gui.listener;

import org.bukkit.event.EventHandler;

/**
 * @author DqmnJyre
 *
 */

import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;

import fr.thejyre4rf.enderchest.Main;
import fr.thejyre4rf.enderchest.utils.Config;

public class EnderChestListener implements Listener {
	
	private Main main;
	
	public EnderChestListener(Main main){
		this.main = main;
	}

	@EventHandler
	public void onClose(InventoryCloseEvent e){
		if(e.getInventory().getType().equals(InventoryType.ANVIL)){
			if(main.waitAnvil.containsKey(e.getPlayer())){
				e.getInventory().clear();
			}
		}
		if(main.waitCloseGUI.containsKey(e.getPlayer())){
			int slot = main.waitCloseGUI.get(e.getPlayer());
			Config cfg = main.playerEcDataMap.get(e.getPlayer());
			if(e.getInventory().getName().equals("§6Sélecteur d'enderchest"))
				return;
			switch(slot){
				case 0:
					cfg.setEnderChestSlot0(e.getInventory());
					main.waitCloseGUI.remove(e.getPlayer());
					break;
				case 1:
					cfg.setEnderChestSlot1(e.getInventory());
					main.waitCloseGUI.remove(e.getPlayer());
					break;
				case 2:
					cfg.setEnderChestSlot2(e.getInventory());
					main.waitCloseGUI.remove(e.getPlayer());
					break;
				case 3:
					cfg.setEnderChestSlot3(e.getInventory());
					main.waitCloseGUI.remove(e.getPlayer());
					break;
				case 4:
					cfg.setEnderChestSlot4(e.getInventory());
					main.waitCloseGUI.remove(e.getPlayer());
					break;
				case 5:
					cfg.setEnderChestSlot5(e.getInventory());
					main.waitCloseGUI.remove(e.getPlayer());
					break;
				case 6:
					cfg.setEnderChestSlot6(e.getInventory());
					main.waitCloseGUI.remove(e.getPlayer());
					break;
				case 7:
					cfg.setEnderChestSlot7(e.getInventory());
					main.waitCloseGUI.remove(e.getPlayer());
					break;
				case 8:
					cfg.setEnderChestSlot8(e.getInventory());
					main.waitCloseGUI.remove(e.getPlayer());
					break;
				default:
					break;
			}
		}
	}
	
}
