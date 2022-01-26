package com.edgedo.drawing.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.drawing.entity.BigdataDriverCountDay;
import com.edgedo.drawing.queryvo.BigdataDriverCountDayQuery;
import com.edgedo.drawing.queryvo.BigdataDriverCountDayView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BigdataDriverCountDayMapper extends BaseMapper<BigdataDriverCountDay>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDriverCountDayView> listPage(BigdataDriverCountDayQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDriverCountDayView> listByObj(BigdataDriverCountDayQuery query);


    void updateByFenPian(BigdataDriverCountDay bigdataDriverCountDay);

	BigdataDriverCountDay selectByVo(BigdataDriverCountDay bigdataDriverCountDay);
	/**
	 * @Author WangZhen
	 * @Description 根据主键和分片字段查询
	 * @Date 2020/2/4 20:43
	 **/
    BigdataDriverCountDay selectByIdAndFenpian(BigdataDriverCountDay driverCountDay);

}