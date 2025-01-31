package org.mrtetyong.religionplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {

    private final ReligionPlugin plugin;

    public ReloadCommand(ReligionPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player) || sender.hasPermission("religionplugin.reload")) {
            plugin.reloadConfig();
            plugin.loadReligionsFromConfig();
            sender.sendMessage(ChatColor.GREEN + "Плагин был перезапущен.");
        } else {
            sender.sendMessage(ChatColor.RED + "У вас нет прав на выполнение этой команды.");
        }
        return true;
    }
}