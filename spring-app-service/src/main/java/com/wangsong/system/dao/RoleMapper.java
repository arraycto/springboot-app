package com.wangsong.system.dao;

import java.util.List;

import com.wangsong.system.model.Dict;
import com.wangsong.system.model.Role;
import com.wangsong.system.model.RolePage;
import com.wangsong.system.vo.RoleVO;

public interface RoleMapper {

	int deleteByPrimaryKey(String id);

    int insert(Role record);

    Role selectByPrimaryKey(String id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);
	
	List<Role> findTByPage(RolePage role);

	int findTCountByT(RolePage role);

	void deleteBy(String[] id);

	RoleVO selectRoleVOByPrimaryKey(String id);

}