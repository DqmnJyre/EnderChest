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

public class MineraiGUI {
	
	public void openGUI(Player p){
		Inventory inv = Bukkit.getServer().createInventory(null, 2*9, "§6Catégorie Minerai");
		inv.setItem(0, getItem(Material.COAL_ORE, "Minerai de charbon"));
		inv.setItem(1, getItem(Material.IRON_ORE, "Minerai de fer"));
		inv.setItem(2, getItem(Material.GOLD_ORE, "Minerai d'or"));
		inv.setItem(3, getItem(Material.REDSTONE_ORE, "Minerai de redstone"));
		inv.setItem(4, getItem(Material.LAPIS_ORE, "Minerai de lapiz-lazuli"));
		inv.setItem(5, getItem(Material.COAL, "Charbon"));
		inv.setItem(6, getItem(Material.IRON_ORE, "Lingot de fer"));
		inv.setItem(7, getItem(Material.GOLD_ORE, "Lingot d'or"));
		inv.setItem(8, getItem(Material.REDSTONE_ORE, "Poudre de redstone"));
		inv.setItem(9, getItem(Material.INK_SACK, (short)4, "Lapiz-lazuli"));
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
		ItemStack itm = new ItemStack(m,1, i);
		ItemMeta itmm = itm.getItemMeta();
		itmm.setDisplayName(name);
		itm.setItemMeta(itmm);
		return itm;
	}
	
}
