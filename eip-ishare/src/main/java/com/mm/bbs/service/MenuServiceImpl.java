package com.mm.bbs.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mm.bbs.dao.MenuDao;
import com.mm.bbs.pojo.MenuCode;
import com.mm.bbs.pojo.SecCode;
import com.mm.bbs.vo.TreeDataVo;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
	
	@Resource
	private MenuDao menuDao;

	@Override
	public List<MenuCode> finds() {
		// TODO Auto-generated method stub
		return menuDao.finds();
	}

	@Override
	public List<TreeDataVo> findTrees() {
		// TODO Auto-generated method stub
		
		List<MenuCode> menus = menuDao.finds();
		List<TreeDataVo> trees = new ArrayList<TreeDataVo>();
		if(menus != null){
			for(MenuCode menu : menus){
				System.out.print("菜单:"+menu.getMenuCode()+"-拥有的子菜单:");
				TreeDataVo treeDataVo = new TreeDataVo();
				treeDataVo.setMenuId(menu.getMenuId());
				treeDataVo.setMenuCode(menu.getMenuCode());
				treeDataVo.setIconClass(menu.getIconClass());
				treeDataVo.setMenuState(menu.getMenuState());
				List<SecCode> secList = new ArrayList<SecCode>();
				//二级
				for (SecCode sec : menu.getSecCodes()) {
					SecCode secCode = new SecCode();
					secCode.setSecId(sec.getSecId());
					secCode.setSecCode(sec.getSecCode());
					secCode.setSecIcon(sec.getSecIcon());
					secCode.setMenu(sec.getMenu());
					secCode.setUrl(sec.getUrl());
					secList.add(secCode);
				}
				treeDataVo.setSecCodes(secList);
				trees.add(treeDataVo);
			}
		}

		return trees;
	}

}
