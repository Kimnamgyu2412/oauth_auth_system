package com.oauth.system.oauthapisystem.domain.login;

import com.oauth.system.oauthapisystem.config.auth.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    //final private NewEmailService newEmailService;
    /**
     * 로그인 화면 view controller
     * @param user 로그인 사용자
     * @return
     */
    @RequestMapping("")
    public ModelAndView login(@AuthenticationPrincipal CustomUserDetails user) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("pages/login");
        if (user != null) {
            mav.setViewName("redirect:/main");
        }

        return mav;
    }

    /**
     * 로그인 만료 화면 view controller
     * @return
     */
    @RequestMapping("expired")
    public ModelAndView expired() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("pages/login_expired");

        return mav;
    }


}
