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

public class MatiereGUI {
	
	public void openGUI(Player p){
		Inventory inv = Bukkit.getServer().createInventory(null, 1*9, "§6Catégorie Matière Première");
		inv.setItem(0, getItem(Material.SLIME_BALL,"Boule de Slime"));
		inv.setItem(1, getItem(Material.BRICK, "Brique"));
		inv.setItem(2, getItem(Material.STICK, "Bâton"));
		inv.setItem(3, getItem(Material.COAL, "Charbon"));
		inv.setItem(4, getItem(Material.STRING, "Fils"));
		inv.setItem(5, getItem(Material.EGG, "Oeuf"));
		inv.setItem(6, getItem(Material.PAPER, "Papier"));
		inv.setItem(7, getItem(Material.FLINT, "Silex"));
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
