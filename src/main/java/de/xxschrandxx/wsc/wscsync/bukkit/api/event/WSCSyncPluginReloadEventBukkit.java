package de.xxschrandxx.wsc.wscsync.bukkit.api.event;

import de.xxschrandxx.wsc.wscbridge.bukkit.api.event.AbstractWSCPluginReloadEventBukkit;
import de.xxschrandxx.wsc.wscbridge.core.api.command.ISender;

public final class WSCSyncPluginReloadEventBukkit extends AbstractWSCPluginReloadEventBukkit {
    public WSCSyncPluginReloadEventBukkit(ISender<?> sender) {
        super(sender);
    }    
}
