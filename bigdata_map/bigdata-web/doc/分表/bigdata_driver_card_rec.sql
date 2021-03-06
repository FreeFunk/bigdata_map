CREATE TABLE `bigdata_driver_card_rec20198` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `B_ID` varchar(50) DEFAULT NULL COMMENT '业务主键',
  `COMP_ID` varchar(50) DEFAULT NULL COMMENT '所属运营商',
  `COMP_NAME` varchar(50) DEFAULT NULL COMMENT '运营商名',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CAR_PLATE_NUM` varchar(20) DEFAULT NULL COMMENT '车牌号',
  `CAR_PLATE_COLOR` varchar(10) DEFAULT NULL COMMENT '车牌颜色',
  `DRIVER_NAME` varchar(20) DEFAULT NULL COMMENT '驾驶员姓名',
  `COMPANY` varchar(100) DEFAULT NULL COMMENT '所属企业',
  `LICENCE_NUM` varchar(50) DEFAULT NULL COMMENT '驾驶员资格证号',
  `REC_TYPE` varchar(50) DEFAULT NULL COMMENT '记录类型(插卡/拔卡)',
  `CARD_TIME` datetime DEFAULT NULL COMMENT '插卡/拔卡时间',
  `SYS_RECEIVE_TIME` datetime DEFAULT NULL COMMENT '系统接收时间',
  `QUALIFIED_FLAG` varchar(50) DEFAULT NULL,
  `COUNT_DATE` int(11) NOT NULL,
  `COUNT_MONTH` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`,`COUNT_DATE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
partition by range(COUNT_DATE%100)(
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
     partition p12 values less than (13),
     partition p13 values less than (14),
     partition p14 values less than (15),
     partition p15 values less than (16),
     partition p16 values less than (17),
     partition p17 values less than (18),
     partition p18 values less than (19),
     partition p19 values less than (20),
     partition p20 values less than (21),
     partition p21 values less than (22),
     partition p22 values less than (23),
     partition p23 values less than (24),
     partition p24 values less than (25),
     partition p25 values less than (26),
     partition p26 values less than (27),
     partition p27 values less than (28),
     partition p28 values less than (29),
     partition p29 values less than (30),
     partition p30 values less than (31),
     partition p31 values less than MAXVALUE
   );

CREATE TABLE `bigdata_driver_card_rec20199` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `B_ID` varchar(50) DEFAULT NULL COMMENT '业务主键',
  `COMP_ID` varchar(50) DEFAULT NULL COMMENT '所属运营商',
  `COMP_NAME` varchar(50) DEFAULT NULL COMMENT '运营商名',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CAR_PLATE_NUM` varchar(20) DEFAULT NULL COMMENT '车牌号',
  `CAR_PLATE_COLOR` varchar(10) DEFAULT NULL COMMENT '车牌颜色',
  `DRIVER_NAME` varchar(20) DEFAULT NULL COMMENT '驾驶员姓名',
  `COMPANY` varchar(100) DEFAULT NULL COMMENT '所属企业',
  `LICENCE_NUM` varchar(50) DEFAULT NULL COMMENT '驾驶员资格证号',
  `REC_TYPE` varchar(50) DEFAULT NULL COMMENT '记录类型(插卡/拔卡)',
  `CARD_TIME` datetime DEFAULT NULL COMMENT '插卡/拔卡时间',
  `SYS_RECEIVE_TIME` datetime DEFAULT NULL COMMENT '系统接收时间',
  `QUALIFIED_FLAG` varchar(50) DEFAULT NULL,
  `COUNT_DATE` int(11) NOT NULL,
  `COUNT_MONTH` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`,`COUNT_DATE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
partition by range(COUNT_DATE%100)(
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
     partition p12 values less than (13),
     partition p13 values less than (14),
     partition p14 values less than (15),
     partition p15 values less than (16),
     partition p16 values less than (17),
     partition p17 values less than (18),
     partition p18 values less than (19),
     partition p19 values less than (20),
     partition p20 values less than (21),
     partition p21 values less than (22),
     partition p22 values less than (23),
     partition p23 values less than (24),
     partition p24 values less than (25),
     partition p25 values less than (26),
     partition p26 values less than (27),
     partition p27 values less than (28),
     partition p28 values less than (29),
     partition p29 values less than (30),
     partition p30 values less than (31),
     partition p31 values less than MAXVALUE
   );
