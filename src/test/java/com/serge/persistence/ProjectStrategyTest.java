/*
 * Copyright 2006-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.serge.persistence;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import com.serge.persistence.model.ProjectStrategy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class ProjectStrategyTest {
	
	@Autowired
	private ProjectStrategy projectStrategy;

	@Test
	public void testSimpleProperties() throws Exception {
		assertNotNull(projectStrategy);
	}
	
	@Test
	public void testNameDatabase() throws Exception {
		assertNotNull(projectStrategy);
		assertEquals("PROJECT_ESSAI",this.projectStrategy.classToTableName("essai"));
	}
	
	
	@Test
	public void testColumnName() throws Exception {
		assertNotNull(projectStrategy);
		assertEquals("COLUMN",this.projectStrategy.columnName("column"));
	}
	
	@Test
	public void testPropertyToColumnName() throws Exception {
		assertNotNull(projectStrategy);
		this.projectStrategy.classToTableName("essai");
		assertEquals("PROPERTY",this.projectStrategy.propertyToColumnName("property"));
	}
	
	@Test
	public void testPropertyToColumnNameId() throws Exception {
		assertNotNull(projectStrategy);
		this.projectStrategy.classToTableName("essai");
		assertEquals("ESSAI_ID",this.projectStrategy.propertyToColumnName("ID"));
	}
}
