package com.wy.adalliance.dal.thinksns.model;

import java.io.Serializable;

public class TsFeed implements Serializable {

	/**
	 * 动态ID
	 * @mbggenerated
	 */
	private Integer feedId;
	/**
	 * 产生动态的用户UID
	 * @mbggenerated
	 */
	private Integer uid;
	/**
	 * feed类型.由发表feed的程序控制
	 * @mbggenerated
	 */
	private String type;
	/**
	 * feed来源的appname
	 * @mbggenerated
	 */
	private String app;
	/**
	 * 关联资源所在的表
	 * @mbggenerated
	 */
	private String appRowTable;
	/**
	 * 关联的来源ID（如知识的id）
	 * @mbggenerated
	 */
	private Integer appRowId;
	/**
	 * 产生时间戳
	 * @mbggenerated
	 */
	private Integer publishTime;
	/**
	 * 是否删除 默认为0
	 * @mbggenerated
	 */
	private Integer isDel;
	/**
	 * 客户端类型，0：网站；1：手机网页版；2：android；3：iphone
	 * @mbggenerated
	 */
	private Byte from;
	/**
	 * 评论数
	 * @mbggenerated
	 */
	private Integer commentCount;
	/**
	 * 分享数
	 * @mbggenerated
	 */
	private Integer repostCount;
	/**
	 * 全部评论数目
	 * @mbggenerated
	 */
	private Integer commentAllCount;
	/**
	 * @mbggenerated
	 */
	private Integer diggCount;
	/**
	 * 是否转发 0-否  1-是
	 * @mbggenerated
	 */
	private Integer isRepost;
	/**
	 * 是否已审核 0-未审核 1-已审核
	 * @mbggenerated
	 */
	private Integer isAudit;
	/**
	 * 纬度
	 * @mbggenerated
	 */
	private Float latitude;
	/**
	 * 经度
	 * @mbggenerated
	 */
	private Float longitude;
	/**
	 * 发布地址
	 * @mbggenerated
	 */
	private String address;
	/**
	 * @mbggenerated
	 */
	private Byte isRecommend;
	/**
	 * @mbggenerated
	 */
	private Integer recommendTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table ts_feed
	 * @mbggenerated  Thu Jul 21 10:43:12 CST 2016
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 动态ID
	 * @mbggenerated
	 */
	public Integer getFeedId() {
		return feedId;
	}

	/**
	 * 动态ID
	 * @param feedId  动态ID
	 * @mbggenerated
	 */
	public void setFeedId(Integer feedId) {
		this.feedId = feedId;
	}

	/**
	 * 产生动态的用户UID
	 * @mbggenerated
	 */
	public Integer getUid() {
		return uid;
	}

	/**
	 * 产生动态的用户UID
	 * @param uid  产生动态的用户UID
	 * @mbggenerated
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}

	/**
	 * feed类型.由发表feed的程序控制
	 * @mbggenerated
	 */
	public String getType() {
		return type;
	}

	/**
	 * feed类型.由发表feed的程序控制
	 * @param type  feed类型.由发表feed的程序控制
	 * @mbggenerated
	 */
	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	/**
	 * feed来源的appname
	 * @mbggenerated
	 */
	public String getApp() {
		return app;
	}

	/**
	 * feed来源的appname
	 * @param app  feed来源的appname
	 * @mbggenerated
	 */
	public void setApp(String app) {
		this.app = app == null ? null : app.trim();
	}

	/**
	 * 关联资源所在的表
	 * @mbggenerated
	 */
	public String getAppRowTable() {
		return appRowTable;
	}

	/**
	 * 关联资源所在的表
	 * @param appRowTable  关联资源所在的表
	 * @mbggenerated
	 */
	public void setAppRowTable(String appRowTable) {
		this.appRowTable = appRowTable == null ? null : appRowTable.trim();
	}

	/**
	 * 关联的来源ID（如知识的id）
	 * @mbggenerated
	 */
	public Integer getAppRowId() {
		return appRowId;
	}

	/**
	 * 关联的来源ID（如知识的id）
	 * @param appRowId  关联的来源ID（如知识的id）
	 * @mbggenerated
	 */
	public void setAppRowId(Integer appRowId) {
		this.appRowId = appRowId;
	}

	/**
	 * 产生时间戳
	 * @mbggenerated
	 */
	public Integer getPublishTime() {
		return publishTime;
	}

	/**
	 * 产生时间戳
	 * @param publishTime  产生时间戳
	 * @mbggenerated
	 */
	public void setPublishTime(Integer publishTime) {
		this.publishTime = publishTime;
	}

	/**
	 * 是否删除 默认为0
	 * @mbggenerated
	 */
	public Integer getIsDel() {
		return isDel;
	}

