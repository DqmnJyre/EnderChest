package fr.thejyre4rf.enderchest.gui.listener;

import org.bukkit.Material;

/**
 * @author DqmnJyre
 *
 */

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.thejyre4rf.enderchest.Main;
import fr.thejyre4rf.enderchest.gui.ColorantGUI;
import fr.thejyre4rf.enderchest.gui.CombatGUI;
import fr.thejyre4rf.enderchest.gui.DecorationGUI;
import fr.thejyre4rf.enderchest.gui.MatiereGUI;
import fr.thejyre4rf.enderchest.gui.MineraiGUI;
import fr.thejyre4rf.enderchest.gui.NourritureGUI;
import fr.thejyre4rf.enderchest.gui.OutilsGUI;
import fr.thejyre4rf.enderchest.gui.OwnItemGUI;
import fr.thejyre4rf.enderchest.utils.Config;

public class ItemSelectorListener implements Listener{

	private Main main;
	public ItemSelectorListener(Main main){
		this.main = main;
	}
	
	@EventHandler
	public void onItemSelector(InventoryClickEvent e){
		switch(e.getInventory().getName()){
			case "§6Sélecteur de catégorie":
				e.setCancelled(true);
				switch(e.getCurrentItem().getItemMeta().getDisplayName()){
					case "§6Catégorie des combats":
						new CombatGUI().openGUI((Player)e.getWhoClicked());
						break;
					case "§6Catégorie des colorants":
						new ColorantGUI().openGUI((Player)e.getWhoClicked());
						break;
					case "§6Catégorie des décorations":
						new DecorationGUI().openGUI((Player)e.getWhoClicked());
						break;
					case "§6Catégorie des matières premières":
						new MatiereGUI().openGUI((Player) e.getWhoClicked());
						break;
					case "§6Catégorie des minerais":
						new MineraiGUI().openGUI((Player) e.getWhoClicked());
						break;
					case "§6Catégorie de la nourriture":
						new NourritureGUI().openGUI((Player) e.getWhoClicked());
						break;
					case "§6Catégorie des outils":
						new OutilsGUI().openGUI((Player) e.getWhoClicked());
						break;
					case "§6Votre ITEM":
						new OwnItemGUI().openGUI((Player) e.getWhoClicked());
						break;
					default:
						break;
				}
			case "§6Votre propre ITEM":
				if(e.getCurrentItem() == null){
					return;
				}
				if(e.getCurrentItem().getType() == null || e.getCurrentItem().getType() == Material.AIR){
					return;
				}
				if(e.getRawSlot() != 0 && e.getRawSlot() < 9){
					e.setCancelled(true);
					return;
				}
				Config cfg = main.playerEcDataMap.get(e.getWhoClicked());
				switch(main.waitSelectGUI.get(e.getWhoClicked())){
					case 0:
						System.out.println(e.getCurrentItem().getDurability());
						cfg.setEnderChestMaterial0(e.getCurrentItem());
						cfg.setEnderChestData0(e.getCurrentItem());
						main.waitSelectGUI.remove(e.getWhoClicked());
						e.getWhoClicked().closeInventory();
						break;
					case 1:
						cfg.setEnderChestMaterial1(e.getCurrentItem());
						cfg.setEnderChestData1(e.getCurrentItem());
						main.waitSelectGUI.remove(e.getWhoClicked());
						e.getWhoClicked().closeInventory();
						break;
					case 2:
						cfg.setEnderChestMaterial2(e.getCurrentItem());
						cfg.setEnderChestData2(e.getCurrentItem());
						main.waitSelectGUI.remove(e.getWhoClicked());
						e.getWhoClicked().closeInventory();
						break;
					case 3:
						cfg.setEnderChestMaterial3(e.getCurrentItem());
						cfg.setEnderChestData3(e.getCurrentItem());
						main.waitSelectGUI.remove(e.getWhoClicked());
						e.getWhoClicked().closeInventory();
						break;
					case 4:
						cfg.setEnderChestMaterial4(e.getCurrentItem());
						cfg.setEnderChestData4(e.getCurrentItem());
						main.waitSelectGUI.remove(e.getWhoClicked());
						e.getWhoClicked().closeInventory();
						break;
					case 5:
						cfg.setEnderChestMaterial5(e.getCurrentItem());
						cfg.setEnderChestData5(e.getCurrentItem());
						main.waitSelectGUI.remove(e.getWhoClicked());
						e.getWhoClicked().closeInventory();
						break;
					case 6:
						cfg.setEnderChestMaterial6(e.getCurrentItem());
						cfg.setEnderChestData6(e.getCurrentItem());
						main.waitSelectGUI.remove(e.getWhoClicked());
						e.getWhoClicked().closeInventory();
						break;
					case 7:
						cfg.setEnderChestMaterial7(e.getCurrentItem());
						cfg.setEnderChestData7(e.getCurrentItem());
						main.waitSelectGUI.remove(e.getWhoClicked());
						e.getWhoClicked().closeInventory();
						break;
					case 8:
						cfg.setEnderChestMaterial8(e.getCurrentItem());
						cfg.setEnderChestData8(e.getCurrentItem());
						main.waitSelectGUI.remove(e.getWhoClicked());
						e.getWhoClicked().closeInventory();
						break;
					default:
						break;
				}
			default:
				break;
		}
		if(e.getInventory().getName() == "§6Catégorie Colorant" ||
				e.getInventory().getName() == "§6Catégorie Combat" || e.getInventory().getName() == "§6Catégorie Décoration" ||
				e.getInventory().getName() == "§6Catégorie Matière Première" || e.getInventory().getName() == "§6Catégorie Minerai" ||
				e.getInventory().getName() == "§6Catégorie Nourriture" || e.getInventory().getName() == "§6Catégorie Outils"){
			e.setCancelled(true);
			if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR){
				return;
			}
			Config cfg = main.playerEcDataMap.get(e.getWhoClicked());
			switch (main.waitSelectGUI.get((Player)e.getWhoClicked())) {
				case 0:
					cfg.setEnderChestMaterial0(e.getCurrentItem());
					cfg.setEnderChestData0(e.getCurrentItem());
					main.waitSelectGUI.remove((Player)e.getWhoClicked());
					e.getWhoClicked().closeInventory();
					break;
				case 1:
					cfg.setEnderChestMaterial1(e.getCurrentItem());
					cfg.setEnderChestData1(e.getCurrentItem());
					main.waitSelectGUI.remove((Player)e.getWhoClicked());
					e.getWhoClicked().closeInventory();
					break;
				case 2:
					cfg.setEnderChestMaterial2(e.getCurrentItem());
					cfg.setEnderChestData2(e.getCurrentItem());
					main.waitSelectGUI.remove((Player)e.getWhoClicked());
					e.getWhoClicked().closeInventory();
					break;
				case 3:
					cfg.setEnderChestMaterial3(e.getCurrentItem());
					cfg.setEnderChestData3(e.getCurrentItem());
					main.waitSelectGUI.remove((Player)e.getWhoClicked());
					e.getWhoClicked().closeInventory();
					break;
				case 4:
					cfg.setEnderChestMaterial4(e.getCurrentItem());
					cfg.setEnderChestData4(e.getCurrentItem());
					main.waitSelectGUI.remove((Player)e.getWhoClicked());
					e.getWhoClicked().closeInventory();
					break;
				case 5:
					cfg.setEnderChestMaterial5(e.getCurrentItem());
					cfg.setEnderChestData5(e.getCurrentItem());
					main.waitSelectGUI.remove((Player)e.getWhoClicked());
					e.getWhoClicked().closeInventory();
					break;
				case 6:
					cfg.setEnderChestMaterial6(e.getCurrentItem());
					cfg.setEnderChestData6(e.getCurrentItem());
					main.waitSelectGUI.remove((Player)e.getWhoClicked());
					e.getWhoClicked().closeInventory();
					break;
				case 7:
					cfg.setEnderChestMaterial7(e.getCurrentItem());
					cfg.setEnderChestData7(e.getCurrentItem());
					main.waitSelectGUI.remove((Player)e.getWhoClicked());
					e.getWhoClicked().closeInventory();
					break;
				case 8:
					cfg.setEnderChestMaterial8(e.getCurrentItem());
					cfg.setEnderChestData8(e.getCurrentItem());
					main.waitSelectGUI.remove((Player)e.getWhoClicked());
					e.getWhoClicked().closeInventory();
					break;
				default:
					break;
			}
		}
	}
	
		
}
