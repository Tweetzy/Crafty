package ca.tweetzy.crafty.api.sync;

import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public interface Synchronize {

	default void sync(@Nullable final Consumer<SynchronizeResult> syncResult) {
		if (syncResult != null)
			syncResult.accept(SynchronizeResult.SUCCESS);
	}
}
