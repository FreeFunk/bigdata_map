package com.edgedo.drawing.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.drawing.entity.BigdataDriverCarPartitionCountDay;
import com.edgedo.drawing.queryvo.BigdataDriverCarPartitionCountDayQuery;
import com.edgedo.drawing.queryvo.BigdataDriverCarPartitionCountDayView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface BigdataDriverCarPartitionCountDayMapper  extends BaseMapper<BigdataDriverCarPartitionCountDay>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDriverCarPartitionCountDayView> listPage(BigdataDriverCarPartitionCountDayQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDriverCarPartitionCountDayView> listByObj(BigdataDriverCarPartitionCountDayQuery query);

	/**
	 * @Author WangZhen
	 * @Description 根据主键和分片字段来查询
	 * @Date 2020/2/3 21:06
	 **/
    int selectCountByIdAndFenPian(BigdataDriverCarPartitionCountDayView driverCarPartitionCountDay);
	/**
	 * @Author WangZhen
	 * @Description 查询某个司机某一天的分段统计
	 * 汇总某个人的某天的 总里程 总时长，白天 晚上 危险时段
	 * @Date 2020/2/4 20:14
	 **/
	BigdataDriverCarPartitionCountDayView sumDriverPartitionOfDay(Map<String, Object> param);

}