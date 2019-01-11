package com.mm.bbs.dao;

import java.util.List;

import com.mm.bbs.pojo.CarSensorDtl; 

public interface CarSensorDtlDao extends BaseDao<CarSensorDtl, String> {

	List<CarSensorDtl> findDeviceByParams(Integer i, String deviceId, String carStatus);

	List<CarSensorDtl> findDeviceBtwDatetime(String deviceId, String carStatus, String fdate, String todate);

}
