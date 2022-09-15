package de.xxschrandxx.wsc.wscsync.core.api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.UUID;

import de.xxschrandxx.wsc.wscbridge.core.api.IMinecraftBridgeCoreAPI;
import de.xxschrandxx.wsc.wscbridge.core.api.Response;
import de.xxschrandxx.wsc.wscsync.core.api.exception.SyncGroupException;
import de.xxschrandxx.wsc.wscsync.core.api.permission.IPermissionHandler;

public interface IMinecraftSyncCoreAPI extends IMinecraftBridgeCoreAPI {
    public Response<String, Object> getGroups(UUID uuid) throws SocketTimeoutException, MalformedURLException, IOException;
    public void syncGroups(UUID uuid) throws SyncGroupException;
    public IPermissionHandler getHandler();
}
