package fr.doritanh.olurwa.core;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import fr.doritanh.olurwa.core.commands.LobbyCommand;
import fr.doritanh.olurwa.core.commands.MotdCommand;
import fr.doritanh.olurwa.core.listeners.MessageListener;
import fr.doritanh.olurwa.core.listeners.PlayerListener;
import fr.doritanh.olurwa.core.listeners.ProxyPingListener;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class Core extends Plugin {
	private static Core instance;
	private LuckPerms lp;
	private Configuration config;

	private Command motdCommand;
	private Command lobbyCommand;

	public Core() {
		Core.instance = this;
		if (!this.getDataFolder().exists()) {
			this.getDataFolder().mkdir();
		}
		File configFile = new File(this.getDataFolder(), "config.yml");
		try {
			configFile.createNewFile();
			this.config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(configFile);
		} catch (IOException e) {
			this.getLogger().log(Level.SEVERE, "Can't create config file !");
		}
	}

	@Override
	public void onEnable() {
		// Use Luckperms API for prefix in chat
		this.lp = LuckPermsProvider.get();

		// Config file
		config.set("motd", "Olurwa en construction");
		this.saveConfig();

		// Register commands
		this.motdCommand = new MotdCommand();
		this.lobbyCommand = new LobbyCommand();
		this.getProxy().getPluginManager().registerCommand(this, this.motdCommand);
		this.getProxy().getPluginManager().registerCommand(this, this.lobbyCommand);
		// Register events
		this.getProxy().getPluginManager().registerListener(this, new MessageListener());
		this.getProxy().getPluginManager().registerListener(this, new ProxyPingListener());
		this.getProxy().getPluginManager().registerListener(this, new PlayerListener());
		// Register channels
		this.getProxy().registerChannel("olurwa:core");

	}

	public static Core get() {
		return instance;
	}

	public Configuration getConfig() {
		return config;
	}

	public void saveConfig() {
		try {
			ConfigurationProvider.getProvider(YamlConfiguration.class).save(config,
					new File(getDataFolder(), "config.yml"));
		} catch (IOException e) {
			this.getLogger().log(Level.SEVERE, "Can't save config file !");
		}
	}

	public LuckPerms getLuckPerms() {
		return this.lp;
	}

	public Command getMotdCommand() {
		return motdCommand;
	}

	public Command getLobbyCommand() {
		return lobbyCommand;
	}

}
