package com.wangsong.sys.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wangsong.sys.dao.ResourcesMapper;
import com.wangsong.sys.dao.RoleResourcesMapper;
import com.wangsong.sys.model.Resources;
import com.wangsong.sys.model.RoleResources;
import com.wangsong.sys.model.User;
import com.wangsong.sys.service.ResourcesService;
import com.wangsong.sys.util.tree.Attributes;
import com.wangsong.sys.util.tree.JsonTreeData;
import com.wangsong.sys.util.tree.TreeNodeUtil;



@Service
@Transactional
public class ResourcesServiceImpl extends BaseServiceImpl <Resources> implements ResourcesService {
	@Autowired
	private ResourcesMapper resourcesMapper;
	@Autowired
	private RoleResourcesMapper roleResourcesMapper;
	
	@Override
	public int delete(String[] id) {
		int j=0;
		
		for(int i=0;i<id.length;i++){
			if(!"1".equals(id[i])){
				j++;
			}
		}
		
		RoleResources[] r=new RoleResources[j];
		
		for(int i=0;i<id.length;i++){
			if(!"1".equals(id[i])){
				RoleResources roleResources=new RoleResources();
				roleResources.setResourcesId(id[i]);
				r[i]=roleResources;
			}
		}
		
		if(j!=0){
			roleResourcesMapper.deleteByT(r);
			resourcesMapper.deleteByPrimaryKey(id);
		}
	
		return 0;
	}
	
	@Override
	public int insert(Resources resources) {
		String id = UUID.randomUUID().toString();
		resources.setId(id);
		if("".equals(resources.getUrl())){
			resources.setUrl("/");
		}
		return resourcesMapper.insert(resources);
	}
	
	@Override
	public int updateByPrimaryKey(Resources resources) {
		if("".equals(resources.getUrl())){
			resources.setUrl("/");
		}
		return resourcesMapper.updateByPrimaryKey(resources);
	}

	@Override
	public List<JsonTreeData> findResources() {
		List<Resources> resourcesList =resourcesMapper.selectAll();
		 List<JsonTreeData> treeDataList = new ArrayList<JsonTreeData>();
        /*为了整理成公用的方法，所以将查询结果进行二次转换。
         * 其中specid为主键ID，varchar类型UUID生成
         * parentid为父ID
         * specname为节点名称
         * */
       for (Resources htSpecifications : resourcesList) {
           JsonTreeData treeData = new JsonTreeData();
           treeData.setId(htSpecifications.getId());
           treeData.setPid(htSpecifications.getPid());
           treeData.setText(htSpecifications.getName());
           Attributes attributes=new Attributes();
           attributes.setUrl(htSpecifications.getUrl()); 
           treeData.setAttributes(attributes);
           treeDataList.add(treeData);
       }
       //最后得到结果集,经过FirstJSON转换后就可得所需的json格式
       List<JsonTreeData> newTreeDataList = TreeNodeUtil.getfatherNode(treeDataList);
		return newTreeDataList;
	}
	
	@Override
	public List<JsonTreeData> findResourcesEMUByResources() {
		Resources resources=new Resources();
		resources.setId(((User)SecurityUtils.getSubject().getPrincipal()).getId());
		resources.setType("1");
		List<Resources> resourcesList =resourcesMapper.findTByT(resources);
		List<JsonTreeData> treeDataList = new ArrayList<JsonTreeData>();
         /*为了整理成公用的方法，所以将查询结果进行二次转换。
          * 其中specid为主键ID，varchar类型UUID生成
          * parentid为父ID
          * specname为节点名称
          * */
        for (Resources htSpecifications : resourcesList) {
            JsonTreeData treeData = new JsonTreeData();
            treeData.setId(htSpecifications.getId());
            treeData.setPid(htSpecifications.getPid());
            treeData.setText(htSpecifications.getName());
            Attributes attributes=new Attributes();
            attributes.setUrl(htSpecifications.getUrl()); 
            treeData.setAttributes(attributes);
            treeDataList.add(treeData);
        }
        //最后得到结果集,经过FirstJSON转换后就可得所需的json格式
        List<JsonTreeData> newTreeDataList = TreeNodeUtil.getfatherNode(treeDataList);
		return newTreeDataList;
	}
	
}
