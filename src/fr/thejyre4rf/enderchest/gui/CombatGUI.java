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

public class CombatGUI {
	
	public void openGUI(Player p){
		Inventory inv = Bukkit.getServer().createInventory(null, 5*9, "§6Catégorie Combat");
		inv.setItem(0, getItem(Material.BOW, "Arc"));
		inv.setItem(1, getItem(Material.ARROW, "Flèche"));
		inv.setItem(3, getItem(Material.SNOW_BALL, "Boule de neige"));
		
		inv.setItem(9, getItem(Material.LEATHER_HELMET, "Casque en cuir"));
		inv.setItem(18, getItem(Material.LEATHER_CHESTPLATE, "Plastron en cuir"));
		inv.setItem(27, getItem(Material.LEATHER_LEGGINGS, "Jambière en cuir"));
		inv.setItem(36, getItem(Material.LEATHER_BOOTS, "Botte en cuir"));
		
		inv.setItem(10, getItem(Material.CHAINMAIL_HELMET, "Casque en maille"));
		inv.setItem(19, getItem(Material.CHAINMAIL_CHESTPLATE, "Plastron en maille"));
		inv.setItem(28, getItem(Material.CHAINMAIL_LEGGINGS, "Jambière en maille"));
		inv.setItem(37, getItem(Material.CHAINMAIL_BOOTS, "Botte en maille"));
		
		inv.setItem(11, getItem(Material.GOLD_HELMET, "Casque en or"));
		inv.setItem(20, getItem(Material.GOLD_CHESTPLATE, "Plastron en or"));
		inv.setItem(29, getItem(Material.GOLD_LEGGINGS, "Jambière en or"));
		inv.setItem(38, getItem(Material.GOLD_BOOTS, "Botte en or"));
		
		inv.setItem(12, getItem(Material.IRON_HELMET, "Casque en fer"));
		inv.setItem(21, getItem(Material.IRON_CHESTPLATE, "Plastron en fer"));
		inv.setItem(30, getItem(Material.IRON_LEGGINGS, "Jambière en fer"));
		inv.setItem(39, getItem(Material.IRON_BOOTS, "Botte en fer"));
		
		inv.setItem(13, getItem(Material.DIAMOND_HELMET, "Casque en diamant"));
		inv.setItem(22, getItem(Material.DIAMOND_CHESTPLATE, "Plastron en diamant"));
		inv.setItem(31, getItem(Material.DIAMOND_LEGGINGS, "Jambière en diamant"));
		inv.setItem(40, getItem(Material.DIAMOND_BOOTS, "Botte en diamant"));
		
		inv.setItem(8, getItem(Material.WOOD_SWORD, "Epee en bois"));
		inv.setItem(17, getItem(Material.STONE_SWORD, "Epee en pierre"));
		inv.setItem(26, getItem(Material.GOLD_SWORD, "Epee en or"));
		inv.setItem(35, getItem(Material.IRON_SWORD, "Epee en fer"));
		inv.setItem(44, getItem(Material.DIAMOND_SWORD, "Epee en diamant"));
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
