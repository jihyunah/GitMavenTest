package user.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import user.bean.UserDTO;
import user.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("writeForm")
	public String writeForm() {
		return "user/writeForm";
	}

	@PostMapping("write")
	@ResponseBody //무조건 jsp를 찾아간다. 그래서 이거를 써야함.
	public void write(@ModelAttribute UserDTO userDTO) {
		userService.write(userDTO);
	}
	
	@GetMapping("list")
	public String list() {
		return "user/list";
	}
	
	@PostMapping("getUserList")
	@ResponseBody
	public List<UserDTO> getUserList() {
		return userService.getUserList();
	}
	
	@PostMapping("isExistId")
	@ResponseBody
	public String isExistId(@RequestParam String id) {
		String result = userService.isExistId(id);
		return result;
	}
	
	@PostMapping("search")
	@ResponseBody
	//public List<UserDTO> search(@RequestParam String searchOption, @RequestParam String keyword)
	public List<UserDTO> search(@RequestParam Map<String, String> map){
		List<UserDTO> list = userService.search(map);
		return list;
	}
	
	@GetMapping("updateForm")
	public String updateForm() {
		return "user/updateForm";
	}
	
	@PostMapping("getUser")
	@ResponseBody
	public Optional<UserDTO> getUser(@RequestParam String id) {
		Optional<UserDTO> userDTO = userService.getUser(id);
		return userDTO;
	}
	
	
}
