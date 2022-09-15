package de.xxschrandxx.wsc.wscsync.bungee.listener;

import de.xxschrandxx.wsc.wscbridge.core.IMinecraftBridgePlugin;
import de.xxschrandxx.wsc.wscsync.core.api.IMinecraftSyncCoreAPI;
import de.xxschrandxx.wsc.wscsync.core.listener.MinecraftSyncCoreJoinListener;
import net.md_5.bungee.api.event.ServerConnectedEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class MinecraftSyncBungeeJoinListener extends MinecraftSyncCoreJoinListener implements Listener {
    public MinecraftSyncBungeeJoinListener(IMinecraftBridgePlugin<? extends IMinecraftSyncCoreAPI> instance) {
        super(instance);
    }

    @EventHandler
    public void onJoin(ServerConnectedEvent event) {
        syncPlayer(event.getPlayer().getUniqueId());
    }
}
