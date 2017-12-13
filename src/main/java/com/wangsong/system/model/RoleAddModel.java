package com.wangsong.system.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.wangsong.system.groups.RoleUpdate;



public class RoleAddModel  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3582588209589180635L;
	@NotNull(groups = { RoleUpdate.class }, message = "id不能为空")  
	private String id;
	@NotNull(groups = { RoleUpdate.class,RoleAddModel.class }, message = "name不能为空")  
    private String name;
	private String[] resourcesId;
	
	
    public String[] getResourcesId() {
		return resourcesId;
	}

	public void setResourcesId(String[] resourcesId) {
		this.resourcesId = resourcesId;
	}

	public RoleAddModel(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
    
	public String getId() {
        return id;
    }
	public RoleAddModel(){
		 
	}
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	
    
}