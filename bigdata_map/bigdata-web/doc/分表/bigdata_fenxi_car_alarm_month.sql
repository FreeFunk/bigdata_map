
CREATE TABLE `bigdata_fenxi_car_alarm_month2019` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `OWNER_CAR_MONTH_ID` varchar(50) DEFAULT NULL COMMENT '所属车辆月统计ID',
  `ALARM_TYPE` varchar(20) DEFAULT NULL COMMENT '报警类型',
  `ALARM_TYPE_DESC` varchar(30) DEFAULT NULL COMMENT '报警类型描述',
  `ALARM_NUM` int(11) DEFAULT NULL COMMENT '报警数量',
  `ALARM_RATE` decimal(16,3) DEFAULT NULL COMMENT '报警数量/百公里',
  `COUNT_DATE` int(11) DEFAULT NULL COMMENT '统计日期',
  `COUNT_MONTH` int(11) NOT NULL COMMENT '统计月份',
  `YEAR_NUM` int(11) DEFAULT NULL COMMENT '统计年份',
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
CREATE TABLE `bigdata_fenxi_car_alarm_month2020` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `OWNER_CAR_MONTH_ID` varchar(50) DEFAULT NULL COMMENT '所属车辆月统计ID',
  `ALARM_TYPE` varchar(20) DEFAULT NULL COMMENT '报警类型',
  `ALARM_TYPE_DESC` varchar(30) DEFAULT NULL COMMENT '报警类型描述',
  `ALARM_NUM` int(11) DEFAULT NULL COMMENT '报警数量',
  `ALARM_RATE` decimal(16,3) DEFAULT NULL COMMENT '报警数量/百公里',
  `COUNT_DATE` int(11) DEFAULT NULL COMMENT '统计日期',
  `COUNT_MONTH` int(11) NOT NULL COMMENT '统计月份',
  `YEAR_NUM` int(11) DEFAULT NULL COMMENT '统计年份',
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


