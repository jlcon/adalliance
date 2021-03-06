package com.wy.adalliance.dal.mybatis.maps;

import com.wy.adalliance.dal.mybatis.model.SupermanMovie;
import com.wy.adalliance.dal.mybatis.model.SupermanMovieExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SupermanMovieMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	int countByExample(SupermanMovieExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	int deleteByExample(SupermanMovieExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	int deleteByPrimaryKey(String movieId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	int insert(SupermanMovie record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	int insertSelective(SupermanMovie record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	List<SupermanMovie> selectByExampleWithBLOBsWithRowbounds(SupermanMovieExample example,
																RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	List<SupermanMovie> selectByExampleWithBLOBs(SupermanMovieExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	List<SupermanMovie> selectByExampleWithRowbounds(SupermanMovieExample example,
														RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	List<SupermanMovie> selectByExample(SupermanMovieExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	SupermanMovie selectByPrimaryKey(String movieId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	int updateByExampleSelective(@Param("record") SupermanMovie record,
									@Param("example") SupermanMovieExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	int updateByExampleWithBLOBs(@Param("record") SupermanMovie record,
									@Param("example") SupermanMovieExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	int updateByExample(@Param("record") SupermanMovie record,
						@Param("example") SupermanMovieExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	int updateByPrimaryKeySelective(SupermanMovie record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	int updateByPrimaryKeyWithBLOBs(SupermanMovie record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	int updateByPrimaryKey(SupermanMovie record);
}