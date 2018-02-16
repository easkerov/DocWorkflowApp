package com.easkerov.docworkflowapp.web;

import com.easkerov.docworkflowapp.util.LoggerUtil;
import org.slf4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ApplicationController {

    private static final Logger logger = LoggerUtil.getLogger(ApplicationController.class);

    /**
     * Log out current user and redirect to index.jsp page
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        LoggerUtil.logActivity(logger,
                "debug",
                "logoutPage",
                request.getMethod(),
                request.getRequestURI(),
                "Logging out " + auth.getName());

        return "redirect:/index.jsp";
    }

}
