package de.xxschrandxx.wsc.wscsync.bungee.api.event;

import de.xxschrandxx.wsc.wscbridge.bungee.api.event.WSCBridgeConfigReloadEventBungee;
import de.xxschrandxx.wsc.wscbridge.core.api.command.ISender;

public class WSCSyncConfigReloadEventBungee extends WSCBridgeConfigReloadEventBungee {
    public WSCSyncConfigReloadEventBungee(ISender<?> sender) {
        super(sender);
    }   
}
