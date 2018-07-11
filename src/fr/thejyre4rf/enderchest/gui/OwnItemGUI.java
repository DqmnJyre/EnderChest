package fr.thejyre4rf.enderchest.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class OwnItemGUI {

	public void openGUI(Player p){
		Inventory inv = Bukkit.getServer().createInventory(null, 1*9, "§6Votre propre ITEM");
		ItemStack gp = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)1);
		for(int i = 1; i < 9; i++){
			inv.setItem(i, gp);
		}
		p.openInventory(inv);
	}
	
}
