package de.xxschrandxx.wsc.wscsync.core.listener;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import de.xxschrandxx.wsc.wscbridge.core.IMinecraftBridgePlugin;
import de.xxschrandxx.wsc.wscsync.core.MinecraftSyncVars;
import de.xxschrandxx.wsc.wscsync.core.api.IMinecraftSyncCoreAPI;
import de.xxschrandxx.wsc.wscsync.core.api.exception.SyncGroupException;

public class MinecraftSyncCoreJoinListener {
    protected HashMap<UUID, Date> uuids = new HashMap<UUID, Date>();
    protected final IMinecraftBridgePlugin<? extends IMinecraftSyncCoreAPI> instance;
    public MinecraftSyncCoreJoinListener(IMinecraftBridgePlugin<? extends IMinecraftSyncCoreAPI> instance) {
        this.instance = instance;
    }
    public void syncPlayer(UUID uuid) {
        if (uuids.containsKey(uuid)) {
            if (uuids.get(uuid).before(new Date(System.currentTimeMillis() + instance.getConfiguration().getLong(MinecraftSyncVars.Configuration.syncOnJoinInterval)))) {
                if (instance.getAPI().isDebugModeEnabled()) {
                    instance.getAPI().log("Skipped sync of " + uuid.toString() + " on join.");
                }
                return;
            }
        }
        try {
            instance.getAPI().syncGroups(uuid);
            uuids.put(uuid, new Date());
            if (instance.getAPI().isDebugModeEnabled()) {
                instance.getAPI().log("Synced " + uuid.toString() + " on join.");
            }
        } catch (SyncGroupException e) {
            if (instance.getAPI().isDebugModeEnabled()) {
                instance.getAPI().log("Could not sync " + uuid.toString() + " groups on join.", e);
            }
        }
    }
}
