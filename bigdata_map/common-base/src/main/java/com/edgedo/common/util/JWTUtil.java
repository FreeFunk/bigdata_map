package com.edgedo.common.util;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Clock;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.edgedo.common.base.BusinessException;
import com.edgedo.common.shiro.JwtRsaSecKey;
import com.edgedo.common.shiro.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class JWTUtil {

    // 过期时间1天
    private static final long EXPIRE_TIME = 24*60*60*1000;

    /**
     * 校验token是否正确
     * @param token 密钥
     * @param secret 用户的密码
     * @return 是否正确
     */
    public static boolean verify(String token, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            Clock clock = new Clock() {
                @Override
                public Date getToday() {
                    return new Date();
                }
            };
            JWTVerifier.BaseVerification verification = (JWTVerifier.BaseVerification) JWT.require(algorithm);
            JWTVerifier verifier = verification.build(clock);
            verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public static boolean verify(HttpServletRequest request) throws Exception {
        JwtRsaSecKey secKey = IocUtil.getBean(JwtRsaSecKey.class);
        String token = request.getHeader("access-token");
        //验证token是否失效或者合法
        return  verify(token,secKey.getJwtSecretkey());

    }

    /**
     * 获得token中的信息无需secret解密也能获得
     * @return token中包含的用户名
     */
    public static String getUserInfo(String token) {
        try {

            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userinfo").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 生成签名,指定时间后过期,一经生成不可修改，令牌在指定时间内一直有效
     * @param userInfo 用户编号
     * @param secret 用户的密码
     * @return 加密的token
     */
    public static String sign(String userInfo, String secret) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(secret);
        // 附带username信息
        return JWT.create()
                .withClaim("userinfo", userInfo)
                .withExpiresAt(date)
                .sign(algorithm);
    }

    /**
     * 获得token中的用户
     * @param request
     * @return
     */
    public static User getTokenUser(HttpServletRequest request) throws BusinessException {
        try {
            JwtRsaSecKey secKey = IocUtil.getBean(JwtRsaSecKey.class);
            String token = request.getHeader("access-token");
            //验证token是否失效或者合法
            boolean passFlag = verify(token, secKey.getJwtSecretkey());
            if (!passFlag) {
                return null;
            }
            DecodedJWT jwt = JWT.decode(token);
            String userInfo = jwt.getClaim("userinfo").asString();
            String userJson = RSAUtil.decode(userInfo, secKey);
            User userObj = JSON.parseObject(userJson, User.class);
            return userObj;
        }catch (Exception e){
            throw new BusinessException("获取用户信息失败");
        }
    }




}