CREATE TABLE `bigdata_driver_card_rec201910` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `B_ID` varchar(50) DEFAULT NULL COMMENT '业务主键',
  `COMP_ID` varchar(50) DEFAULT NULL COMMENT '所属运营商',
  `COMP_NAME` varchar(50) DEFAULT NULL COMMENT '运营商名',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CAR_PLATE_NUM` varchar(20) DEFAULT NULL COMMENT '车牌号',
  `CAR_PLATE_COLOR` varchar(10) DEFAULT NULL COMMENT '车牌颜色',
  `DRIVER_NAME` varchar(20) DEFAULT NULL COMMENT '驾驶员姓名',
  `COMPANY` varchar(100) DEFAULT NULL COMMENT '所属企业',
  `LICENCE_NUM` varchar(50) DEFAULT NULL COMMENT '驾驶员资格证号',
  `REC_TYPE` varchar(50) DEFAULT NULL COMMENT '记录类型(插卡/拔卡)',
  `CARD_TIME` datetime DEFAULT NULL COMMENT '插卡/拔卡时间',
  `SYS_RECEIVE_TIME` datetime DEFAULT NULL COMMENT '系统接收时间',
  `QUALIFIED_FLAG` varchar(50) DEFAULT NULL,
  `COUNT_DATE` int(11) NOT NULL,
  `COUNT_MONTH` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`,`COUNT_DATE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
partition by range(COUNT_DATE%100)(
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
     partition p12 values less than (13),
     partition p13 values less than (14),
     partition p14 values less than (15),
     partition p15 values less than (16),
     partition p16 values less than (17),
     partition p17 values less than (18),
     partition p18 values less than (19),
     partition p19 values less than (20),
     partition p20 values less than (21),
     partition p21 values less than (22),
     partition p22 values less than (23),
     partition p23 values less than (24),
     partition p24 values less than (25),
     partition p25 values less than (26),
     partition p26 values less than (27),
     partition p27 values less than (28),
     partition p28 values less than (29),
     partition p29 values less than (30),
     partition p30 values less than (31),
     partition p31 values less than MAXVALUE
   );

CREATE TABLE `bigdata_driver_card_rec201911` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `B_ID` varchar(50) DEFAULT NULL COMMENT '业务主键',
  `COMP_ID` varchar(50) DEFAULT NULL COMMENT '所属运营商',
  `COMP_NAME` varchar(50) DEFAULT NULL COMMENT '运营商名',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CAR_PLATE_NUM` varchar(20) DEFAULT NULL COMMENT '车牌号',
  `CAR_PLATE_COLOR` varchar(10) DEFAULT NULL COMMENT '车牌颜色',
  `DRIVER_NAME` varchar(20) DEFAULT NULL COMMENT '驾驶员姓名',
  `COMPANY` varchar(100) DEFAULT NULL COMMENT '所属企业',
  `LICENCE_NUM` varchar(50) DEFAULT NULL COMMENT '驾驶员资格证号',
  `REC_TYPE` varchar(50) DEFAULT NULL COMMENT '记录类型(插卡/拔卡)',
  `CARD_TIME` datetime DEFAULT NULL COMMENT '插卡/拔卡时间',
  `SYS_RECEIVE_TIME` datetime DEFAULT NULL COMMENT '系统接收时间',
  `QUALIFIED_FLAG` varchar(50) DEFAULT NULL,
  `COUNT_DATE` int(11) NOT NULL,
  `COUNT_MONTH` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`,`COUNT_DATE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
partition by range(COUNT_DATE%100)(
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
     partition p12 values less than (13),
     partition p13 values less than (14),
     partition p14 values less than (15),
     partition p15 values less than (16),
     partition p16 values less than (17),
     partition p17 values less than (18),
     partition p18 values less than (19),
     partition p19 values less than (20),
     partition p20 values less than (21),
     partition p21 values less than (22),
     partition p22 values less than (23),
     partition p23 values less than (24),
     partition p24 values less than (25),
     partition p25 values less than (26),
     partition p26 values less than (27),
     partition p27 values less than (28),
     partition p28 values less than (29),
     partition p29 values less than (30),
     partition p30 values less than (31),
     partition p31 values less than MAXVALUE
   );

