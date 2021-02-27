package fr.doritanh.olurwa.core.messages;

import fr.doritanh.olurwa.core.Core;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;

public class MotdMessage {
	private TextComponent motd;
	
	public MotdMessage() {
		String motd = Core.get().getConfig().getString("motd");
		this.motd = new TextComponent(motd);
		this.motd.setColor(ChatColor.AQUA);
		
	}
	
	public void setMotd(TextComponent tc) {
		this.motd = tc;
	}
	
	public TextComponent getMotd() {
		return this.motd;
	}
	
	
}
