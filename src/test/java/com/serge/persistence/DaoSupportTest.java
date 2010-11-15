package com.serge.persistence;

import static org.junit.Assert.*;
import com.serge.persistence.model.test.EntityDao;
import com.serge.persistence.model.test.EntityTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations="/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback=true)
@Transactional
public class DaoSupportTest {

	@Autowired
	private EntityDao entityDao;
	
	@Test
	public void testPersist() {
		EntityTest entityPersist = this.entityDao.persist(new EntityTest("essai"));
		assertNotNull(entityPersist.getId());
	}
	
	@Test
	public void testPersistTransactional() {
		EntityTest entityPersist = this.entityDao.persist(new EntityTest("essai"));
		this.entityDao.delete(entityPersist);
		
	}
	
	@Test
	public void testdelete() {
		EntityTest entityPersist = this.entityDao.persist(new EntityTest("essai"));
		this.entityDao.delete(entityPersist);
		
	}
}
