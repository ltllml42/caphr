package com.capinfo.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "js_sys_menu")
public class JsSysMenu implements Serializable {
    /**
     * 菜单编码
     */
    @Id
    private String menu_code;

    /**
     * 父级编号
     */
    private String parent_code;

    /**
     * 所有父级编号
     */
    private String parent_codes;

    /**
     * 本级排序号（升序）
     */
    private Long tree_sort;

    /**
     * 所有级别排序号
     */
    private String tree_sorts;

    /**
     * 是否最末级
     */
    private String tree_leaf;

    /**
     * 层次级别
     */
    private Short tree_level;

    /**
     * 全节点名
     */
    private String tree_names;

    /**
     * 菜单名称
     */
    private String menu_name;

    /**
     * 菜单类型（1菜单 2权限 3开发）
     */
    private String menu_type;

    /**
     * 链接
     */
    private String menu_href;

    /**
     * 目标
     */
    private String menu_target;

    /**
     * 图标
     */
    private String menu_icon;

    /**
     * 颜色
     */
    private String menu_color;

    /**
     * 权限标识
     */
    private String permission;

    /**
     * 菜单权重
     */
    private Short weight;

    /**
     * 是否显示（1显示 0隐藏）
     */
    private String is_show;

    /**
     * 归属系统（default:主导航菜单、mobileApp:APP菜单）
     */
    private String sys_code;

    /**
     * 归属模块（多个用逗号隔开）
     */
    private String module_codes;

    /**
     * 状态（0正常 1删除 2停用）
     */
    private String status;

    /**
     * 创建者
     */
    private String create_by;

    /**
     * 创建时间
     */
    private Date create_date;

    /**
     * 更新者
     */
    private String update_by;

    /**
     * 更新时间
     */
    private Date update_date;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 扩展 String 1
     */
    private String extend_s1;

    /**
     * 扩展 String 2
     */
    private String extend_s2;

    /**
     * 扩展 String 3
     */
    private String extend_s3;

    /**
     * 扩展 String 4
     */
    private String extend_s4;

    /**
     * 扩展 String 5
     */
    private String extend_s5;

    /**
     * 扩展 String 6
     */
    private String extend_s6;

    /**
     * 扩展 String 7
     */
    private String extend_s7;

    /**
     * 扩展 String 8
     */
    private String extend_s8;

    /**
     * 扩展 Integer 1
     */
    private BigDecimal extend_i1;

    /**
     * 扩展 Integer 2
     */
    private BigDecimal extend_i2;

    /**
     * 扩展 Integer 3
     */
    private BigDecimal extend_i3;

    /**
     * 扩展 Integer 4
     */
    private BigDecimal extend_i4;

    /**
     * 扩展 Float 1
     */
    private BigDecimal extend_f1;

    /**
     * 扩展 Float 2
     */
    private BigDecimal extend_f2;

    /**
     * 扩展 Float 3
     */
    private BigDecimal extend_f3;

    /**
     * 扩展 Float 4
     */
    private BigDecimal extend_f4;

    /**
     * 扩展 Date 1
     */
    private Date extend_d1;

    /**
     * 扩展 Date 2
     */
    private Date extend_d2;

    /**
     * 扩展 Date 3
     */
    private Date extend_d3;

    /**
     * 扩展 Date 4
     */
    private Date extend_d4;

    private static final long serialVersionUID = 1L;

    /**
     * 获取菜单编码
     *
     * @return menu_code - 菜单编码
     */
    public String getMenu_code() {
        return menu_code;
    }

    /**
     * 设置菜单编码
     *
     * @param menu_code 菜单编码
     */
    public void setMenu_code(String menu_code) {
        this.menu_code = menu_code;
    }

    /**
     * 获取父级编号
     *
     * @return parent_code - 父级编号
     */
    public String getParent_code() {
        return parent_code;
    }

    /**
     * 设置父级编号
     *
     * @param parent_code 父级编号
     */
    public void setParent_code(String parent_code) {
        this.parent_code = parent_code;
    }

    /**
     * 获取所有父级编号
     *
     * @return parent_codes - 所有父级编号
     */
    public String getParent_codes() {
        return parent_codes;
    }

