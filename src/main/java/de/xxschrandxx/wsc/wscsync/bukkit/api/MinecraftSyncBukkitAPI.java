package de.xxschrandxx.wsc.wscsync.bukkit.api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.UUID;
import java.util.logging.Logger;

import de.xxschrandxx.wsc.wscbridge.bukkit.api.MinecraftBridgeBukkitAPI;
import de.xxschrandxx.wsc.wscbridge.core.api.MinecraftBridgeCoreAPI;
import de.xxschrandxx.wsc.wscbridge.core.api.Response;
import de.xxschrandxx.wsc.wscsync.core.api.IMinecraftSyncCoreAPI;
import de.xxschrandxx.wsc.wscsync.core.api.MinecraftSyncCoreAPI;
import de.xxschrandxx.wsc.wscsync.core.api.exception.SyncGroupException;
import de.xxschrandxx.wsc.wscsync.core.api.permission.*;

public class MinecraftSyncBukkitAPI extends MinecraftBridgeBukkitAPI implements IMinecraftSyncCoreAPI {

    protected final URL url;

    protected final IPermissionHandler permHandler;

    public MinecraftSyncBukkitAPI(URL url, PermissionPlugin permPlugin, Logger logger, MinecraftBridgeCoreAPI api) {
        super(api.getID(), api.getAuth(), logger, api.isDebugModeEnabled());
        this.url = url;
        switch(permPlugin) {
            case LuckPerms:
                this.permHandler = new LuckPermsHandler(this);
                break;
            case CloudNet:
                this.permHandler = new CloudNetHandler(this);
                break;
            case Vault:
                this.permHandler = new VaultHandler(this);
                break;
            default:
                this.permHandler = new DefaultHandler(this);
                break;
        }
    }

    public Response<String, Object> getGroups(UUID uuid) throws SocketTimeoutException, MalformedURLException, IOException {
        return MinecraftSyncCoreAPI.getGroups(this, url, uuid);
    }

    public void syncGroups(UUID uuid) throws SyncGroupException {
        MinecraftSyncCoreAPI.syncGroups(this, url, uuid);
    }

    public IPermissionHandler getHandler() {
        return this.permHandler;
    }
}
