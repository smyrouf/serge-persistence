package com.serge.persistence;

import static org.junit.Assert.*;

import com.serge.persistence.model.test.Entity;
import com.serge.persistence.model.test.EntityDao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations="/ProjectStrategyTest-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DaoSupportTest {

	@Test
	public void testPersist() {
		EntityDao entityDao = new EntityDao();
		Entity entityPersist = entityDao.persist(new Entity());
		assertNotNull(entityPersist.getId());
	}
	
	@Test
	public void testdelete() {
		EntityDao entityDao = new EntityDao();
		Entity entityPersist = entityDao.persist(new Entity());
	}
}
