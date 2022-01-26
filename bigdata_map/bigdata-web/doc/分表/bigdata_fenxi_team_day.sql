
CREATE TABLE `bigdata_fenxi_team_day2019` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `PROVINCE_ID` varchar(50) DEFAULT NULL COMMENT '省ID',
  `PROVINCE_NAME` varchar(16) DEFAULT NULL COMMENT '省名',
  `CITY_ID` varchar(50) DEFAULT NULL COMMENT '城市ID',
  `CITY_NAME` varchar(16) DEFAULT NULL COMMENT '城市名',
  `XIANQU_ID` varchar(50) DEFAULT NULL COMMENT '县区ID',
  `XIANQU_NAME` varchar(16) DEFAULT NULL COMMENT '县区名',
  `TEAM_NAME` varchar(50) DEFAULT NULL COMMENT '企业名',
  `TEAM_TYPE` varchar(20) DEFAULT NULL COMMENT '企业类型',
  `TRANSIT_TYPE` varchar(20) DEFAULT NULL COMMENT '运输类型',
  `COUNT_CAR_NUM` int(11) DEFAULT NULL COMMENT '统计车辆数',
  `RUN_MILEAGE` decimal(16,2) DEFAULT NULL COMMENT '行驶里程',
  `RUN_TIME_LENGTH` int(11) DEFAULT NULL COMMENT '行驶时长（秒）',
  `RUN_TIME_LENGTH_TEXT` varchar(30) DEFAULT NULL COMMENT '行驶时长文本',
  `RUN_TIME_LENGTH_HOUR` decimal(16,2) DEFAULT NULL COMMENT '行驶时长(小时）',
  `ALARM_NUM` int(11) DEFAULT NULL COMMENT '报警数量',
  `ALARM_RATE` decimal(16,3) DEFAULT NULL COMMENT '报警数量/百公里',
  `SAFE_SCORE` decimal(16,2) DEFAULT NULL COMMENT '安全评分',
  `AVERAGE_SPEED` decimal(16,2) DEFAULT NULL COMMENT '平均速度',
  `AVERAGE_RUN_MILEAGE` decimal(16,2) DEFAULT NULL COMMENT '平均行驶里程',
  `AVERAGE_RUN_TIME_LENGTH` decimal(16,2) DEFAULT NULL COMMENT '平均行驶时长（小时）',
  `AVERAGE_ALARM_NUM` decimal(16,2) DEFAULT NULL COMMENT '平均报警数量',
  `RUN_MILEAGE_TOP_THREE` varchar(200) DEFAULT NULL COMMENT '行驶里程前三',
  `ALARM_NUM_TOP_THREE` varchar(200) DEFAULT NULL COMMENT '报警数量前三',
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


CREATE TABLE `bigdata_fenxi_team_day2020` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `PROVINCE_ID` varchar(50) DEFAULT NULL COMMENT '省ID',
  `PROVINCE_NAME` varchar(16) DEFAULT NULL COMMENT '省名',
  `CITY_ID` varchar(50) DEFAULT NULL COMMENT '城市ID',
  `CITY_NAME` varchar(16) DEFAULT NULL COMMENT '城市名',
  `XIANQU_ID` varchar(50) DEFAULT NULL COMMENT '县区ID',
  `XIANQU_NAME` varchar(16) DEFAULT NULL COMMENT '县区名',
  `TEAM_NAME` varchar(50) DEFAULT NULL COMMENT '企业名',
  `TEAM_TYPE` varchar(20) DEFAULT NULL COMMENT '企业类型',
  `TRANSIT_TYPE` varchar(20) DEFAULT NULL COMMENT '运输类型',
  `COUNT_CAR_NUM` int(11) DEFAULT NULL COMMENT '统计车辆数',
  `RUN_MILEAGE` decimal(16,2) DEFAULT NULL COMMENT '行驶里程',
  `RUN_TIME_LENGTH` int(11) DEFAULT NULL COMMENT '行驶时长（秒）',
  `RUN_TIME_LENGTH_TEXT` varchar(30) DEFAULT NULL COMMENT '行驶时长文本',
  `RUN_TIME_LENGTH_HOUR` decimal(16,2) DEFAULT NULL COMMENT '行驶时长(小时）',
  `ALARM_NUM` int(11) DEFAULT NULL COMMENT '报警数量',
  `ALARM_RATE` decimal(16,3) DEFAULT NULL COMMENT '报警数量/百公里',
  `SAFE_SCORE` decimal(16,2) DEFAULT NULL COMMENT '安全评分',
  `AVERAGE_SPEED` decimal(16,2) DEFAULT NULL COMMENT '平均速度',
  `AVERAGE_RUN_MILEAGE` decimal(16,2) DEFAULT NULL COMMENT '平均行驶里程',
  `AVERAGE_RUN_TIME_LENGTH` decimal(16,2) DEFAULT NULL COMMENT '平均行驶时长（小时）',
  `AVERAGE_ALARM_NUM` decimal(16,2) DEFAULT NULL COMMENT '平均报警数量',
  `RUN_MILEAGE_TOP_THREE` varchar(200) DEFAULT NULL COMMENT '行驶里程前三',
  `ALARM_NUM_TOP_THREE` varchar(200) DEFAULT NULL COMMENT '报警数量前三',
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