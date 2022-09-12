package inventoryinterception.inventoryinterception;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Interception implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command,String label,String[] args){

        Player player;
        Player send = (Player) sender;

        if(args.length != 2){
            return false;
        }

        try{
            player = Bukkit.getPlayer(args[0]);
            if(!(player.isOnline())){
                // a target player does not online
                sender.sendMessage("§cThe player does not exist.(A target player does not exist error.)");
                return false;
            }
        }catch(Exception exception){
            sender.sendMessage("§cThe player does not exist.(To get player error.)");
            return false;
        }

        Inventory targetInventory;

        if(args[1].equalsIgnoreCase("ender")){
            targetInventory = player.getEnderChest();

        }else if(args[1].equalsIgnoreCase("normal")){
            targetInventory = player.getInventory();

        }else{
            return false;
        }

        send.openInventory(targetInventory);
        return true;
    }

}
