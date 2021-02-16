package fr.doritanh.olurwa.core.messages;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;

public class MotdMessage {
	private TextComponent motd;
	
	public MotdMessage() {
		this.motd = new TextComponent("Olurwa en construction");
		this.motd.setColor(ChatColor.AQUA);
		
	}
	
	public void setMotd(TextComponent tc) {
		this.motd = tc;
	}
	
	public TextComponent getMotd() {
		return this.motd;
	}
	
	
}
