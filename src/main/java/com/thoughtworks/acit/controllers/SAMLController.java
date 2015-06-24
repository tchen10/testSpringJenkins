package com.thoughtworks.acit.controllers;

import com.okta.saml.util.OktaAuthPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

@Controller
public class SAMLController {

//    private final OktaAuthPeer oktaAuthPeer;
    private final String oktaUrl;
    private final String oktaApiKey;

    @Autowired
    public SAMLController(String oktaUrl, String oktaApiKey) {
//        this.oktaAuthPeer = oktaAuthPeer;
        this.oktaUrl = oktaUrl;
        this.oktaApiKey = oktaApiKey;
    }

    @RequestMapping(value = "/auth/saml/callback", method = RequestMethod.POST)
    public String handleOktaRedirectCallback(HttpServletRequest request, HttpSession session) {
        session.setAttribute("okta.acit.principal.name", "admin-user@test.com");
        session.setAttribute("okta.acit.user.id", "userId");
        session.setAttribute("okta.acit.user.groups", Collections.singletonList("ACIT Admins"));

        return "redirect:/";
    }
}
