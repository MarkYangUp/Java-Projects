package com.mgielib.dao;
import java.util.List;

import com.mgielib.entity.EMaterialsBaseEntity;
import com.mgielib.entity.SearchCriteria;
public interface SearchCriteriaDao {

List<EMaterialsBaseEntity> search(SearchCriteria searchCriteria);
List<EMaterialsBaseEntity> quickSearch(String quickSearch);

}
