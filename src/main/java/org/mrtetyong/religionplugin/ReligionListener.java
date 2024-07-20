package org.mrtetyong.religionplugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ReligionListener implements Listener {

    private final ReligionPlugin plugin;

    public ReligionListener(ReligionPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        // Проверяем религию игрока и применяем баффы
        Religion religion = getReligion(player);
        if (religion != null) {
            applyBuffs(player, religion);
        }
    }

    @EventHandler
    public void onPlayerItemConsume(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        Material item = event.getItem().getType();
        Religion religion = getReligion(player);
        if (religion != null && religion.getName().equals("Ислам") && item == Material.PORKCHOP) {
            event.setCancelled(true);
            player.sendMessage(ChatColor.RED + "Вам запрещено употреблять свинину по вашей религии.");
        }
    }

    private Religion getReligion(Player player) {
        // Получение религии игрока (из данных или конфигурации)
        return plugin.getReligion("Christianity"); // Пример, здесь можно реализовать реальную логику получения религии
    }

    private void applyBuffs(Player player, Religion religion) {
        PotionEffectType buffType = PotionEffectType.getByName(religion.getBuff());
        PotionEffectType debuffType = PotionEffectType.getByName(religion.getDebuff());

        if (buffType != null) {
            player.addPotionEffect(new PotionEffect(buffType, Integer.MAX_VALUE, 1));
        }

        if (debuffType != null) {
            player.addPotionEffect(new PotionEffect(debuffType, Integer.MAX_VALUE, 1));
        }

        player.sendMessage(ChatColor.GREEN + "Вам были применены баффы религии: " + religion.getName());
    }
}