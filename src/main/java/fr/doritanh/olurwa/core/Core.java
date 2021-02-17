package fr.doritanh.olurwa.core;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import fr.doritanh.olurwa.core.commands.LobbyCommand;
import fr.doritanh.olurwa.core.commands.MotdCommand;
import fr.doritanh.olurwa.core.listeners.MessageListener;
import fr.doritanh.olurwa.core.listeners.PlayerListener;
import fr.doritanh.olurwa.core.listeners.ProxyPingListener;
import fr.doritanh.olurwa.core.messages.JoinMessage;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class Core extends Plugin {
	private static Core instance;
	private LuckPerms lp;
	private Configuration config;
	
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
			// e.printStackTrace();
			this.getLogger().log(Level.SEVERE, "Can't create config file !");
		}
	}
	
	@Override
    public void onEnable() {
		// Use Luckperms API for prefix in chat
		this.lp = LuckPermsProvider.get();
		
		// Config file
		config.set("motd", "Olurwa en construction");
		
		// Register commands
		this.getProxy().getPluginManager().registerCommand(this, new MotdCommand());
		this.getProxy().getPluginManager().registerCommand(this, new LobbyCommand());
		// Register events
		this.getProxy().getPluginManager().registerListener(this, new MessageListener());
		this.getProxy().getPluginManager().registerListener(this, new ProxyPingListener());
		this.getProxy().getPluginManager().registerListener(this, new PlayerListener());
		
    }
	
	public static Core getInstance() {
		return instance;
	}
	
	public Configuration getConfig() {
		return config;
	}
	
	public LuckPerms getLuckPerms() {
		return this.lp;
	}
}
