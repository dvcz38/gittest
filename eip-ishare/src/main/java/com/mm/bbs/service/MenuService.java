package com.mm.bbs.service;

import java.util.List;

import com.mm.bbs.pojo.MenuCode;
import com.mm.bbs.vo.TreeDataVo;

public interface MenuService {
	List<MenuCode> finds();
	//主界面封装主接口
	List<TreeDataVo> findTrees();
}
