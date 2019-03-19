package com.capinfo.engine;

public class TaoGaiBehaviorFactory {


    public static TaoGaiBehavior newFactory(TaoGaiType type){
        switch (type){
            case XYXJGXL: return new TypeTaoGaiBehavior1();
            case ZWXL: return new TypeTaoGaiBehavior2();
            default: return null;
        }
    }

}
