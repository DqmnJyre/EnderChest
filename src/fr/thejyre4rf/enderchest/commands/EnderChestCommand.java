package fr.thejyre4rf.enderchest.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.thejyre4rf.enderchest.Main;
import fr.thejyre4rf.enderchest.gui.SelectorGUI;

public class EnderChestCommand implements CommandExecutor{

	private Main main;
	
	public EnderChestCommand(Main main){
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player){
			Player p = (Player) sender;
			if(p.hasPermission("enderchest.command")){
				new SelectorGUI().openGUI(p, main);
			}
			else{
				p.sendMessage("§6[§cERREUR§6] §aVous n'avez pas les permissions pour utiliser cette commande");
			}
		}else{
			return false;
		}
		return false;
	}

	
	
}
