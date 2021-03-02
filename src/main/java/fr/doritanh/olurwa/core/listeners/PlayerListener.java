package fr.doritanh.olurwa.core.listeners;

import java.util.Collection;
import java.util.Map;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import fr.doritanh.olurwa.core.Core;
import fr.doritanh.olurwa.core.messages.JoinMessage;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PlayerListener implements Listener {

	@EventHandler
	public void onPostLogin(PostLoginEvent e) {
		// Set up the join message
		JoinMessage msg = new JoinMessage(e.getPlayer());
		for (ProxiedPlayer other : Core.get().getProxy().getPlayers()) {
			other.sendMessage(msg.getJoinMessage());
		}
	}

	@EventHandler
	public void onDisconnect(PlayerDisconnectEvent e) {
		// Get server of player
		Server srv = e.getPlayer().getServer();
		// Get players in the network
		Collection<ProxiedPlayer> playersCollection = srv.getInfo().getPlayers();
		if (playersCollection == null || playersCollection.isEmpty()) {
			return;
		}
		String players = "";
		for (ProxiedPlayer p : playersCollection) {
			if (p.getUniqueId() == e.getPlayer().getUniqueId())
				continue;
			if (players.equalsIgnoreCase("")) {
				players += p.getName();
			} else {
				players += ", " + p.getName();
			}
		}

		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("PlayerList");
		out.writeUTF(srv.getInfo().getName());
		out.writeUTF(players);

		for (Map.Entry<String, ServerInfo> pair : Core.get().getProxy().getServersCopy().entrySet()) {
			pair.getValue().sendData("olurwa:core", out.toByteArray());
		}
	}
}
