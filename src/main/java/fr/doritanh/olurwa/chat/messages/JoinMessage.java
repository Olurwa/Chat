package fr.doritanh.olurwa.chat.messages;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class JoinMessage {
	private TextComponent joinMessage;
	private ProxiedPlayer player;
	
	public JoinMessage(ProxiedPlayer p) {
		this.joinMessage = new TextComponent("");
		this.player = p;

		int msg = (int) (Math.random() * 5);
		switch (msg) {
		case 0:
			this.setJoinMessage0();
			break;
		case 1:
			this.setJoinMessage1();
			break;
		case 2:
			this.setJoinMessage2();
			break;
		case 3:
			this.setJoinMessage3();
			break;
		case 4:
			this.setJoinMessage4();
			break;
		default:
			this.setJoinMessageDefault();
			break;
		}
	}
	
	private void setJoinMessageDefault() {
		this.joinMessage.addExtra("Bonjour ");
		this.joinMessage.setColor(ChatColor.AQUA);
		this.joinMessage.addExtra(this.player.getName());
		this.joinMessage.setColor(ChatColor.BLUE);
		this.joinMessage.addExtra(" !");
		this.joinMessage.setColor(ChatColor.AQUA);
	}
	
	private void setJoinMessage0() {
		this.joinMessage.addExtra("Salut, ");
		this.joinMessage.setColor(ChatColor.AQUA);
		this.joinMessage.addExtra(this.player.getName());
		this.joinMessage.setColor(ChatColor.BLUE);
		this.joinMessage.addExtra(" !");
		this.joinMessage.setColor(ChatColor.AQUA);
	}
	
	private void setJoinMessage1() {
		this.joinMessage.addExtra("Te voilà de retour, ");
		this.joinMessage.setColor(ChatColor.AQUA);
		this.joinMessage.addExtra(this.player.getName());
		this.joinMessage.setColor(ChatColor.BLUE);
		this.joinMessage.addExtra(" !");
		this.joinMessage.setColor(ChatColor.AQUA);
	}
	
	private void setJoinMessage2() {
		this.joinMessage.addExtra("On t'attendais, ");
		this.joinMessage.setColor(ChatColor.AQUA);
		this.joinMessage.addExtra(this.player.getName());
		this.joinMessage.setColor(ChatColor.BLUE);
		this.joinMessage.addExtra(" !");
		this.joinMessage.setColor(ChatColor.AQUA);
	}
	
	private void setJoinMessage3() {
		this.joinMessage.addExtra("Mais qui voilà ? ");
		this.joinMessage.setColor(ChatColor.AQUA);
		this.joinMessage.addExtra(this.player.getName());
		this.joinMessage.setColor(ChatColor.BLUE);
		this.joinMessage.addExtra(" !");
		this.joinMessage.setColor(ChatColor.AQUA);
	}
	
	private void setJoinMessage4() {
		this.joinMessage.addExtra("Attention, ");
		this.joinMessage.setColor(ChatColor.AQUA);
		this.joinMessage.addExtra(this.player.getName());
		this.joinMessage.setColor(ChatColor.BLUE);
		this.joinMessage.addExtra(" est là !");
		this.joinMessage.setColor(ChatColor.AQUA);
	}
	
	public TextComponent getJoinMessage() {
		return this.joinMessage;
	}
	
}