CREATE TABLE `bigdata_driver_card_rec201912` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `B_ID` varchar(50) DEFAULT NULL COMMENT '业务主键',
  `COMP_ID` varchar(50) DEFAULT NULL COMMENT '所属运营商',
  `COMP_NAME` varchar(50) DEFAULT NULL COMMENT '运营商名',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CAR_PLATE_NUM` varchar(20) DEFAULT NULL COMMENT '车牌号',
  `CAR_PLATE_COLOR` varchar(10) DEFAULT NULL COMMENT '车牌颜色',
  `DRIVER_NAME` varchar(20) DEFAULT NULL COMMENT '驾驶员姓名',
  `COMPANY` varchar(100) DEFAULT NULL COMMENT '所属企业',
  `LICENCE_NUM` varchar(50) DEFAULT NULL COMMENT '驾驶员资格证号',
  `REC_TYPE` varchar(50) DEFAULT NULL COMMENT '记录类型(插卡/拔卡)',
  `CARD_TIME` datetime DEFAULT NULL COMMENT '插卡/拔卡时间',
  `SYS_RECEIVE_TIME` datetime DEFAULT NULL COMMENT '系统接收时间',
  `QUALIFIED_FLAG` varchar(50) DEFAULT NULL,
  `COUNT_DATE` int(11) NOT NULL,
  `COUNT_MONTH` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`,`COUNT_DATE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
partition by range(COUNT_DATE%100)(
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
     partition p12 values less than (13),
     partition p13 values less than (14),
     partition p14 values less than (15),
     partition p15 values less than (16),
     partition p16 values less than (17),
     partition p17 values less than (18),
     partition p18 values less than (19),
     partition p19 values less than (20),
     partition p20 values less than (21),
     partition p21 values less than (22),
     partition p22 values less than (23),
     partition p23 values less than (24),
     partition p24 values less than (25),
     partition p25 values less than (26),
     partition p26 values less than (27),
     partition p27 values less than (28),
     partition p28 values less than (29),
     partition p29 values less than (30),
     partition p30 values less than (31),
     partition p31 values less than MAXVALUE
   );

CREATE TABLE `bigdata_driver_card_rec20201` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `B_ID` varchar(50) DEFAULT NULL COMMENT '业务主键',
  `COMP_ID` varchar(50) DEFAULT NULL COMMENT '所属运营商',
  `COMP_NAME` varchar(50) DEFAULT NULL COMMENT '运营商名',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CAR_PLATE_NUM` varchar(20) DEFAULT NULL COMMENT '车牌号',
  `CAR_PLATE_COLOR` varchar(10) DEFAULT NULL COMMENT '车牌颜色',
  `DRIVER_NAME` varchar(20) DEFAULT NULL COMMENT '驾驶员姓名',
  `COMPANY` varchar(100) DEFAULT NULL COMMENT '所属企业',
  `LICENCE_NUM` varchar(50) DEFAULT NULL COMMENT '驾驶员资格证号',
  `REC_TYPE` varchar(50) DEFAULT NULL COMMENT '记录类型(插卡/拔卡)',
  `CARD_TIME` datetime DEFAULT NULL COMMENT '插卡/拔卡时间',
  `SYS_RECEIVE_TIME` datetime DEFAULT NULL COMMENT '系统接收时间',
  `QUALIFIED_FLAG` varchar(50) DEFAULT NULL,
  `COUNT_DATE` int(11) NOT NULL,
  `COUNT_MONTH` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`,`COUNT_DATE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
partition by range(COUNT_DATE%100)(
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
     partition p12 values less than (13),
     partition p13 values less than (14),
     partition p14 values less than (15),
     partition p15 values less than (16),
     partition p16 values less than (17),
     partition p17 values less than (18),
     partition p18 values less than (19),
     partition p19 values less than (20),
     partition p20 values less than (21),
     partition p21 values less than (22),
     partition p22 values less than (23),
     partition p23 values less than (24),
     partition p24 values less than (25),
     partition p25 values less than (26),
     partition p26 values less than (27),
     partition p27 values less than (28),
     partition p28 values less than (29),
     partition p29 values less than (30),
     partition p30 values less than (31),
     partition p31 values less than MAXVALUE
   );

