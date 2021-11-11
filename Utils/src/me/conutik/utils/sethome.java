package me.conutik.utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class sethome implements CommandExecutor {

    private static Main main;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            final Player player = (Player) sender;

            if(args.length == 0) {
                player.sendMessage(ChatColor.RED + "Please specify home name.");
                return false;
            }

            PlayerConfig.create(player);

            PlayerConfig.load(player);

            PlayerConfig.config.set("home."+args[0], player.getLocation());

            player.sendMessage(ChatColor.GREEN + "Home " + '"' + args[0] + '"' + " has been set");

            PlayerConfig.save();
        }

        return true;
    }
}
