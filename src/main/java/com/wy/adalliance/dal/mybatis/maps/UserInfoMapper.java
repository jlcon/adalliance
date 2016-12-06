package com.wy.adalliance.dal.mybatis.maps;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.wy.adalliance.dal.mybatis.model.UserInfo;
import com.wy.adalliance.dal.mybatis.model.UserInfoExample;

public interface UserInfoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	int countByExample(UserInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	int deleteByExample(UserInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	int deleteByPrimaryKey(String userId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	int insert(UserInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	int insertSelective(UserInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	List<UserInfo> selectByExampleWithRowbounds(UserInfoExample example, RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	List<UserInfo> selectByExample(UserInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	UserInfo selectByPrimaryKey(String userId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	int updateByExampleSelective(@Param("record") UserInfo record,
									@Param("example") UserInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	int updateByPrimaryKeySelective(UserInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	int updateByPrimaryKey(UserInfo record);

	List<HashMap<String, Object>> getRolesByUserID(String userid);
}