CREATE TABLE `bigdata_driver_card_rec20202` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `B_ID` varchar(50) DEFAULT NULL COMMENT '业务主键',
  `COMP_ID` varchar(50) DEFAULT NULL COMMENT '所属运营商',
  `COMP_NAME` varchar(50) DEFAULT NULL COMMENT '运营商名',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CAR_PLATE_NUM` varchar(20) DEFAULT NULL COMMENT '车牌号',
  `CAR_PLATE_COLOR` varchar(10) DEFAULT NULL COMMENT '车牌颜色',
  `DRIVER_NAME` varchar(20) DEFAULT NULL COMMENT '驾驶员姓名',
  `COMPANY` varchar(100) DEFAULT NULL COMMENT '所属企业',
  `LICENCE_NUM` varchar(50) DEFAULT NULL COMMENT '驾驶员资格证号',
  `REC_TYPE` varchar(50) DEFAULT NULL COMMENT '记录类型(插卡/拔卡)',
  `CARD_TIME` datetime DEFAULT NULL COMMENT '插卡/拔卡时间',
  `SYS_RECEIVE_TIME` datetime DEFAULT NULL COMMENT '系统接收时间',
  `QUALIFIED_FLAG` varchar(50) DEFAULT NULL,
  `COUNT_DATE` int(11) NOT NULL,
  `COUNT_MONTH` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`,`COUNT_DATE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
partition by range(COUNT_DATE%100)(
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
     partition p12 values less than (13),
     partition p13 values less than (14),
     partition p14 values less than (15),
     partition p15 values less than (16),
     partition p16 values less than (17),
     partition p17 values less than (18),
     partition p18 values less than (19),
     partition p19 values less than (20),
     partition p20 values less than (21),
     partition p21 values less than (22),
     partition p22 values less than (23),
     partition p23 values less than (24),
     partition p24 values less than (25),
     partition p25 values less than (26),
     partition p26 values less than (27),
     partition p27 values less than (28),
     partition p28 values less than (29),
     partition p29 values less than (30),
     partition p30 values less than (31),
     partition p31 values less than MAXVALUE
   );

CREATE TABLE `bigdata_driver_card_rec20203` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `B_ID` varchar(50) DEFAULT NULL COMMENT '业务主键',
  `COMP_ID` varchar(50) DEFAULT NULL COMMENT '所属运营商',
  `COMP_NAME` varchar(50) DEFAULT NULL COMMENT '运营商名',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CAR_PLATE_NUM` varchar(20) DEFAULT NULL COMMENT '车牌号',
  `CAR_PLATE_COLOR` varchar(10) DEFAULT NULL COMMENT '车牌颜色',
  `DRIVER_NAME` varchar(20) DEFAULT NULL COMMENT '驾驶员姓名',
  `COMPANY` varchar(100) DEFAULT NULL COMMENT '所属企业',
  `LICENCE_NUM` varchar(50) DEFAULT NULL COMMENT '驾驶员资格证号',
  `REC_TYPE` varchar(50) DEFAULT NULL COMMENT '记录类型(插卡/拔卡)',
  `CARD_TIME` datetime DEFAULT NULL COMMENT '插卡/拔卡时间',
  `SYS_RECEIVE_TIME` datetime DEFAULT NULL COMMENT '系统接收时间',
  `QUALIFIED_FLAG` varchar(50) DEFAULT NULL,
  `COUNT_DATE` int(11) NOT NULL,
  `COUNT_MONTH` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`,`COUNT_DATE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
partition by range(COUNT_DATE%100)(
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
     partition p12 values less than (13),
     partition p13 values less than (14),
     partition p14 values less than (15),
     partition p15 values less than (16),
     partition p16 values less than (17),
     partition p17 values less than (18),
     partition p18 values less than (19),
     partition p19 values less than (20),
     partition p20 values less than (21),
     partition p21 values less than (22),
     partition p22 values less than (23),
     partition p23 values less than (24),
     partition p24 values less than (25),
     partition p25 values less than (26),
     partition p26 values less than (27),
     partition p27 values less than (28),
     partition p28 values less than (29),
     partition p29 values less than (30),
     partition p30 values less than (31),
     partition p31 values less than MAXVALUE
   );

