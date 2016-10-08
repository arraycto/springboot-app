package com.wangsong.sys.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wangsong.sys.model.Dict;
import com.wangsong.sys.model.User;
import com.wangsong.sys.service.DictServiceI;
import com.wangsong.sys.service.UserServiceI;
import com.wangsong.sys.util.Page;

@Controller
@RequestMapping("/sys/dict")
public class DictController extends BaseController{
	@Autowired
	private DictServiceI dictService;
	
	@RequestMapping(value="/toList")
	public String toList() {
		return "sys/dict/list";
	}
	
	@RequiresPermissions("/sys/dict/list")
	@RequestMapping(value="/list")
	@ResponseBody
	public Object list(HttpServletRequest request,Dict dict) {
		Page page = getPage(request);
		page = dictService.selectAll(page, dict);
		return getEasyUIData(page);
	}

	@RequestMapping(value="/toAdd")
	public String toAdd() {
		return "sys/dict/add";
	}
	
	@RequiresPermissions("/sys/dict/add")
	@RequestMapping(value="/add")
	@ResponseBody
	public Object add(Dict dict) {
		Map<String, Object>	map=new HashMap<>();
		dictService.insert(dict);
		return map;
	}
	
	@RequestMapping(value="/toUpdate")
	public ModelAndView toUpdate(String id) {
		ModelAndView mav= new ModelAndView("sys/dict/update");
		mav.addObject("id", id);
		return mav;
	}

	@RequiresPermissions("/sys/dict/update")
	@RequestMapping(value="/update")
	@ResponseBody
	public Object update(Dict dict) {
		Map<String, Object>	map=new HashMap<>();
		dictService.updateByPrimaryKey(dict);
		return map;
	}
	
	@RequiresPermissions("/sys/dict/delete")
	@RequestMapping(value="/delete")
	@ResponseBody
	public Object delete(String id) {
		Map<String, Object>	map=new HashMap<>();
		dictService.deleteByPrimaryKey(id);
		return map;
	}
	
	@RequestMapping(value="/selectByDict")
	@ResponseBody
	public Object selectByDict(Dict dict) {
		return dictService.selectByDict(dict);
	}
	
	
	@RequestMapping(value="/selectByPrimaryKey")
	@ResponseBody
	public Object selectByPrimaryKey(String id) {
		return dictService.selectByPrimaryKey(id);
	}
	
}
