package fr.thejyre4rf.enderchest.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * @author DqmnJyre
 *
 */


public class NourritureGUI {

	public void openGUI(Player p){
		Inventory inv = Bukkit.getServer().createInventory(null, 2*9, "§6Catégorie Nourriture");
		inv.setItem(0, getItem(Material.WHEAT, "Minerai de charbon"));
		inv.setItem(1, getItem(Material.RAW_BEEF, "Minerai de fer"));
		inv.setItem(2, getItem(Material.CARROT, "Minerai d'or"));
		inv.setItem(3, getItem(Material.GOLDEN_CARROT, "Minerai de redstone"));
		inv.setItem(4, getItem(Material.BROWN_MUSHROOM, "Minerai de lapiz-lazuli"));
		inv.setItem(5, getItem(Material.COOKIE, "Charbon"));
		inv.setItem(6, getItem(Material.GRILLED_PORK, "Lingot de fer"));
		inv.setItem(7, getItem(Material.CAKE, "Lingot d'or"));
		inv.setItem(8, getItem(Material.MUTTON, "Poudre de redstone"));
		inv.setItem(9, getItem(Material.COOKED_MUTTON, "Lapiz-lazuli"));
		inv.setItem(10, getItem(Material.BREAD, "Pain"));
		inv.setItem(11, getItem(Material.MELON, "Pastèque"));
		inv.setItem(12, getItem(Material.COOKED_FISH, "Poisson cuit"));
		inv.setItem(13, getItem(Material.APPLE, "Pomme"));
		inv.setItem(14, getItem(Material.POTATO, "Pomme de terre"));
		inv.setItem(15, getItem(Material.COOKED_CHICKEN, "Poulet cuit"));
		inv.setItem(16, getItem(Material.MUSHROOM_SOUP, "Soupe de champignons"));
		inv.setItem(17, getItem(Material.COOKED_BEEF, "Steak"));
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
