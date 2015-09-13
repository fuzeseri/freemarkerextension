package com.glueball.rapidminer.report.freemarker;

import com.glueball.rapidminer.report.freemarker.util.ColumnType;
import com.rapidminer.example.Attribute;
import com.rapidminer.example.Example;

/**
 * @author karesz
 *
 */
public final class Cell {

	/**
	 * 
	 */
	private final Example ex;

	/**
	 * 
	 */
	private final Attribute attr;

	/**
	 * @param example
	 * @param attribute
	 */
	public Cell(final Example example, final Attribute attribute) {

		this.ex = example;
		this.attr = attribute;
	}

	/**
	 * @return the colName
	 */
	public String getColName() {

		return attr.getName();
	}

	/**
	 * @return the type
	 */
	public String getType() {

		return ColumnType.getType(attr);
	}

	/**
	 * @return the value
	 */
	public String getValue() {

		return ex.getValueAsString(attr);
	}

}
