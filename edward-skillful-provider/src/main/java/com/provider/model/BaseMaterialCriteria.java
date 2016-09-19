package com.provider.model;


import com.api.page.PageCriteria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseMaterialCriteria extends PageCriteria {
    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BaseMaterialCriteria() {
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

        public Criteria andMaterialIdIsNull() {
            addCriterion("material_id is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIsNotNull() {
            addCriterion("material_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdEqualTo(Integer value) {
            addCriterion("material_id =", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotEqualTo(Integer value) {
            addCriterion("material_id <>", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdGreaterThan(Integer value) {
            addCriterion("material_id >", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("material_id >=", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLessThan(Integer value) {
            addCriterion("material_id <", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLessThanOrEqualTo(Integer value) {
            addCriterion("material_id <=", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIn(List<Integer> values) {
            addCriterion("material_id in", values, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotIn(List<Integer> values) {
            addCriterion("material_id not in", values, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdBetween(Integer value1, Integer value2) {
            addCriterion("material_id between", value1, value2, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotBetween(Integer value1, Integer value2) {
            addCriterion("material_id not between", value1, value2, "materialId");
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

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeIsNull() {
            addCriterion("material_code is null");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeIsNotNull() {
            addCriterion("material_code is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeEqualTo(String value) {
            addCriterion("material_code =", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotEqualTo(String value) {
            addCriterion("material_code <>", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeGreaterThan(String value) {
            addCriterion("material_code >", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeGreaterThanOrEqualTo(String value) {
            addCriterion("material_code >=", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeLessThan(String value) {
            addCriterion("material_code <", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeLessThanOrEqualTo(String value) {
            addCriterion("material_code <=", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeLike(String value) {
            addCriterion("material_code like", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotLike(String value) {
            addCriterion("material_code not like", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeIn(List<String> values) {
            addCriterion("material_code in", values, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotIn(List<String> values) {
            addCriterion("material_code not in", values, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeBetween(String value1, String value2) {
            addCriterion("material_code between", value1, value2, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotBetween(String value1, String value2) {
            addCriterion("material_code not between", value1, value2, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialNameIsNull() {
            addCriterion("material_name is null");
            return (Criteria) this;
        }

        public Criteria andMaterialNameIsNotNull() {
            addCriterion("material_name is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialNameEqualTo(String value) {
            addCriterion("material_name =", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotEqualTo(String value) {
            addCriterion("material_name <>", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameGreaterThan(String value) {
            addCriterion("material_name >", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameGreaterThanOrEqualTo(String value) {
            addCriterion("material_name >=", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameLessThan(String value) {
            addCriterion("material_name <", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameLessThanOrEqualTo(String value) {
            addCriterion("material_name <=", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameLike(String value) {
            addCriterion("material_name like", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotLike(String value) {
            addCriterion("material_name not like", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameIn(List<String> values) {
            addCriterion("material_name in", values, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotIn(List<String> values) {
            addCriterion("material_name not in", values, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameBetween(String value1, String value2) {
            addCriterion("material_name between", value1, value2, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotBetween(String value1, String value2) {
            addCriterion("material_name not between", value1, value2, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialSpecIsNull() {
            addCriterion("material_spec is null");
            return (Criteria) this;
        }

        public Criteria andMaterialSpecIsNotNull() {
            addCriterion("material_spec is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialSpecEqualTo(String value) {
            addCriterion("material_spec =", value, "materialSpec");
            return (Criteria) this;
        }

        public Criteria andMaterialSpecNotEqualTo(String value) {
            addCriterion("material_spec <>", value, "materialSpec");
            return (Criteria) this;
        }

        public Criteria andMaterialSpecGreaterThan(String value) {
            addCriterion("material_spec >", value, "materialSpec");
            return (Criteria) this;
        }

        public Criteria andMaterialSpecGreaterThanOrEqualTo(String value) {
            addCriterion("material_spec >=", value, "materialSpec");
            return (Criteria) this;
        }

        public Criteria andMaterialSpecLessThan(String value) {
            addCriterion("material_spec <", value, "materialSpec");
            return (Criteria) this;
        }

        public Criteria andMaterialSpecLessThanOrEqualTo(String value) {
            addCriterion("material_spec <=", value, "materialSpec");
            return (Criteria) this;
        }

        public Criteria andMaterialSpecLike(String value) {
            addCriterion("material_spec like", value, "materialSpec");
            return (Criteria) this;
        }

        public Criteria andMaterialSpecNotLike(String value) {
            addCriterion("material_spec not like", value, "materialSpec");
            return (Criteria) this;
        }

        public Criteria andMaterialSpecIn(List<String> values) {
            addCriterion("material_spec in", values, "materialSpec");
            return (Criteria) this;
        }

        public Criteria andMaterialSpecNotIn(List<String> values) {
            addCriterion("material_spec not in", values, "materialSpec");
            return (Criteria) this;
        }

        public Criteria andMaterialSpecBetween(String value1, String value2) {
            addCriterion("material_spec between", value1, value2, "materialSpec");
            return (Criteria) this;
        }

        public Criteria andMaterialSpecNotBetween(String value1, String value2) {
            addCriterion("material_spec not between", value1, value2, "materialSpec");
            return (Criteria) this;
        }

        public Criteria andMnemonicCodeIsNull() {
            addCriterion("mnemonic_code is null");
            return (Criteria) this;
        }

        public Criteria andMnemonicCodeIsNotNull() {
            addCriterion("mnemonic_code is not null");
            return (Criteria) this;
        }

        public Criteria andMnemonicCodeEqualTo(String value) {
            addCriterion("mnemonic_code =", value, "mnemonicCode");
            return (Criteria) this;
        }

        public Criteria andMnemonicCodeNotEqualTo(String value) {
            addCriterion("mnemonic_code <>", value, "mnemonicCode");
            return (Criteria) this;
        }

        public Criteria andMnemonicCodeGreaterThan(String value) {
            addCriterion("mnemonic_code >", value, "mnemonicCode");
            return (Criteria) this;
        }

        public Criteria andMnemonicCodeGreaterThanOrEqualTo(String value) {
            addCriterion("mnemonic_code >=", value, "mnemonicCode");
            return (Criteria) this;
        }

        public Criteria andMnemonicCodeLessThan(String value) {
            addCriterion("mnemonic_code <", value, "mnemonicCode");
            return (Criteria) this;
        }

        public Criteria andMnemonicCodeLessThanOrEqualTo(String value) {
            addCriterion("mnemonic_code <=", value, "mnemonicCode");
            return (Criteria) this;
        }

        public Criteria andMnemonicCodeLike(String value) {
            addCriterion("mnemonic_code like", value, "mnemonicCode");
            return (Criteria) this;
        }

        public Criteria andMnemonicCodeNotLike(String value) {
            addCriterion("mnemonic_code not like", value, "mnemonicCode");
            return (Criteria) this;
        }

        public Criteria andMnemonicCodeIn(List<String> values) {
            addCriterion("mnemonic_code in", values, "mnemonicCode");
            return (Criteria) this;
        }

        public Criteria andMnemonicCodeNotIn(List<String> values) {
            addCriterion("mnemonic_code not in", values, "mnemonicCode");
            return (Criteria) this;
        }

        public Criteria andMnemonicCodeBetween(String value1, String value2) {
            addCriterion("mnemonic_code between", value1, value2, "mnemonicCode");
            return (Criteria) this;
        }

        public Criteria andMnemonicCodeNotBetween(String value1, String value2) {
            addCriterion("mnemonic_code not between", value1, value2, "mnemonicCode");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitIsNull() {
            addCriterion("material_unit is null");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitIsNotNull() {
            addCriterion("material_unit is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitEqualTo(String value) {
            addCriterion("material_unit =", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitNotEqualTo(String value) {
            addCriterion("material_unit <>", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitGreaterThan(String value) {
            addCriterion("material_unit >", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitGreaterThanOrEqualTo(String value) {
            addCriterion("material_unit >=", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitLessThan(String value) {
            addCriterion("material_unit <", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitLessThanOrEqualTo(String value) {
            addCriterion("material_unit <=", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitLike(String value) {
            addCriterion("material_unit like", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitNotLike(String value) {
            addCriterion("material_unit not like", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitIn(List<String> values) {
            addCriterion("material_unit in", values, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitNotIn(List<String> values) {
            addCriterion("material_unit not in", values, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitBetween(String value1, String value2) {
            addCriterion("material_unit between", value1, value2, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitNotBetween(String value1, String value2) {
            addCriterion("material_unit not between", value1, value2, "materialUnit");
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

        public Criteria andPlantingSysCodeIsNull() {
            addCriterion("planting_sys_code is null");
            return (Criteria) this;
        }

        public Criteria andPlantingSysCodeIsNotNull() {
            addCriterion("planting_sys_code is not null");
            return (Criteria) this;
        }

        public Criteria andPlantingSysCodeEqualTo(String value) {
            addCriterion("planting_sys_code =", value, "plantingSysCode");
            return (Criteria) this;
        }

        public Criteria andPlantingSysCodeNotEqualTo(String value) {
            addCriterion("planting_sys_code <>", value, "plantingSysCode");
            return (Criteria) this;
        }

        public Criteria andPlantingSysCodeGreaterThan(String value) {
            addCriterion("planting_sys_code >", value, "plantingSysCode");
            return (Criteria) this;
        }

        public Criteria andPlantingSysCodeGreaterThanOrEqualTo(String value) {
            addCriterion("planting_sys_code >=", value, "plantingSysCode");
            return (Criteria) this;
        }

        public Criteria andPlantingSysCodeLessThan(String value) {
            addCriterion("planting_sys_code <", value, "plantingSysCode");
            return (Criteria) this;
        }

        public Criteria andPlantingSysCodeLessThanOrEqualTo(String value) {
            addCriterion("planting_sys_code <=", value, "plantingSysCode");
            return (Criteria) this;
        }

        public Criteria andPlantingSysCodeLike(String value) {
            addCriterion("planting_sys_code like", value, "plantingSysCode");
            return (Criteria) this;
        }

        public Criteria andPlantingSysCodeNotLike(String value) {
            addCriterion("planting_sys_code not like", value, "plantingSysCode");
            return (Criteria) this;
        }

        public Criteria andPlantingSysCodeIn(List<String> values) {
            addCriterion("planting_sys_code in", values, "plantingSysCode");
            return (Criteria) this;
        }

        public Criteria andPlantingSysCodeNotIn(List<String> values) {
            addCriterion("planting_sys_code not in", values, "plantingSysCode");
            return (Criteria) this;
        }

        public Criteria andPlantingSysCodeBetween(String value1, String value2) {
            addCriterion("planting_sys_code between", value1, value2, "plantingSysCode");
            return (Criteria) this;
        }

        public Criteria andPlantingSysCodeNotBetween(String value1, String value2) {
            addCriterion("planting_sys_code not between", value1, value2, "plantingSysCode");
            return (Criteria) this;
        }

        public Criteria andPlantingSysNameIsNull() {
            addCriterion("planting_sys_name is null");
            return (Criteria) this;
        }

        public Criteria andPlantingSysNameIsNotNull() {
            addCriterion("planting_sys_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlantingSysNameEqualTo(String value) {
            addCriterion("planting_sys_name =", value, "plantingSysName");
            return (Criteria) this;
        }

        public Criteria andPlantingSysNameNotEqualTo(String value) {
            addCriterion("planting_sys_name <>", value, "plantingSysName");
            return (Criteria) this;
        }

        public Criteria andPlantingSysNameGreaterThan(String value) {
            addCriterion("planting_sys_name >", value, "plantingSysName");
            return (Criteria) this;
        }

        public Criteria andPlantingSysNameGreaterThanOrEqualTo(String value) {
            addCriterion("planting_sys_name >=", value, "plantingSysName");
            return (Criteria) this;
        }

        public Criteria andPlantingSysNameLessThan(String value) {
            addCriterion("planting_sys_name <", value, "plantingSysName");
            return (Criteria) this;
        }

        public Criteria andPlantingSysNameLessThanOrEqualTo(String value) {
            addCriterion("planting_sys_name <=", value, "plantingSysName");
            return (Criteria) this;
        }

        public Criteria andPlantingSysNameLike(String value) {
            addCriterion("planting_sys_name like", value, "plantingSysName");
            return (Criteria) this;
        }

        public Criteria andPlantingSysNameNotLike(String value) {
            addCriterion("planting_sys_name not like", value, "plantingSysName");
            return (Criteria) this;
        }

        public Criteria andPlantingSysNameIn(List<String> values) {
            addCriterion("planting_sys_name in", values, "plantingSysName");
            return (Criteria) this;
        }

        public Criteria andPlantingSysNameNotIn(List<String> values) {
            addCriterion("planting_sys_name not in", values, "plantingSysName");
            return (Criteria) this;
        }

        public Criteria andPlantingSysNameBetween(String value1, String value2) {
            addCriterion("planting_sys_name between", value1, value2, "plantingSysName");
            return (Criteria) this;
        }

        public Criteria andPlantingSysNameNotBetween(String value1, String value2) {
            addCriterion("planting_sys_name not between", value1, value2, "plantingSysName");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Short value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Short value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Short value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Short value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Short value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Short> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Short> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Short value1, Short value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Short value1, Short value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andCodeLikeInsensitive(String value) {
            addCriterion("upper(code) like", value.toUpperCase(), "code");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeLikeInsensitive(String value) {
            addCriterion("upper(material_code) like", value.toUpperCase(), "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialNameLikeInsensitive(String value) {
            addCriterion("upper(material_name) like", value.toUpperCase(), "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialSpecLikeInsensitive(String value) {
            addCriterion("upper(material_spec) like", value.toUpperCase(), "materialSpec");
            return (Criteria) this;
        }

        public Criteria andMnemonicCodeLikeInsensitive(String value) {
            addCriterion("upper(mnemonic_code) like", value.toUpperCase(), "mnemonicCode");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitLikeInsensitive(String value) {
            addCriterion("upper(material_unit) like", value.toUpperCase(), "materialUnit");
            return (Criteria) this;
        }

        public Criteria andClassCodeLikeInsensitive(String value) {
            addCriterion("upper(class_code) like", value.toUpperCase(), "classCode");
            return (Criteria) this;
        }

        public Criteria andClassNameLikeInsensitive(String value) {
            addCriterion("upper(class_name) like", value.toUpperCase(), "className");
            return (Criteria) this;
        }

        public Criteria andPlantingSysCodeLikeInsensitive(String value) {
            addCriterion("upper(planting_sys_code) like", value.toUpperCase(), "plantingSysCode");
            return (Criteria) this;
        }

        public Criteria andPlantingSysNameLikeInsensitive(String value) {
            addCriterion("upper(planting_sys_name) like", value.toUpperCase(), "plantingSysName");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}