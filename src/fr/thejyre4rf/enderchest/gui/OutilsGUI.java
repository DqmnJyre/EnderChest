package fr.thejyre4rf.enderchest.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OutilsGUI {

	public void openGUI(Player p){
		Inventory inv = Bukkit.getServer().createInventory(null, 2*9, "§6Catégorie Outils");
		inv.setItem(0, getItem(Material.FLINT_AND_STEEL, "Briquet"));
		inv.setItem(1, getItem(Material.FISHING_ROD, "Canne à pêche"));
		inv.setItem(2, getItem(Material.CARROT_STICK, "Carotte sur un bâton"));
		inv.setItem(3, getItem(Material.WOOD_AXE, "Hache en bois"));
		inv.setItem(4, getItem(Material.WOOD_PICKAXE, "Pioche en bois"));
		inv.setItem(5, getItem(Material.WOOD_SPADE, "Pelle en bois"));
		inv.setItem(6, getItem(Material.WOOD_HOE, "Houe en bois"));
		inv.setItem(7, getItem(Material.BUCKET, "sceau"));
		inv.setItem(8, getItem(Material.NAME_TAG, "Etiquette"));

		
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
