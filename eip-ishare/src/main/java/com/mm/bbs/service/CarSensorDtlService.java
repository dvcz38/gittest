package com.mm.bbs.service;

import java.util.List;

import com.mm.bbs.pojo.CarSensorDtl; 

public interface CarSensorDtlService extends BaseService<CarSensorDtl>{

	List<CarSensorDtl> findDeviceOnCurrentDay(String deviceId, String carStatus);

	List<CarSensorDtl> findDeviceBtwDatetime(String deviceId, String carState, String fdate, String todate);

}
