package com.wy.adalliance.dal.mybatis.maps;

import com.wy.adalliance.dal.mybatis.model.ClGuideInfo;
import com.wy.adalliance.dal.mybatis.model.ClGuideInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ClGuideInfoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cl_guide_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	int countByExample(ClGuideInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cl_guide_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	int deleteByExample(ClGuideInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cl_guide_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	int deleteByPrimaryKey(String guideId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cl_guide_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	int insert(ClGuideInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cl_guide_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	int insertSelective(ClGuideInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cl_guide_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	List<ClGuideInfo> selectByExampleWithRowbounds(ClGuideInfoExample example, RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cl_guide_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	List<ClGuideInfo> selectByExample(ClGuideInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cl_guide_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	ClGuideInfo selectByPrimaryKey(String guideId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cl_guide_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	int updateByExampleSelective(@Param("record") ClGuideInfo record,
									@Param("example") ClGuideInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cl_guide_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	int updateByExample(@Param("record") ClGuideInfo record,
						@Param("example") ClGuideInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cl_guide_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	int updateByPrimaryKeySelective(ClGuideInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cl_guide_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	int updateByPrimaryKey(ClGuideInfo record);
}