    /**
     * 设置所有父级编号
     *
     * @param parent_codes 所有父级编号
     */
    public void setParent_codes(String parent_codes) {
        this.parent_codes = parent_codes;
    }

    /**
     * 获取本级排序号（升序）
     *
     * @return tree_sort - 本级排序号（升序）
     */
    public Long getTree_sort() {
        return tree_sort;
    }

    /**
     * 设置本级排序号（升序）
     *
     * @param tree_sort 本级排序号（升序）
     */
    public void setTree_sort(Long tree_sort) {
        this.tree_sort = tree_sort;
    }

    /**
     * 获取所有级别排序号
     *
     * @return tree_sorts - 所有级别排序号
     */
    public String getTree_sorts() {
        return tree_sorts;
    }

    /**
     * 设置所有级别排序号
     *
     * @param tree_sorts 所有级别排序号
     */
    public void setTree_sorts(String tree_sorts) {
        this.tree_sorts = tree_sorts;
    }

    /**
     * 获取是否最末级
     *
     * @return tree_leaf - 是否最末级
     */
    public String getTree_leaf() {
        return tree_leaf;
    }

    /**
     * 设置是否最末级
     *
     * @param tree_leaf 是否最末级
     */
    public void setTree_leaf(String tree_leaf) {
        this.tree_leaf = tree_leaf;
    }

    /**
     * 获取层次级别
     *
     * @return tree_level - 层次级别
     */
    public Short getTree_level() {
        return tree_level;
    }

    /**
     * 设置层次级别
     *
     * @param tree_level 层次级别
     */
    public void setTree_level(Short tree_level) {
        this.tree_level = tree_level;
    }

    /**
     * 获取全节点名
     *
     * @return tree_names - 全节点名
     */
    public String getTree_names() {
        return tree_names;
    }

    /**
     * 设置全节点名
     *
     * @param tree_names 全节点名
     */
    public void setTree_names(String tree_names) {
        this.tree_names = tree_names;
    }

    /**
     * 获取菜单名称
     *
     * @return menu_name - 菜单名称
     */
    public String getMenu_name() {
        return menu_name;
    }

    /**
     * 设置菜单名称
     *
     * @param menu_name 菜单名称
     */
    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    /**
     * 获取菜单类型（1菜单 2权限 3开发）
     *
     * @return menu_type - 菜单类型（1菜单 2权限 3开发）
     */
    public String getMenu_type() {
        return menu_type;
    }

    /**
     * 设置菜单类型（1菜单 2权限 3开发）
     *
     * @param menu_type 菜单类型（1菜单 2权限 3开发）
     */
    public void setMenu_type(String menu_type) {
        this.menu_type = menu_type;
    }

    /**
     * 获取链接
     *
     * @return menu_href - 链接
     */
    public String getMenu_href() {
        return menu_href;
    }

    /**
     * 设置链接
     *
     * @param menu_href 链接
     */
    public void setMenu_href(String menu_href) {
        this.menu_href = menu_href;
    }

    /**
     * 获取目标
     *
     * @return menu_target - 目标
     */
    public String getMenu_target() {
        return menu_target;
    }

    /**
     * 设置目标
     *
     * @param menu_target 目标
     */
    public void setMenu_target(String menu_target) {
        this.menu_target = menu_target;
    }

    /**
     * 获取图标
     *
     * @return menu_icon - 图标
     */
    public String getMenu_icon() {
        return menu_icon;
    }

    /**
     * 设置图标
     *
     * @param menu_icon 图标
     */
    public void setMenu_icon(String menu_icon) {
        this.menu_icon = menu_icon;
    }

    /**
     * 获取颜色
     *
     * @return menu_color - 颜色
     */
    public String getMenu_color() {
        return menu_color;
    }

    /**
     * 设置颜色
     *
     * @param menu_color 颜色
     */
    public void setMenu_color(String menu_color) {
        this.menu_color = menu_color;
    }

    /**
     * 获取权限标识
     *
     * @return permission - 权限标识
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 设置权限标识
     *
     * @param permission 权限标识
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * 获取菜单权重
     *
     * @return weight - 菜单权重
     */
    public Short getWeight() {
        return weight;
    }

    /**
     * 设置菜单权重
     *
     * @param weight 菜单权重
     */
    public void setWeight(Short weight) {
        this.weight = weight;
    }

