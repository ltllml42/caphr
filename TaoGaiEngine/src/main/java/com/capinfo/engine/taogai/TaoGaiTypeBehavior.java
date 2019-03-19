package com.capinfo.engine.taogai;

import com.capinfo.engine.data.VersionInfo;
import com.capinfo.engine.message.MessageCode;

/**
 * 套改类型判断
 */
public interface TaoGaiTypeBehavior<T> {
    /**
     * 填写版本
     * @return
     */
    public VersionInfo getVersion();

    /**
     * 通过基础数据判断套改类型
     *
     * //符合县以下机关职级并完成套改后人员(县以下机关序列)
     * //无法进行套改的只拥有领导职务且领导职务小于等于厅局级副职、大于 等于乡科级副职的人员(职务序列)
     * //非领导套改后人员/县以下机关序列到顶后人员(符合县以下机关人员晋升到一级调研员之后)/领导人员完成首次晋升后人员。(职级序列)
     *
     *
     * @param data
     * @return
     */
    public TaoGaiType judgementType(T data);

    /**
     * 传入的数据必须是符合套改条件的基础数据
     * @param data
     * @return
     */
    public MessageCode validate(T data);




}
