package com.cache.hazelcast.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.cache.hazelcast.dao.ItemDao;
import com.cache.hazelcast.model.Item;

@Repository
public class ItemDaoImpl extends JdbcDaoSupport implements ItemDao{

	/*@Autowired
    JdbcTitemlate titemlate;*/
	
	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	
	private static Logger log = LoggerFactory.getLogger(ItemDaoImpl.class);
	
	@Override
	public void insertItem(Item cus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertItems(List<Item> Items) {
		// TODO Auto-generated method stub
		
	}

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
		String sql = "SELECT * FROM Item WHERE id = ?";
		return (Item) getJdbcTemplate().queryForObject(sql, new Object[] { itemId }, new RowMapper<Item>() {
			@Override
			public Item mapRow(ResultSet row, int rwNumber) throws SQLException {
				Item item = new Item();
				item.setId(row.getInt("id"));
				item.setName(row.getString("name"));
				item.setCategory(row.getString("category"));
				return item;
			}
		});
	}

}
