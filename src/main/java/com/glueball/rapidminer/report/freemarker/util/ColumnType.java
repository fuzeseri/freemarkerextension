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

import com.rapidminer.example.Attribute;
import com.rapidminer.tools.Ontology;

/**
 * Helper class to map the RapidMiner column types to the Report column types.
 *
 * @author karesz
 */
public final class ColumnType {

	/**
	 * Hidden constructor.
	 */
	private ColumnType() {
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

		return Ontology.VALUE_TYPE_NAMES[attr.getValueType()];
	}
}
