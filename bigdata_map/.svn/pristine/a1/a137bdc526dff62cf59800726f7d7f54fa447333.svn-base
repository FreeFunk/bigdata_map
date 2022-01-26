package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataDriverCardInfo;
import com.edgedo.bigdata.entity.Emp;
import com.edgedo.bigdata.entity.TransitCarBaseinfo;
import com.edgedo.bigdata.queryvo.BigdataDriverCardInfoQuery;
import com.edgedo.bigdata.queryvo.BigdataDriverCardInfoView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


@Mapper
public interface BigdataDriverCardInfoMapper extends BaseMapper<BigdataDriverCardInfo>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDriverCardInfoView> listPage(BigdataDriverCardInfoQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataDriverCardInfoView> listByObj(BigdataDriverCardInfoQuery query);


    BigdataDriverCardInfo selectByLicenceNum(String licenceNum);

	int countDriverCarRec(Map<String, Object> map);

    Emp selectByLicenceCode(String licenceNum);

    TransitCarBaseinfo selectByCarNumAndCarColor(@Param("carPlateNum") String carPlateNum,@Param("carPlateColor") String carPlateColor);

	void insertEmp(Emp newEmp);
	/**
	 * @Author WangZhen
	 * @Description 根据司机卡 从业资格证号查询司机卡信息
	 * @Date 2020/2/3 17:38
	 **/
	BigdataDriverCardInfo selectDriverInfo(String licenceNum);

    void updateByBigdataDriverCardInfoId(BigdataDriverCardInfo bigdataDriverCardInfo);

    TransitCarBaseinfo selectByCarNum(String carPlateNum);

    List<BigdataDriverCardInfo> selectByCarPlateNumAndColor(Map<String, String> map);


    int countDriverTotalNum();

	List<BigdataDriverCardInfo> listOrderById(Map<String, Object> param);

	List<BigdataDriverCardInfo> listByStartAndEndBySortNum(Map<String, Object> param);

	int selectSortNum();
}