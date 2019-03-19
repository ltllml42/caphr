package com.capinfo.engine.taogai.factory;

import com.capinfo.engine.taogai.TaoGaiBehavior;
import com.capinfo.engine.taogai.TaoGaiType;
import com.capinfo.engine.taogai.TypeTaoGaiBehavior1;
import com.capinfo.engine.taogai.TypeTaoGaiBehavior2;

public class TaoGaiBehaviorFactory {


    public static TaoGaiBehavior newFactory(TaoGaiType type){
        switch (type){
            case XYXJGXL: return new TypeTaoGaiBehavior1();
            case ZWXL: return new TypeTaoGaiBehavior2();
            default: return null;
        }
    }

}
