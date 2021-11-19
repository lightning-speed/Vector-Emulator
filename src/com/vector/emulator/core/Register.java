package com.vector.emulator.core;

public class Register {
    public static short ax;
    public static short bx;
    public static short cx;
    public static short dx;
    public static short si;
    public static short di;
    public static short bp;
    public static short sp;
    public static short cs;
    public static short ds;
    public static short es;
    public static short ss;
    public static byte getLowerHalfOfChar(char num){
        return (byte) (num&15);
    }
    public static byte getUpperHalfOfChar(char num){
        return (byte) (num >> 4);
    }
    public static char getLowerHalfOfShort(short num){
        return (char) (num&255);
    }
    public static char getUpperHalfOfShort(short num){
        return (char) (num >> 8);
    }

    public static void setRegValueTo(String name,int value){
        switch (name){
            case "ax":
                ax = (short)value;
                break;
            case "ah":
                ax = (short) ((short)ax | value << 7);
                break;
            case "al":
                ax = (short) ((short)ax | value << 0);
                break;
            case "bx":
                bx = (short)value;
                break;
            case "bh":
                bx = (short) ((short)bx | value << 7);
                break;
            case "bl":
                bx = (short) ((short)bx | value << 0);
                break;
            case "cx":
                cx = (short)value;
                break;
            case "ch":
                cx = (short) ((short)cx | value << 7);
                break;
            case "cl":
                cx = (short) ((short)cx | value << 0);
                break;
            case "dx":
                dx = (short)value;
                break;
            case "dh":
                dx = (short) ((short)dx | value << 7);
                break;
            case "dl":
                dx = (short) ((short)dx | value << 0);
                break;
            case "si":
                si = (short)value;
                break;
            case "di":
                di = (short)value;
                break;
            case "bp":
                bp = (short)value;
                break;
            case "sp":
                sp = (short)value;
                break;
            case "cs":
                cs = (short)value;
                break;
            case "ds":
                ds = (short)value;
                break;
            case "es":
                es = (short)value;
                break;
            case "ss":
                ss = (short)value;
                break;
            default:
                break;
        }
    }
    public static short getRegValueOf(String name){
        switch(name){
            case "ax":
                return ax;
            case "ah":
                return (short) (ax >> 7);
            case "al":
                return (short) (ax & 255);
            case "bx":
                return bx;
            case "bh":
                return (short) (bx >> 7);
            case "bl":
                return (short) (bx & 255);
            case "cx":
                return cx;
            case "ch":
                return (short) (cx >> 7);
            case "cl":
                return (short) (cx & 255);
            case "dx":
                return dx;
            case "dh":
                return (short) (dx >> 7);
            case "dl":
                return (short) (dx & 255);
            case "si":
                return si;
            case "di":
                return di;
            case "bp":
                return bp;
            case "sp":
                return sp;
            case "es":
               return es;
            case "ds":
                return ds;
            case "ss":
                return ss;
            case "cs":
                return cs;
            default:
                break;
        }
        return 0;
    }
    public static void MoveReg(String from,String to){
        setRegValueTo(from,getRegValueOf(to));
    }
    public static void MoveValue(String from,int to){
        setRegValueTo(from,to);
    }
    public static String[] getRegsFromCode(int a, int b){
        String out[] = new String[2];
        if(a==0xc){
            if(b==0x0)out = new String[]{"ax", "ax"};
            else if(b==0x3)out = new String[]{"bx","ax"};
            else if(b==0x1)out = new String[]{"cx","ax"};
            else if(b==0x2)out = new String[]{"dx","ax"};
            else if(b==0x6)out = new String[]{"si","ax"};
            else if(b==0x7)out = new String[]{"di","ax"};
            else if(b==0x4)out = new String[]{"sp","ax"};
            else if(b==0x5)out = new String[]{"bp","ax"};
            else if(b==0x8)out = new String[]{"ax","cx"};
            else if(b==0xb)out = new String[]{"bx","cx"};
            else if(b==0x9)out = new String[]{"cx","cx"};
            else if(b==0xa)out = new String[]{"dx","cx"};
            else if(b==0xe)out = new String[]{"si","cx"};
            else if(b==0xf)out = new String[]{"di","cx"};
            else if(b==0xc)out = new String[]{"sp","cx"};
            else if(b==0xd)out = new String[]{"bp","cx"};
        }
        if(a==0xd){
            if(b==0x8)out = new String[]{"ax","bx"};
            else if(b==0xb)out = new String[]{"bx","bx"};
            else if(b==0x9)out = new String[]{"cx","bx"};
            else if(b==0xa)out = new String[]{"dx","bx"};
            else if(b==0xe)out = new String[]{"si","bx"};
            else if(b==0xf)out = new String[]{"di","bx"};
            else if(b==0xc)out = new String[]{"sp","bx"};
            else if(b==0xd)out = new String[]{"bp","bx"};
            else if(b==0x0)out = new String[]{"ax","dx"};
            else if(b==0x3)out = new String[]{"bx","dx"};
            else if(b==0x1)out = new String[]{"cx","dx"};
            else if(b==0x2)out = new String[]{"dx","dx"};
            else if(b==0x6)out = new String[]{"si","dx"};
            else if(b==0x7)out = new String[]{"di","dx"};
            else if(b==0x4)out = new String[]{"sp","dx"};
            else if(b==0x5)out = new String[]{"bp","dx"};
        }
        if(a==0xe){
            if(b==0x8)out = new String[]{"ax","bp"};
            else if(b==0xb)out = new String[]{"bx","bp"};
            else if(b==0x9)out = new String[]{"cx","bp"};
            else if(b==0xa)out = new String[]{"dx","bp"};
            else if(b==0x0)out = new String[]{"ax","sp"};
            else if(b==0x3)out = new String[]{"bx","sp"};
            else if(b==0x1)out = new String[]{"cx","sp"};
            else if(b==0x2)out = new String[]{"dx","sp"};
        }
        if(a==0xf) {
            if (b == 0x8) out = new String[]{"ax", "di"};
            else if (b == 0xb) out = new String[]{"bx", "di"};
            else if (b == 0x9) out = new String[]{"cx", "di"};
            else if (b == 0xa) out = new String[]{"dx", "di"};
            else if (b == 0x0) out = new String[]{"ax", "si"};
            else if (b == 0x3) out = new String[]{"bx", "si"};
            else if (b == 0x1) out = new String[]{"cx", "si"};
            else if (b == 0x2) out = new String[]{"dx", "si"};
        }
        return out;
    }
}
