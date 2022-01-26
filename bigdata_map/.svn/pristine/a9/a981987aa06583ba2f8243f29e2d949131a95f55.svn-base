CREATE TABLE `car_day_direction_distribution2019` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `PROVINCE_ID` varchar(50) DEFAULT NULL COMMENT '省ID',
  `PROVINCE_NAME` varchar(20) DEFAULT NULL COMMENT '省名',
  `CITY_ID` varchar(50) DEFAULT NULL COMMENT '城市ID',
  `CITY_NAME` varchar(20) DEFAULT NULL COMMENT '城市名',
  `CAR_TYPE` varchar(10) DEFAULT NULL COMMENT '车辆类型',
  `CAR_NUM` int(11) DEFAULT NULL COMMENT '车辆数',
  `COUNT_TIME` datetime DEFAULT NULL COMMENT '统计时间',
  `AREA_COUNT_TYPE` varchar(20) DEFAULT NULL COMMENT '区域统计级别',
  `YEAR_QUARTER` int(6) DEFAULT NULL COMMENT '季度',
  `COUNT_DATE` int(11) DEFAULT NULL,
  `COUNT_MONTH` int(11) NOT NULL,
  `YEAR_NUM` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`,`COUNT_MONTH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
partition by range(COUNT_MONTH%100)(
      partition p1 values less than (2),
      partition p2 values less than (3),
      partition p3 values less than (4),
      partition p4 values less than (5),
      partition p5 values less than (6),
      partition p6 values less than (7),
      partition p7 values less than (8),
      partition p8 values less than (9),
      partition p9 values less than (10),
      partition p10 values less than (11),
      partition p11 values less than (12),
      partition p12 values less than MAXVALUE
   );


CREATE TABLE `car_day_direction_distribution2020` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `PROVINCE_ID` varchar(50) DEFAULT NULL COMMENT '省ID',
  `PROVINCE_NAME` varchar(20) DEFAULT NULL COMMENT '省名',
  `CITY_ID` varchar(50) DEFAULT NULL COMMENT '城市ID',
  `CITY_NAME` varchar(20) DEFAULT NULL COMMENT '城市名',
  `CAR_TYPE` varchar(10) DEFAULT NULL COMMENT '车辆类型',
  `CAR_NUM` int(11) DEFAULT NULL COMMENT '车辆数',
  `COUNT_TIME` datetime DEFAULT NULL COMMENT '统计时间',
  `AREA_COUNT_TYPE` varchar(20) DEFAULT NULL COMMENT '区域统计级别',
  `YEAR_QUARTER` int(6) DEFAULT NULL COMMENT '季度',
  `COUNT_DATE` int(11) DEFAULT NULL,
  `COUNT_MONTH` int(11) NOT NULL,
  `YEAR_NUM` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`,`COUNT_MONTH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
partition by range(COUNT_MONTH%100)(
      partition p1 values less than (2),
      partition p2 values less than (3),
      partition p3 values less than (4),
      partition p4 values less than (5),
      partition p5 values less than (6),
      partition p6 values less than (7),
      partition p7 values less than (8),
      partition p8 values less than (9),
      partition p9 values less than (10),
      partition p10 values less than (11),
      partition p11 values less than (12),
      partition p12 values less than MAXVALUE
   );

