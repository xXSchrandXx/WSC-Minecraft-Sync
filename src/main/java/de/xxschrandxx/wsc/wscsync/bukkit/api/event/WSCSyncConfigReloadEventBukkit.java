package de.xxschrandxx.wsc.wscsync.bukkit.api.event;

import de.xxschrandxx.wsc.wscbridge.bukkit.api.event.WSCBridgeConfigReloadEventBukkit;
import de.xxschrandxx.wsc.wscbridge.core.api.command.ISender;

public class WSCSyncConfigReloadEventBukkit extends WSCBridgeConfigReloadEventBukkit {
    public WSCSyncConfigReloadEventBukkit(ISender<?> sender) {
        super(sender);
    }   
}
