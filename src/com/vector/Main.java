package com.vector;

import com.vector.emulator.core.*;

public class Main {
    public static void main(String args[]){
        launcher.setParameters(args);
        System.out.println("Starting...");
        Core.init();
        RAM.ram_init();
        BIOS.loadBIOS();
        CPU.start_execution();
    }
}
