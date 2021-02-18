package dev.bjarne.noDeathDespawn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class eventHandler implements Listener {

	public static main Main;
	public static List<ItemStack> itemList;

	public eventHandler() {
		itemList = new ArrayList<ItemStack>();
	}

	public void setMain(main m) {
		eventHandler.Main = m;
		m.eH = this;

	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		Iterator<ItemStack> it = event.getDrops().iterator();
		while (it.hasNext()) {
			itemList.add(it.next());
		}
		return;
	}

	@EventHandler
	public void onItemDespawn(ItemDespawnEvent event) {
		if (event.getEntity().getItemStack() != null) {
			if (itemList.contains(event.getEntity().getItemStack())) {
				event.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onItemPickup(EntityPickupItemEvent event) {
		if (event.getItem().getItemStack() != null) {
			ItemStack s = event.getItem().getItemStack();
			if (itemList.contains(s)) {
				itemList.remove(s);
			}
		}
	}
}
