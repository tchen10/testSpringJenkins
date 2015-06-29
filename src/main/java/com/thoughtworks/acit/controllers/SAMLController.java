package com.thoughtworks.acit.controllers;

import com.okta.saml.SAMLResponse;
import com.okta.saml.util.OktaAuthPeer;
import org.opensaml.ws.security.SecurityPolicyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Arrays;
import java.util.Collections;

@Controller
public class SAMLController {

    private final OktaAuthPeer oktaAuthPeer;
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final String oktaUrl;
    private final String oktaApiKey;

    @Autowired
    public SAMLController(OktaAuthPeer oktaAuthPeer, String oktaUrl, String oktaApiKey) {
        this.oktaAuthPeer = oktaAuthPeer;
        this.oktaUrl = oktaUrl;
        this.oktaApiKey = oktaApiKey;
    }

    @RequestMapping(value = "/auth/saml/callback", method = RequestMethod.POST)
    public String handleOktaRedirectCallback(HttpServletRequest request, HttpSession session) {
        try {
            String sAMLResponseString = request.getParameter("SAMLResponse");
            SAMLResponse sAMLResponse = oktaAuthPeer.getSAMLResponse(sAMLResponseString);
            Principal principal = oktaAuthPeer.getUserPrincipal(sAMLResponse);
            oktaAuthPeer.putPrincipalInSessionContext(request, principal);

            String userId = sAMLResponse.getAttributes().get("userId").get(0);

            session.setAttribute("okta.acit.principal.name", principal.getName());
            session.setAttribute("okta.acit.user.id", userId);

            return "redirect:/";
        } catch (UnsupportedEncodingException | SecurityPolicyException e) {
            logger.warn(e + " at: " + e.getStackTrace()[0]);
            return "redirect:/sorry";
        }
    }
}
