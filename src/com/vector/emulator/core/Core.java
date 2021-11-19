package com.vector.emulator.core;

import com.vector.launcher;

import java.io.File;

public class Core {
    public static File DISK_FILE;
    public static void init(){
        if(launcher.Disk_img_path!= null)
        DISK_FILE = new File(launcher.Disk_img_path);
    }

}
