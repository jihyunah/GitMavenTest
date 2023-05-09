package user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import user.bean.UserDTO;

@Controller
@RequestMapping("user")
public class UserController {
	
	
	@GetMapping("writeForm")
	public String writeForm() {
		return "user/writeForm";
	}

	@PostMapping("write")
	@ResponseBody //무조건 jsp를 찾아간다. 그래서 이거를 써야함.
	public void write(@ModelAttribute UserDTO userDTO) {
		
	}
}