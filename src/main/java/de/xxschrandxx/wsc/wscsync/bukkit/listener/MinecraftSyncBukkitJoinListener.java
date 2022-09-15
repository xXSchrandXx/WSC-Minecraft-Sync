package de.xxschrandxx.wsc.wscsync.bukkit.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.xxschrandxx.wsc.wscbridge.core.IMinecraftBridgePlugin;
import de.xxschrandxx.wsc.wscsync.core.api.IMinecraftSyncCoreAPI;
import de.xxschrandxx.wsc.wscsync.core.listener.MinecraftSyncCoreJoinListener;

public class MinecraftSyncBukkitJoinListener extends MinecraftSyncCoreJoinListener implements Listener {
    public MinecraftSyncBukkitJoinListener(IMinecraftBridgePlugin<? extends IMinecraftSyncCoreAPI> instance) {
        super(instance);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        syncPlayer(event.getPlayer().getUniqueId());
    }
}
