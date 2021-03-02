package fr.doritanh.olurwa.core.commands;

import fr.doritanh.olurwa.core.Core;
import fr.doritanh.olurwa.core.messages.MotdMessage;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class MotdCommand extends Command {

	public MotdCommand() {
		super("motd", "core.motd");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		Core.get().getConfig().set("motd", args);
		Core.get().saveConfig();
	}

}
