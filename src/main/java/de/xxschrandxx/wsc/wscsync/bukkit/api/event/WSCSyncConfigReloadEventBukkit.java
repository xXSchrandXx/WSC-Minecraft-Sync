package de.xxschrandxx.wsc.wscsync.bukkit.api.event;

import de.xxschrandxx.wsc.wscbridge.bukkit.api.event.AbstractWSCConfigReloadEventBukkit;
import de.xxschrandxx.wsc.wscbridge.core.api.command.ISender;

public final class WSCSyncConfigReloadEventBukkit extends AbstractWSCConfigReloadEventBukkit {
    public WSCSyncConfigReloadEventBukkit(ISender<?> sender) {
        super(sender);
    }   
}
