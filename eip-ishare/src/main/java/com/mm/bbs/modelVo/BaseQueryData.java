package com.mm.bbs.modelVo;

import java.util.List;

/**
 *  构建返回信息处理类
 * @ClassName: BaseQueryData
 * @Description: TODO
 * @author: lenovo
 * @date: 2018年2月6日 下午3:02:53
 */
public class BaseQueryData {
	private String msg;
	private List data;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "BaseQueryData [msg=" + msg + ", data=" + data + "]";
	}
	
}
