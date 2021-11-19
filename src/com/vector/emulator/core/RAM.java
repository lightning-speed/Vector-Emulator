package com.vector.emulator.core;

import com.vector.launcher;

public class RAM {
    public static char[] memory;
    public static void ram_init(){
        memory = new char[(int)launcher.Memory_size];
        System.out.println("Ram Initialized");
    }
}
