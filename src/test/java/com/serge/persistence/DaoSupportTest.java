package com.serge.persistence;

import static org.junit.Assert.*;
import com.serge.persistence.model.test.EntityDao;
import com.serge.persistence.model.test.EntityTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations="/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DaoSupportTest {

	@Autowired
	private EntityDao entityDao;
	
	@Test
	public void testPersist() {
		EntityTest entityPersist = entityDao.persist(new EntityTest("essai"));
		assertNotNull(entityPersist.getId());
	}
	
	@Test
	public void testdelete() {
		EntityTest entityPersist = entityDao.persist(new EntityTest("essai"));
		entityDao.delete(entityPersist);
		
	}
}
