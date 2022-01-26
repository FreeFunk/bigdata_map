package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataDriverCardRec;
import com.edgedo.bigdata.queryvo.BigdataDriverCardRecQuery;
import com.edgedo.bigdata.queryvo.BigdataDriverCardRecView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface BigdataDriverCardRecMapper extends BaseMapper<BigdataDriverCardRec>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDriverCardRecView> listPage(BigdataDriverCardRecQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDriverCardRecView> listByObj(BigdataDriverCardRecQuery query);

	/**
	 * 根据运营商id和业务主键查询司机的插卡把卡记录
	 * @param param
	 * @return
	 */
    int countByCompIdAndBid(Map<String, Object> param);


	int countDriverCardUpNum(Map<String, Object> param2);
	/**
	 * @Author WangZhen
	 * @Description 根据车牌号和车牌颜色 获得司机卡插卡记录
	 * @Date 2020/2/3 17:30
	 **/
    List<BigdataDriverCardRecView> selectDriverCarRecOfChakaOfCar(Map<String, Object> param);
	/**
	 * @Author WangZhen
	 * @Description 根据车牌号和车牌颜色 获得某天的司机卡插卡记录最后一条
	 * @Date 2020/2/3 17:30
	 **/
	BigdataDriverCardRecView selectLastDriverCarRecOfChakaOfCar(Map<String, Object> param);

    int countSumNumByCompId(Map<String, Object> map);
}