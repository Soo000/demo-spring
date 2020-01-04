package com.kkwrite.redis.pojo.module;

import com.kkwrite.redis.pojo.BasePojo;

public class Module extends BasePojo {

	private static final long serialVersionUID = 4493355988077933781L;
	
	private int moduleId;
	private String moduleName;
	private int pModuleId;
	private String pModuleName;
	private int isValid;
	private String moduleDesc;
	
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public int getpModuleId() {
		return pModuleId;
	}
	public void setpModuleId(int pModuleId) {
		this.pModuleId = pModuleId;
	}
	public String getpModuleName() {
		return pModuleName;
	}
	public void setpModuleName(String pModuleName) {
		this.pModuleName = pModuleName;
	}
	public int getIsValid() {
		return isValid;
	}
	public void setIsValid(int isValid) {
		this.isValid = isValid;
	}
	public String getModuleDesc() {
		return moduleDesc;
	}
	public void setModuleDesc(String moduleDesc) {
		this.moduleDesc = moduleDesc;
	}
	
	@Override
	public String toString() {
		return "Module [moduleId=" + moduleId + ", moduleName=" + moduleName + ", pModuleId=" + pModuleId
				+ ", pModuleName=" + pModuleName + ", isValid=" + isValid + ", moduleDesc=" + moduleDesc + "]";
	}
	
}
