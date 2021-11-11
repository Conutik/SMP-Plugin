package me.conutik.utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class openechest implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            final Player player = (Player) sender;

            PlayerConfig.create(player);

            PlayerConfig.load(player);


            if(!player.isOp()) {
                player.sendMessage(ChatColor.RED + "No Perms");
                return false;
            }

            Player user = Bukkit.getPlayer(args[0]);

            if(user == null) {
                player.sendMessage(ChatColor.RED + "User?");
                return false;
            }

            player.openInventory(user.getEnderChest());



            player.sendMessage(ChatColor.GREEN + "You have opened " + user.getDisplayName() + "'s Ender Chest");
        }

        return true;
    }
}


//PlayerConfig.config.get("home."+args[0]);
