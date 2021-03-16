package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.model.User;
import web.service.RoleService;

@Controller
public class ViewsController {

    private RoleService roleService;
    private UserDao userDao;

    @Autowired
    public ViewsController(RoleService roleService, UserDao userDao) {
        this.roleService = roleService;
        this.userDao = userDao;
    }

    @GetMapping(value = "/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping(value = "/admin")
    public String getAdmin(Model model) {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        User authUser = userDao.getUserByName(a.getName());
        model.addAttribute("authUser", authUser);
        model.addAttribute("listRoles", roleService.listRoles());
        return "admin";
    }

    @GetMapping("/user")
    public String userPage(Model model) {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        User authUser = userDao.getUserByName(a.getName());
        model.addAttribute("authUser", authUser);
        return "user";
    }

}
