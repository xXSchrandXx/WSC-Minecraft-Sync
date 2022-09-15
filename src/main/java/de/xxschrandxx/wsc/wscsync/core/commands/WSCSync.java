package de.xxschrandxx.wsc.wscsync.core.commands;

import java.util.UUID;

import de.xxschrandxx.wsc.wscbridge.core.IMinecraftBridgePlugin;
import de.xxschrandxx.wsc.wscbridge.core.api.command.ISender;
import de.xxschrandxx.wsc.wscsync.core.MinecraftSyncVars;
import de.xxschrandxx.wsc.wscsync.core.api.IMinecraftSyncCoreAPI;
import de.xxschrandxx.wsc.wscsync.core.api.exception.SyncGroupException;

public class WSCSync {
    private IMinecraftBridgePlugin<? extends IMinecraftSyncCoreAPI> instance;
    public WSCSync(IMinecraftBridgePlugin<? extends IMinecraftSyncCoreAPI> instance) {
        this.instance = instance;
    }
    public void execute(ISender<?> sender, String[] args) {
        if (args.length == 0) {
            player(sender);
        }
        else {
            admin(sender, args);
        }
    }

    public void player(ISender<?> sender) {
        if (!sender.isPlayer()) {
            sender.send(MinecraftSyncVars.Configuration.LangCmdPlayerOnly);
            return;
        }
        if (!sender.checkPermission(MinecraftSyncVars.Configuration.PermCmdWSCSync)) {
            sender.send(MinecraftSyncVars.Configuration.LangCmdNoPerm);
            return;
        }
        UUID uuid = sender.getUniqueId();
        if (uuid == null) {
            sender.send(MinecraftSyncVars.Configuration.LangCmdPlayerOnly);
            return;
        }
        try {
            instance.getAPI().syncGroups(uuid);
            sender.send(MinecraftSyncVars.Configuration.LangCmdWSCSyncSuccess);
        }
        catch (SyncGroupException e) {
            String message = instance.getConfiguration().getString(MinecraftSyncVars.Configuration.LangCmdWSCSyncError);
            sender.sendMessage(message.replaceAll("%error%", e.getMessage()));
        }
    }

    public void admin(ISender<?> sender, String[] args) {
        if (!sender.checkPermission(MinecraftSyncVars.Configuration.PermCmdWSCSyncAdmin)) {
            sender.send(MinecraftSyncVars.Configuration.LangCmdNoPerm);
            return;
        }
        ISender<?> target = null;
        try {
            UUID uuid = UUID.fromString(args[0]);
            target = instance.getAPI().getSender(uuid, instance);
            }
        catch (IllegalArgumentException e) {
            target = instance.getAPI().getSender(args[0], instance);
        }
        if (target == null) {
            sender.send(MinecraftSyncVars.Configuration.LangCmdAdminNoPlayer);
            return;
        }
        try {
            instance.getAPI().syncGroups(target.getUniqueId());
            sender.send(MinecraftSyncVars.Configuration.LangCmdAdminSyncSuccess);
        }
        catch (SyncGroupException e) {
            String message = instance.getConfiguration().getString(MinecraftSyncVars.Configuration.LangCmdAdminSyncError);
            sender.sendMessage(message.replaceAll("%error%", e.getMessage()));
        }
    }
}
