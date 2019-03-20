package com.capinfo.engine.promotion;

import com.capinfo.engine.data.DictBean;
import com.capinfo.engine.data.OriginalProduct;
import com.capinfo.engine.data.VersionInfo;
import com.capinfo.engine.message.MessageCode;
import com.capinfo.engine.message.MessageEnum;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class PromotionTypeBehaviorImpl<T> implements PromotionTypeBehavior<T> {


    @Override
    public VersionInfo getVersion() {
        return VersionInfo.VERSION_2019;
    }

    /**
     * @param data
     * @return
     */
    @Override
    public PromotionType judgementType(T data) {
        OriginalProduct product = (OriginalProduct)data;
        String afterRanks= product.getAfterRanks();
        List<DictBean> needRanksList = product.getNeedRanksDicts();
        if (needRanksList.contains(new DictBean(afterRanks))){
            return PromotionType.DYZ1;
        }else if(!product.isLeader()){
            return PromotionType.DYZ2;
        }
        return PromotionType.DYZ3;
        //throw new Exception(new MessageCode().failMessage(MessageEnum.LI_CODE_03, OriginalProduct.class.getName(), data.getClass());
    }

    @Override
    public MessageCode validate(T data) {
        if (data == null)
            return new MessageCode().failMessage(MessageEnum.LI_CODE_04);
        if (!(data instanceof OriginalProduct))
            return new MessageCode().failMessage(MessageEnum.LI_CODE_03, OriginalProduct.class.getName(), data.getClass());

        OriginalProduct product = (OriginalProduct)data;
        //if ()通过当前年 判断是否有新的套改规则。
        StringBuffer message = new StringBuffer("");
        if(!product.isCoverModel()){
            message.append(new MessageCode().failMessage(MessageEnum.LI_CODE_05,product.getName(),product.getIdCode()).getMsg()+"\n");
        };
        if(StringUtils.isNotBlank(product.getAfterRanks())){
            message.append(new MessageCode().failMessage(MessageEnum.LI_CODE_06,product.getName(),product.getIdCode(),"套改后职级").getMsg()+"\n");
        }


        if(StringUtils.isNotBlank(message.toString())){
            return new MessageCode().failMessage(message);
        }

        return new MessageCode().successMessage();
    }
}
