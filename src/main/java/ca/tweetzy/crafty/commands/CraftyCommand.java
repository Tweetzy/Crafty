package ca.tweetzy.crafty.commands;

import ca.tweetzy.crafty.Crafty;
import ca.tweetzy.crafty.gui.CraftyMainAdminGUI;
import ca.tweetzy.flight.command.AllowedExecutor;
import ca.tweetzy.flight.command.Command;
import ca.tweetzy.flight.command.ReturnType;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public final class CraftyCommand extends Command {

	public CraftyCommand() {
		super(AllowedExecutor.BOTH, "crafty");
	}

	@Override
	protected ReturnType execute(CommandSender sender, String... args) {
		if (sender instanceof final Player player) {
			Crafty.getGuiManager().showGUI(player, new CraftyMainAdminGUI(player));
		}

		return ReturnType.SUCCESS;
	}

	@Override
	public String getSyntax() {
		return "/crafty";
	}

	@Override
	public String getDescription() {
		return "Main command for the plugin";
	}

	@Override
	public String getPermissionNode() {
		return "crafty.command";
	}

	@Override
	protected List<String> tab(CommandSender sender, String... args) {
		return null;
	}
}
