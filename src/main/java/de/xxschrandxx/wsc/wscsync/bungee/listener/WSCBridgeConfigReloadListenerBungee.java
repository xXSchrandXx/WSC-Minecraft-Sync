package de.xxschrandxx.wsc.wscsync.bungee.listener;

import java.util.logging.Level;

import de.xxschrandxx.wsc.wscbridge.bungee.api.event.WSCBridgeConfigReloadEventBungee;
import de.xxschrandxx.wsc.wscsync.bungee.MinecraftSyncBungee;
import de.xxschrandxx.wsc.wscsync.bungee.api.event.WSCSyncConfigReloadEventBungee;
import de.xxschrandxx.wsc.wscsync.core.MinecraftSyncVars;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class WSCBridgeConfigReloadListenerBungee implements Listener {
    @EventHandler
    public void onConfigReload(WSCBridgeConfigReloadEventBungee event) {
        MinecraftSyncBungee instance = MinecraftSyncBungee.getInstance();
        String configStart = instance.getConfiguration().getString(MinecraftSyncVars.Configuration.LangCmdReloadConfigStart);
        event.getSender().sendMessage(configStart);
        if (!instance.reloadConfiguration(event.getSender())) {
            String configError = instance.getConfiguration().getString(MinecraftSyncVars.Configuration.LangCmdReloadConfigError);
            event.getSender().sendMessage(configError);
            instance.getLogger().log(Level.WARNING, "Could not load config.yml!");
            return;
        }
        String configSuccess = instance.getConfiguration().getString(MinecraftSyncVars.Configuration.LangCmdReloadConfigSuccess);
        event.getSender().sendMessage(configSuccess);
        instance.getProxy().getPluginManager().callEvent(new WSCSyncConfigReloadEventBungee(event.getSender()));
    }
}
