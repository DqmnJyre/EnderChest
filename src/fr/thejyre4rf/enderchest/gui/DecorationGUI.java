package fr.thejyre4rf.enderchest.gui;

/**
 * @author DqmnJyre
 *
 */

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DecorationGUI {

	public void openGUI(Player p){
		Inventory inv = Bukkit.getServer().createInventory(null, 1*9, "§6Catégorie Décoration");
		inv.setItem(0, getItem(Material.BOOKSHELF, "Bibliothèque"));
		inv.setItem(1, getItem(Material.ITEM_FRAME, "Cadre"));
		inv.setItem(2, getItem(Material.HUGE_MUSHROOM_1, "Champignon"));
		inv.setItem(3, getItem(Material.YELLOW_FLOWER, "Fleurs"));
		inv.setItem(4, getItem(Material.PAINTING, "Tableau"));
		inv.setItem(5, getItem(Material.JUKEBOX, "Jukebox"));
		p.openInventory(inv);

	}
	
	public ItemStack getItem(Material m, String name){
		ItemStack itm = new ItemStack(m);
		ItemMeta itmm = itm.getItemMeta();
		itmm.setDisplayName(name);
		itm.setItemMeta(itmm);
		return itm;
	}
	
}
