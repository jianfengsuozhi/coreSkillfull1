package com.provider.page;


import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SingleTableDao<U, V extends PageCriteria> extends MyBatisRepository {
    int countByCriteria(V example);

    int deleteByCriteria(V example);

    int deleteById(Integer dispenseId);

    int insert(U record);

    int insertSelective(U record);

    List<U> selectByCriteria(V example);

    U selectById(Integer dispenseId);

    int updateByCriteriaSelective(@Param("record") U record, @Param("example") V example);

    int updateByCriteria(@Param("record") U record, @Param("example") V example);

    int updateByIdSelective(U record);

    int updateById(U record);
}
