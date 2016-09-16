package com.provider.model;

import com.provider.page.PageCriteria;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseMaterialClassCriteria extends PageCriteria {
    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BaseMaterialClassCriteria() {
        oredCriteria = new ArrayList<Criteria>();
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

        public Criteria andClassIdIsNull() {
            addCriterion("class_id is null");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNotNull() {
            addCriterion("class_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassIdEqualTo(Integer value) {
            addCriterion("class_id =", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotEqualTo(Integer value) {
            addCriterion("class_id <>", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThan(Integer value) {
            addCriterion("class_id >", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("class_id >=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThan(Integer value) {
            addCriterion("class_id <", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThanOrEqualTo(Integer value) {
            addCriterion("class_id <=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdIn(List<Integer> values) {
            addCriterion("class_id in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotIn(List<Integer> values) {
            addCriterion("class_id not in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdBetween(Integer value1, Integer value2) {
            addCriterion("class_id between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotBetween(Integer value1, Integer value2) {
            addCriterion("class_id not between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNull() {
            addCriterion("class_name is null");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNotNull() {
            addCriterion("class_name is not null");
            return (Criteria) this;
        }

        public Criteria andClassNameEqualTo(String value) {
            addCriterion("class_name =", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotEqualTo(String value) {
            addCriterion("class_name <>", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThan(String value) {
            addCriterion("class_name >", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("class_name >=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThan(String value) {
            addCriterion("class_name <", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThanOrEqualTo(String value) {
            addCriterion("class_name <=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLike(String value) {
            addCriterion("class_name like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotLike(String value) {
            addCriterion("class_name not like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameIn(List<String> values) {
            addCriterion("class_name in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotIn(List<String> values) {
            addCriterion("class_name not in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameBetween(String value1, String value2) {
            addCriterion("class_name between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotBetween(String value1, String value2) {
            addCriterion("class_name not between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andClassCodeIsNull() {
            addCriterion("class_code is null");
            return (Criteria) this;
        }

        public Criteria andClassCodeIsNotNull() {
            addCriterion("class_code is not null");
            return (Criteria) this;
        }

        public Criteria andClassCodeEqualTo(String value) {
            addCriterion("class_code =", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeNotEqualTo(String value) {
            addCriterion("class_code <>", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeGreaterThan(String value) {
            addCriterion("class_code >", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeGreaterThanOrEqualTo(String value) {
            addCriterion("class_code >=", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeLessThan(String value) {
            addCriterion("class_code <", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeLessThanOrEqualTo(String value) {
            addCriterion("class_code <=", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeLike(String value) {
            addCriterion("class_code like", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeNotLike(String value) {
            addCriterion("class_code not like", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeIn(List<String> values) {
            addCriterion("class_code in", values, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeNotIn(List<String> values) {
            addCriterion("class_code not in", values, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeBetween(String value1, String value2) {
            addCriterion("class_code between", value1, value2, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeNotBetween(String value1, String value2) {
            addCriterion("class_code not between", value1, value2, "classCode");
            return (Criteria) this;
        }

        public Criteria andParentHospitalIdIsNull() {
            addCriterion("parent_hospital_id is null");
            return (Criteria) this;
        }

        public Criteria andParentHospitalIdIsNotNull() {
            addCriterion("parent_hospital_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentHospitalIdEqualTo(Integer value) {
            addCriterion("parent_hospital_id =", value, "parentHospitalId");
            return (Criteria) this;
        }

        public Criteria andParentHospitalIdNotEqualTo(Integer value) {
            addCriterion("parent_hospital_id <>", value, "parentHospitalId");
            return (Criteria) this;
        }

        public Criteria andParentHospitalIdGreaterThan(Integer value) {
            addCriterion("parent_hospital_id >", value, "parentHospitalId");
            return (Criteria) this;
        }

        public Criteria andParentHospitalIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_hospital_id >=", value, "parentHospitalId");
            return (Criteria) this;
        }

        public Criteria andParentHospitalIdLessThan(Integer value) {
            addCriterion("parent_hospital_id <", value, "parentHospitalId");
            return (Criteria) this;
        }

        public Criteria andParentHospitalIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_hospital_id <=", value, "parentHospitalId");
            return (Criteria) this;
        }

        public Criteria andParentHospitalIdIn(List<Integer> values) {
            addCriterion("parent_hospital_id in", values, "parentHospitalId");
            return (Criteria) this;
        }

        public Criteria andParentHospitalIdNotIn(List<Integer> values) {
            addCriterion("parent_hospital_id not in", values, "parentHospitalId");
            return (Criteria) this;
        }

        public Criteria andParentHospitalIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_hospital_id between", value1, value2, "parentHospitalId");
            return (Criteria) this;
        }

        public Criteria andParentHospitalIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_hospital_id not between", value1, value2, "parentHospitalId");
            return (Criteria) this;
        }

        public Criteria andParentClassCodeIsNull() {
            addCriterion("parent_class_code is null");
            return (Criteria) this;
        }

        public Criteria andParentClassCodeIsNotNull() {
            addCriterion("parent_class_code is not null");
            return (Criteria) this;
        }

        public Criteria andParentClassCodeEqualTo(String value) {
            addCriterion("parent_class_code =", value, "parentClassCode");
            return (Criteria) this;
        }

        public Criteria andParentClassCodeNotEqualTo(String value) {
            addCriterion("parent_class_code <>", value, "parentClassCode");
            return (Criteria) this;
        }

        public Criteria andParentClassCodeGreaterThan(String value) {
            addCriterion("parent_class_code >", value, "parentClassCode");
            return (Criteria) this;
        }

        public Criteria andParentClassCodeGreaterThanOrEqualTo(String value) {
            addCriterion("parent_class_code >=", value, "parentClassCode");
            return (Criteria) this;
        }

        public Criteria andParentClassCodeLessThan(String value) {
            addCriterion("parent_class_code <", value, "parentClassCode");
            return (Criteria) this;
        }

        public Criteria andParentClassCodeLessThanOrEqualTo(String value) {
            addCriterion("parent_class_code <=", value, "parentClassCode");
            return (Criteria) this;
        }

        public Criteria andParentClassCodeLike(String value) {
            addCriterion("parent_class_code like", value, "parentClassCode");
            return (Criteria) this;
        }

        public Criteria andParentClassCodeNotLike(String value) {
            addCriterion("parent_class_code not like", value, "parentClassCode");
            return (Criteria) this;
        }

        public Criteria andParentClassCodeIn(List<String> values) {
            addCriterion("parent_class_code in", values, "parentClassCode");
            return (Criteria) this;
        }

        public Criteria andParentClassCodeNotIn(List<String> values) {
            addCriterion("parent_class_code not in", values, "parentClassCode");
            return (Criteria) this;
        }

        public Criteria andParentClassCodeBetween(String value1, String value2) {
            addCriterion("parent_class_code between", value1, value2, "parentClassCode");
            return (Criteria) this;
        }

        public Criteria andParentClassCodeNotBetween(String value1, String value2) {
            addCriterion("parent_class_code not between", value1, value2, "parentClassCode");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(Integer value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(Integer value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(Integer value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(Integer value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(Integer value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<Integer> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<Integer> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(Integer value1, Integer value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(Integer value1, Integer value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andClassStatusIsNull() {
            addCriterion("class_status is null");
            return (Criteria) this;
        }

        public Criteria andClassStatusIsNotNull() {
            addCriterion("class_status is not null");
            return (Criteria) this;
        }

        public Criteria andClassStatusEqualTo(Short value) {
            addCriterion("class_status =", value, "classStatus");
            return (Criteria) this;
        }

        public Criteria andClassStatusNotEqualTo(Short value) {
            addCriterion("class_status <>", value, "classStatus");
            return (Criteria) this;
        }

        public Criteria andClassStatusGreaterThan(Short value) {
            addCriterion("class_status >", value, "classStatus");
            return (Criteria) this;
        }

        public Criteria andClassStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("class_status >=", value, "classStatus");
            return (Criteria) this;
        }

        public Criteria andClassStatusLessThan(Short value) {
            addCriterion("class_status <", value, "classStatus");
            return (Criteria) this;
        }

        public Criteria andClassStatusLessThanOrEqualTo(Short value) {
            addCriterion("class_status <=", value, "classStatus");
            return (Criteria) this;
        }

        public Criteria andClassStatusIn(List<Short> values) {
            addCriterion("class_status in", values, "classStatus");
            return (Criteria) this;
        }

        public Criteria andClassStatusNotIn(List<Short> values) {
            addCriterion("class_status not in", values, "classStatus");
            return (Criteria) this;
        }

        public Criteria andClassStatusBetween(Short value1, Short value2) {
            addCriterion("class_status between", value1, value2, "classStatus");
            return (Criteria) this;
        }

        public Criteria andClassStatusNotBetween(Short value1, Short value2) {
            addCriterion("class_status not between", value1, value2, "classStatus");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andClassNameLikeInsensitive(String value) {
            addCriterion("upper(class_name) like", value.toUpperCase(), "className");
            return (Criteria) this;
        }

        public Criteria andClassCodeLikeInsensitive(String value) {
            addCriterion("upper(class_code) like", value.toUpperCase(), "classCode");
            return (Criteria) this;
        }

        public Criteria andParentClassCodeLikeInsensitive(String value) {
            addCriterion("upper(parent_class_code) like", value.toUpperCase(), "parentClassCode");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}