package fr.doritanh.olurwa.chat;

import fr.doritanh.olurwa.chat.messages.JoinMessage;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;

public class Chat extends Plugin {
	private static Chat instance;
	
	public Chat() {
		this.instance = this;
	}
	
	@Override
    public void onEnable() {
		this.getProxy().getPluginManager().registerListener(this, new MessageListener());
    }
	
	public static Chat getInstance() {
		return instance;
	}
	
	public void sendJoinMessage(ProxiedPlayer p) {
		JoinMessage msg = new JoinMessage(p);
		for (ProxiedPlayer other : this.getProxy().getPlayers()) {
			other.sendMessage(msg.getJoinMessage());
		}
	}
}
