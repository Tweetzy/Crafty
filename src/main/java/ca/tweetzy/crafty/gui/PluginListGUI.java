package ca.tweetzy.crafty.gui;

import ca.tweetzy.crafty.api.TweetzyPlugin;
import ca.tweetzy.crafty.gui.template.CraftyPagedGUI;
import ca.tweetzy.flight.comp.enums.CompMaterial;
import ca.tweetzy.flight.gui.events.GuiClickEvent;
import ca.tweetzy.flight.utils.ChatUtil;
import ca.tweetzy.flight.utils.Common;
import ca.tweetzy.flight.utils.QuickItem;
import lombok.NonNull;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * Date Created: April 25 2022
 * Time Created: 12:24 a.m.
 *
 * @author Kiran Hart
 */
public final class PluginListGUI extends CraftyPagedGUI<TweetzyPlugin> {

	public PluginListGUI(@NonNull final Player player) {
		super(new CraftyMainAdminGUI(player), player, "&ATweetzy &8> &7Plugins", 6, List.of(
				new TweetzyPlugin(60325, CompMaterial.CHEST, "Auction House", List.of("The most feature packed, up to date auction plugin"), 12),
				new TweetzyPlugin(102575, CompMaterial.SPAWNER, "Spawners", List.of("Mineable spawners, chunk/player limits, custom spawner", "levels, presets, upgrading, spawner shop."), 12),
				new TweetzyPlugin(92178, CompMaterial.LIME_SHULKER_BOX, "Markets", List.of("Markets is a completely new take on traditional player owned shops"), 12),
				new TweetzyPlugin(75600, CompMaterial.DIAMOND, "Shops", List.of("Shops is the ultimate solutions when", "it comes to creating server shops."), 12),
				new TweetzyPlugin(89864, CompMaterial.PAPER, "Vouchers", List.of("An easy to use voucher plugin, completely GUI based."), 0),
				new TweetzyPlugin(90098, CompMaterial.ZOMBIE_HEAD, "Skulls", List.of("Skulls is a collection of 55k+ custom textured Minecraft heads.", "A free alternative to Head Database"), 0),
				new TweetzyPlugin(101670, CompMaterial.GOLD_NUGGET, "Funds", List.of("Create unlimited custom currencies, Vault Support", "Withdraw / Pay / and Physical Currency"), 0),
				new TweetzyPlugin(29641, CompMaterial.NAME_TAG, "Item Name Tags", List.of("Allow players to rename items with ease, includes", "item name tags, lore tags, and delore tags."), 0)
		));
		draw();
	}

	@Override
	protected void drawFixed() {
		applyBackExit();
	}

	@Override
	protected ItemStack makeDisplayItem(TweetzyPlugin plugin) {
		return QuickItem.of(plugin.icon())
				.name("&e" + plugin.name())
				.lore(plugin.description())
				.lore("", "&7Price&f: " + (plugin.price() > 0D ? "&a$" + String.format("%,.2f", plugin.price()) + " USD" : "&bFree"))
				.hideTags(true)
				.make();
	}

	@Override
	protected void onClick(TweetzyPlugin object, GuiClickEvent clickEvent) {
		clickEvent.gui.close();
		Common.tellNoPrefix(clickEvent.player,
				"&8&m-----------------------------------------------------",
				"",
				ChatUtil.centerMessage("&e" + object.name()),
				ChatUtil.centerMessage("&bhttps://spigotmc.org/resources/" + object.spigotId()),
				"&8&m-----------------------------------------------------"
		);
	}

	@Override
	protected List<Integer> fillSlots() {
		return List.of(10, 12, 14, 16, 20, 22, 24, 28, 30, 32, 34);
	}
}
