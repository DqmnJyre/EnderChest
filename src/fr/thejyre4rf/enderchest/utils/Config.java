package fr.thejyre4rf.enderchest.utils;

/**
 * @author DqmnJyre
 *
 */

import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.thejyre4rf.enderchest.Main;


public class Config {

	public Main main;
	public Player player;

	public SimpleConfigManager manager;
	public SimpleConfig dataConfig;

	public Config(Main main, Player player) {
		this.main = main;
		this.player = player;
		this.manager = new SimpleConfigManager(main);
		String[] header = { "EnderChestData of " + getUUID(), "Made by DqmnJyre",
				"DON'T CHANGE ANYTHING IN THIS FILE" };
		this.dataConfig = this.manager.getNewConfig("ecdata/" + getUUID()
				+ ".yml", header);
	}

	public Player getPlayer() {
		return player;
	}

	public UUID getUUID() {
		return player.getUniqueId();
	}

	public SimpleConfig getDataConfig() {
		return dataConfig;
	}

	public Inventory getBlankInventory(){ return Bukkit.getServer().createInventory(null, 9*6); }
	
	public void setContent() {
		getDataConfig().set("UUID", getUUID().toString());
		Inventory inv = getBlankInventory();
		try{
			getDataConfig().set("0", ItemSerialisation.serializeInventory(inv));
			getDataConfig().set("1", ItemSerialisation.serializeInventory(inv));
			getDataConfig().set("2", ItemSerialisation.serializeInventory(inv));
			getDataConfig().set("3", ItemSerialisation.serializeInventory(inv));
			getDataConfig().set("4", ItemSerialisation.serializeInventory(inv));
			getDataConfig().set("5", ItemSerialisation.serializeInventory(inv));
			getDataConfig().set("6", ItemSerialisation.serializeInventory(inv));
			getDataConfig().set("7", ItemSerialisation.serializeInventory(inv));
			getDataConfig().set("8", ItemSerialisation.serializeInventory(inv));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		getDataConfig().set("i0", new ItemStack(Material.YELLOW_FLOWER));
		getDataConfig().set("i1", new ItemStack(Material.YELLOW_FLOWER));
		getDataConfig().set("i2", new ItemStack(Material.YELLOW_FLOWER));
		getDataConfig().set("i3", new ItemStack(Material.YELLOW_FLOWER));
		getDataConfig().set("i4", new ItemStack(Material.YELLOW_FLOWER));
		getDataConfig().set("i5", new ItemStack(Material.YELLOW_FLOWER));
		getDataConfig().set("i6", new ItemStack(Material.YELLOW_FLOWER));
		getDataConfig().set("i7", new ItemStack(Material.YELLOW_FLOWER));
		getDataConfig().set("i8", new ItemStack(Material.YELLOW_FLOWER));

		getDataConfig().set("n0", "enderchest");
		getDataConfig().set("n1", "enderchest");
		getDataConfig().set("n2", "enderchest");
		getDataConfig().set("n3", "enderchest");
		getDataConfig().set("n4", "enderchest");
		getDataConfig().set("n5", "enderchest");
		getDataConfig().set("n6", "enderchest");
		getDataConfig().set("n7", "enderchest");
		getDataConfig().set("n8", "enderchest");
		
		getDataConfig().set("d0", "0");
		getDataConfig().set("d1", "0");
		getDataConfig().set("d2", "0");
		getDataConfig().set("d3", "0");
		getDataConfig().set("d4", "0");
		getDataConfig().set("d5", "0");
		getDataConfig().set("d6", "0");
		getDataConfig().set("d7", "0");
		getDataConfig().set("d8", "0");
		
		getDataConfig().saveConfig();
	}

	public boolean hasPlayerData() {
		String as = getDataConfig().getString("UUID");

		if (as == null) {
			return false;
		} else {
			return true;
		}

	}

	public void createPlayerData() {
		setContent();
		System.out.println("PlayerData for " + getUUID() + " has been created");
	}

	public Inventory getInventory(Integer slot){
		Inventory inv = Bukkit.getServer().createInventory(null, 6*9);
		try{
			switch(slot){
				case 0:
					ItemSerialisation.deserializeInventory(getDataConfig().getString("0"), inv);
					break;
				case 1:
					ItemSerialisation.deserializeInventory(getDataConfig().getString("1"), inv);
					break;
				case 2:
					ItemSerialisation.deserializeInventory(getDataConfig().getString("2"), inv);
					break;
				case 3:
					ItemSerialisation.deserializeInventory(getDataConfig().getString("3"), inv);
					break;
				case 4:
					ItemSerialisation.deserializeInventory(getDataConfig().getString("4"), inv);
					break;
				case 5:
					ItemSerialisation.deserializeInventory(getDataConfig().getString("5"), inv);
					break;
				case 6:
					ItemSerialisation.deserializeInventory(getDataConfig().getString("6"), inv);
					break;
				case 7:
					ItemSerialisation.deserializeInventory(getDataConfig().getString("7"), inv);
					break;
				case 8:
					ItemSerialisation.deserializeInventory(getDataConfig().getString("8"), inv);
					break;
				default:
					break;
			}
		} catch(Exception e){
			System.out.println("ERROR");
		}
		return inv;
	}
	

	public void setEnderChestSlot0(Inventory inv){ try {
		getDataConfig().set("0", ItemSerialisation.serializeInventory(inv));
		getDataConfig().saveConfig();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} }
	public void setEnderChestSlot1(Inventory inv){ try {
		getDataConfig().set("1", ItemSerialisation.serializeInventory(inv));
		getDataConfig().saveConfig();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} }	
	public void setEnderChestSlot2(Inventory inv){ try {
		getDataConfig().set("2", ItemSerialisation.serializeInventory(inv));
		getDataConfig().saveConfig();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} }
	public void setEnderChestSlot3(Inventory inv){ try {
		getDataConfig().set("3", ItemSerialisation.serializeInventory(inv));
		getDataConfig().saveConfig();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} }
	public void setEnderChestSlot4(Inventory inv){ try {
		getDataConfig().set("4", ItemSerialisation.serializeInventory(inv));
		getDataConfig().saveConfig();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} }
	public void setEnderChestSlot5(Inventory inv){ try {
		getDataConfig().set("5", ItemSerialisation.serializeInventory(inv));
		getDataConfig().saveConfig();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} }
	public void setEnderChestSlot6(Inventory inv){ try {
		getDataConfig().set("6", ItemSerialisation.serializeInventory(inv));
		getDataConfig().saveConfig();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} }
	public void setEnderChestSlot7(Inventory inv){ try {
		getDataConfig().set("7", ItemSerialisation.serializeInventory(inv));
		getDataConfig().saveConfig();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} }
	public void setEnderChestSlot8(Inventory inv){ try {
		getDataConfig().set("8", ItemSerialisation.serializeInventory(inv));
		getDataConfig().saveConfig();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} }

	public Material getEnderChestMaterial0(){ return getDataConfig().getItemStack("i0").getType();}
	public Material getEnderChestMaterial1(){ return getDataConfig().getItemStack("i1").getType();}
	public Material getEnderChestMaterial2(){ return getDataConfig().getItemStack("i2").getType();}
	public Material getEnderChestMaterial3(){ return getDataConfig().getItemStack("i3").getType();}
	public Material getEnderChestMaterial4(){ return getDataConfig().getItemStack("i4").getType();}
	public Material getEnderChestMaterial5(){ return getDataConfig().getItemStack("i5").getType();}
	public Material getEnderChestMaterial6(){ return getDataConfig().getItemStack("i6").getType();}
	public Material getEnderChestMaterial7(){ return getDataConfig().getItemStack("i7").getType();}
	public Material getEnderChestMaterial8(){ return getDataConfig().getItemStack("i8").getType();}

	public void setEnderChestMaterial0(ItemStack i){getDataConfig().set("i0", i); getDataConfig().saveConfig();}
	public void setEnderChestMaterial1(ItemStack i){getDataConfig().set("i1", i); getDataConfig().saveConfig();}
	public void setEnderChestMaterial2(ItemStack i){getDataConfig().set("i2", i); getDataConfig().saveConfig();}
	public void setEnderChestMaterial3(ItemStack i){getDataConfig().set("i3", i); getDataConfig().saveConfig();}
	public void setEnderChestMaterial4(ItemStack i){getDataConfig().set("i4", i); getDataConfig().saveConfig();}
	public void setEnderChestMaterial5(ItemStack i){getDataConfig().set("i5", i); getDataConfig().saveConfig();}
	public void setEnderChestMaterial6(ItemStack i){getDataConfig().set("i6", i); getDataConfig().saveConfig();}
	public void setEnderChestMaterial7(ItemStack i){getDataConfig().set("i7", i); getDataConfig().saveConfig();}
	public void setEnderChestMaterial8(ItemStack i){getDataConfig().set("i8", i); getDataConfig().saveConfig();}
	
	public String getEnderChestName0(){ return getDataConfig().getString("n0").replace("&", "§"); }
	public String getEnderChestName1(){ return getDataConfig().getString("n1").replace("&", "§"); }
	public String getEnderChestName2(){ return getDataConfig().getString("n2").replace("&", "§"); }
	public String getEnderChestName3(){ return getDataConfig().getString("n3").replace("&", "§"); }
	public String getEnderChestName4(){ return getDataConfig().getString("n4").replace("&", "§"); }
	public String getEnderChestName5(){ return getDataConfig().getString("n5").replace("&", "§"); }
	public String getEnderChestName6(){ return getDataConfig().getString("n6").replace("&", "§"); }
	public String getEnderChestName7(){ return getDataConfig().getString("n7").replace("&", "§"); }
	public String getEnderChestName8(){ return getDataConfig().getString("n8").replace("&", "§"); }

	public void setEnderChestName0(String i){getDataConfig().set("n0", i); getDataConfig().saveConfig();}
	public void setEnderChestName1(String i){getDataConfig().set("n1", i); getDataConfig().saveConfig();}
	public void setEnderChestName2(String i){getDataConfig().set("n2", i); getDataConfig().saveConfig();}
	public void setEnderChestName3(String i){getDataConfig().set("n3", i); getDataConfig().saveConfig();}
	public void setEnderChestName4(String i){getDataConfig().set("n4", i); getDataConfig().saveConfig();}
	public void setEnderChestName5(String i){getDataConfig().set("n5", i); getDataConfig().saveConfig();}
	public void setEnderChestName6(String i){getDataConfig().set("n6", i); getDataConfig().saveConfig();}
	public void setEnderChestName7(String i){getDataConfig().set("n7", i); getDataConfig().saveConfig();}
	public void setEnderChestName8(String i){getDataConfig().set("n8", i); getDataConfig().saveConfig();}
	
	public short getEnderChestData0(){ return (short) getDataConfig().getInt("d0"); }
	public short getEnderChestData1(){ return (short) getDataConfig().getInt("d1"); }
	public short getEnderChestData2(){ return (short) getDataConfig().getInt("d2"); }
	public short getEnderChestData3(){ return (short) getDataConfig().getInt("d3"); }
	public short getEnderChestData4(){ return (short) getDataConfig().getInt("d4"); }
	public short getEnderChestData5(){ return (short) getDataConfig().getInt("d5"); }
	public short getEnderChestData6(){ return (short) getDataConfig().getInt("d6"); }
	public short getEnderChestData7(){ return (short) getDataConfig().getInt("d7"); }
	public short getEnderChestData8(){ return (short) getDataConfig().getInt("d8"); }

	public void setEnderChestData0(ItemStack i){ getDataConfig().set("d0", i.getDurability()); getDataConfig().saveConfig(); }
	public void setEnderChestData1(ItemStack i){ getDataConfig().set("d1", i.getDurability()); getDataConfig().saveConfig(); }
	public void setEnderChestData2(ItemStack i){ getDataConfig().set("d2", i.getDurability()); getDataConfig().saveConfig(); }
	public void setEnderChestData3(ItemStack i){ getDataConfig().set("d3", i.getDurability()); getDataConfig().saveConfig(); }
	public void setEnderChestData4(ItemStack i){ getDataConfig().set("d4", i.getDurability()); getDataConfig().saveConfig(); }
	public void setEnderChestData5(ItemStack i){ getDataConfig().set("d5", i.getDurability()); getDataConfig().saveConfig(); }
	public void setEnderChestData6(ItemStack i){ getDataConfig().set("d6", i.getDurability()); getDataConfig().saveConfig(); }
	public void setEnderChestData7(ItemStack i){ getDataConfig().set("d7", i.getDurability()); getDataConfig().saveConfig(); }
	public void setEnderChestData8(ItemStack i){ getDataConfig().set("d8", i.getDurability()); getDataConfig().saveConfig(); }
	
	public void removePlayerData() {
		getDataConfig().removeKey("UUID");
		getDataConfig().removeKey("0");
		getDataConfig().removeKey("1");
		getDataConfig().removeKey("2");
		getDataConfig().removeKey("3");
		getDataConfig().removeKey("4");
		getDataConfig().removeKey("5");
		getDataConfig().removeKey("6");
		getDataConfig().removeKey("7");
		getDataConfig().removeKey("8");
		getDataConfig().removeKey("d0");
		getDataConfig().removeKey("d1");
		getDataConfig().removeKey("d2");
		getDataConfig().removeKey("d3");
		getDataConfig().removeKey("d4");
		getDataConfig().removeKey("d5");
		getDataConfig().removeKey("d6");
		getDataConfig().removeKey("d7");
		getDataConfig().removeKey("d8");
		getDataConfig().removeKey("i0");
		getDataConfig().removeKey("i1");
		getDataConfig().removeKey("i2");
		getDataConfig().removeKey("i3");
		getDataConfig().removeKey("i4");
		getDataConfig().removeKey("i5");
		getDataConfig().removeKey("i6");
		getDataConfig().removeKey("i7");
		getDataConfig().removeKey("i8");
		getDataConfig().removeKey("n0");
		getDataConfig().removeKey("n1");
		getDataConfig().removeKey("n2");
		getDataConfig().removeKey("n3");
		getDataConfig().removeKey("n4");
		getDataConfig().removeKey("n5");
		getDataConfig().removeKey("n6");
		getDataConfig().removeKey("n7");
		getDataConfig().removeKey("n8");		
		getDataConfig().saveConfig();
	}

}