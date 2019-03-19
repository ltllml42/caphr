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
     *   符合县以下机关职级并完成套改后人员(县以下机关序列)   完成套改后
     *
         含有一条在任的非领导职务人员 完成套改后
     *
     *   无法进行套改的只拥有领导职务且领导职务小于等于厅局级副职、大于 等于乡科级副职的人员(职务序列)
     *
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
