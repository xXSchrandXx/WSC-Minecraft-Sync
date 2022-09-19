package de.xxschrandxx.wsc.wscsync.bukkit.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import de.xxschrandxx.wsc.wscbridge.bukkit.api.event.WSCBridgeModuleEventBukkit;
import de.xxschrandxx.wsc.wscsync.core.listener.AddModuleListenerCore;

public class AddModuleListenerBukkit extends AddModuleListenerCore implements Listener {
    @EventHandler
    public void addModuleListener(WSCBridgeModuleEventBukkit event) {
        event.addModule(name);
    }
}
