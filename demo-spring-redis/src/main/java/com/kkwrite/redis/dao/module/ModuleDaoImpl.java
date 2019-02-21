package com.kkwrite.redis.dao.module;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.kkwrite.redis.pojo.module.Module;

@Repository("moduleDao")
public class ModuleDaoImpl implements ModuleDao {
	
	@Autowired
	private RedisTemplate redisTemplate;

	@Override
	public void save(final Module module) {
		redisTemplate.execute(new RedisCallback<Object>() {

			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {

				/**
				 * 传入参数，需要final标识，禁止方法内修改。
				 * 调用RedisConnection的set方法实现Redis的SET命令。
				 * 不管是Key，还是Value都需要进行Serialize。
				 * 序列化操作，最好使用RedisTemplate提供的Serializer来完成。
				 */
				connection.set(redisTemplate.getStringSerializer().serialize("module.id." + module.getModuleId()),
						redisTemplate.getStringSerializer().serialize(module.getModuleName()));
				
				return null;
			}
			
		});
	}
	
	/**
	 * 需要确认 hash 操作是否这样
	 */
	@Override
	public void saveModule(final Module module) {
		redisTemplate.execute(new RedisCallback<Object> () {

			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				
				byte[] key = redisTemplate.getStringSerializer().serialize("module.id." + module.getModuleId());
				
				BoundHashOperations<Serializable, byte[], byte[]> boundHashOperations = redisTemplate.boundHashOps(key);
				
				byte[] bKey = redisTemplate.getStringSerializer().serialize("module.name");
				byte[] bValue = redisTemplate.getStringSerializer().serialize(module.getModuleName());
				boundHashOperations.put(bKey, bValue);
				
				bKey = redisTemplate.getStringSerializer().serialize("module.pModuleId");
				bValue = redisTemplate.getValueSerializer().serialize(module.getpModuleId());
				boundHashOperations.put(bKey, bValue);
				
				bKey = redisTemplate.getStringSerializer().serialize("module.pModuleName");
				bValue = redisTemplate.getValueSerializer().serialize(module.getpModuleName());
				boundHashOperations.put(bKey, bValue);
				
				bKey = redisTemplate.getStringSerializer().serialize("module.isValid");
				bValue = redisTemplate.getValueSerializer().serialize(module.getIsValid());
				boundHashOperations.put(bKey, bValue);
				
				bKey = redisTemplate.getStringSerializer().serialize("module.moduleDesc");
				bValue = redisTemplate.getValueSerializer().serialize(module.getModuleDesc());
				boundHashOperations.put(bKey, bValue);
				
				connection.hMSet(key, boundHashOperations.entries());
				
				return null;
			}
			
		});
	}

	@Override
	public Module read(final int id) {
		return (Module) redisTemplate.execute(new RedisCallback<Module>() {

			/**
			 * 记得使用泛型，如RedisCallback<User>()
			 * 使用同一的序列化/反序列化Serializer
			 * 建议使用connection.exists(key)判别键值是否存在，避免无用功
			 */
			@Override
			public Module doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] key = redisTemplate.getStringSerializer().serialize("module.id." + id); 
				if (connection.exists(key)) {  
	                byte[] value = connection.get(key);  
	                String name = (String) redisTemplate.getStringSerializer().deserialize(value);
	                
	                Module module = new Module();  
	                module.setModuleId(id);
	                module.setModuleName(name);
	                return module;  
	            }  
				return null;
			}

		});
	}
	
	/**
	 * 需要确认读取 Hash 是否这样
	 */
	@Override
	public Module readModule(final int id) {
		return (Module) redisTemplate.execute(new RedisCallback<Module>() {

			@Override
			public Module doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] key = redisTemplate.getStringSerializer().serialize("module.id." + id);
				if (connection.exists(key)) {
					List<byte[]> value = connection.hMGet(key, 
							redisTemplate.getDefaultSerializer().serialize("module.name"),
							redisTemplate.getStringSerializer().serialize("module.pModuleId"),
							redisTemplate.getStringSerializer().serialize("module.pModuleName"),
							redisTemplate.getStringSerializer().serialize("module.pModuleId"),
							redisTemplate.getStringSerializer().serialize("module.pModuleName"),
							redisTemplate.getStringSerializer().serialize("module.isValid"),
							redisTemplate.getStringSerializer().serialize("module.moduleDesc"));
					
					System.out.println(redisTemplate.getStringSerializer().deserialize(value.get(0)));
					System.out.println(redisTemplate.getStringSerializer().deserialize(value.get(1)));
					System.out.println(redisTemplate.getStringSerializer().deserialize(value.get(2)));
					System.out.println(redisTemplate.getStringSerializer().deserialize(value.get(3)));
					System.out.println(redisTemplate.getStringSerializer().deserialize(value.get(4)));
					System.out.println(redisTemplate.getStringSerializer().deserialize(value.get(5)));
					System.out.println(redisTemplate.getStringSerializer().deserialize(value.get(6)));
					/*Module module = new Module();
					module.setModuleId(id);
					module.setModuleName((String) redisTemplate.getStringSerializer().deserialize(value.get(0)));
					module.setpModuleId(Integer.parseInt(redisTemplate.getStringSerializer().deserialize(value.get(1)).toString()));
					module.setpModuleName((String) redisTemplate.getStringSerializer().deserialize(value.get(2)));
					module.setIsValid(Integer.parseInt(redisTemplate.getStringSerializer().deserialize(value.get(3)).toString()));
					module.setModuleDesc((String) redisTemplate.getStringSerializer().deserialize(value.get(4)));
					return module;*/
				}
				return null;
			}
			
		});
	}

	@Override
	public void delete(final int id) {
		redisTemplate.execute(new RedisCallback<Object>() {

			@Override
			public Object doInRedis(RedisConnection connect) throws DataAccessException {
				connect.del(redisTemplate.getStringSerializer().serialize("module.id." + id));
				return null;
			}
			
		});
	}

}
