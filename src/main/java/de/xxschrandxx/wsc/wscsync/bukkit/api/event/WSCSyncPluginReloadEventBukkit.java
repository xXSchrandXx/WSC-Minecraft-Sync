package de.xxschrandxx.wsc.wscsync.bukkit.api.event;

import de.xxschrandxx.wsc.wscbridge.bukkit.api.event.WSCBridgePluginReloadEventBukkit;
import de.xxschrandxx.wsc.wscbridge.core.api.command.ISender;

public class WSCSyncPluginReloadEventBukkit extends WSCBridgePluginReloadEventBukkit {
    public WSCSyncPluginReloadEventBukkit(ISender<?> sender) {
        super(sender);
    }    
}
