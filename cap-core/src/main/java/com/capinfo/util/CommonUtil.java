package com.capinfo.util;


import com.capinfo.base.CurrentUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.util.ThreadContext;


/**
 * @author zhuxiaomeng
 * @date 2017/12/4.
 * @email 154040976@qq.com
 *
 * 管理工具类
 */
public class CommonUtil {

  /**
   * 获取当前用户
   */
  public static CurrentUser getUser() {

      org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
      Session session = subject.getSession();

      return (CurrentUser) session.getAttribute("curentUser");

//      SecurityManager securityManager = null;
//
//      try{
//          securityManager = SecurityUtils.getSecurityManager();
//      }catch (RuntimeException e){
//          SecurityUtils.setSecurityManager(SpringUtil.getBean("securityManager"));
//          org.apache.shiro.mgt.SecurityManager securityManager1 = SpringUtil.getBean("securityManager");
//          ThreadContext.bind(securityManager1);
//      }
//      if(securityManager!=null){
//          System.out.println(SpringUtil.getBean("securityManager").toString());
//
//          System.out.println(ThreadContext.getSecurityManager());
//
//          //ThreadContext.bind();
//          org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
//          Session session = subject.getSession();
//          return (CurrentUser) session.getAttribute("curentUser");
//      }
//      return null;
  }
}