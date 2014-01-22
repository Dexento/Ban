package me.Dexento.TicTacToe;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin 
{
    public final Logger logger = Logger.getLogger("TicTacToe");
    public static Main plugin;
	
	public void onEnable()
	{
        this.logger.info("TicTacToe has been enabled!");
	}
	
	public void onDisable()
	{
		this.logger.info("TicTacToe has been disabled!");
	}
	
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    	Player p = (Player) sender;
    	if (cmd.getName().equalsIgnoreCase("ban")){
    		if(p.hasPermission("impulse.ban")){
    			if (args.length == 0){
    				p.sendMessage("USAGEGOESHERE");
    			}
    			
    			if (args.length == 1){
    				if(Bukkit.getPlayer(args[0]).isOnline()) {
    					Player tp = getServer().getPlayer(args[0]);
    					tp.setBanned(true);
    					tp.kickPlayer("REASONGOESHERE");
    				}else{
    					OfflinePlayer op = getServer().getOfflinePlayer(args[0]);
    					op.setBanned(true);
    				}
    			}
    		}
    	}
    	if (cmd.getName().equalsIgnoreCase("unban")){
    		if(p.hasPermission("impulse.unban")){
    			if (args.length == 0){
    				p.sendMessage("USAGEGOESHERE");
    			}
    			
    			if (args.length == 1){
					OfflinePlayer op = getServer().getOfflinePlayer(args[0]);
					op.setBanned(false);
    			}else{
    				if(!p.isBanned());
    				p.sendMessage("PLAYERNOTBANNEDMESSAGE");
    			}
    		}
    	}
    	if (cmd.getName().equalsIgnoreCase("kick")){
    		if(p.hasPermission("impulse.kick")){
    			if (args.length == 0){
    				p.sendMessage("USAGEGOESHERE");
    			}
    			
    			if (args.length == 1){
    				if (Bukkit.getPlayer(args[0]).isOnline()) {
    					Player tp = getServer().getPlayer(args[0]);
    					tp.kickPlayer("REASONGOESHERE");
    				}else{
    					p.sendMessage("PLAYERNOTONLINEMESSAGE");
    				}
    			}
    		}
    	}
		return false;
    }
}
    
