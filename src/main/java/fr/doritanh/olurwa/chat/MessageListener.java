package fr.doritanh.olurwa.chat;

import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class MessageListener implements Listener {

	@EventHandler
    public void onPostLogin(PostLoginEvent e) {
		Chat.getInstance().sendJoinMessage(e.getPlayer());
    }
	
}
