package me.conutik.utils;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class anvil implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            final Player player = (Player) sender;

            Inventory inv = Bukkit.createInventory(null, InventoryType.ANVIL);
//            player.openInventory(inv);

            player.sendMessage("This command is disabled as of right now.");
        }
        return true;
    }
}
