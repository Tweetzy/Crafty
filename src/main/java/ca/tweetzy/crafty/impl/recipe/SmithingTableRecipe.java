package ca.tweetzy.crafty.impl.recipe;

import ca.tweetzy.crafty.Crafty;
import ca.tweetzy.crafty.api.recipe.CustomRecipe;
import ca.tweetzy.crafty.api.recipe.RecipeType;
import ca.tweetzy.flight.utils.SerializeUtil;
import com.google.gson.JsonObject;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.SmithingRecipe;
import org.bukkit.inventory.SmithingTransformRecipe;

public final class SmithingTableRecipe extends CustomRecipe {

	private ItemStack template;
	private ItemStack equipment;
	private ItemStack upgrade;
	private ItemStack result;

	public SmithingTableRecipe(String id, ItemStack template, ItemStack equipment, ItemStack upgrade, ItemStack result) {
		super(id.toLowerCase(), RecipeType.SMITHING_TABLE);
		this.template = template;
		this.equipment =equipment;
		this.upgrade = upgrade;
		this.result = result;
	}

	@Override
	public void register() {

		final SmithingRecipe smithingRecipe = new SmithingTransformRecipe(
				this.getKey(),
				this.result,
				new RecipeChoice.ExactChoice(this.template),
				new RecipeChoice.ExactChoice(this.equipment),
				new RecipeChoice.ExactChoice(this.upgrade)
		);


		Crafty.getInstance().getServer().getScheduler().runTask(Crafty.getInstance(), () -> {
			Crafty.getInstance().getServer().addRecipe(smithingRecipe);
			Bukkit.getOnlinePlayers().forEach(player -> {
				if (!player.hasDiscoveredRecipe(this.getKey()))
					player.discoverRecipe(this.getKey());
			});
		});
	}

	@Override
	public String getJSONString() {
		final JsonObject object = new JsonObject();
		object.addProperty("key", this.id.toLowerCase());

		object.addProperty("template", SerializeUtil.encodeItem(this.template));
		object.addProperty("equipment", SerializeUtil.encodeItem(this.equipment));
		object.addProperty("upgrade", SerializeUtil.encodeItem(this.upgrade));
		object.addProperty("result", SerializeUtil.encodeItem(this.result));

		return object.toString();
	}
}
