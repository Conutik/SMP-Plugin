package me.conutik.utils.Commands;
import me.conutik.utils.Config;
import me.conutik.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomeCommand implements CommandExecutor {

    private static Utils main;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            final Player player = (Player) sender;

            if(args.length == 0) {
                player.sendMessage(ChatColor.RED + "Please specify the home name.");
                return false;
            }
            Config PlayerConfig = new Config();

            PlayerConfig.createPlayerData(player);

            PlayerConfig.load(player);

            Object idk = PlayerConfig.getConfig().get("home."+args[0]);

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
