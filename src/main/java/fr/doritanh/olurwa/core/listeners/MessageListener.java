package fr.doritanh.olurwa.core.listeners;

import fr.doritanh.olurwa.core.Core;
import fr.doritanh.olurwa.core.messages.JoinMessage;
import net.luckperms.api.cacheddata.CachedMetaData;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class MessageListener implements Listener {

	@EventHandler
    public void onPostLogin(PostLoginEvent e) {
		JoinMessage msg = new JoinMessage(e.getPlayer());
		for (ProxiedPlayer other : Core.getInstance().getProxy().getPlayers()) {
			other.sendMessage(msg.getJoinMessage());
		}
    }
	
	@EventHandler
	public void onChatEvent(ChatEvent e) {
		if (!e.isCommand() && !e.isProxyCommand() && e.getSender() instanceof ProxiedPlayer) {
			e.setCancelled(true);
			ProxiedPlayer player = (ProxiedPlayer)e.getSender();
			CachedMetaData user = Core.getInstance().getLuckPerms().getPlayerAdapter(ProxiedPlayer.class).getMetaData(player);
			String message = player.getName() + ": ";
			if (user.getPrefix() != null) {
				message = user.getPrefix() + ChatColor.RESET + player.getName() + ": ";
			}
			for (ProxiedPlayer other : Core.getInstance().getProxy().getPlayers()) {
				other.sendMessage(new TextComponent(message));
			}
		}
	}
	
}
