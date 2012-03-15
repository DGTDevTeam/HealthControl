package me.JamieSinn.Bukkit;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class HealthControl extends JavaPlugin {
	public final Logger logger = Logger.getLogger("Minecraft");
	public static HealthControl Plugin;
	
	@Override
	public void onDisable()
	{
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has Been Disabled!");
		
	}
	@Override
	public void onEnable()
	{
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version" + pdfFile.getVersion() +  " Has Been Successfully Enabled!");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		Player player = (Player) sender;
		if (commandLabel.equalsIgnoreCase("heal"))
		{
			if (args.length == 0)
			{
				player.setHealth(20);
				player.sendMessage(ChatColor.GREEN + "Healed");
			}
			else if(args.length == 1)
			{
				if(player.getServer().getPlayer(args[0]) !=null)
				{
				Player targetPlayer1 = player.getServer().getPlayer(args [0]);
				targetPlayer1.setHealth(20);
				targetPlayer1.setFireTicks(0);
				player.sendMessage("Healed");
				}
			}
			else
			{
				player.sendMessage(ChatColor.RED + "PLAYER NOT ONLINE");
			}
		}
		return false;
	 
	
	}
}
