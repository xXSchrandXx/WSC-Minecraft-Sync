package de.xxschrandxx.wsc.wscsync.bungee.api.event;

import de.xxschrandxx.wsc.wscbridge.bungee.api.event.AbstractWSCConfigReloadEventBungee;
import de.xxschrandxx.wsc.wscbridge.core.api.command.ISender;

public final class WSCSyncPluginReloadEventBungee extends AbstractWSCConfigReloadEventBungee {
    public WSCSyncPluginReloadEventBungee(ISender<?> sender) {
        super(sender);
    }    
}