    /**
     * 获取是否显示（1显示 0隐藏）
     *
     * @return is_show - 是否显示（1显示 0隐藏）
     */
    public String getIs_show() {
        return is_show;
    }

    /**
     * 设置是否显示（1显示 0隐藏）
     *
     * @param is_show 是否显示（1显示 0隐藏）
     */
    public void setIs_show(String is_show) {
        this.is_show = is_show;
    }

    /**
     * 获取归属系统（default:主导航菜单、mobileApp:APP菜单）
     *
     * @return sys_code - 归属系统（default:主导航菜单、mobileApp:APP菜单）
     */
    public String getSys_code() {
        return sys_code;
    }

    /**
     * 设置归属系统（default:主导航菜单、mobileApp:APP菜单）
     *
     * @param sys_code 归属系统（default:主导航菜单、mobileApp:APP菜单）
     */
    public void setSys_code(String sys_code) {
        this.sys_code = sys_code;
    }

    /**
     * 获取归属模块（多个用逗号隔开）
     *
     * @return module_codes - 归属模块（多个用逗号隔开）
     */
    public String getModule_codes() {
        return module_codes;
    }

    /**
     * 设置归属模块（多个用逗号隔开）
     *
     * @param module_codes 归属模块（多个用逗号隔开）
     */
    public void setModule_codes(String module_codes) {
        this.module_codes = module_codes;
    }

    /**
     * 获取状态（0正常 1删除 2停用）
     *
     * @return status - 状态（0正常 1删除 2停用）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态（0正常 1删除 2停用）
     *
     * @param status 状态（0正常 1删除 2停用）
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreate_by() {
        return create_by;
    }

    /**
     * 设置创建者
     *
     * @param create_by 创建者
     */
    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreate_date() {
        return create_date;
    }

    /**
     * 设置创建时间
     *
     * @param create_date 创建时间
     */
    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    /**
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public String getUpdate_by() {
        return update_by;
    }

    /**
     * 设置更新者
     *
     * @param update_by 更新者
     */
    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    /**
     * 获取更新时间
     *
     * @return update_date - 更新时间
     */
    public Date getUpdate_date() {
        return update_date;
    }

    /**
     * 设置更新时间
     *
     * @param update_date 更新时间
     */
    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    /**
     * 获取备注信息
     *
     * @return remarks - 备注信息
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注信息
     *
     * @param remarks 备注信息
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 获取扩展 String 1
     *
     * @return extend_s1 - 扩展 String 1
     */
    public String getExtend_s1() {
        return extend_s1;
    }

    /**
     * 设置扩展 String 1
     *
     * @param extend_s1 扩展 String 1
     */
    public void setExtend_s1(String extend_s1) {
        this.extend_s1 = extend_s1;
    }

    /**
     * 获取扩展 String 2
     *
     * @return extend_s2 - 扩展 String 2
     */
    public String getExtend_s2() {
        return extend_s2;
    }

    /**
     * 设置扩展 String 2
     *
     * @param extend_s2 扩展 String 2
     */
    public void setExtend_s2(String extend_s2) {
        this.extend_s2 = extend_s2;
    }

    /**
     * 获取扩展 String 3
     *
     * @return extend_s3 - 扩展 String 3
     */
    public String getExtend_s3() {
        return extend_s3;
    }

    /**
     * 设置扩展 String 3
     *
     * @param extend_s3 扩展 String 3
     */
    public void setExtend_s3(String extend_s3) {
        this.extend_s3 = extend_s3;
    }

    /**
     * 获取扩展 String 4
     *
     * @return extend_s4 - 扩展 String 4
     */
    public String getExtend_s4() {
        return extend_s4;
    }

    /**
     * 设置扩展 String 4
     *
     * @param extend_s4 扩展 String 4
     */
    public void setExtend_s4(String extend_s4) {
        this.extend_s4 = extend_s4;
    }

    /**
     * 获取扩展 String 5
     *
     * @return extend_s5 - 扩展 String 5
     */
    public String getExtend_s5() {
        return extend_s5;
    }

    /**
     * 设置扩展 String 5
     *
     * @param extend_s5 扩展 String 5
     */
    public void setExtend_s5(String extend_s5) {
        this.extend_s5 = extend_s5;
    }

