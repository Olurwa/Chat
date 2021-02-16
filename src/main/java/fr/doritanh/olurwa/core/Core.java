package fr.doritanh.olurwa.core;

import fr.doritanh.olurwa.core.listener.MessageListener;
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
		this.getProxy().getPluginManager().registerListener(this, new MessageListener());
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
