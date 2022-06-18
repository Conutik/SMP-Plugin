package me.conutik.utils;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class PlayerConfig {
    public static Utils main;
    static File cfile;
    public static FileConfiguration config;
    private static File folder;
    static File df; // = main.getDataFolder();

    public static void setMain(Utils m) {
        main = m;
        folder = new File(main.getDataFolder(), "player-data" + File.separator);
        folder.mkdirs();
        df = main.getDataFolder();
    }

    public static void create(Player p) {
        cfile = new File(folder, p.getUniqueId() + ".yml");
        if (!df.exists()) df.mkdir();
        if (!cfile.exists()) {
            try {
                cfile.createNewFile();
            } catch (Exception e) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Error creating " + cfile.getName() + "!");
            }
        }
        config = YamlConfiguration.loadConfiguration(cfile);
//        config.set("warnings", "0");
    }

    public static File getfolder() {
        return folder;
    }

    public static File getfile() {
        return cfile;
    }

    public static void load(Player p) {
        cfile = new File(df, "player-data" + File.separator + p.getUniqueId() + ".yml");
        config = YamlConfiguration.loadConfiguration(cfile);
    }

    public static FileConfiguration get() {
        return config;
    }

    public static void save() {
        try {
            config.save(cfile);
        } catch (Exception e) {
            Bukkit.broadcast(ChatColor.RED + "Error saving " + cfile.getName() + "!", "ChatColor.ErrorMsgs");
        }
    }
}
