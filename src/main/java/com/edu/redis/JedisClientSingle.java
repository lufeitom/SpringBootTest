package com.edu.redis;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisClientSingle implements JedisClient{
	
	@Autowired
	private JedisPool jedisPool;
	
	@Override
	public String get(String key) {
		String string = null;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			string = jedis.get(key);
		} catch (Exception e) {
			jedisPool.close();
			e.printStackTrace();
		} finally {
			close(jedis);
		}
		return string;
	}

	@Override
	public String set(String key, String value) {
		Jedis jedis = null;
		String string = null;
		try {
			jedis = jedisPool.getResource();
			string = jedis.set(key, value);
		}catch (Exception e){
			jedisPool.close();
			e.printStackTrace();
		}finally {
			close(jedis);
		}
		return string;
	}

	@Override
	public String hget(String hkey, String key) {
		Jedis jedis = null;
		String string = null;
		try {
			jedis = jedisPool.getResource();
			string = jedis.hget(hkey, key);
		}catch (Exception e){
			jedisPool.close();
			e.printStackTrace();
		}finally {
			close(jedis);
		}
		return string;
	}

	@Override
	public long hset(String hkey, String key, String value) {
		Jedis jedis = null;
		Long result = null;
		try {
			jedis = jedisPool.getResource();
			result = jedis.hset(hkey, key, value);
		}catch (Exception e){
			jedisPool.close();
			e.printStackTrace();
		}finally {
			close(jedis);
		}
		return result;
	}

	@Override
	public long incr(String key) {
		Jedis jedis = null;
		Long result = null;
		try {
			jedis = jedisPool.getResource();
			result = jedis.incr(key);
		}catch (Exception e){
			jedisPool.close();
			e.printStackTrace();
		}finally {
			close(jedis);
		}
		return result;
	}

	@Override
	public long expire(String key, int second) {
		Jedis jedis = null;
		Long result = null;
		try {
			jedis = jedisPool.getResource();
			result = jedis.expire(key, second);
		}catch (Exception e){
			jedisPool.close();
			e.printStackTrace();
		}finally {
			close(jedis);
		}
		return result;
	}

	@Override
	public long ttl(String key) {
		Jedis jedis = null;
		Long result = null;
		try {
			jedis = jedisPool.getResource();
			result = jedis.ttl(key);
		}catch (Exception e){
			jedisPool.close();
			e.printStackTrace();
		}finally {
			close(jedis);
		}
		return result;
	}

	@Override
	public long del(String key) {
		Jedis jedis = null;
		Long result = null;
		try {
			jedis = jedisPool.getResource();
			result = jedis.del(key);
		}catch (Exception e){
			jedisPool.close();
			e.printStackTrace();
		}finally {
			close(jedis);
		}
		return result;
	}

	@Override
	public long hdel(String hkey, String key) {
		Jedis jedis = null;
		Long result = null;
		try {
			jedis = jedisPool.getResource();
			result = jedis.hdel(key);
		}catch (Exception e){
			jedisPool.close();
			e.printStackTrace();
		}finally {
			close(jedis);
		}
		return result;
	}

	private static void close(Jedis jedis) {
		try {
			if (jedis != null) {
				jedis.close();
			}
		} catch (Exception e) {
			if (jedis.isConnected()) {
				jedis.quit();
				jedis.disconnect();
			}
		}
	}
}
