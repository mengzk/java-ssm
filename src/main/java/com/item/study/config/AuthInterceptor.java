package com.item.study.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.item.study.model.result.ResultBody;
import com.item.study.modules.exception.CommonError;
import com.item.study.utils.JwtToken;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

/**
 * Author: Meng
 * Date: 2024-12-20
 * Desc: 统一鉴权拦截器
 */
public class AuthInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (token == null) {
            logger.warn("token is null");
            writeResponse(response, 400, CommonError.NOT_LOGIN.getCEMsg());
            return false;
        }
        boolean expire = JwtToken.check(token);
        if (expire) {
            logger.warn("token is expired");
            writeResponse(response, 401, CommonError.UNAUTHORIZED.getCEMsg());
            return false;
        }
        int id = JwtToken.getId(token);
        if (id <= 0) {
            logger.warn("token is invalid");
            writeResponse(response, 402, CommonError.INVALID_TOKEN.getCEMsg());
            return false;
        }
        return true;
    }

    /**
     * 包装返回结果
     */
    private void writeResponse(HttpServletResponse response, int status, String message) throws IOException {
        ResultBody body = ResultBody.fail(status, message);
        response.setStatus(status);
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(body));
    }
}
