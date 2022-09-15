package de.xxschrandxx.wsc.wscsync.bungee.commands;

import de.xxschrandxx.wsc.wscbridge.bungee.api.command.SenderBungee;
import de.xxschrandxx.wsc.wscsync.bungee.MinecraftSyncBungee;
import de.xxschrandxx.wsc.wscsync.core.commands.WSCSync;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class WSCSyncBungee extends Command {
    public WSCSyncBungee(String name) {
        super(name);
    }
    @Override
    public void execute(CommandSender sender, String[] args) {
        MinecraftSyncBungee instance = MinecraftSyncBungee.getInstance();
        SenderBungee sb = new SenderBungee(sender, instance);
        new WSCSync(instance).execute(sb, args);;
    }
}
