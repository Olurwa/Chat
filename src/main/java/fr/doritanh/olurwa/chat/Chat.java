package fr.doritanh.olurwa.chat;

import net.md_5.bungee.api.chat.TextComponent;
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
		TextComponent welcome = new TextComponent("Salut ");
		welcome.addExtra(p.getName());
		this.getProxy().broadcast(welcome);
	}
}
