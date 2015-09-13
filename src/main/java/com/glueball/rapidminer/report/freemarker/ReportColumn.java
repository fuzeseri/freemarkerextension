package com.glueball.rapidminer.report.freemarker;

import com.glueball.rapidminer.report.freemarker.util.ColumnType;
import com.rapidminer.example.Attribute;

/**
 * @author karesz
 *
 */
public final class ReportColumn {

	/**
	 * 
	 */
	private final Attribute attr;

	/**
	 * @param attribute
	 */
	public ReportColumn(final Attribute attribute) {

		this.attr = attribute;
	}

	/**
	 * @return the name
	 */
	public String getName() {

		return attr.getName();
	}

	/**
	 * @return the type
	 */
	public String getType() {

		return ColumnType.getType(attr);
	}

}
