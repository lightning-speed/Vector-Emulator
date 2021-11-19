package com.vector;

import java.io.File;

public class launcher {
    public static long Memory_size;
    public static int processing_delay;
    public static String Disk_img_path = null;
    public static String Memory_dump_file_path;
    public static void setParameters(String args[]){
      for(int i = 0;i<args.length;i++){
          if(args[i].charAt(0)=='-'&&args[i].charAt(1)=='m'){
             Memory_size = Long.parseLong(args[i+1]);
              System.out.println("Memory Size Set to: "+Memory_size);
              i+=1;
          }
          else if(args[i].charAt(0)=='-'&&args[i].charAt(1)=='p'){
              processing_delay = Integer.parseInt(args[i+1]);
              System.out.println("Processing delay Set to: "+processing_delay);
              i+=1;
          }
          else if(args[i].charAt(0)=='-'&&args[i].charAt(1)=='d'&&args[i].charAt(2)=='f'){
              Memory_dump_file_path = args[i+1];
              System.out.println("Memory Dump File Set to: "+Memory_dump_file_path);
              i+=1;
          }
          else if(new File(args[i]).exists()&&new File(args[i]).isFile()){
            Disk_img_path = args[i];
              System.out.println("Disk Image Path Set to: "+Disk_img_path);
          }
          else{
              System.out.println("Invalid argument: "+args[i]);
          }
      }
    }
}
