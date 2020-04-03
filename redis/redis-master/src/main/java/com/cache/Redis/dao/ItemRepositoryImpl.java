package com.cache.Redis.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.cache.Redis.model.Item;

@Repository
public class ItemRepositoryImpl extends JdbcDaoSupport implements ItemRepository {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	private static Logger log = LoggerFactory.getLogger(ItemRepositoryImpl.class);

	private static final String REDIS_LIST_KEY = "ProgrammerList";

	private static final String REDIS_SET_KEY = "ProgrammerSet";

	@Override
	public List<Item> getAllItems() {
		log.info("Inside the dao");
		String sql = "SELECT * FROM Item";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

		List<Item> result = new ArrayList<Item>();
		for (Map<String, Object> row : rows) {
			Item item = new Item();
			item.setId((int) row.get("id"));
			item.setName((String) row.get("name"));
			item.setCategory((String) row.get("category"));
			result.add(item);
		}

		return result;
	}

	@Override
	public Item getItemById(int itemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setItemAsString(String idKey, String Item) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getItemAsString(String idKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addToItemList(Item Item) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Item> getItemListMembers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getItemListCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addToItemSet(Item... item) {
		redisTemplate.opsForSet().add(REDIS_SET_KEY, item);

	}

	@Override
	public Set<Item> getItemSetMembers() {
		return (Set) redisTemplate.opsForSet().members(REDIS_SET_KEY);
	}

	@Override
	public boolean isItemSetMember(Item item) {
		return redisTemplate.opsForSet().isMember(REDIS_SET_KEY, item);
	}

	@Override
	public void deleteString(String idKey) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllList() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllSet() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addFakeItemSet() {
		// TODO Auto-generated method stub

	}

}
