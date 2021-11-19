package com.vector.emulator.core;

import com.vector.emulator.io.FileManager;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class BIOS {
    public static void loadBIOS(){
        File f=new File("bios.bin");     //Creation of File Descriptor for input file
        BufferedReader br= null;  //Creation of BufferedReader object
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("bios.bin"), StandardCharsets.ISO_8859_1));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int c = 0;
        int i = 0;
        while(true)         //Read char by Char
        {
            try {
                if (!((c = br.read()) != -1)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            char character = (char)(c);
            RAM.memory[i] = character;
            i++;
        }
    }
}
