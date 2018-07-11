package fr.thejyre4rf.enderchest.gui.listener;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.thejyre4rf.enderchest.Main;
import fr.thejyre4rf.enderchest.gui.CatGUI;
import fr.thejyre4rf.enderchest.utils.AnvilContainer;
import fr.thejyre4rf.enderchest.utils.Config;
import net.minecraft.server.v1_8_R3.ChatMessage;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.PacketPlayOutOpenWindow;

public class SelectorListener implements Listener{
	
	private Main main;
	
	public SelectorListener(Main main){
		this.main = main;
	}
	

	
	public void openAnvil(Player player, String text, ItemStack itm){
		EntityPlayer p = ((CraftPlayer) player).getHandle();
	    AnvilContainer container = new AnvilContainer(p);
	    int c = p.nextContainerCounter();
	    p.playerConnection.sendPacket(new PacketPlayOutOpenWindow(c,"minecraft:anvil",new ChatMessage(text,new Object[]{}),0));
	    p.activeContainer = container;
	    p.activeContainer.windowId = c;
	    p.activeContainer.setItem(0, CraftItemStack.asNMSCopy(itm));
	    p.activeContainer.addSlotListener(p);
	}
	
	@EventHandler
	public void onInventoryInteract(InventoryClickEvent e){
		if(e.getCurrentItem() == null || e.getCurrentItem().getType() == null || e.getCurrentItem().getType() == Material.AIR)
			return;
		if(e.getInventory().getName().equals("§6Sélecteur d'enderchest")){
			e.setCancelled(true);
			ItemStack gp = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)1);
			ItemMeta gpm = gp.getItemMeta();
			gpm.setDisplayName("§a§oDébloque des coffres sur la boutique en ligne, ou dans le /menu !");
			gp.setItemMeta(gpm);
			Config cfg = main.playerEcDataMap.get(e.getWhoClicked());
			if( e.getCurrentItem() == null || e.getCurrentItem().equals(gp) || e.getCurrentItem().getType() == Material.AIR){
				return;
			}
			else{
				if(e.getRawSlot() == 0){
					if(e.getClick() == ClickType.MIDDLE){
						main.waitAnvil.put((Player) e.getWhoClicked(), 0);
						e.getWhoClicked().sendMessage("§6[§7EnderChest§6] §aEnvoyez dans le chat le nouveau nom de votre item");
						e.getWhoClicked().closeInventory();
					}
					if(e.getClick() == ClickType.LEFT){
						main.waitCloseGUI.put((Player) e.getWhoClicked(), 0);
						e.getWhoClicked().openInventory(cfg.getInventory(0));
					}
					if(e.getClick() == ClickType.RIGHT){
						main.waitSelectGUI.put((Player) e.getWhoClicked(), 0);
						new CatGUI().openGUI((Player)e.getWhoClicked(), main);
					}
				}
				if(e.getRawSlot() == 1){
					if(e.getClick() == ClickType.MIDDLE){
						main.waitAnvil.put((Player) e.getWhoClicked(), 1);
						e.getWhoClicked().sendMessage("§6[§7EnderChest§6] §aEnvoyez dans le chat le nouveau nom de votre item");
						e.getWhoClicked().closeInventory();
						}
					if(e.getClick() == ClickType.LEFT){
						main.waitCloseGUI.put((Player) e.getWhoClicked(), 1);
						e.getWhoClicked().openInventory(cfg.getInventory(1));
					}
					if(e.getClick() == ClickType.RIGHT){
						main.waitSelectGUI.put((Player) e.getWhoClicked(), 1);
						new CatGUI().openGUI((Player)e.getWhoClicked(), main);
					}
				}
				if(e.getRawSlot() == 2){
					if(e.getClick() == ClickType.MIDDLE){
						main.waitAnvil.put((Player) e.getWhoClicked(), 2);
						e.getWhoClicked().sendMessage("§6[§7EnderChest§6] §aEnvoyez dans le chat le nouveau nom de votre item");
						e.getWhoClicked().closeInventory();
					}
					if(e.getClick() == ClickType.LEFT){
						main.waitCloseGUI.put((Player) e.getWhoClicked(), 2);
						e.getWhoClicked().openInventory(cfg.getInventory(2));
					}
					if(e.getClick() == ClickType.RIGHT){
						main.waitSelectGUI.put((Player) e.getWhoClicked(), 2);
						new CatGUI().openGUI((Player)e.getWhoClicked(), main);
					}
				}
				if(e.getRawSlot() == 3){
					if(e.getClick() == ClickType.MIDDLE){
						main.waitAnvil.put((Player) e.getWhoClicked(), 3);
						e.getWhoClicked().sendMessage("§6[§7EnderChest§6] §aEnvoyez dans le chat le nouveau nom de votre item");
						e.getWhoClicked().closeInventory();
					}
					if(e.getClick() == ClickType.LEFT){
						main.waitCloseGUI.put((Player) e.getWhoClicked(), 3);
						e.getWhoClicked().openInventory(cfg.getInventory(3));
					}
					if(e.getClick() == ClickType.RIGHT){
						main.waitSelectGUI.put((Player) e.getWhoClicked(), 3);
						new CatGUI().openGUI((Player)e.getWhoClicked(), main);
					}
				}
				if(e.getRawSlot() == 4){
					if(e.getClick() == ClickType.MIDDLE){
						main.waitAnvil.put((Player) e.getWhoClicked(), 4);
						e.getWhoClicked().sendMessage("§6[§7EnderChest§6] §aEnvoyez dans le chat le nouveau nom de votre item");
						e.getWhoClicked().closeInventory();
					}
					if(e.getClick() == ClickType.LEFT){
						main.waitCloseGUI.put((Player) e.getWhoClicked(), 4);
						e.getWhoClicked().openInventory(cfg.getInventory(4));
					}
					if(e.getClick() == ClickType.RIGHT){
						main.waitSelectGUI.put((Player) e.getWhoClicked(), 4);
						new CatGUI().openGUI((Player)e.getWhoClicked(), main);
					}
				}
				if(e.getRawSlot() == 5){
					if(e.getClick() == ClickType.MIDDLE){
						main.waitAnvil.put((Player) e.getWhoClicked(), 5);
						e.getWhoClicked().sendMessage("§6[§7EnderChest§6] §aEnvoyez dans le chat le nouveau nom de votre item");
						e.getWhoClicked().closeInventory();
					}
					if(e.getClick() == ClickType.LEFT){
						main.waitCloseGUI.put((Player) e.getWhoClicked(), 5);
						e.getWhoClicked().openInventory(cfg.getInventory(5));
					}
					if(e.getClick() == ClickType.RIGHT){
						main.waitSelectGUI.put((Player) e.getWhoClicked(), 5);
						new CatGUI().openGUI((Player)e.getWhoClicked(), main);
					}
				}
				if(e.getRawSlot() == 6){
					if(e.getClick() == ClickType.MIDDLE){
						main.waitAnvil.put((Player) e.getWhoClicked(), 6);
						e.getWhoClicked().sendMessage("§6[§7EnderChest§6] §aEnvoyez dans le chat le nouveau nom de votre item");
						e.getWhoClicked().closeInventory();
					}
					if(e.getClick() == ClickType.LEFT){
						main.waitCloseGUI.put((Player) e.getWhoClicked(), 6);
						e.getWhoClicked().openInventory(cfg.getInventory(6));
					}
					if(e.getClick() == ClickType.RIGHT){
						main.waitSelectGUI.put((Player) e.getWhoClicked(), 6);
						new CatGUI().openGUI((Player)e.getWhoClicked(), main);
					}
				}
				if(e.getRawSlot() == 7){
					if(e.getClick() == ClickType.MIDDLE){
						main.waitAnvil.put((Player) e.getWhoClicked(), 7);
						e.getWhoClicked().sendMessage("§6[§7EnderChest§6] §aEnvoyez dans le chat le nouveau nom de votre item");
						e.getWhoClicked().closeInventory();
					}
					if(e.getClick() == ClickType.LEFT){
						main.waitCloseGUI.put((Player) e.getWhoClicked() , 7);
						e.getWhoClicked().openInventory(cfg.getInventory(7));
					}
					if(e.getClick() == ClickType.RIGHT){
						main.waitSelectGUI.put((Player) e.getWhoClicked(), 7);
						new CatGUI().openGUI((Player)e.getWhoClicked(), main);
					}
				}
				if(e.getRawSlot() == 8){
					if(e.getClick() == ClickType.MIDDLE){
						main.waitAnvil.put((Player) e.getWhoClicked(), 8);
						e.getWhoClicked().sendMessage("§6[§7EnderChest§6] §aEnvoyez dans le chat le nouveau nom de votre item");
						e.getWhoClicked().closeInventory();
					}
					if(e.getClick() == ClickType.LEFT){
						main.waitCloseGUI.put((Player) e.getWhoClicked(), 8);
						e.getWhoClicked().openInventory(cfg.getInventory(8));
					}
					if(e.getClick() == ClickType.RIGHT){
						main.waitSelectGUI.put((Player) e.getWhoClicked(), 8);
						new CatGUI().openGUI((Player)e.getWhoClicked(), main);
					}
				}
			}
		}
	}
	
	public ItemStack getItem(Material m, String name){
		ItemStack itm = new ItemStack(m);
		ItemMeta itmm = itm.getItemMeta();
		itmm.setDisplayName(name);
		itm.setItemMeta(itmm);
		return itm;
	}
}
