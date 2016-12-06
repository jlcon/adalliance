package com.wy.adalliance.dal.mybatis.maps;

import com.wy.adalliance.dal.mybatis.model.ClAlbumInfo;
import com.wy.adalliance.dal.mybatis.model.ClAlbumInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ClAlbumInfoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cl_album_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	int countByExample(ClAlbumInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cl_album_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	int deleteByExample(ClAlbumInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cl_album_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	int deleteByPrimaryKey(String albumId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cl_album_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	int insert(ClAlbumInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cl_album_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	int insertSelective(ClAlbumInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cl_album_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	List<ClAlbumInfo> selectByExampleWithRowbounds(ClAlbumInfoExample example, RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cl_album_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	List<ClAlbumInfo> selectByExample(ClAlbumInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cl_album_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	ClAlbumInfo selectByPrimaryKey(String albumId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cl_album_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	int updateByExampleSelective(@Param("record") ClAlbumInfo record,
									@Param("example") ClAlbumInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cl_album_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	int updateByExample(@Param("record") ClAlbumInfo record,
						@Param("example") ClAlbumInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cl_album_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	int updateByPrimaryKeySelective(ClAlbumInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cl_album_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	int updateByPrimaryKey(ClAlbumInfo record);
}