package me.conutik.utils;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CustomRecipes {

    private Utils main = new Utils().getMain();

    public void enchantedObby() {


        ItemStack item = new ItemStack(Material.OBSIDIAN);

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Obsidian Core");

        List<String> lores = new ArrayList<String>();

        lores.add(ChatColor.GOLD + "This item gives the wielder the ability");
        lores.add(ChatColor.GOLD + "to forge powerful items, that were never");
        lores.add(ChatColor.GOLD + "meant to not be discovered.");
        lores.add(ChatColor.RED + "" + ChatColor.BOLD + ChatColor.UNDERLINE + "Use this item with caution");

        meta.setLore(lores);

        item.setItemMeta(meta);

        NamespacedKey key = new NamespacedKey(this.main, "obsidian");

        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape("*g*", "gog", "*g*");

        recipe.setIngredient('g', Material.GOLD_INGOT);
        recipe.setIngredient('o', Material.OBSIDIAN);
        recipe.setIngredient('*', Material.AIR);

        Bukkit.addRecipe(recipe);

//        Bukkit.getServer().addRecipe();
    }

    public void corruptChest() {

        ItemStack items = new ItemStack(Material.OBSIDIAN);

        ItemMeta metas = items.getItemMeta();

        metas.setDisplayName(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Obsidian Core");

        List<String> lores = new ArrayList<String>();

        lores.add(ChatColor.GOLD + "This item gives the wielder the ability");
        lores.add(ChatColor.GOLD + "to forge powerful items, that were never");
        lores.add(ChatColor.GOLD + "meant to not be discovered.");
        lores.add(ChatColor.RED + "" + ChatColor.BOLD + ChatColor.UNDERLINE + "Use this item with caution");

        metas.setLore(lores);

        items.setItemMeta(metas);


        ItemStack item = new ItemStack(Material.ENDER_CHEST);

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Corrupted Ender Chest");

        List<String> loress = new ArrayList<String>();

        loress.add(ChatColor.GOLD + "This item gives the wielder the ability");
        loress.add(ChatColor.GOLD + "to open their EnderChest using /echest");
        loress.add(ChatColor.RED + "" + ChatColor.BOLD + ChatColor.UNDERLINE + "\nUse this item with caution");

        meta.setLore(loress);

        item.setItemMeta(meta);

        NamespacedKey key = new NamespacedKey(this.main, "ender_chest");

        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape("*g*", "oeo", "*o*");

        recipe.setIngredient('g', Material.LIGHTNING_ROD);
        recipe.setIngredient('o', new RecipeChoice.ExactChoice(items));
        recipe.setIngredient('*', Material.ENDER_EYE);
        recipe.setIngredient('e', Material.ENDER_CHEST);

        Bukkit.addRecipe(recipe);
    }
}
