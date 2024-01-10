package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ashokit.entity.Counsellor;
import in.ashokit.service.CounsellerService;

@Controller
public class CounsellorsController {

	@Autowired
	private CounsellerService counsellerSvc;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("counsellor", new Counsellor());
		return "loginView";
	}

	@PostMapping("/login")
	public String handleLogin(Counsellor c, Model model) {
		Counsellor obj = counsellerSvc.loginCheck(c.getEmail(), c.getPwd());

		if (obj == null) {
			model.addAttribute("errMsg", "Invalid Credentials");
			return "loginView";
		}
		return "redirect:dashboard";
	}

	@GetMapping("/dashboard")
	public String buildDashboard(Model model) {
		return "dashboardView";
	}

	@GetMapping("/register")
	public String regPage(Model model) {
		model.addAttribute("counsellor", new Counsellor());
		return "registerView";
	}

	@PostMapping("/register")
	public String handleRegistration(Counsellor c, Model model) {
		String msg = counsellerSvc.saveConsellor(c);
		model.addAttribute("msg", msg);
		return "registerView";
	}

	@GetMapping("/forget-pwd")
	private String recoverPwdPage(Model model) {
		return "forgetPwdView";
	}

	@GetMapping("/recover-pwd")
	public String recoverPwd(@RequestParam String email, Model model) {
		boolean status = counsellerSvc.recoverPwd(email);

		if (status) {
			model.addAttribute("smsg", "pwd sent to your email");
		} else {
			model.addAttribute("errmsg", "Invalid Email");
		}

		return "forgetPwdView";
	}

}
