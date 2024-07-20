package org.mrtetyong.religionplugin;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class ReligionPlugin extends JavaPlugin {

    private Economy economy;

    @Override
    public void onEnable() {
        // Инициализация Vault
        if (!setupEconomy()) {
            getLogger().severe("Vault not found!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        this.getCommand("religion").setExecutor(new ReligionCommand(this));
        this.getCommand("upgradeReligion").setExecutor(new UpgradeReligionCommand(this));
        // Другие команды и инициализация
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        economy = rsp.getProvider();
        return economy != null;
    }

    public boolean deductCoins(Player player, int amount) {
        if (economy == null) return false;
        return economy.withdrawPlayer(player, amount).transactionSuccess();
    }

    public Religion getReligion(String key) {
        // Логика получения религии по ключу
        return null; // Заглушка
    }

    public void setPlayerReligion(Player player, String religionKey) {
        // Логика установки религии игроку
    }

    public ReligionPlayerData getPlayerData(Player player) {
        // Логика получения данных игрока
        return null; // Заглушка
    }

    public void savePlayerData(Player player, ReligionPlayerData data) {
        // Логика сохранения данных игрока
    }

    public void resetPlayerReligion(Player player) {
    }

    public void loadReligionsFromConfig() {
    }
}