package com.wy.adalliance.dal.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SupermanMovieFileInfoExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	public SupermanMovieFileInfoExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;
		
		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}
		
		public boolean isValid() {
			return criteria.size() > 0;
		}
		
		public List<Criterion> getAllCriteria() {
			return criteria;
		}
		
		public List<Criterion> getCriteria() {
			return criteria;
		}
		
		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}
		
		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}
		
		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}
		
		public Criteria andMovieFileIdIsNull() {
			addCriterion("movie_file_id is null");
			return (Criteria) this;
		}
		
		public Criteria andMovieFileIdIsNotNull() {
			addCriterion("movie_file_id is not null");
			return (Criteria) this;
		}
		
		public Criteria andMovieFileIdEqualTo(String value) {
			addCriterion("movie_file_id =", value, "movieFileId");
			return (Criteria) this;
		}
		
		public Criteria andMovieFileIdNotEqualTo(String value) {
			addCriterion("movie_file_id <>", value, "movieFileId");
			return (Criteria) this;
		}
		
		public Criteria andMovieFileIdGreaterThan(String value) {
			addCriterion("movie_file_id >", value, "movieFileId");
			return (Criteria) this;
		}
		
		public Criteria andMovieFileIdGreaterThanOrEqualTo(String value) {
			addCriterion("movie_file_id >=", value, "movieFileId");
			return (Criteria) this;
		}
		
		public Criteria andMovieFileIdLessThan(String value) {
			addCriterion("movie_file_id <", value, "movieFileId");
			return (Criteria) this;
		}
		
		public Criteria andMovieFileIdLessThanOrEqualTo(String value) {
			addCriterion("movie_file_id <=", value, "movieFileId");
			return (Criteria) this;
		}
		
		public Criteria andMovieFileIdLike(String value) {
			addCriterion("movie_file_id like", value, "movieFileId");
			return (Criteria) this;
		}
		
		public Criteria andMovieFileIdNotLike(String value) {
			addCriterion("movie_file_id not like", value, "movieFileId");
			return (Criteria) this;
		}
		
		public Criteria andMovieFileIdIn(List<String> values) {
			addCriterion("movie_file_id in", values, "movieFileId");
			return (Criteria) this;
		}
		
		public Criteria andMovieFileIdNotIn(List<String> values) {
			addCriterion("movie_file_id not in", values, "movieFileId");
			return (Criteria) this;
		}
		
		public Criteria andMovieFileIdBetween(String value1, String value2) {
			addCriterion("movie_file_id between", value1, value2, "movieFileId");
			return (Criteria) this;
		}
		
		public Criteria andMovieFileIdNotBetween(String value1, String value2) {
			addCriterion("movie_file_id not between", value1, value2, "movieFileId");
			return (Criteria) this;
		}
		
		public Criteria andMovieIdIsNull() {
			addCriterion("movie_id is null");
			return (Criteria) this;
		}
		
		public Criteria andMovieIdIsNotNull() {
			addCriterion("movie_id is not null");
			return (Criteria) this;
		}
		
		public Criteria andMovieIdEqualTo(String value) {
			addCriterion("movie_id =", value, "movieId");
			return (Criteria) this;
		}
		
		public Criteria andMovieIdNotEqualTo(String value) {
			addCriterion("movie_id <>", value, "movieId");
			return (Criteria) this;
		}
		
		public Criteria andMovieIdGreaterThan(String value) {
			addCriterion("movie_id >", value, "movieId");
			return (Criteria) this;
		}
		
		public Criteria andMovieIdGreaterThanOrEqualTo(String value) {
			addCriterion("movie_id >=", value, "movieId");
			return (Criteria) this;
		}
		
		public Criteria andMovieIdLessThan(String value) {
			addCriterion("movie_id <", value, "movieId");
			return (Criteria) this;
		}
		
		public Criteria andMovieIdLessThanOrEqualTo(String value) {
			addCriterion("movie_id <=", value, "movieId");
			return (Criteria) this;
		}
		
		public Criteria andMovieIdLike(String value) {
			addCriterion("movie_id like", value, "movieId");
			return (Criteria) this;
		}
		
		public Criteria andMovieIdNotLike(String value) {
			addCriterion("movie_id not like", value, "movieId");
			return (Criteria) this;
		}
		
		public Criteria andMovieIdIn(List<String> values) {
			addCriterion("movie_id in", values, "movieId");
			return (Criteria) this;
		}
		
		public Criteria andMovieIdNotIn(List<String> values) {
			addCriterion("movie_id not in", values, "movieId");
			return (Criteria) this;
		}
		
		public Criteria andMovieIdBetween(String value1, String value2) {
			addCriterion("movie_id between", value1, value2, "movieId");
			return (Criteria) this;
		}
		
		public Criteria andMovieIdNotBetween(String value1, String value2) {
			addCriterion("movie_id not between", value1, value2, "movieId");
			return (Criteria) this;
		}
		
		public Criteria andMovieFileNameIsNull() {
			addCriterion("movie_file_name is null");
			return (Criteria) this;
		}
		
		public Criteria andMovieFileNameIsNotNull() {
			addCriterion("movie_file_name is not null");
			return (Criteria) this;
		}
		
		public Criteria andMovieFileNameEqualTo(String value) {
			addCriterion("movie_file_name =", value, "movieFileName");
			return (Criteria) this;
		}
		
		public Criteria andMovieFileNameNotEqualTo(String value) {
			addCriterion("movie_file_name <>", value, "movieFileName");
			return (Criteria) this;
		}
		
		public Criteria andMovieFileNameGreaterThan(String value) {
			addCriterion("movie_file_name >", value, "movieFileName");
			return (Criteria) this;
		}
		
		public Criteria andMovieFileNameGreaterThanOrEqualTo(String value) {
			addCriterion("movie_file_name >=", value, "movieFileName");
			return (Criteria) this;
		}
		
		public Criteria andMovieFileNameLessThan(String value) {
			addCriterion("movie_file_name <", value, "movieFileName");
			return (Criteria) this;
		}
		
		public Criteria andMovieFileNameLessThanOrEqualTo(String value) {
			addCriterion("movie_file_name <=", value, "movieFileName");
			return (Criteria) this;
		}
		
		public Criteria andMovieFileNameLike(String value) {
			addCriterion("movie_file_name like", value, "movieFileName");
			return (Criteria) this;
		}
		
		public Criteria andMovieFileNameNotLike(String value) {
			addCriterion("movie_file_name not like", value, "movieFileName");
			return (Criteria) this;
		}
		
		public Criteria andMovieFileNameIn(List<String> values) {
			addCriterion("movie_file_name in", values, "movieFileName");
			return (Criteria) this;
		}
		
		public Criteria andMovieFileNameNotIn(List<String> values) {
			addCriterion("movie_file_name not in", values, "movieFileName");
			return (Criteria) this;
		}
		
		public Criteria andMovieFileNameBetween(String value1, String value2) {
			addCriterion("movie_file_name between", value1, value2, "movieFileName");
			return (Criteria) this;
		}
		
		public Criteria andMovieFileNameNotBetween(String value1, String value2) {
			addCriterion("movie_file_name not between", value1, value2, "movieFileName");
			return (Criteria) this;
		}
		
		public Criteria andMovieFilePicPathIsNull() {
			addCriterion("movie_file_pic_path is null");
			return (Criteria) this;
		}
		
		public Criteria andMovieFilePicPathIsNotNull() {
			addCriterion("movie_file_pic_path is not null");
			return (Criteria) this;
		}
		
		public Criteria andMovieFilePicPathEqualTo(String value) {
			addCriterion("movie_file_pic_path =", value, "movieFilePicPath");
			return (Criteria) this;
		}
		
		public Criteria andMovieFilePicPathNotEqualTo(String value) {
			addCriterion("movie_file_pic_path <>", value, "movieFilePicPath");
			return (Criteria) this;
		}
		
		public Criteria andMovieFilePicPathGreaterThan(String value) {
			addCriterion("movie_file_pic_path >", value, "movieFilePicPath");
			return (Criteria) this;
		}
		
		public Criteria andMovieFilePicPathGreaterThanOrEqualTo(String value) {
			addCriterion("movie_file_pic_path >=", value, "movieFilePicPath");
			return (Criteria) this;
		}
		
		public Criteria andMovieFilePicPathLessThan(String value) {
			addCriterion("movie_file_pic_path <", value, "movieFilePicPath");
			return (Criteria) this;
		}
		
		public Criteria andMovieFilePicPathLessThanOrEqualTo(String value) {
			addCriterion("movie_file_pic_path <=", value, "movieFilePicPath");
			return (Criteria) this;
		}
		
		public Criteria andMovieFilePicPathLike(String value) {
			addCriterion("movie_file_pic_path like", value, "movieFilePicPath");
			return (Criteria) this;
		}
		
		public Criteria andMovieFilePicPathNotLike(String value) {
			addCriterion("movie_file_pic_path not like", value, "movieFilePicPath");
			return (Criteria) this;
		}
		
		public Criteria andMovieFilePicPathIn(List<String> values) {
			addCriterion("movie_file_pic_path in", values, "movieFilePicPath");
			return (Criteria) this;
		}
		
		public Criteria andMovieFilePicPathNotIn(List<String> values) {
			addCriterion("movie_file_pic_path not in", values, "movieFilePicPath");
			return (Criteria) this;
		}
		
		public Criteria andMovieFilePicPathBetween(String value1, String value2) {
			addCriterion("movie_file_pic_path between", value1, value2, "movieFilePicPath");
			return (Criteria) this;
		}
		
		public Criteria andMovieFilePicPathNotBetween(String value1, String value2) {
			addCriterion("movie_file_pic_path not between", value1, value2, "movieFilePicPath");
			return (Criteria) this;
		}
		
		public Criteria andMovieUrlIsNull() {
			addCriterion("movie_url is null");
			return (Criteria) this;
		}
		
		public Criteria andMovieUrlIsNotNull() {
			addCriterion("movie_url is not null");
			return (Criteria) this;
		}
		
		public Criteria andMovieUrlEqualTo(String value) {
			addCriterion("movie_url =", value, "movieUrl");
			return (Criteria) this;
		}
		
		public Criteria andMovieUrlNotEqualTo(String value) {
			addCriterion("movie_url <>", value, "movieUrl");
			return (Criteria) this;
		}
		
		public Criteria andMovieUrlGreaterThan(String value) {
			addCriterion("movie_url >", value, "movieUrl");
			return (Criteria) this;
		}
		
		public Criteria andMovieUrlGreaterThanOrEqualTo(String value) {
			addCriterion("movie_url >=", value, "movieUrl");
			return (Criteria) this;
		}
		
		public Criteria andMovieUrlLessThan(String value) {
			addCriterion("movie_url <", value, "movieUrl");
			return (Criteria) this;
		}
		
		public Criteria andMovieUrlLessThanOrEqualTo(String value) {
			addCriterion("movie_url <=", value, "movieUrl");
			return (Criteria) this;
		}
		
		public Criteria andMovieUrlLike(String value) {
			addCriterion("movie_url like", value, "movieUrl");
			return (Criteria) this;
		}
		
		public Criteria andMovieUrlNotLike(String value) {
			addCriterion("movie_url not like", value, "movieUrl");
			return (Criteria) this;
		}
		
		public Criteria andMovieUrlIn(List<String> values) {
			addCriterion("movie_url in", values, "movieUrl");
			return (Criteria) this;
		}
		
		public Criteria andMovieUrlNotIn(List<String> values) {
			addCriterion("movie_url not in", values, "movieUrl");
			return (Criteria) this;
		}
		
		public Criteria andMovieUrlBetween(String value1, String value2) {
			addCriterion("movie_url between", value1, value2, "movieUrl");
			return (Criteria) this;
		}
		
		public Criteria andMovieUrlNotBetween(String value1, String value2) {
			addCriterion("movie_url not between", value1, value2, "movieUrl");
			return (Criteria) this;
		}
		
		public Criteria andMagnetIsNull() {
			addCriterion("magnet is null");
			return (Criteria) this;
		}
		
		public Criteria andMagnetIsNotNull() {
			addCriterion("magnet is not null");
			return (Criteria) this;
		}
		
		public Criteria andMagnetEqualTo(String value) {
			addCriterion("magnet =", value, "magnet");
			return (Criteria) this;
		}
		
		public Criteria andMagnetNotEqualTo(String value) {
			addCriterion("magnet <>", value, "magnet");
			return (Criteria) this;
		}
		
		public Criteria andMagnetGreaterThan(String value) {
			addCriterion("magnet >", value, "magnet");
			return (Criteria) this;
		}
		
		public Criteria andMagnetGreaterThanOrEqualTo(String value) {
			addCriterion("magnet >=", value, "magnet");
			return (Criteria) this;
		}
		
		public Criteria andMagnetLessThan(String value) {
			addCriterion("magnet <", value, "magnet");
			return (Criteria) this;
		}
		
		public Criteria andMagnetLessThanOrEqualTo(String value) {
			addCriterion("magnet <=", value, "magnet");
			return (Criteria) this;
		}
		
		public Criteria andMagnetLike(String value) {
			addCriterion("magnet like", value, "magnet");
			return (Criteria) this;
		}
		
		public Criteria andMagnetNotLike(String value) {
			addCriterion("magnet not like", value, "magnet");
			return (Criteria) this;
		}
		
		public Criteria andMagnetIn(List<String> values) {
			addCriterion("magnet in", values, "magnet");
			return (Criteria) this;
		}
		
		public Criteria andMagnetNotIn(List<String> values) {
			addCriterion("magnet not in", values, "magnet");
			return (Criteria) this;
		}
		
		public Criteria andMagnetBetween(String value1, String value2) {
			addCriterion("magnet between", value1, value2, "magnet");
			return (Criteria) this;
		}
		
		public Criteria andMagnetNotBetween(String value1, String value2) {
			addCriterion("magnet not between", value1, value2, "magnet");
			return (Criteria) this;
		}
		
		public Criteria andIsCorrectIsNull() {
			addCriterion("is_correct is null");
			return (Criteria) this;
		}
		
		public Criteria andIsCorrectIsNotNull() {
			addCriterion("is_correct is not null");
			return (Criteria) this;
		}
		
		public Criteria andIsCorrectEqualTo(Integer value) {
			addCriterion("is_correct =", value, "isCorrect");
			return (Criteria) this;
		}
		
		public Criteria andIsCorrectNotEqualTo(Integer value) {
			addCriterion("is_correct <>", value, "isCorrect");
			return (Criteria) this;
		}
		
		public Criteria andIsCorrectGreaterThan(Integer value) {
			addCriterion("is_correct >", value, "isCorrect");
			return (Criteria) this;
		}
		
		public Criteria andIsCorrectGreaterThanOrEqualTo(Integer value) {
			addCriterion("is_correct >=", value, "isCorrect");
			return (Criteria) this;
		}
		
		public Criteria andIsCorrectLessThan(Integer value) {
			addCriterion("is_correct <", value, "isCorrect");
			return (Criteria) this;
		}
		
		public Criteria andIsCorrectLessThanOrEqualTo(Integer value) {
			addCriterion("is_correct <=", value, "isCorrect");
			return (Criteria) this;
		}
		
		public Criteria andIsCorrectIn(List<Integer> values) {
			addCriterion("is_correct in", values, "isCorrect");
			return (Criteria) this;
		}
		
		public Criteria andIsCorrectNotIn(List<Integer> values) {
			addCriterion("is_correct not in", values, "isCorrect");
			return (Criteria) this;
		}
		
		public Criteria andIsCorrectBetween(Integer value1, Integer value2) {
			addCriterion("is_correct between", value1, value2, "isCorrect");
			return (Criteria) this;
		}
		
		public Criteria andIsCorrectNotBetween(Integer value1, Integer value2) {
			addCriterion("is_correct not between", value1, value2, "isCorrect");
			return (Criteria) this;
		}
		
		public Criteria andRowAddTimeIsNull() {
			addCriterion("row_add_time is null");
			return (Criteria) this;
		}
		
		public Criteria andRowAddTimeIsNotNull() {
			addCriterion("row_add_time is not null");
			return (Criteria) this;
		}
		
		public Criteria andRowAddTimeEqualTo(Date value) {
			addCriterion("row_add_time =", value, "rowAddTime");
			return (Criteria) this;
		}
		
		public Criteria andRowAddTimeNotEqualTo(Date value) {
			addCriterion("row_add_time <>", value, "rowAddTime");
			return (Criteria) this;
		}
		
		public Criteria andRowAddTimeGreaterThan(Date value) {
			addCriterion("row_add_time >", value, "rowAddTime");
			return (Criteria) this;
		}
		
		public Criteria andRowAddTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("row_add_time >=", value, "rowAddTime");
			return (Criteria) this;
		}
		
		public Criteria andRowAddTimeLessThan(Date value) {
			addCriterion("row_add_time <", value, "rowAddTime");
			return (Criteria) this;
		}
		
		public Criteria andRowAddTimeLessThanOrEqualTo(Date value) {
			addCriterion("row_add_time <=", value, "rowAddTime");
			return (Criteria) this;
		}
		
		public Criteria andRowAddTimeIn(List<Date> values) {
			addCriterion("row_add_time in", values, "rowAddTime");
			return (Criteria) this;
		}
		
		public Criteria andRowAddTimeNotIn(List<Date> values) {
			addCriterion("row_add_time not in", values, "rowAddTime");
			return (Criteria) this;
		}
		
		public Criteria andRowAddTimeBetween(Date value1, Date value2) {
			addCriterion("row_add_time between", value1, value2, "rowAddTime");
			return (Criteria) this;
		}
		
		public Criteria andRowAddTimeNotBetween(Date value1, Date value2) {
			addCriterion("row_add_time not between", value1, value2, "rowAddTime");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table superman_movie_file_info
	 * @mbggenerated  Mon Dec 05 16:36:46 CST 2016
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;
		
		public String getCondition() {
			return condition;
		}
		
		public Object getValue() {
			return value;
		}
		
		public Object getSecondValue() {
			return secondValue;
		}
		
		public boolean isNoValue() {
			return noValue;
		}
		
		public boolean isSingleValue() {
			return singleValue;
		}
		
		public boolean isBetweenValue() {
			return betweenValue;
		}
		
		public boolean isListValue() {
			return listValue;
		}
		
		public String getTypeHandler() {
			return typeHandler;
		}
		
		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}
		
		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}
		
		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}
		
		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}
		
		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table superman_movie_file_info
     *
     * @mbggenerated do_not_delete_during_merge Mon Dec 05 11:16:54 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}