CREATE TABLE `bigdata_driver_card_rec20204` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `B_ID` varchar(50) DEFAULT NULL COMMENT '业务主键',
  `COMP_ID` varchar(50) DEFAULT NULL COMMENT '所属运营商',
  `COMP_NAME` varchar(50) DEFAULT NULL COMMENT '运营商名',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CAR_PLATE_NUM` varchar(20) DEFAULT NULL COMMENT '车牌号',
  `CAR_PLATE_COLOR` varchar(10) DEFAULT NULL COMMENT '车牌颜色',
  `DRIVER_NAME` varchar(20) DEFAULT NULL COMMENT '驾驶员姓名',
  `COMPANY` varchar(100) DEFAULT NULL COMMENT '所属企业',
  `LICENCE_NUM` varchar(50) DEFAULT NULL COMMENT '驾驶员资格证号',
  `REC_TYPE` varchar(50) DEFAULT NULL COMMENT '记录类型(插卡/拔卡)',
  `CARD_TIME` datetime DEFAULT NULL COMMENT '插卡/拔卡时间',
  `SYS_RECEIVE_TIME` datetime DEFAULT NULL COMMENT '系统接收时间',
  `QUALIFIED_FLAG` varchar(50) DEFAULT NULL,
  `COUNT_DATE` int(11) NOT NULL,
  `COUNT_MONTH` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`,`COUNT_DATE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
partition by range(COUNT_DATE%100)(
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
     partition p12 values less than (13),
     partition p13 values less than (14),
     partition p14 values less than (15),
     partition p15 values less than (16),
     partition p16 values less than (17),
     partition p17 values less than (18),
     partition p18 values less than (19),
     partition p19 values less than (20),
     partition p20 values less than (21),
     partition p21 values less than (22),
     partition p22 values less than (23),
     partition p23 values less than (24),
     partition p24 values less than (25),
     partition p25 values less than (26),
     partition p26 values less than (27),
     partition p27 values less than (28),
     partition p28 values less than (29),
     partition p29 values less than (30),
     partition p30 values less than (31),
     partition p31 values less than MAXVALUE
   );

CREATE TABLE `bigdata_driver_card_rec20205` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `B_ID` varchar(50) DEFAULT NULL COMMENT '业务主键',
  `COMP_ID` varchar(50) DEFAULT NULL COMMENT '所属运营商',
  `COMP_NAME` varchar(50) DEFAULT NULL COMMENT '运营商名',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CAR_PLATE_NUM` varchar(20) DEFAULT NULL COMMENT '车牌号',
  `CAR_PLATE_COLOR` varchar(10) DEFAULT NULL COMMENT '车牌颜色',
  `DRIVER_NAME` varchar(20) DEFAULT NULL COMMENT '驾驶员姓名',
  `COMPANY` varchar(100) DEFAULT NULL COMMENT '所属企业',
  `LICENCE_NUM` varchar(50) DEFAULT NULL COMMENT '驾驶员资格证号',
  `REC_TYPE` varchar(50) DEFAULT NULL COMMENT '记录类型(插卡/拔卡)',
  `CARD_TIME` datetime DEFAULT NULL COMMENT '插卡/拔卡时间',
  `SYS_RECEIVE_TIME` datetime DEFAULT NULL COMMENT '系统接收时间',
  `QUALIFIED_FLAG` varchar(50) DEFAULT NULL,
  `COUNT_DATE` int(11) NOT NULL,
  `COUNT_MONTH` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`,`COUNT_DATE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
partition by range(COUNT_DATE%100)(
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
     partition p12 values less than (13),
     partition p13 values less than (14),
     partition p14 values less than (15),
     partition p15 values less than (16),
     partition p16 values less than (17),
     partition p17 values less than (18),
     partition p18 values less than (19),
     partition p19 values less than (20),
     partition p20 values less than (21),
     partition p21 values less than (22),
     partition p22 values less than (23),
     partition p23 values less than (24),
     partition p24 values less than (25),
     partition p25 values less than (26),
     partition p26 values less than (27),
     partition p27 values less than (28),
     partition p28 values less than (29),
     partition p29 values less than (30),
     partition p30 values less than (31),
     partition p31 values less than MAXVALUE
   );

