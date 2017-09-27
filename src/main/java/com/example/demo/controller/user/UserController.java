package com.example.demo.controller.user;

import com.example.demo.entity.user.User;
import com.example.demo.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/tologin.do")
    public ModelAndView tologin() {
        System.out.println("ToLogin");
        return new ModelAndView("log_in");
    }

    @RequestMapping(value = "/dologin.do")
    public String toIndex(User u, HttpServletRequest request, HttpSession session, Model model) {
        System.out.println("USERNAME:" + u.getUserName());
        System.out.println("USERPASS:" + u.getUserPass());
        User user = iUserService.loginUserByNamePass(u);
        System.out.println(user.getUserName());
        session.setAttribute("USER", user);
        ;
        model.addAttribute("USER", user);
        return "edit";
    }

    @RequestMapping(value = "/tologout.do")
    public ModelAndView totologout(HttpServletRequest request, HttpSession session, Model model) {
        session.setAttribute("USER", null);
        model.addAttribute("USER", null);
        session.invalidate();
        return new ModelAndView("log_in");
    }

    //toChangepassword.do
    @RequestMapping(value = "/toChangepassword.do")
    public ModelAndView toChangepassword(HttpServletRequest request, HttpSession session, Model model) {
        System.out.println("walcome to Change_password");
        return new ModelAndView("Change_password");
    }

    @RequestMapping(value = "/dochangepassword.do")
    public String dochangepassword(HttpSession session, String lpassword, String fpassword) {
        User user = (User) session.getAttribute("USER");
        if (user.getUserPass().equals(lpassword)) {
            user.setUserPass(fpassword);
            int bool = iUserService.changePasswordByUserId(user);
            if (bool > 0) {
                return "log_in";
            } else {
                return "error";
            }
        } else {
            return "false";
        }


    }

    @RequestMapping(value = "excuteAddUser.do")
    public String excuteAddUser(User u, HttpServletResponse response) {
        int bool = iUserService.insertUser(u);
        if (bool > 0) {
            return "log_in";
        } else {
            return "error";
        }

    }


}
