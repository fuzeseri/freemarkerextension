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
package com.glueball.rapidminer.report.freemarker.util;

import java.util.HashMap;
import java.util.Map;

import com.rapidminer.example.Attribute;

/**
 * Helper class to map the RapidMiner column types to the Report column types.
 *
 * @author karesz
 */
public final class ReportColumnType {

	/**
	 * Represents text data.
	 */
	public static final String TEXT = "TEXT";

	/**
	 * Represents floating point numbers.
	 */
	public static final String REAL = "REAL";

	/**
	 * Represents integers.
	 */
	public static final String INTEGER = "INTEGER";

	/**
	 * Represents date.
	 */
	public static final String DATE = "DATE";

	/**
	 * Map to provide the mapping between the RpaidMiner data types and the
	 * Freemarker operator data types.
	 */
	private static final Map<Integer, String> TYPE_MAPPING = new HashMap<Integer, String>();

	static {

		// 0 "attribute_value"
		// 1 "nominal"
		// 2 "numeric"
		// 3 "integer"
		// 4 "real"
		// 5 "text"
		// 6 "binominal"
		// 7 "polynominal"
		// 8 "file_path"
		// 9 "date_time"
		// 10 "date"
		// 11 "time"

		TYPE_MAPPING.put(0, TEXT);
		TYPE_MAPPING.put(1, TEXT);
		TYPE_MAPPING.put(2, REAL);
		TYPE_MAPPING.put(3, INTEGER);
		TYPE_MAPPING.put(4, REAL);
		TYPE_MAPPING.put(5, TEXT);
		TYPE_MAPPING.put(6, TEXT);
		TYPE_MAPPING.put(7, TEXT);
		TYPE_MAPPING.put(8, TEXT);
		TYPE_MAPPING.put(9, DATE);
		TYPE_MAPPING.put(10, DATE);
		TYPE_MAPPING.put(11, DATE);
	}

	/**
	 * Hidden constructor.
	 */
	private ReportColumnType() {
	}

	/**
	 * Helper method to map the RapidMiner column types to the Report column
	 * types.
	 *
	 * @param attr
	 *            the RapidMiner attribute.
	 * @return Name of the report column type.
	 */
	public static String getType(final Attribute attr) {

		return TYPE_MAPPING.get(attr.getValueType());
	}
}
