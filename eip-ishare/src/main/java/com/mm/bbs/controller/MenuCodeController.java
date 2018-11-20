package com.mm.bbs.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mm.bbs.modelVo.MenuCodeVo;
import com.mm.bbs.pojo.MenuCode;
import com.mm.bbs.pojo.SecCode;
import com.mm.bbs.service.MenuService;
import com.mm.bbs.vo.TreeDataVo;



@Controller
@RequestMapping("/menu")
@SuppressWarnings("all")
public class MenuCodeController {
	@Resource
	private MenuService menuService;

	/**
	 * http://localhost:8081/eip-ishare/menu/find.do
	 * @Title: findMenus
	 * @Description: TODO
	 * @return
	 * @return: BaseDataVo
	 */
	@RequestMapping(value = "/find.do",method = RequestMethod.GET)
	@ResponseBody
	public List<TreeDataVo> findMenus(HttpServletRequest request,Model model){
		List<TreeDataVo> menus = menuService.findTrees();			
		return menus;
	}
}
