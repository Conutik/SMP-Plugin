package me.conutik.utils.Commands;
import me.conutik.utils.Config;
import me.conutik.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetHomeCommand implements CommandExecutor {

    private static Utils main;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            final Player player = (Player) sender;

            if(args.length == 0) {
                player.sendMessage(ChatColor.RED + "Please specify home name.");
                return false;
            }
            Config PlayerConfig = new Config();

            PlayerConfig.createPlayerData(player);

            PlayerConfig.load(player);

            PlayerConfig.getConfig().set("home."+args[0], player.getLocation());

            player.sendMessage(ChatColor.GREEN + "Home " + '"' + args[0] + '"' + " has been set");

            PlayerConfig.save();
        }

        return true;
    }
}
