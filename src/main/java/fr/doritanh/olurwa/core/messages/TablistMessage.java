package fr.doritanh.olurwa.core.messages;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;

public class TablistMessage {
	private TextComponent header;
	private TextComponent footer;
	
	public TablistMessage() {
		this.header = new TextComponent(ChatColor.AQUA + "Olurwa \n ");
		this.footer = new TextComponent(ChatColor.GREEN + " \n Rejoignez-nous sur discord !");
	}
	
	public TextComponent getHeader() {
		return header;
	}

	public void setHeader(TextComponent heander) {
		this.header = heander;
	}

	public TextComponent getFooter() {
		return footer;
	}

	public void setFooter(TextComponent footer) {
		this.footer = footer;
	}
	
}
