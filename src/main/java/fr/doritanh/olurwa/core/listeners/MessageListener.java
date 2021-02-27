package fr.doritanh.olurwa.core.listeners;

import fr.doritanh.olurwa.core.Core;
import io.github.waterfallmc.waterfall.event.ProxyDefineCommandsEvent;
import net.luckperms.api.cacheddata.CachedMetaData;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;

import net.md_5.bungee.event.EventHandler;

public class MessageListener implements Listener {
	
	@EventHandler
	public void onChatEvent(ChatEvent e) {
		if (e.isCommand() || e.isProxyCommand() || !(e.getSender() instanceof ProxiedPlayer)) return;
		e.setCancelled(true);
		ProxiedPlayer player = (ProxiedPlayer)e.getSender();
		CachedMetaData user = Core.get().getLuckPerms().getPlayerAdapter(ProxiedPlayer.class).getMetaData(player);
		String message = player.getName() + ": " + e.getMessage();
		if (user.getPrefix() != null) {
			message = user.getPrefix() + ChatColor.RESET + player.getName() + ": " + e.getMessage();
		}
		message = ChatColor.translateAlternateColorCodes('&', message);
		for (ProxiedPlayer other : Core.get().getProxy().getPlayers()) {
			other.sendMessage(new TextComponent(message));
		}
	}
	
	@EventHandler 
	public void onProxyDefineCommands(ProxyDefineCommandsEvent e) {
		e.getCommands().clear();
		e.getCommands().put("lobby", Core.get().getLobbyCommand());
	}
	
}
