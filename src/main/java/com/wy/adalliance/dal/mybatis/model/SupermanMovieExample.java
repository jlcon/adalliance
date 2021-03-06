package com.wy.adalliance.dal.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SupermanMovieExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	public SupermanMovieExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
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
		
		public Criteria andMovieNameIsNull() {
			addCriterion("movie_name is null");
			return (Criteria) this;
		}
		
		public Criteria andMovieNameIsNotNull() {
			addCriterion("movie_name is not null");
			return (Criteria) this;
		}
		
		public Criteria andMovieNameEqualTo(String value) {
			addCriterion("movie_name =", value, "movieName");
			return (Criteria) this;
		}
		
		public Criteria andMovieNameNotEqualTo(String value) {
			addCriterion("movie_name <>", value, "movieName");
			return (Criteria) this;
		}
		
		public Criteria andMovieNameGreaterThan(String value) {
			addCriterion("movie_name >", value, "movieName");
			return (Criteria) this;
		}
		
		public Criteria andMovieNameGreaterThanOrEqualTo(String value) {
			addCriterion("movie_name >=", value, "movieName");
			return (Criteria) this;
		}
		
		public Criteria andMovieNameLessThan(String value) {
			addCriterion("movie_name <", value, "movieName");
			return (Criteria) this;
		}
		
		public Criteria andMovieNameLessThanOrEqualTo(String value) {
			addCriterion("movie_name <=", value, "movieName");
			return (Criteria) this;
		}
		
		public Criteria andMovieNameLike(String value) {
			addCriterion("movie_name like", value, "movieName");
			return (Criteria) this;
		}
		
		public Criteria andMovieNameNotLike(String value) {
			addCriterion("movie_name not like", value, "movieName");
			return (Criteria) this;
		}
		
		public Criteria andMovieNameIn(List<String> values) {
			addCriterion("movie_name in", values, "movieName");
			return (Criteria) this;
		}
		
		public Criteria andMovieNameNotIn(List<String> values) {
			addCriterion("movie_name not in", values, "movieName");
			return (Criteria) this;
		}
		
		public Criteria andMovieNameBetween(String value1, String value2) {
			addCriterion("movie_name between", value1, value2, "movieName");
			return (Criteria) this;
		}
		
		public Criteria andMovieNameNotBetween(String value1, String value2) {
			addCriterion("movie_name not between", value1, value2, "movieName");
			return (Criteria) this;
		}
		
		public Criteria andMovieDirectorIsNull() {
			addCriterion("movie_director is null");
			return (Criteria) this;
		}
		
		public Criteria andMovieDirectorIsNotNull() {
			addCriterion("movie_director is not null");
			return (Criteria) this;
		}
		
		public Criteria andMovieDirectorEqualTo(String value) {
			addCriterion("movie_director =", value, "movieDirector");
			return (Criteria) this;
		}
		
		public Criteria andMovieDirectorNotEqualTo(String value) {
			addCriterion("movie_director <>", value, "movieDirector");
			return (Criteria) this;
		}
		
		public Criteria andMovieDirectorGreaterThan(String value) {
			addCriterion("movie_director >", value, "movieDirector");
			return (Criteria) this;
		}
		
		public Criteria andMovieDirectorGreaterThanOrEqualTo(String value) {
			addCriterion("movie_director >=", value, "movieDirector");
			return (Criteria) this;
		}
		
		public Criteria andMovieDirectorLessThan(String value) {
			addCriterion("movie_director <", value, "movieDirector");
			return (Criteria) this;
		}
		
		public Criteria andMovieDirectorLessThanOrEqualTo(String value) {
			addCriterion("movie_director <=", value, "movieDirector");
			return (Criteria) this;
		}
		
		public Criteria andMovieDirectorLike(String value) {
			addCriterion("movie_director like", value, "movieDirector");
			return (Criteria) this;
		}
		
		public Criteria andMovieDirectorNotLike(String value) {
			addCriterion("movie_director not like", value, "movieDirector");
			return (Criteria) this;
		}
		
		public Criteria andMovieDirectorIn(List<String> values) {
			addCriterion("movie_director in", values, "movieDirector");
			return (Criteria) this;
		}
		
		public Criteria andMovieDirectorNotIn(List<String> values) {
			addCriterion("movie_director not in", values, "movieDirector");
			return (Criteria) this;
		}
		
		public Criteria andMovieDirectorBetween(String value1, String value2) {
			addCriterion("movie_director between", value1, value2, "movieDirector");
			return (Criteria) this;
		}
		
		public Criteria andMovieDirectorNotBetween(String value1, String value2) {
			addCriterion("movie_director not between", value1, value2, "movieDirector");
			return (Criteria) this;
		}
		
		public Criteria andMoviePicPathIsNull() {
			addCriterion("movie_pic_path is null");
			return (Criteria) this;
		}
		
		public Criteria andMoviePicPathIsNotNull() {
			addCriterion("movie_pic_path is not null");
			return (Criteria) this;
		}
		
		public Criteria andMoviePicPathEqualTo(String value) {
			addCriterion("movie_pic_path =", value, "moviePicPath");
			return (Criteria) this;
		}
		
		public Criteria andMoviePicPathNotEqualTo(String value) {
			addCriterion("movie_pic_path <>", value, "moviePicPath");
			return (Criteria) this;
		}
		
		public Criteria andMoviePicPathGreaterThan(String value) {
			addCriterion("movie_pic_path >", value, "moviePicPath");
			return (Criteria) this;
		}
		
		public Criteria andMoviePicPathGreaterThanOrEqualTo(String value) {
			addCriterion("movie_pic_path >=", value, "moviePicPath");
			return (Criteria) this;
		}
		
		public Criteria andMoviePicPathLessThan(String value) {
			addCriterion("movie_pic_path <", value, "moviePicPath");
			return (Criteria) this;
		}
		
		public Criteria andMoviePicPathLessThanOrEqualTo(String value) {
			addCriterion("movie_pic_path <=", value, "moviePicPath");
			return (Criteria) this;
		}
		
		public Criteria andMoviePicPathLike(String value) {
			addCriterion("movie_pic_path like", value, "moviePicPath");
			return (Criteria) this;
		}
		
		public Criteria andMoviePicPathNotLike(String value) {
			addCriterion("movie_pic_path not like", value, "moviePicPath");
			return (Criteria) this;
		}
		
		public Criteria andMoviePicPathIn(List<String> values) {
			addCriterion("movie_pic_path in", values, "moviePicPath");
			return (Criteria) this;
		}
		
		public Criteria andMoviePicPathNotIn(List<String> values) {
			addCriterion("movie_pic_path not in", values, "moviePicPath");
			return (Criteria) this;
		}
		
		public Criteria andMoviePicPathBetween(String value1, String value2) {
			addCriterion("movie_pic_path between", value1, value2, "moviePicPath");
			return (Criteria) this;
		}
		
		public Criteria andMoviePicPathNotBetween(String value1, String value2) {
			addCriterion("movie_pic_path not between", value1, value2, "moviePicPath");
			return (Criteria) this;
		}
		
		public Criteria andMovieScoreIsNull() {
			addCriterion("movie_score is null");
			return (Criteria) this;
		}
		
		public Criteria andMovieScoreIsNotNull() {
			addCriterion("movie_score is not null");
			return (Criteria) this;
		}
		
		public Criteria andMovieScoreEqualTo(Float value) {
			addCriterion("movie_score =", value, "movieScore");
			return (Criteria) this;
		}
		
		public Criteria andMovieScoreNotEqualTo(Float value) {
			addCriterion("movie_score <>", value, "movieScore");
			return (Criteria) this;
		}
		
		public Criteria andMovieScoreGreaterThan(Float value) {
			addCriterion("movie_score >", value, "movieScore");
			return (Criteria) this;
		}
		
		public Criteria andMovieScoreGreaterThanOrEqualTo(Float value) {
			addCriterion("movie_score >=", value, "movieScore");
			return (Criteria) this;
		}
		
		public Criteria andMovieScoreLessThan(Float value) {
			addCriterion("movie_score <", value, "movieScore");
			return (Criteria) this;
		}
		
		public Criteria andMovieScoreLessThanOrEqualTo(Float value) {
			addCriterion("movie_score <=", value, "movieScore");
			return (Criteria) this;
		}
		
		public Criteria andMovieScoreIn(List<Float> values) {
			addCriterion("movie_score in", values, "movieScore");
			return (Criteria) this;
		}
		
		public Criteria andMovieScoreNotIn(List<Float> values) {
			addCriterion("movie_score not in", values, "movieScore");
			return (Criteria) this;
		}
		
		public Criteria andMovieScoreBetween(Float value1, Float value2) {
			addCriterion("movie_score between", value1, value2, "movieScore");
			return (Criteria) this;
		}
		
		public Criteria andMovieScoreNotBetween(Float value1, Float value2) {
			addCriterion("movie_score not between", value1, value2, "movieScore");
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
	 * This class was generated by MyBatis Generator. This class corresponds to the database table superman_movie
	 * @mbggenerated  Thu Dec 08 10:04:22 CST 2016
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
     * This class corresponds to the database table superman_movie
     *
     * @mbggenerated do_not_delete_during_merge Mon Dec 05 11:16:54 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}