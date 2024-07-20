package org.mrtetyong.religionplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReligionCommand implements CommandExecutor {

    private final ReligionPlugin plugin;

    public ReligionCommand(ReligionPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Эту команду могут использовать только игроки.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length < 1) {
            player.sendMessage(ChatColor.RED + "Использование: /religion <название религии>");
            return true;
        }

        String religionKey = args[0];
        Religion religion = plugin.getReligion(religionKey);

        if (religion == null) {
            player.sendMessage(ChatColor.RED + "Религия " + religionKey + " не найдена.");
            return true;
        }

        plugin.setPlayerReligion(player, religionKey);
        player.sendMessage(ChatColor.GREEN + "Вы выбрали религию: " + religion.getName());
        player.sendMessage(ChatColor.GREEN + "Вы получили бафф: " + religion.getBuff() + " и дебафф: " + religion.getDebuff());

        return true;
    }
}