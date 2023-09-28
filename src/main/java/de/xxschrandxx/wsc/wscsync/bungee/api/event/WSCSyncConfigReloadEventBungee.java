package de.xxschrandxx.wsc.wscsync.bungee.api.event;

import de.xxschrandxx.wsc.wscbridge.bungee.api.event.AbstractWSCConfigReloadEventBungee;
import de.xxschrandxx.wsc.wscbridge.core.api.command.ISender;

public final class WSCSyncConfigReloadEventBungee extends AbstractWSCConfigReloadEventBungee {
    public WSCSyncConfigReloadEventBungee(ISender<?> sender) {
        super(sender);
    }   
}
