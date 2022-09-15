package de.xxschrandxx.wsc.wscsync.bungee.api.event;

import de.xxschrandxx.wsc.wscbridge.bungee.api.event.WSCBridgePluginReloadEventBungee;
import de.xxschrandxx.wsc.wscbridge.core.api.command.ISender;

public class WSCSyncPluginReloadEventBungee extends WSCBridgePluginReloadEventBungee {
    public WSCSyncPluginReloadEventBungee(ISender<?> sender) {
        super(sender);
    }    
}