    /**
     * 获取扩展 String 6
     *
     * @return extend_s6 - 扩展 String 6
     */
    public String getExtend_s6() {
        return extend_s6;
    }

    /**
     * 设置扩展 String 6
     *
     * @param extend_s6 扩展 String 6
     */
    public void setExtend_s6(String extend_s6) {
        this.extend_s6 = extend_s6;
    }

    /**
     * 获取扩展 String 7
     *
     * @return extend_s7 - 扩展 String 7
     */
    public String getExtend_s7() {
        return extend_s7;
    }

    /**
     * 设置扩展 String 7
     *
     * @param extend_s7 扩展 String 7
     */
    public void setExtend_s7(String extend_s7) {
        this.extend_s7 = extend_s7;
    }

    /**
     * 获取扩展 String 8
     *
     * @return extend_s8 - 扩展 String 8
     */
    public String getExtend_s8() {
        return extend_s8;
    }

    /**
     * 设置扩展 String 8
     *
     * @param extend_s8 扩展 String 8
     */
    public void setExtend_s8(String extend_s8) {
        this.extend_s8 = extend_s8;
    }

    /**
     * 获取扩展 Integer 1
     *
     * @return extend_i1 - 扩展 Integer 1
     */
    public BigDecimal getExtend_i1() {
        return extend_i1;
    }

    /**
     * 设置扩展 Integer 1
     *
     * @param extend_i1 扩展 Integer 1
     */
    public void setExtend_i1(BigDecimal extend_i1) {
        this.extend_i1 = extend_i1;
    }

    /**
     * 获取扩展 Integer 2
     *
     * @return extend_i2 - 扩展 Integer 2
     */
    public BigDecimal getExtend_i2() {
        return extend_i2;
    }

    /**
     * 设置扩展 Integer 2
     *
     * @param extend_i2 扩展 Integer 2
     */
    public void setExtend_i2(BigDecimal extend_i2) {
        this.extend_i2 = extend_i2;
    }

    /**
     * 获取扩展 Integer 3
     *
     * @return extend_i3 - 扩展 Integer 3
     */
    public BigDecimal getExtend_i3() {
        return extend_i3;
    }

    /**
     * 设置扩展 Integer 3
     *
     * @param extend_i3 扩展 Integer 3
     */
    public void setExtend_i3(BigDecimal extend_i3) {
        this.extend_i3 = extend_i3;
    }

    /**
     * 获取扩展 Integer 4
     *
     * @return extend_i4 - 扩展 Integer 4
     */
    public BigDecimal getExtend_i4() {
        return extend_i4;
    }

    /**
     * 设置扩展 Integer 4
     *
     * @param extend_i4 扩展 Integer 4
     */
    public void setExtend_i4(BigDecimal extend_i4) {
        this.extend_i4 = extend_i4;
    }

    /**
     * 获取扩展 Float 1
     *
     * @return extend_f1 - 扩展 Float 1
     */
    public BigDecimal getExtend_f1() {
        return extend_f1;
    }

    /**
     * 设置扩展 Float 1
     *
     * @param extend_f1 扩展 Float 1
     */
    public void setExtend_f1(BigDecimal extend_f1) {
        this.extend_f1 = extend_f1;
    }

    /**
     * 获取扩展 Float 2
     *
     * @return extend_f2 - 扩展 Float 2
     */
    public BigDecimal getExtend_f2() {
        return extend_f2;
    }

    /**
     * 设置扩展 Float 2
     *
     * @param extend_f2 扩展 Float 2
     */
    public void setExtend_f2(BigDecimal extend_f2) {
        this.extend_f2 = extend_f2;
    }

    /**
     * 获取扩展 Float 3
     *
     * @return extend_f3 - 扩展 Float 3
     */
    public BigDecimal getExtend_f3() {
        return extend_f3;
    }

    /**
     * 设置扩展 Float 3
     *
     * @param extend_f3 扩展 Float 3
     */
    public void setExtend_f3(BigDecimal extend_f3) {
        this.extend_f3 = extend_f3;
    }

    /**
     * 获取扩展 Float 4
     *
     * @return extend_f4 - 扩展 Float 4
     */
    public BigDecimal getExtend_f4() {
        return extend_f4;
    }

