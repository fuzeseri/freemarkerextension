/**
 * RapidMiner GmbH
 *
 * Copyright (C) 2015-2015 by RapidMiner GmbH and the contributors
 *
 * Complete list of developers available at our web site:
 *
 *      www.rapidminer.com
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 */
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
	 * The RapidMiner ExampleSet.
	 */
	private final Example ex;

	/**
	 * the RapidMiner Attribute.
	 */
	private final Attribute attr;

	/**
	 * Constructor.
	 *
	 * @param example
	 *            the RapidMiner Example.
	 * @param attribute
	 *            the RapidMiner Attribute.
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
