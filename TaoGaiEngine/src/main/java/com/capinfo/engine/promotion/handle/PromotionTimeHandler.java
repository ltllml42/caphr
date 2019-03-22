package com.capinfo.engine.promotion.handle;

import com.capinfo.engine.TaoGaiLogger;
import com.capinfo.engine.data.*;
import com.capinfo.engine.log.Ledger;
import com.capinfo.engine.promotion.PromotionType;
import com.capinfo.engine.utils.DateUtils;
import com.capinfo.engine.utils.entity.DateAddEntity;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

public class PromotionTimeHandler extends ServingLimitHandler implements Ledger {


    @Override
    public TaoGaiLogger message(String level, Object... msg) {
        return null;
    }

    @Override
    public boolean validate() {
        boolean flag = super.validate();
        return flag;
    }

    @Override
    public void handleRequest(PromotionType type) {
        switch (type) {
            case DYZ1: servingLimit +=countTypeOneServingList(product);
                break;
            case DYZ2: servingLimit +=countTypeTwoServingList(product);
                break;
            case DYZ3: servingLimit +=countTypeThreeServingList(product);

                break;
        }
    }

    /**
     *
     *     套改 第一次晋级  正常晋级
     *
     *
     *     type=1     县处级以下职级，只晋升一次，晋升时间=当前时间-县处级以下职级的任职时间
     *                晋升时间>2年，满足晋升一级的时间，晋升一级。
     *                次晋升时，晋升时间=当前时间-上次晋升时间
     * @param product
     * @return
     */
    private int countTypeOneServingList(OriginalProduct product) {



        return 0;
    }

    /**
     *     type=2    非领导职务 \n
     *           首次晋升===》   任职年限=当前时间-套改前职务层次时间  \n
     *           二次晋升===》   任职年限=当前时间-套改前职务层次时间-首次晋升用时年限（规则中规定的首次晋升时这个职级应该用掉的时间）\n
     *           再次晋升===》   任职年限=当前时间-上次晋升时间 \n
     * @param product
     * @return
     */
    private int countTypeTwoServingList(OriginalProduct product) {
                Stack<TaoGaiPromotionSubset> promotionHisList = product.getPromotionHisList();
        TaoGaiPromotionSubset promPeek = promotionHisList.peek();
        //首次晋升



        return 0;
    }

    /**
     *     type=3   领导职务  \n
     *          首次晋升===》   任职年限=当前时间-任现职务层次时间  \n
     *          二次晋升===》   任职年限=当前时间-任现职务层次时间-首次晋升用时年限（规则中规定的首次晋升时这个职级应该用掉的时间） \n
     *          再次晋升===》   任职年限=当前时间-上次晋升时间 \n
     *
     * @param product
     * @return
     */
    private int countTypeThreeServingList(OriginalProduct product) {

        return 0;
    }

    @Override
    public List loadDict(List dictList) {
        return null;
    }
}
