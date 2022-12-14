package de.xxschrandxx.wsc.wscsync.bungee.api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.UUID;
import java.util.logging.Logger;

import de.xxschrandxx.wsc.wscbridge.bungee.api.MinecraftBridgeBungeeAPI;
import de.xxschrandxx.wsc.wscbridge.core.api.Response;
import de.xxschrandxx.wsc.wscsync.core.api.IMinecraftSyncCoreAPI;
import de.xxschrandxx.wsc.wscsync.core.api.MinecraftSyncCoreAPI;
import de.xxschrandxx.wsc.wscsync.core.api.exception.SyncGroupException;
import de.xxschrandxx.wsc.wscsync.core.api.permission.*;

public class MinecraftSyncBungeeAPI extends MinecraftBridgeBungeeAPI implements IMinecraftSyncCoreAPI {

    protected final URL url;

    protected final IPermissionHandler permHandler;

    public MinecraftSyncBungeeAPI(URL url, PermissionPlugin permPlugin, Logger logger, MinecraftBridgeBungeeAPI api) {
        super(api, logger);
        this.url = url;
        switch(permPlugin) {
            case LuckPerms:
                this.permHandler = new LuckPermsHandler(this);
                break;
            case CloudNet:
                this.permHandler = new CloudNetHandler(this);
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
