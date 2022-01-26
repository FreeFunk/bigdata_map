CREATE TABLE `bigdata_push_learn_rec2019`  (
  `ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `CREATE_TIME` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `EMP_ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '从业人员ID',
  `ALARM_TYPE` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '违章类型',
  `LESSION_ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '课件ID',
  `LESSON_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '课件名称',
  `STUDY_STATE` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '学习状态',
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


CREATE TABLE `bigdata_push_learn_rec2020`  (
  `ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `CREATE_TIME` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `EMP_ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '从业人员ID',
  `ALARM_TYPE` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '违章类型',
  `LESSION_ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '课件ID',
  `LESSON_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '课件名称',
  `STUDY_STATE` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '学习状态',
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

