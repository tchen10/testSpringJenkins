package com.thoughtworks.acit.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class HomeInterceptor extends HandlerInterceptorAdapter {

    private static final String OKTA_KEY = "okta.acit.user.id";
    private final String oktaRedirect;

    @Autowired
    public HomeInterceptor(String oktaRedirect) {
        super();
        this.oktaRedirect = oktaRedirect;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);

        if(isNull(session)) {
            redirect(response, oktaRedirect);
            return false;
        }

        return true;
    }

    private void redirect(HttpServletResponse response, String location) throws IOException {
        response.sendRedirect(location);
    }

    private boolean isNull(HttpSession session) {
        return session == null || session.getAttribute(OKTA_KEY) == null;
    }
}
