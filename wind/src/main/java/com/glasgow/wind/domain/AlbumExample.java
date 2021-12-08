package com.glasgow.wind.domain;

import java.util.ArrayList;
import java.util.List;

public class AlbumExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AlbumExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andArtistIsNull() {
            addCriterion("artist is null");
            return (Criteria) this;
        }

        public Criteria andArtistIsNotNull() {
            addCriterion("artist is not null");
            return (Criteria) this;
        }

        public Criteria andArtistEqualTo(String value) {
            addCriterion("artist =", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistNotEqualTo(String value) {
            addCriterion("artist <>", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistGreaterThan(String value) {
            addCriterion("artist >", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistGreaterThanOrEqualTo(String value) {
            addCriterion("artist >=", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistLessThan(String value) {
            addCriterion("artist <", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistLessThanOrEqualTo(String value) {
            addCriterion("artist <=", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistLike(String value) {
            addCriterion("artist like", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistNotLike(String value) {
            addCriterion("artist not like", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistIn(List<String> values) {
            addCriterion("artist in", values, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistNotIn(List<String> values) {
            addCriterion("artist not in", values, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistBetween(String value1, String value2) {
            addCriterion("artist between", value1, value2, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistNotBetween(String value1, String value2) {
            addCriterion("artist not between", value1, value2, "artist");
            return (Criteria) this;
        }

        public Criteria andGenreIsNull() {
            addCriterion("genre is null");
            return (Criteria) this;
        }

        public Criteria andGenreIsNotNull() {
            addCriterion("genre is not null");
            return (Criteria) this;
        }

        public Criteria andGenreEqualTo(String value) {
            addCriterion("genre =", value, "genre");
            return (Criteria) this;
        }

        public Criteria andGenreNotEqualTo(String value) {
            addCriterion("genre <>", value, "genre");
            return (Criteria) this;
        }

        public Criteria andGenreGreaterThan(String value) {
            addCriterion("genre >", value, "genre");
            return (Criteria) this;
        }

        public Criteria andGenreGreaterThanOrEqualTo(String value) {
            addCriterion("genre >=", value, "genre");
            return (Criteria) this;
        }

        public Criteria andGenreLessThan(String value) {
            addCriterion("genre <", value, "genre");
            return (Criteria) this;
        }

        public Criteria andGenreLessThanOrEqualTo(String value) {
            addCriterion("genre <=", value, "genre");
            return (Criteria) this;
        }

        public Criteria andGenreLike(String value) {
            addCriterion("genre like", value, "genre");
            return (Criteria) this;
        }

        public Criteria andGenreNotLike(String value) {
            addCriterion("genre not like", value, "genre");
            return (Criteria) this;
        }

        public Criteria andGenreIn(List<String> values) {
            addCriterion("genre in", values, "genre");
            return (Criteria) this;
        }

        public Criteria andGenreNotIn(List<String> values) {
            addCriterion("genre not in", values, "genre");
            return (Criteria) this;
        }

        public Criteria andGenreBetween(String value1, String value2) {
            addCriterion("genre between", value1, value2, "genre");
            return (Criteria) this;
        }

        public Criteria andGenreNotBetween(String value1, String value2) {
            addCriterion("genre not between", value1, value2, "genre");
            return (Criteria) this;
        }

        public Criteria andReleaseDateIsNull() {
            addCriterion("release_date is null");
            return (Criteria) this;
        }

        public Criteria andReleaseDateIsNotNull() {
            addCriterion("release_date is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseDateEqualTo(String value) {
            addCriterion("release_date =", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateNotEqualTo(String value) {
            addCriterion("release_date <>", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateGreaterThan(String value) {
            addCriterion("release_date >", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateGreaterThanOrEqualTo(String value) {
            addCriterion("release_date >=", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateLessThan(String value) {
            addCriterion("release_date <", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateLessThanOrEqualTo(String value) {
            addCriterion("release_date <=", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateLike(String value) {
            addCriterion("release_date like", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateNotLike(String value) {
            addCriterion("release_date not like", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateIn(List<String> values) {
            addCriterion("release_date in", values, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateNotIn(List<String> values) {
            addCriterion("release_date not in", values, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateBetween(String value1, String value2) {
            addCriterion("release_date between", value1, value2, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateNotBetween(String value1, String value2) {
            addCriterion("release_date not between", value1, value2, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNull() {
            addCriterion("introduction is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNotNull() {
            addCriterion("introduction is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("introduction =", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("introduction <>", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("introduction >", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("introduction >=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThan(String value) {
            addCriterion("introduction <", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("introduction <=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLike(String value) {
            addCriterion("introduction like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotLike(String value) {
            addCriterion("introduction not like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("introduction in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("introduction not in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("introduction between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("introduction not between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andTrackListingIsNull() {
            addCriterion("track_listing is null");
            return (Criteria) this;
        }

        public Criteria andTrackListingIsNotNull() {
            addCriterion("track_listing is not null");
            return (Criteria) this;
        }

        public Criteria andTrackListingEqualTo(String value) {
            addCriterion("track_listing =", value, "trackListing");
            return (Criteria) this;
        }

        public Criteria andTrackListingNotEqualTo(String value) {
            addCriterion("track_listing <>", value, "trackListing");
            return (Criteria) this;
        }

        public Criteria andTrackListingGreaterThan(String value) {
            addCriterion("track_listing >", value, "trackListing");
            return (Criteria) this;
        }

        public Criteria andTrackListingGreaterThanOrEqualTo(String value) {
            addCriterion("track_listing >=", value, "trackListing");
            return (Criteria) this;
        }

        public Criteria andTrackListingLessThan(String value) {
            addCriterion("track_listing <", value, "trackListing");
            return (Criteria) this;
        }

        public Criteria andTrackListingLessThanOrEqualTo(String value) {
            addCriterion("track_listing <=", value, "trackListing");
            return (Criteria) this;
        }

        public Criteria andTrackListingLike(String value) {
            addCriterion("track_listing like", value, "trackListing");
            return (Criteria) this;
        }

        public Criteria andTrackListingNotLike(String value) {
            addCriterion("track_listing not like", value, "trackListing");
            return (Criteria) this;
        }

        public Criteria andTrackListingIn(List<String> values) {
            addCriterion("track_listing in", values, "trackListing");
            return (Criteria) this;
        }

        public Criteria andTrackListingNotIn(List<String> values) {
            addCriterion("track_listing not in", values, "trackListing");
            return (Criteria) this;
        }

        public Criteria andTrackListingBetween(String value1, String value2) {
            addCriterion("track_listing between", value1, value2, "trackListing");
            return (Criteria) this;
        }

        public Criteria andTrackListingNotBetween(String value1, String value2) {
            addCriterion("track_listing not between", value1, value2, "trackListing");
            return (Criteria) this;
        }

        public Criteria andCoverUrlIsNull() {
            addCriterion("cover_url is null");
            return (Criteria) this;
        }

        public Criteria andCoverUrlIsNotNull() {
            addCriterion("cover_url is not null");
            return (Criteria) this;
        }

        public Criteria andCoverUrlEqualTo(String value) {
            addCriterion("cover_url =", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlNotEqualTo(String value) {
            addCriterion("cover_url <>", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlGreaterThan(String value) {
            addCriterion("cover_url >", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlGreaterThanOrEqualTo(String value) {
            addCriterion("cover_url >=", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlLessThan(String value) {
            addCriterion("cover_url <", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlLessThanOrEqualTo(String value) {
            addCriterion("cover_url <=", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlLike(String value) {
            addCriterion("cover_url like", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlNotLike(String value) {
            addCriterion("cover_url not like", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlIn(List<String> values) {
            addCriterion("cover_url in", values, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlNotIn(List<String> values) {
            addCriterion("cover_url not in", values, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlBetween(String value1, String value2) {
            addCriterion("cover_url between", value1, value2, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlNotBetween(String value1, String value2) {
            addCriterion("cover_url not between", value1, value2, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andContributorIdIsNull() {
            addCriterion("contributor_id is null");
            return (Criteria) this;
        }

        public Criteria andContributorIdIsNotNull() {
            addCriterion("contributor_id is not null");
            return (Criteria) this;
        }

        public Criteria andContributorIdEqualTo(Integer value) {
            addCriterion("contributor_id =", value, "contributorId");
            return (Criteria) this;
        }

        public Criteria andContributorIdNotEqualTo(Integer value) {
            addCriterion("contributor_id <>", value, "contributorId");
            return (Criteria) this;
        }

        public Criteria andContributorIdGreaterThan(Integer value) {
            addCriterion("contributor_id >", value, "contributorId");
            return (Criteria) this;
        }

        public Criteria andContributorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("contributor_id >=", value, "contributorId");
            return (Criteria) this;
        }

        public Criteria andContributorIdLessThan(Integer value) {
            addCriterion("contributor_id <", value, "contributorId");
            return (Criteria) this;
        }

        public Criteria andContributorIdLessThanOrEqualTo(Integer value) {
            addCriterion("contributor_id <=", value, "contributorId");
            return (Criteria) this;
        }

        public Criteria andContributorIdIn(List<Integer> values) {
            addCriterion("contributor_id in", values, "contributorId");
            return (Criteria) this;
        }

        public Criteria andContributorIdNotIn(List<Integer> values) {
            addCriterion("contributor_id not in", values, "contributorId");
            return (Criteria) this;
        }

        public Criteria andContributorIdBetween(Integer value1, Integer value2) {
            addCriterion("contributor_id between", value1, value2, "contributorId");
            return (Criteria) this;
        }

        public Criteria andContributorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("contributor_id not between", value1, value2, "contributorId");
            return (Criteria) this;
        }

        public Criteria andAlbumStatusIsNull() {
            addCriterion("album_status is null");
            return (Criteria) this;
        }

        public Criteria andAlbumStatusIsNotNull() {
            addCriterion("album_status is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumStatusEqualTo(Integer value) {
            addCriterion("album_status =", value, "albumStatus");
            return (Criteria) this;
        }

        public Criteria andAlbumStatusNotEqualTo(Integer value) {
            addCriterion("album_status <>", value, "albumStatus");
            return (Criteria) this;
        }

        public Criteria andAlbumStatusGreaterThan(Integer value) {
            addCriterion("album_status >", value, "albumStatus");
            return (Criteria) this;
        }

        public Criteria andAlbumStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("album_status >=", value, "albumStatus");
            return (Criteria) this;
        }

        public Criteria andAlbumStatusLessThan(Integer value) {
            addCriterion("album_status <", value, "albumStatus");
            return (Criteria) this;
        }

        public Criteria andAlbumStatusLessThanOrEqualTo(Integer value) {
            addCriterion("album_status <=", value, "albumStatus");
            return (Criteria) this;
        }

        public Criteria andAlbumStatusIn(List<Integer> values) {
            addCriterion("album_status in", values, "albumStatus");
            return (Criteria) this;
        }

        public Criteria andAlbumStatusNotIn(List<Integer> values) {
            addCriterion("album_status not in", values, "albumStatus");
            return (Criteria) this;
        }

        public Criteria andAlbumStatusBetween(Integer value1, Integer value2) {
            addCriterion("album_status between", value1, value2, "albumStatus");
            return (Criteria) this;
        }

        public Criteria andAlbumStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("album_status not between", value1, value2, "albumStatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

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
}