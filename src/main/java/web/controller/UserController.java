package web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @GetMapping("user")
	public String userPage(Model model) {
		Authentication a = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> authorities = a.getAuthorities();
		model.addAttribute("name", a.getName());
		model.addAttribute("roles", authorities);
		return "user";
	}

}