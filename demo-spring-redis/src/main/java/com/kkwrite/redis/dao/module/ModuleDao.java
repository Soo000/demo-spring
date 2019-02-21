package com.kkwrite.redis.dao.module;

import com.kkwrite.redis.pojo.module.Module;

public interface ModuleDao {

	/** 
     */  
    void save(Module module);
    
    /**
     * 
     * @param module
     */
    void saveModule(Module module);
  
    /** 
     * @param id
     * @return 
     */  
    Module read(int id);
    
    /**
     * 
     * @param id
     * @return
     */
    Module readModule(int id);
  
    /** 
     * @param id 
     */  
    void delete(int id);
    
}
