package com.capinfo.core.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;

import java.util.Collection;

public class CustomeModularRealmAuthenticator extends ModularRealmAuthenticator {


    @Override
    protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken)
            throws AuthenticationException {

        assertRealmsConfigured();

        Collection<Realm> realms = getRealms();

        AuthenticationInfo authenticationInfo = null;

        for (Realm realm : realms) {
            System.out.println(realm.getName());
            System.out.println(authenticationToken.getClass());
            if (realm.supports(authenticationToken)) {
                authenticationInfo = doSingleRealmAuthentication(realm, authenticationToken);
                break;
            }
        }
        return authenticationInfo;
    }
}
