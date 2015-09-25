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
import com.rapidminer.tools.Ontology;

/**
 * Represents a cell of the report table.
 *
 * @author karesz
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
	 * The report contaxt to use.
	 */
	private final ReportContext reportContext;

	/**
	 * Constructor.
	 *
	 * @param example
	 *            the RapidMiner Example.
	 * @param attribute
	 *            the RapidMiner Attribute.
	 * @param context
	 *            the report context use.
	 */
	public Cell(final Example example, final Attribute attribute,
			final ReportContext context) {

		this.ex = example;
		this.attr = attribute;
		this.reportContext = context;
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

		if (Double.isNaN(ex.getValue(attr))
				|| "?".equals(ex.getValueAsString(attr))) {

			return reportContext.getNullValue();
		}

		if (attr.isNominal()) {

			return ex.getValueAsString(attr);
		}
		if (attr.isNumerical()) {

			if (Ontology.ATTRIBUTE_VALUE_TYPE.isA(attr.getValueType(),
					Ontology.REAL)) {

				return String.valueOf(ex.getNumericalValue(attr));
			}
			if (Ontology.ATTRIBUTE_VALUE_TYPE.isA(attr.getValueType(),
					Ontology.INTEGER)) {

				return String.valueOf((long) ex.getNumericalValue(attr));
			}
		}
		if (attr.isDateTime()) {

			return ex.getValueAsString(attr);
		}
		return ex.getValueAsString(attr);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return getValue();
	}
}
