package de.xxschrandxx.wsc.wscsync.core.api.permission;

import java.util.ArrayList;
import java.util.UUID;

import de.xxschrandxx.wsc.wscbridge.core.api.command.ISender;

public interface IPermissionHandler {
    public ArrayList<String> groupList();
    public ArrayList<String> getUsersGroups(UUID uuid) throws IllegalArgumentException;
    public ArrayList<String> getUsersGroups(ISender<?> sender) throws IllegalArgumentException;
    public boolean addGroup(UUID uuid, String groupName) throws IllegalArgumentException;
    public boolean addGroup(ISender<?> sender, String groupName) throws IllegalArgumentException;
    public boolean removeGroup(UUID uuid, String groupName) throws IllegalArgumentException;
    public boolean removeGroup(ISender<?> sender, String groupName) throws IllegalArgumentException;
}
