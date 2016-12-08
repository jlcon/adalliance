package com.wy.adalliance.dal.mybatis.maps;

import com.wy.adalliance.dal.mybatis.model.SupermanMovieFileInfo;
import com.wy.adalliance.dal.mybatis.model.SupermanMovieFileInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SupermanMovieFileInfoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	int countByExample(SupermanMovieFileInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	int deleteByExample(SupermanMovieFileInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	int deleteByPrimaryKey(String movieFileId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	int insert(SupermanMovieFileInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	int insertSelective(SupermanMovieFileInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	List<SupermanMovieFileInfo> selectByExampleWithBLOBsWithRowbounds(	SupermanMovieFileInfoExample example,
																		RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	List<SupermanMovieFileInfo> selectByExampleWithBLOBs(SupermanMovieFileInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	List<SupermanMovieFileInfo> selectByExampleWithRowbounds(SupermanMovieFileInfoExample example,
																RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	List<SupermanMovieFileInfo> selectByExample(SupermanMovieFileInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	SupermanMovieFileInfo selectByPrimaryKey(String movieFileId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	int updateByExampleSelective(@Param("record") SupermanMovieFileInfo record,
									@Param("example") SupermanMovieFileInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	int updateByExampleWithBLOBs(@Param("record") SupermanMovieFileInfo record,
									@Param("example") SupermanMovieFileInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	int updateByExample(@Param("record") SupermanMovieFileInfo record,
						@Param("example") SupermanMovieFileInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	int updateByPrimaryKeySelective(SupermanMovieFileInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	int updateByPrimaryKeyWithBLOBs(SupermanMovieFileInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	int updateByPrimaryKey(SupermanMovieFileInfo record);
}