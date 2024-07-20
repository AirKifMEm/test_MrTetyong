package org.mrtetyong.religionplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ResetReligionCommand implements CommandExecutor {

    private final ReligionPlugin plugin;

    public ResetReligionCommand(ReligionPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Эту команду могут использовать только игроки.");
            return true;
        }

        Player player = (Player) sender;
        plugin.resetPlayerReligion(player);
        player.sendMessage(ChatColor.GREEN + "Ваша религия была сброшена, все бафы и дебаффы удалены.");

        return true;
    }
}