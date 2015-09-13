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
package com.glueball.rapidminer.report;

import java.io.OutputStream;

import com.rapidminer.example.ExampleSet;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.io.AbstractStreamWriter;

/**
 * Freemarker template applyer operator for RapidMiner.
 *
 * @author karesz
 *
 */
public class FreemarkerStreamWriter extends AbstractStreamWriter {

	public FreemarkerStreamWriter(final OperatorDescription description) {

		super(description);
	}

	@Override
	protected void writeStream(final ExampleSet exampleSet,
			final OutputStream outputStream) throws OperatorException {

	}

	@Override
	protected String getFileParameterName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getFileExtensions() {
		// TODO Auto-generated method stub
		return null;
	}

}
