package com.deadmandungeons.audioconnect.flags.compat;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.flags.Flag;
import com.sk89q.worldguard.protection.flags.InvalidFlagFormat;
import com.sk89q.worldguard.protection.flags.RegionGroup;
import com.sk89q.worldguard.protection.flags.StringFlag;
import org.bukkit.command.CommandSender;

public class LegacyFlag<T> extends Flag<T> {

    private final StringFlag stringFlag = new StringFlag(null);
    private final FlagHandler<T> handler;

    public LegacyFlag(FlagHandler<T> handler, String name, RegionGroup defaultGroup) {
        super(name, defaultGroup);
        this.handler = handler;
    }

    public LegacyFlag(FlagHandler<T> handler, String name) {
        super(name);
        this.handler = handler;
    }


    @Override
    public T parseInput(WorldGuardPlugin plugin, CommandSender sender, String input) throws InvalidFlagFormat {
        return handler.parseInput(stringFlag.parseInput(plugin, sender, input));
    }

    @Override
    public T unmarshal(Object object) {
        return handler.unmarshal(object);
    }

    @Override
    public Object marshal(T instance) {
        return handler.marshal(instance);
    }

}
