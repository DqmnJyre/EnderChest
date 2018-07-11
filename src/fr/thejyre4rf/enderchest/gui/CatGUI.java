package fr.thejyre4rf.enderchest.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.thejyre4rf.enderchest.Main;

public class CatGUI {

	public void openGUI(Player p, Main main){
		Inventory inv = Bukkit.getServer().createInventory(null, 9, "§6Sélecteur de catégorie");
		inv.setItem(0, getItem(Material.GRASS, "§6Catégorie des combats"));
		inv.setItem(1, getItem(Material.INK_SACK, "§6Catégorie des colorants"));
		inv.setItem(2, getItem(Material.YELLOW_FLOWER, "§6Catégorie des décorations"));
		inv.setItem(3, getItem(Material.SLIME_BALL, "§6Catégorie des matières premières"));
		inv.setItem(4, getItem(Material.DIAMOND_ORE, "§6Catégorie des minerais"));
		inv.setItem(5, getItem(Material.CARROT, "§6Catégorie de la nourriture"));
		inv.setItem(5, getItem(Material.FLINT_AND_STEEL, "§6Catégorie des outils"));
		inv.setItem(6, getItem(Material.HOPPER, "§6Votre ITEM"));
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
