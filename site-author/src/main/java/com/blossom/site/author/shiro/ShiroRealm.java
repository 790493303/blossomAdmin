package com.blossom.site.author.shiro;

import com.blossom.site.author.entity.RoleDo;
import com.blossom.site.author.entity.UserDo;
import com.blossom.site.author.service.RoleAuthorService;
import com.blossom.site.author.service.UserRoleService;
import com.blossom.site.author.service.UserService;
import com.blossom.site.base.utils.CollectionUtils;
import com.blossom.site.base.utils.ObjectUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Blossom
 * @Description 认证
 * @time 2017/3/28 15:23
 */
public class ShiroRealm extends AuthorizingRealm{

    @Autowired
    private UserService userServiceImpl;
    @Autowired
    private UserRoleService userRoleServiceImpl;
    @Autowired
    private RoleAuthorService roleAuthorServiceImpl;


    /**
     * @deprecated :授权
     * Retrieves the AuthorizationInfo for the given principals from the underlying data store.  When returning
     * an instance from this method, you might want to consider using an instance of
     * {@link SimpleAuthorizationInfo SimpleAuthorizationInfo}, as it is suitable in most cases.
     *
     * @param principals
     *         the primary identifying principals of the AuthorizationInfo that should be retrieved.
     * @return the AuthorizationInfo associated with this principals.
     * @see SimpleAuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        UserDo userDo = (UserDo) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        JSONObject json = new JSONObject();
        //角色
        json.put("loginAccount",userDo.getLoginAccount());
        json = userRoleServiceImpl.findUserRoleName(json);
        if (json.getInt("status") == 1){
            List<String> roleNames = JSONArray.toList(json.getJSONArray("roleNames"),String.class);
            Set<String> roleNameSet = new HashSet<>();
            roleNameSet.addAll(roleNames);
            roleNames.clear();
            info.setRoles(roleNameSet);
        }
        //权限
        json.put("loginAccount",userDo.getLoginAccount());
        json = userRoleServiceImpl.listEntityInfo(json);
        if (json.getInt("status") == 1){
            JSONArray jsonArray = json.getJSONArray("roles");
            List<RoleDo> roleDos = JSONArray.toList(jsonArray, RoleDo.class);
            if (!CollectionUtils.isEmpty(roleDos)){
                StringBuilder builder = new StringBuilder();
                for(RoleDo role : roleDos){
                    builder.append(role.getRoleId()).append(",");
                }
                json.put("roleIds",builder.toString());
                json = roleAuthorServiceImpl.findUserAuthor(json);
                if (json.getInt("status") == 1){
                    List<String> authorNames = JSONArray.toList(json.getJSONArray("authorNames"),String.class);
                    Set<String> authorNameSet = new HashSet<>();
                    authorNameSet.addAll(authorNames);
                    info.setStringPermissions(authorNameSet);
                }
            }
        }

        return null;
    }

    /**
     * @deprecated :认证
     * Retrieves authentication data from an implementation-specific datasource (RDBMS, LDAP, etc) for the given
     * authentication token.
     * <p/>
     * For most datasources, this means just 'pulling' authentication data for an associated subject/user and nothing
     * more and letting Shiro do the rest.  But in some systems, this method could actually perform EIS specific
     * log-in logic in addition to just retrieving data - it is up to the Realm implementation.
     * <p/>
     * A {@code null} return value means that no account could be associated with the specified token.
     *
     * @param token
     *         the authentication token containing the user's principal and credentials.
     * @return an {@link AuthenticationInfo} object containing account data resulting from the
     * authentication ONLY if the lookup is successful (i.e. account exists and is valid, etc.)
     * @throws AuthenticationException
     *         if there is an error acquiring data or performing
     *         realm-specific authentication logic for the specified <tt>token</tt>
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
       String loginAccount = (String)token.getPrincipal();
       String loginPassword = new String((char[])token.getCredentials());

       //获取用户信息
        JSONObject json = new JSONObject();
        json.put("loginAccount",loginAccount);

        json = userServiceImpl.getEntityInfo(json);

        if (json.getInt("status") != 1){
            throw new UnknownAccountException("出现异常!");
        }

        UserDo userDo = (UserDo)JSONObject.toBean(json.getJSONObject("user"),UserDo.class);
        if (ObjectUtils.isEmpty(userDo)){
            throw new UnknownAccountException("账号错误!");
        }

        if (!loginPassword.equals(userDo.getLoginPassword())){
            throw new IncorrectCredentialsException("密码错误!");
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userDo,loginPassword,getName());


        return info;
    }
}
