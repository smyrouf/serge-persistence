package com.serge.persistence.model;

import org.hibernate.cfg.NamingStrategy;
import org.hibernate.util.StringHelper;


public class ProjectStrategy implements NamingStrategy{
	
	protected String project;
	private String tableName;
	
	public ProjectStrategy() { }
	
	
	/**
	 * @return the project
	 */
	public String getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(String project) {
		this.project = StringHelper.toUpperCase(project);
	}

	
	public String classToTableName(String className) {
		this.tableName = StringHelper.unqualify(className).toUpperCase().toUpperCase();
		return this.project+"_"+StringHelper.unqualify(className).toUpperCase();
	}

	public String columnName(String column) {
		return column.toUpperCase();
	}

	public String propertyToColumnName(String propertyName) {
		if ( propertyName.toUpperCase().equals("ID") ) {
			return this.tableName +"_"+StringHelper.unqualify(propertyName).toUpperCase();
		}
		return StringHelper.unqualify(propertyName).toUpperCase();
	}

	public String propertyToTableName(String className, String propertyName) {
		return null;
	}

	public String tableName(String tableName) {
		return  this.project+"_"+tableName.toUpperCase();
	}

	public String collectionTableName(String arg0, String arg1, String arg2,
			String arg3, String arg4) {
		return null;
	}

	public String foreignKeyColumnName(String arg0, String arg1, String arg2,
			String arg3) {
		return null;
	}

	public String joinKeyColumnName(String arg0, String arg1) {
		return null;
	}

	public String logicalCollectionColumnName(String arg0, String arg1,
			String arg2) {
		return null;
	}

	public String logicalCollectionTableName(String arg0, String arg1,
			String arg2, String arg3) {
		return null;
	}

	public String logicalColumnName(String arg0, String arg1) {
		return null;
	}

}
