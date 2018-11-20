package com.mm.bbs.dao;

import java.util.List;

import com.mm.bbs.pojo.MenuCode;
import com.mm.bbs.vo.TreeDataVo;

public interface MenuDao {
	List<MenuCode> finds();
}
