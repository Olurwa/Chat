package fr.doritanh.olurwa.core.listeners;

import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Cancellable;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ProxyPingListener implements Listener {

	@EventHandler
	public void onProxyPing(final ProxyPingEvent e) {
		final ServerPing response = e.getResponse();

		if (response == null || e instanceof Cancellable && ((Cancellable) e).isCancelled()) {
			return;
		}
		
		final ServerPing.Players players = response.getPlayers();
		int onlinePlayers = players.getOnline();
		int maxPlayers = players.getMax();
		
		response.setDescriptionComponent(new TextComponent("Olurwa"));
	}
	
}
