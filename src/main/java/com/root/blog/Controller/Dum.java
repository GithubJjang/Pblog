package com.root.blog.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Dum {
	@GetMapping("/Dummy")
	public String dum(Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key1", "string");
		map.put("key2", 10);
		map.put("key3", true);
		
		model.addAttribute("model", map);
		
		return "dumTest";
	}

}
