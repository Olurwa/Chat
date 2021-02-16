package fr.doritanh.olurwa.core;

import fr.doritanh.olurwa.core.listeners.MessageListener;
import fr.doritanh.olurwa.core.listeners.ProxyPingListener;
import fr.doritanh.olurwa.core.messages.JoinMessage;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;

public class Core extends Plugin {
	private static Core instance;
	
	public Core() {
		this.instance = this;
	}
	
	@Override
    public void onEnable() {
		// Register events
		this.getProxy().getPluginManager().registerListener(this, new MessageListener());
		this.getProxy().getPluginManager().registerListener(this, new ProxyPingListener());
    }
	
	public static Core getInstance() {
		return instance;
	}
	
	public void sendJoinMessage(ProxiedPlayer p) {
		JoinMessage msg = new JoinMessage(p);
		for (ProxiedPlayer other : this.getProxy().getPlayers()) {
			other.sendMessage(msg.getJoinMessage());
		}
	}
}
