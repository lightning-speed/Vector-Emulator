package com.vector.emulator.core;

public class CPU {
    public static int instruction_pointer = 0;
    public static void start_execution(){
       for(instruction_pointer = 0;instruction_pointer<RAM.memory.length;instruction_pointer++){
           execute_instruction(instruction_pointer);
       }
    }
   public static void execute_instruction(int address){
        char opcode = (char) RAM.memory[address];
        System.out.println((int)opcode);
        char args[] = new char[5];
        try {
            for (int i = 0; i < 5; i++) args[i] = (char) RAM.memory[address + 1 + i];
        }catch (Exception e){}
        switch (opcode){
            case 0xb8:
                Register.MoveValue("ax",(args[1] << 8) + args[0]);
                break;
            case 0xb4:
                Register.MoveValue("ah", args[0]);
                break;
            case 0xb0:
                Register.MoveValue("al", args[0]);
                break;
            case 0xbb:
                Register.MoveValue("bx",(args[1] << 8) + args[0]);
                break;
            case 0xb7:
                Register.MoveValue("bh", args[0]);
                break;
            case 0xb3:
                Register.MoveValue("bl", args[0]);
                break;
            case 0xb9:
                Register.MoveValue("cx",(args[1] << 8) + args[0]);
                break;
            case 0xb5:
                Register.MoveValue("ch", args[0]);
                break;
            case 0xb1:
                Register.MoveValue("cl", args[0]);
                break;
            case 0xba:
                Register.MoveValue("dx",(args[1] << 8) + args[0]);
                break;
            case 0xb6:
                Register.MoveValue("dh", args[0]);
                break;
            case 0xb2:
                Register.MoveValue("dl", args[0]);
                break;
            case 0xbe:
                Register.MoveValue("si", args[0]);
                break;
            case 0xbf:
                Register.MoveValue("di", args[0]);
                break;
            case 0xbd:
                Register.MoveValue("bp", args[0]);
                break;
            case 0xbc:
                Register.MoveValue("sp", args[0]);
                break;
            case 0x89:
                short a,b;
                a = Register.getUpperHalfOfChar(args[0]);
                b = Register.getLowerHalfOfChar(args[0]);
                String ao[] = Register.getRegsFromCode(a,b);
                System.out.println(ao[0]);
                Register.MoveReg(ao[0],ao[1]);
                break;
            default:
                break;
        }
        System.out.println((int)Register.getRegValueOf("ax"));
    }
}
