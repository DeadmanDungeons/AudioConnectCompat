package com.deadmandungeons.audioconnect.flags.compat;

import com.sk89q.worldguard.protection.flags.InvalidFlagFormat;

public interface FlagHandler<T> {

    T unmarshal(Object object);

    Object marshal(T instance);

    T parseInput(String input) throws InvalidFlagFormat;

}