	/**
	 * 是否删除 默认为0
	 * @param isDel  是否删除 默认为0
	 * @mbggenerated
	 */
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	/**
	 * 客户端类型，0：网站；1：手机网页版；2：android；3：iphone
	 * @mbggenerated
	 */
	public Byte getFrom() {
		return from;
	}

	/**
	 * 客户端类型，0：网站；1：手机网页版；2：android；3：iphone
	 * @param from  客户端类型，0：网站；1：手机网页版；2：android；3：iphone
	 * @mbggenerated
	 */
	public void setFrom(Byte from) {
		this.from = from;
	}

	/**
	 * 评论数
	 * @mbggenerated
	 */
	public Integer getCommentCount() {
		return commentCount;
	}

	/**
	 * 评论数
	 * @param commentCount  评论数
	 * @mbggenerated
	 */
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	/**
	 * 分享数
	 * @mbggenerated
	 */
	public Integer getRepostCount() {
		return repostCount;
	}

	/**
	 * 分享数
	 * @param repostCount  分享数
	 * @mbggenerated
	 */
	public void setRepostCount(Integer repostCount) {
		this.repostCount = repostCount;
	}

	/**
	 * 全部评论数目
	 * @mbggenerated
	 */
	public Integer getCommentAllCount() {
		return commentAllCount;
	}

	/**
	 * 全部评论数目
	 * @param commentAllCount  全部评论数目
	 * @mbggenerated
	 */
	public void setCommentAllCount(Integer commentAllCount) {
		this.commentAllCount = commentAllCount;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getDiggCount() {
		return diggCount;
	}

	/**
	 * @param diggCount  
	 * @mbggenerated
	 */
	public void setDiggCount(Integer diggCount) {
		this.diggCount = diggCount;
	}

	/**
	 * 是否转发 0-否  1-是
	 * @mbggenerated
	 */
	public Integer getIsRepost() {
		return isRepost;
	}

	/**
	 * 是否转发 0-否  1-是
	 * @param isRepost  是否转发 0-否  1-是
	 * @mbggenerated
	 */
	public void setIsRepost(Integer isRepost) {
		this.isRepost = isRepost;
	}

	/**
	 * 是否已审核 0-未审核 1-已审核
	 * @mbggenerated
	 */
	public Integer getIsAudit() {
		return isAudit;
	}

	/**
	 * 是否已审核 0-未审核 1-已审核
	 * @param isAudit  是否已审核 0-未审核 1-已审核
	 * @mbggenerated
	 */
	public void setIsAudit(Integer isAudit) {
		this.isAudit = isAudit;
	}

	/**
	 * 纬度
	 * @mbggenerated
	 */
	public Float getLatitude() {
		return latitude;
	}

	/**
	 * 纬度
	 * @param latitude  纬度
	 * @mbggenerated
	 */
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	/**
	 * 经度
	 * @mbggenerated
	 */
	public Float getLongitude() {
		return longitude;
	}

	/**
	 * 经度
	 * @param longitude  经度
	 * @mbggenerated
	 */
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	/**
	 * 发布地址
	 * @mbggenerated
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 发布地址
	 * @param address  发布地址
	 * @mbggenerated
	 */
	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIsRecommend() {
		return isRecommend;
	}

	/**
	 * @param isRecommend  
	 * @mbggenerated
	 */
	public void setIsRecommend(Byte isRecommend) {
		this.isRecommend = isRecommend;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getRecommendTime() {
		return recommendTime;
	}

	/**
	 * @param recommendTime  
	 * @mbggenerated
	 */
	public void setRecommendTime(Integer recommendTime) {
		this.recommendTime = recommendTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ts_feed
	 * @mbggenerated  Thu Jul 21 10:43:12 CST 2016
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", feedId=").append(feedId);
		sb.append(", uid=").append(uid);
		sb.append(", type=").append(type);
		sb.append(", app=").append(app);
		sb.append(", appRowTable=").append(appRowTable);
		sb.append(", appRowId=").append(appRowId);
		sb.append(", publishTime=").append(publishTime);
		sb.append(", isDel=").append(isDel);
		sb.append(", from=").append(from);
		sb.append(", commentCount=").append(commentCount);
		sb.append(", repostCount=").append(repostCount);
		sb.append(", commentAllCount=").append(commentAllCount);
		sb.append(", diggCount=").append(diggCount);
		sb.append(", isRepost=").append(isRepost);
		sb.append(", isAudit=").append(isAudit);
		sb.append(", latitude=").append(latitude);
		sb.append(", longitude=").append(longitude);
		sb.append(", address=").append(address);
		sb.append(", isRecommend=").append(isRecommend);
		sb.append(", recommendTime=").append(recommendTime);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}