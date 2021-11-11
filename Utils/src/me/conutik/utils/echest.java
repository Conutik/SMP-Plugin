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

public class echest implements CommandExecutor {

    private static Main main;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            final Player player = (Player) sender;

            PlayerConfig.create(player);

            PlayerConfig.load(player);

            Object idk = PlayerConfig.config.get("perm.echest");

            if(idk == null) {
                player.sendMessage(ChatColor.RED + "You don't have permission to use this command. You need a Corrupted Ender Chest to use this command.");
                return false;
            }

            Boolean id = (Boolean) idk;

            if(!id) {
                player.sendMessage(ChatColor.RED + "You don't have permission to use this command. You need a Corrupted Ender Chest to use this command.");
                return false;
            }

            player.openInventory(player.getEnderChest());



            player.sendMessage(ChatColor.GREEN + "You have opened your Ender Chest");
        }

        return true;
    }
}


//PlayerConfig.config.get("home."+args[0]);
