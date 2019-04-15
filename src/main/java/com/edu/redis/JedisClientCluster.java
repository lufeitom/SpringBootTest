package com.edu.redis;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisCluster;

public class JedisClientCluster implements JedisClient {

	@Autowired
	private JedisCluster jedisCluster;
	
	@Override
	public String get(String key) {
		String result = null;
		try {
			result = jedisCluster.get(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(jedisCluster);
		}
		return result;
	}

	@Override
	public String set(String key, String value) {
		String result = null;
		try {
			result = jedisCluster.set(key, value);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(jedisCluster);
		}
		return result;
	}

	@Override
	public String hget(String hkey, String key) {
		String result = null;
		try {
			result = jedisCluster.hget(hkey, key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(jedisCluster);
		}
		return result;
	}

	@Override
	public long hset(String hkey, String key, String value) {
		Long result = null;
		try {
			result = jedisCluster.hset(hkey, key, value);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(jedisCluster);
		}
		return result;
	}

	@Override
	public long incr(String key) {
		Long result = null;
		try {
			result = jedisCluster.incr(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(jedisCluster);
		}
		return result;
	}

	@Override
	public long expire(String key, int second) {
		Long result = null;
		try {
			result = jedisCluster.expire(key, second);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(jedisCluster);
		}
		return result;
	}

	@Override
	public long ttl(String key) {
		Long result = null;
		try {
			result = jedisCluster.ttl(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(jedisCluster);
		}
		return result;
	}

	@Override
	public long del(String key) {
		Long result = null;
		try {
			result = jedisCluster.del(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(jedisCluster);
		}
		return result;
	}

	@Override
	public long hdel(String hkey, String key) {
		Long result = null;
		try {
			result = jedisCluster.hdel(hkey, key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(jedisCluster);
		}
		return result;
	}
	private static void close(JedisCluster jedisCluster) {
		try {
			if (jedisCluster != null) {
				jedisCluster.close();
			}
		} catch (Exception e) {
			jedisCluster.quit();
		}
	}
}
