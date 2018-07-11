/**
 * 
 */
package fr.thejyre4rf.enderchest.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.thejyre4rf.enderchest.Main;
import fr.thejyre4rf.enderchest.utils.Config;

/**
 * @author DqmnJyre
 *
 */
public class SelectorGUI {

	public void openGUI(Player p, Main main){
		Inventory inv = Bukkit.getServer().createInventory(null, 9, "§6Sélecteur d'enderchest");
		ItemStack gp = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)1);
		ItemMeta gpm = gp.getItemMeta();
		gpm.setDisplayName("§a§oDébloque des coffres sur la boutique en ligne, ou dans le /menu !");
		gp.setItemMeta(gpm);
		Config cfg = main.playerEcDataMap.get(p);
		inv.setItem(0, getItem(cfg.getEnderChestMaterial0(), cfg.getEnderChestName0(), cfg.getEnderChestData0()));
		if(p.hasPermission("enderchest.slot.2")){
			inv.setItem(1, getItem(cfg.getEnderChestMaterial1(), cfg.getEnderChestName1(), cfg.getEnderChestData1()));
		}else{
			inv.setItem(1, gp);
		}if(p.hasPermission("enderchest.slot.3")){
			inv.setItem(2, getItem(cfg.getEnderChestMaterial2(), cfg.getEnderChestName2(), cfg.getEnderChestData2()));
		}else{
			inv.setItem(2, gp);
		}if(p.hasPermission("enderchest.slot.4")){
			inv.setItem(3, getItem(cfg.getEnderChestMaterial3(), cfg.getEnderChestName3(), cfg.getEnderChestData3()));
		}else{
			inv.setItem(3, gp);
		}if(p.hasPermission("enderchest.slot.5")){
			inv.setItem(4, getItem(cfg.getEnderChestMaterial4(), cfg.getEnderChestName4(), cfg.getEnderChestData4()));
		}else{
			inv.setItem(4, gp);
		}if(p.hasPermission("enderchest.slot.6")){
			inv.setItem(5, getItem(cfg.getEnderChestMaterial5(), cfg.getEnderChestName5(), cfg.getEnderChestData5()));
		}else{
			inv.setItem(5, gp);
		}if(p.hasPermission("enderchest.slot.7")){
			inv.setItem(6, getItem(cfg.getEnderChestMaterial6(), cfg.getEnderChestName6(), cfg.getEnderChestData6()));
		}else{
			inv.setItem(6, gp);
		}if(p.hasPermission("enderchest.slot.8")){
			inv.setItem(7, getItem(cfg.getEnderChestMaterial7(), cfg.getEnderChestName7(), cfg.getEnderChestData7()));
		}else{
			inv.setItem(7, gp);
		}if(p.hasPermission("enderchest.slot.9")){
			inv.setItem(8, getItem(cfg.getEnderChestMaterial8(), cfg.getEnderChestName8(), cfg.getEnderChestData8()));
		}else{
			inv.setItem(8, gp);
		}
		p.openInventory(inv);
	}
	
	
	
	public ItemStack getItem(Material m, String name, short s){
		ItemStack itm = new ItemStack(m, 1 , s);
		ItemMeta itmm = itm.getItemMeta();
		List<String> lores = new ArrayList<>();
		lores.add("§6Clique Gauche pour ouvrir l'enderchest");
		lores.add("§6Clique Molette pour rename l'item");
		lores.add("§6Clique Droit pour changer l'item");
		itmm.setLore(lores);
		itmm.setDisplayName(name);
		itm.setItemMeta(itmm);
		return itm;
	}
}
