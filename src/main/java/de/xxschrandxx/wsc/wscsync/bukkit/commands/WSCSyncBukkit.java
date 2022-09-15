package de.xxschrandxx.wsc.wscsync.bukkit.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.xxschrandxx.wsc.wscbridge.bukkit.api.command.SenderBukkit;
import de.xxschrandxx.wsc.wscsync.bukkit.MinecraftSyncBukkit;
import de.xxschrandxx.wsc.wscsync.core.commands.WSCSync;

public class WSCSyncBukkit  implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        MinecraftSyncBukkit instance = MinecraftSyncBukkit.getInstance();
        SenderBukkit sb = new SenderBukkit(sender, instance);
        new WSCSync(instance).execute(sb, args);
        return true;
    }
}
