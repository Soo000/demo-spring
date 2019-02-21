package com.kkwrite.redis.ctrl.login;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/loginctrl")
public class LoginCtrl {
	
	private Logger logger = Logger.getLogger(LoginCtrl.class);

	/**
	 * 登录以及登录失败
	 * @param error
	 * @param model
	 * @return
	 */
	@RequestMapping("/prelogin")
	public String preLogin(@RequestParam(value = "error", required = false) String error, Model model) {
		logger.debug("[ BEGIN ]: LoginCtrl.login()");
		logger.debug("[ END ]: LoginCtrl.login()");
		return "/login/login";
	}
	
	/**
	 * 执行登录
	 * @param username
	 * @param password
	 * @param validCode
	 */
	@RequestMapping("/dologin")
	public void doLogin(String username, String password, String validCode) {
		logger.debug("[ BEGIN ]: LoginCtrl.doLogin()");
		logger.debug("[ END ]: LoginCtrl.doLogin()");
	}
	
	/**
	 * 登录成功
	 * @param username
	 * @param password
	 * @param validCode
	 */
	@RequestMapping("/loginsuccess")
	public String loginSuccess(String username, String password, String validCode) {
		logger.debug("[ BEGIN ]: LoginCtrl.loginSuccess()");
		logger.debug("[ END ]: LoginCtrl.loginSuccess()");
		return "/dashboard/dashboard";
	}
	
}
