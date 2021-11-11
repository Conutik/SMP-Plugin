package me.conutik.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main extends JavaPlugin implements Listener {
    PluginDescriptionFile info = this.getDescription();



    public void onEnable() {
        PlayerConfig.setMain(this);
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Utils v" + info.getVersion() + " is now Online");
        Bukkit.getPluginManager().registerEvents(this, this);

        getCommand("sethome").setExecutor(new sethome());
        getCommand("home").setExecutor(new home());
        getCommand("craft").setExecutor(new craft());
        getCommand("echest").setExecutor(new echest());
        getCommand("openechest").setExecutor(new openechest());

        customrecipe.enchantedObby();
        customrecipe.corruptChest();
    }

    @EventHandler
    public void onChat(final AsyncPlayerChatEvent event){
        final String message = event.getMessage();

        event.setFormat(ChatColor.YELLOW + "" + ChatColor.BOLD + event.getPlayer().getDisplayName() + ": " + ChatColor.RESET + event.getMessage());
    }

    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        Player player = e.getPlayer();

        e.setJoinMessage(ChatColor.GREEN + "" + e.getPlayer().getDisplayName() + " has joined!");
    }

    @EventHandler
    public void onLeave(final PlayerQuitEvent e) {
        e.setQuitMessage(ChatColor.RED + "" +e.getPlayer().getDisplayName() + " has left ):");
    }

//    @EventHandler
//    public void onPlayerStairClick(PlayerInteractEvent e) {
//        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
//            if (e.getClickedBlock().getType() == Material.OAK_STAIRS) {
//                Vector vec = new Vector(e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ());
//                Arrow a = e.getClickedBlock().getLocation().getWorld().spawnArrow(
//                        e.getClickedBlock().getLocation(),
//                        vec,
//                        e.getClickedBlock().getLocation().getPitch(),
//                        e.getClickedBlock().getLocation().getYaw());
//                a.addPassenger(e.getPlayer());
//            }
//        }
//    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {


        if(e.getAction() == Action.RIGHT_CLICK_AIR) {

            ItemStack item = new ItemStack(Material.ENDER_CHEST);

            ItemMeta meta = item.getItemMeta();

            meta.setDisplayName(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Corrupted Ender Chest");

            List<String> loress = new ArrayList<String>();

            loress.add(ChatColor.GOLD + "This item gives the wielder the ability");
            loress.add(ChatColor.GOLD + "to open their EnderChest using /echest");
            loress.add(ChatColor.RED + "" + ChatColor.BOLD + ChatColor.UNDERLINE + "\nUse this item with caution");

            meta.setLore(loress);

            item.setItemMeta(meta);

//            if(item == e.getItem()) {
            if(item.isSimilar(e.getItem())) {

                try {

                    TimeUnit.SECONDS.sleep(1);

                    e.getPlayer().getInventory().setItemInMainHand(null);

                    Player player = e.getPlayer();

                    PlayerConfig.create(player);

                    PlayerConfig.load(player);

                    PlayerConfig.config.set("perm.echest", true);

                    e.getPlayer().sendMessage(ChatColor.GREEN + "You have unlocked the ability to use /echest");

                    PlayerConfig.save();
                } catch (InterruptedException exception) {

                }
            }
        }
    }



}
