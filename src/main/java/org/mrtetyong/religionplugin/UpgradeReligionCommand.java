package org.mrtetyong.religionplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UpgradeReligionCommand implements CommandExecutor {

    private final ReligionPlugin plugin;

    public UpgradeReligionCommand(ReligionPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Эту команду могут использовать только игроки.");
            return true;
        }

        Player player = (Player) sender;
        ReligionPlayerData data = plugin.getPlayerData(player);

        if (data == null || data.getReligion() == null) {
            player.sendMessage(ChatColor.RED + "Вы не выбрали религию.");
            return true;
        }

        int level = data.getReligionLevel();
        int cost = getUpgradeCost(level);

        if (cost == -1) {
            player.sendMessage(ChatColor.RED + "Вы уже достигли максимального уровня религии.");
            return true;
        }

        if (!plugin.deductCoins(player, cost)) {
            player.sendMessage(ChatColor.RED + "У вас недостаточно монет для улучшения.");
            return true;
        }

        data.setReligionLevel(level + 1);
        plugin.savePlayerData(player, data);

        player.sendMessage(ChatColor.GREEN + "Вы улучшили вашу религию до уровня " + (level + 1) + " за " + cost + " монет.");

        return true;
    }

    private int getUpgradeCost(int level) {
        switch (level) {
            case 0:
                return 1000;
            case 1:
                return 5000;
            case 2:
                return 10000;
            default:
                return -1;
        }
    }
}