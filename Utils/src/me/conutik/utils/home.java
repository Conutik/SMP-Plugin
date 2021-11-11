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

public class home implements CommandExecutor {

    private static Main main;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            final Player player = (Player) sender;

            if(args.length == 0) {
                player.sendMessage(ChatColor.RED + "Please specify the home name.");
                return false;
            }

            PlayerConfig.create(player);

            PlayerConfig.load(player);

            Object idk = PlayerConfig.config.get("home."+args[0]);

            if(idk == null) {
                player.sendMessage(ChatColor.RED + "You don't have a home with this name.");
            }

            if(idk instanceof Location) {
                Location loc = (Location) idk;
                player.teleport(loc);
            }



            player.sendMessage(ChatColor.GREEN + "You have been teleported to home " + '"' + args[0] + '"');
        }

        return true;
    }
}


//PlayerConfig.config.get("home."+args[0]);
