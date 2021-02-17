package fr.doritanh.olurwa.core.listeners;

import fr.doritanh.olurwa.core.Core;
import fr.doritanh.olurwa.core.messages.JoinMessage;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PlayerListener implements Listener {

	@EventHandler
    public void onPostLogin(PostLoginEvent e) {
		// Set up the join message
		JoinMessage msg = new JoinMessage(e.getPlayer());
		for (ProxiedPlayer other : Core.getInstance().getProxy().getPlayers()) {
			other.sendMessage(msg.getJoinMessage());
		}
		
		// Set up the tablist
		e.getPlayer().setTabHeader(new TextComponent("HEADER"), new TextComponent("FOOTER"));
    }
}