    /**
     * 设置扩展 Float 4
     *
     * @param extend_f4 扩展 Float 4
     */
    public void setExtend_f4(BigDecimal extend_f4) {
        this.extend_f4 = extend_f4;
    }

    /**
     * 获取扩展 Date 1
     *
     * @return extend_d1 - 扩展 Date 1
     */
    public Date getExtend_d1() {
        return extend_d1;
    }

    /**
     * 设置扩展 Date 1
     *
     * @param extend_d1 扩展 Date 1
     */
    public void setExtend_d1(Date extend_d1) {
        this.extend_d1 = extend_d1;
    }

    /**
     * 获取扩展 Date 2
     *
     * @return extend_d2 - 扩展 Date 2
     */
    public Date getExtend_d2() {
        return extend_d2;
    }

    /**
     * 设置扩展 Date 2
     *
     * @param extend_d2 扩展 Date 2
     */
    public void setExtend_d2(Date extend_d2) {
        this.extend_d2 = extend_d2;
    }

    /**
     * 获取扩展 Date 3
     *
     * @return extend_d3 - 扩展 Date 3
     */
    public Date getExtend_d3() {
        return extend_d3;
    }

    /**
     * 设置扩展 Date 3
     *
     * @param extend_d3 扩展 Date 3
     */
    public void setExtend_d3(Date extend_d3) {
        this.extend_d3 = extend_d3;
    }

    /**
     * 获取扩展 Date 4
     *
     * @return extend_d4 - 扩展 Date 4
     */
    public Date getExtend_d4() {
        return extend_d4;
    }

    /**
     * 设置扩展 Date 4
     *
     * @param extend_d4 扩展 Date 4
     */
    public void setExtend_d4(Date extend_d4) {
        this.extend_d4 = extend_d4;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", menu_code=").append(menu_code);
        sb.append(", parent_code=").append(parent_code);
        sb.append(", parent_codes=").append(parent_codes);
        sb.append(", tree_sort=").append(tree_sort);
        sb.append(", tree_sorts=").append(tree_sorts);
        sb.append(", tree_leaf=").append(tree_leaf);
        sb.append(", tree_level=").append(tree_level);
        sb.append(", tree_names=").append(tree_names);
        sb.append(", menu_name=").append(menu_name);
        sb.append(", menu_type=").append(menu_type);
        sb.append(", menu_href=").append(menu_href);
        sb.append(", menu_target=").append(menu_target);
        sb.append(", menu_icon=").append(menu_icon);
        sb.append(", menu_color=").append(menu_color);
        sb.append(", permission=").append(permission);
        sb.append(", weight=").append(weight);
        sb.append(", is_show=").append(is_show);
        sb.append(", sys_code=").append(sys_code);
        sb.append(", module_codes=").append(module_codes);
        sb.append(", status=").append(status);
        sb.append(", create_by=").append(create_by);
        sb.append(", create_date=").append(create_date);
        sb.append(", update_by=").append(update_by);
        sb.append(", update_date=").append(update_date);
        sb.append(", remarks=").append(remarks);
        sb.append(", extend_s1=").append(extend_s1);
        sb.append(", extend_s2=").append(extend_s2);
        sb.append(", extend_s3=").append(extend_s3);
        sb.append(", extend_s4=").append(extend_s4);
        sb.append(", extend_s5=").append(extend_s5);
        sb.append(", extend_s6=").append(extend_s6);
        sb.append(", extend_s7=").append(extend_s7);
        sb.append(", extend_s8=").append(extend_s8);
        sb.append(", extend_i1=").append(extend_i1);
        sb.append(", extend_i2=").append(extend_i2);
        sb.append(", extend_i3=").append(extend_i3);
        sb.append(", extend_i4=").append(extend_i4);
        sb.append(", extend_f1=").append(extend_f1);
        sb.append(", extend_f2=").append(extend_f2);
        sb.append(", extend_f3=").append(extend_f3);
        sb.append(", extend_f4=").append(extend_f4);
        sb.append(", extend_d1=").append(extend_d1);
        sb.append(", extend_d2=").append(extend_d2);
        sb.append(", extend_d3=").append(extend_d3);
        sb.append(", extend_d4=").append(extend_d4);
        sb.append("]");
        return sb.toString();
    }
}