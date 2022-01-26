CREATE TABLE `oftenrun_route_month_count2019` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `START_PROVINCE_ID` varchar(50) DEFAULT NULL COMMENT '出发省ID',
  `START_PROVINCE_NAME` varchar(20) DEFAULT NULL COMMENT '出发省名',
  `END_PROVINCE_ID` varchar(50) DEFAULT NULL COMMENT '目的省ID',
  `END_PROVINCE_NAME` varchar(20) DEFAULT NULL COMMENT '目的省名',
  `START_CITY_ID` varchar(50) DEFAULT NULL COMMENT '出发城市ID',
  `START_CITY_NAME` varchar(20) DEFAULT NULL COMMENT '出发城市名',
  `END_CITY_ID` varchar(50) DEFAULT NULL COMMENT '目的城市ID',
  `END_CITY_NAME` varchar(20) DEFAULT NULL COMMENT '目的城市名',
  `RUN_ROUTE` varchar(100) DEFAULT NULL COMMENT '路线',
  `RUN_NUM` int(11) DEFAULT NULL COMMENT '次数',
  `SUM_MILEAGE` decimal(16,2) DEFAULT NULL COMMENT '总里程',
  `CAR_TYPE` varchar(10) DEFAULT NULL COMMENT '车辆类型',
  `COUNT_TYPE` varchar(10) DEFAULT NULL COMMENT '统计类型',
  `COUNT_TIME` datetime DEFAULT NULL COMMENT '统计时间',
  `MONTH_STR` varchar(20) DEFAULT NULL COMMENT '月份',
  `COUNT_MONTH` int(11) DEFAULT NULL,
  `QUARTER_TYPE` int(11) NOT NULL COMMENT '季度',
  `YEAR_NUM` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`,`QUARTER_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
partition by range(QUARTER_TYPE%10)(
     partition p1 values less than (2),
     partition p2 values less than (3),
     partition p3 values less than (4),
     partition p4 values less than MAXVALUE
   );

CREATE TABLE `oftenrun_route_month_count2020` (
   `ID` varchar(50) NOT NULL COMMENT '主键',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `START_PROVINCE_ID` varchar(50) DEFAULT NULL COMMENT '出发省ID',
  `START_PROVINCE_NAME` varchar(20) DEFAULT NULL COMMENT '出发省名',
  `END_PROVINCE_ID` varchar(50) DEFAULT NULL COMMENT '目的省ID',
  `END_PROVINCE_NAME` varchar(20) DEFAULT NULL COMMENT '目的省名',
  `START_CITY_ID` varchar(50) DEFAULT NULL COMMENT '出发城市ID',
  `START_CITY_NAME` varchar(20) DEFAULT NULL COMMENT '出发城市名',
  `END_CITY_ID` varchar(50) DEFAULT NULL COMMENT '目的城市ID',
  `END_CITY_NAME` varchar(20) DEFAULT NULL COMMENT '目的城市名',
  `RUN_ROUTE` varchar(100) DEFAULT NULL COMMENT '路线',
  `RUN_NUM` int(11) DEFAULT NULL COMMENT '次数',
  `SUM_MILEAGE` decimal(16,2) DEFAULT NULL COMMENT '总里程',
  `CAR_TYPE` varchar(10) DEFAULT NULL COMMENT '车辆类型',
  `COUNT_TYPE` varchar(10) DEFAULT NULL COMMENT '统计类型',
  `COUNT_TIME` datetime DEFAULT NULL COMMENT '统计时间',
  `MONTH_STR` varchar(20) DEFAULT NULL COMMENT '月份',
  `COUNT_MONTH` int(11) DEFAULT NULL,
  `QUARTER_TYPE` int(11) NOT NULL COMMENT '季度',
  `YEAR_NUM` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`,`QUARTER_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
partition by range(QUARTER_TYPE%10)(
     partition p1 values less than (2),
     partition p2 values less than (3),
     partition p3 values less than (4),
     partition p4 values less than MAXVALUE
   );