CREATE TABLE `bigdata_driver_card_rec20206` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `B_ID` varchar(50) DEFAULT NULL COMMENT '业务主键',
  `COMP_ID` varchar(50) DEFAULT NULL COMMENT '所属运营商',
  `COMP_NAME` varchar(50) DEFAULT NULL COMMENT '运营商名',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CAR_PLATE_NUM` varchar(20) DEFAULT NULL COMMENT '车牌号',
  `CAR_PLATE_COLOR` varchar(10) DEFAULT NULL COMMENT '车牌颜色',
  `DRIVER_NAME` varchar(20) DEFAULT NULL COMMENT '驾驶员姓名',
  `COMPANY` varchar(100) DEFAULT NULL COMMENT '所属企业',
  `LICENCE_NUM` varchar(50) DEFAULT NULL COMMENT '驾驶员资格证号',
  `REC_TYPE` varchar(50) DEFAULT NULL COMMENT '记录类型(插卡/拔卡)',
  `CARD_TIME` datetime DEFAULT NULL COMMENT '插卡/拔卡时间',
  `SYS_RECEIVE_TIME` datetime DEFAULT NULL COMMENT '系统接收时间',
  `QUALIFIED_FLAG` varchar(50) DEFAULT NULL,
  `COUNT_DATE` int(11) NOT NULL,
  `COUNT_MONTH` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`,`COUNT_DATE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
partition by range(COUNT_DATE%100)(
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
     partition p12 values less than (13),
     partition p13 values less than (14),
     partition p14 values less than (15),
     partition p15 values less than (16),
     partition p16 values less than (17),
     partition p17 values less than (18),
     partition p18 values less than (19),
     partition p19 values less than (20),
     partition p20 values less than (21),
     partition p21 values less than (22),
     partition p22 values less than (23),
     partition p23 values less than (24),
     partition p24 values less than (25),
     partition p25 values less than (26),
     partition p26 values less than (27),
     partition p27 values less than (28),
     partition p28 values less than (29),
     partition p29 values less than (30),
     partition p30 values less than (31),
     partition p31 values less than MAXVALUE
   );

CREATE TABLE `bigdata_driver_card_rec20207` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `B_ID` varchar(50) DEFAULT NULL COMMENT '业务主键',
  `COMP_ID` varchar(50) DEFAULT NULL COMMENT '所属运营商',
  `COMP_NAME` varchar(50) DEFAULT NULL COMMENT '运营商名',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CAR_PLATE_NUM` varchar(20) DEFAULT NULL COMMENT '车牌号',
  `CAR_PLATE_COLOR` varchar(10) DEFAULT NULL COMMENT '车牌颜色',
  `DRIVER_NAME` varchar(20) DEFAULT NULL COMMENT '驾驶员姓名',
  `COMPANY` varchar(100) DEFAULT NULL COMMENT '所属企业',
  `LICENCE_NUM` varchar(50) DEFAULT NULL COMMENT '驾驶员资格证号',
  `REC_TYPE` varchar(50) DEFAULT NULL COMMENT '记录类型(插卡/拔卡)',
  `CARD_TIME` datetime DEFAULT NULL COMMENT '插卡/拔卡时间',
  `SYS_RECEIVE_TIME` datetime DEFAULT NULL COMMENT '系统接收时间',
  `QUALIFIED_FLAG` varchar(50) DEFAULT NULL,
  `COUNT_DATE` int(11) NOT NULL,
  `COUNT_MONTH` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`,`COUNT_DATE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
partition by range(COUNT_DATE%100)(
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
     partition p12 values less than (13),
     partition p13 values less than (14),
     partition p14 values less than (15),
     partition p15 values less than (16),
     partition p16 values less than (17),
     partition p17 values less than (18),
     partition p18 values less than (19),
     partition p19 values less than (20),
     partition p20 values less than (21),
     partition p21 values less than (22),
     partition p22 values less than (23),
     partition p23 values less than (24),
     partition p24 values less than (25),
     partition p25 values less than (26),
     partition p26 values less than (27),
     partition p27 values less than (28),
     partition p28 values less than (29),
     partition p29 values less than (30),
     partition p30 values less than (31),
     partition p31 values less than MAXVALUE
   );


