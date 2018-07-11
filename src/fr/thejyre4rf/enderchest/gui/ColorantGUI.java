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

public class ColorantGUI {

	public void openGUI(Player p){
		Inventory inv = Bukkit.getServer().createInventory(null, 1*9, "§6Catégorie Colorant");
		inv.setItem(0, getItem(Material.INK_SACK, "Poche d'encre"));
		inv.setItem(1, getItem(Material.INK_SACK, (short) 4, "Lapiz"));
		inv.setItem(2, new ItemStack(Material.INK_SACK, 1, (short) 15));
		p.openInventory(inv);

	}
	
	public ItemStack getItem(Material m, String name){
		ItemStack itm = new ItemStack(m);
		ItemMeta itmm = itm.getItemMeta();
		itmm.setDisplayName(name);
		itm.setItemMeta(itmm);
		return itm;
	}
	public ItemStack getItem(Material m, short i, String name){
		ItemStack itm = new ItemStack(m, 1, i);
		ItemMeta itmm = itm.getItemMeta();
		itmm.setDisplayName(name);
		itm.setItemMeta(itmm);
		return itm;
	}
}
