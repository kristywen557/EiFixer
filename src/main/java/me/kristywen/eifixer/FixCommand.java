package me.kristywen.eifixer;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class FixCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player)sender;
        ItemStack[] items = player.getInventory().getContents();
        for (ItemStack item : items) {
            if (item != null &&
                    item.getType() != Material.AIR && item.getType() != Material.FIREWORK_ROCKET &&
                    item.hasItemMeta()) {
                ItemMeta meta = item.getItemMeta();
                String id = (String)meta.getPersistentDataContainer().getOrDefault(new NamespacedKey("executableitems", "ei-id"), PersistentDataType.STRING, "");
                if (id != "") {
                    Integer amount = Integer.valueOf(item.getAmount());
                    item.setType(Material.STICK);
                    item.setAmount(0);
                    if (id != " ")
                        Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "ei give " + player.getName() + " " + id + " " + amount);
                }
            }
        }
        return true;
    }
}
