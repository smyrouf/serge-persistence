package com.serge.persistence;

import com.serge.persistence.model.test.Entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations="/ProjectStrategyTest-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DaoSupportTest {

	@Test
	public void testCreate() {
		Entity entity = new Entity();
		
	}
}
