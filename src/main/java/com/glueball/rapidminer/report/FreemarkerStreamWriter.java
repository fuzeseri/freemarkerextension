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

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.glueball.rapidminer.report.freemarker.ReportColumns;
import com.glueball.rapidminer.report.freemarker.ReportContext;
import com.glueball.rapidminer.report.freemarker.ReportRows;
import com.rapidminer.example.ExampleSet;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.UserError;
import com.rapidminer.operator.io.AbstractStreamWriter;
import com.rapidminer.parameter.ParameterType;
import com.rapidminer.parameter.ParameterTypeBoolean;
import com.rapidminer.parameter.ParameterTypeDateFormat;
import com.rapidminer.parameter.ParameterTypeDirectory;
import com.rapidminer.parameter.ParameterTypeFile;
import com.rapidminer.parameter.ParameterTypeString;
import com.rapidminer.parameter.UndefinedParameterError;

import freemarker.cache.FileTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * FreeMarker template applier operator for RapidMiner.
 *
 * @author karesz
 *
 */
public class FreemarkerStreamWriter extends AbstractStreamWriter {

	/** The parameter name for &quot;Implementation of the condition.&quot; */
	public static final String PARAMETER_CONDITION_CLASS = "condition_class";

	/**
	 * The name of the output file name parameter.
	 */
	private static final String FILE_PARAMETER_NAME = "Output file";

	/**
	 * Most usual output formats.
	 */
	private static final String[] FILE_EXTENSIONS = new String[] { "csv",
			"html", "xml" };

	/**
	 * The title of the report.
	 */
	private static final String REPORT_TITLE = "title";

	/**
	 * The columns of the table.
	 */
	private static final String REPORT_COLUMNS = "columns";

	/**
	 * The rows pf the table.
	 */
	private static final String REPORT_ROWS = "rows";

	/**
	 * The name of the report table.
	 */
	private static final String REPORT_TABLE_NAME = "tablename";

	/**
	 * The name of the report title parameter.
	 */
	private static final String PARAMETER_REPORT_TITLE = "Report title";

	/**
	 * The name of the table name parameter.
	 */
	private static final String PARAMETER_TABLE_NAME = "Table name";

	/**
	 * The path of the main FreeMarker template file.
	 */
	private static final String PARAMETER_TEMPLATE_DIR = "Template dir";

	/**
	 * The path of the main FreeMarker template file.
	 */
	private static final String PARAMETER_TEMPLATE_MAIN = "Main template";

	/**
	 * The path of the main FreeMarker template file.
	 */
	private static final String PARAMETER_TEMPLATE_DEFAULT = "main.ftl";

	/**
	 * The text to replace the null values with in the output.
	 */
	private static final String PARAMETER_NULL_VALUE = "Null value";

	/**
	 * Quote all nominal fields.
	 */
	private static final String PARAMETER_QUOTE_NOMINAL = "Quote nominal";

	/**
	 * Quote all numerical fields.
	 */
	private static final String PARAMETER_QUOTE_NUMERICAL = "Quote numerical";

	/**
	 * Quote all date time fields.
	 */
	private static final String PARAMETER_QUOTE_DATETIME = "Quote datetime";

	/**
	 * Quote string for the nominal fields.
	 */
	private static final String PARAMETER_QUOTE = "Quote string";

	/**
	 * Default date format for the output.
	 */
	public static final String PARAMETER_DATE_FORMAT = "Date format";

	/**
	 * Format numbers by default in the output.
	 */
	public static final String PARAMETER_FORMAT_NUMBERS = "Format numbers";

	/**
	 * @param description
	 *            the operator description.
	 */
	public FreemarkerStreamWriter(final OperatorDescription description) {

		super(description);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rapidminer.operator.io.AbstractStreamWriter#writeStream(com.rapidminer
	 * .example.ExampleSet, java.io.OutputStream)
	 */
	@Override
	protected void writeStream(final ExampleSet exampleSet,
			final OutputStream outputStream) throws OperatorException {

		final String reportName = getParameterAsString(PARAMETER_REPORT_TITLE);

		final String reportTableName = getParameterAsString(PARAMETER_TABLE_NAME);

		final Map<String, Object> report = new HashMap<String, Object>();

		report.put(REPORT_TITLE, reportName);

		report.put(REPORT_COLUMNS, ReportColumns.getColumns(exampleSet
				.getAttributes().allAttributes()));

		final ReportContext context = getContext();

		report.put(REPORT_ROWS, ReportRows.getRows(exampleSet, context));

		report.put(REPORT_TABLE_NAME, reportTableName);

		try (final Writer writer = new OutputStreamWriter(outputStream)) {

			final Configuration configuration = new Configuration(
					Configuration.VERSION_2_3_23);

			final TemplateLoader templateLoader = new FileTemplateLoader(
					new File(getParameterAsString(PARAMETER_TEMPLATE_DIR)));

			configuration.setTemplateLoader(templateLoader);

			final Template template = configuration
					.getTemplate(getParameterAsString(PARAMETER_TEMPLATE_MAIN));

			template.process(report, writer);

		} catch (final IOException e) {

			logError(e.getMessage());
			throw new UserError(this, e, "Template not found");

		} catch (final TemplateException e) {

			logError(e.getMessage());
			throw new UserError(this, e, "Template error");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rapidminer.operator.io.AbstractStreamWriter#getFileParameterName()
	 */
	@Override
	protected String getFileParameterName() {

		return FILE_PARAMETER_NAME;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rapidminer.operator.io.AbstractStreamWriter#getFileExtensions()
	 */
	@Override
	protected String[] getFileExtensions() {

		return FILE_EXTENSIONS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rapidminer.operator.io.AbstractWriter#getParameterTypes()
	 */
	@Override
	public final List<ParameterType> getParameterTypes() {

		final List<ParameterType> params = new ArrayList<ParameterType>();

		params.addAll(super.getParameterTypes());

		params.add(makeFileParameterType());

		params.add(new ParameterTypeString(PARAMETER_REPORT_TITLE,
				"The title of the report", false));

		params.add(new ParameterTypeString(PARAMETER_TABLE_NAME,
				"The name of the report table", false));

		params.add(new ParameterTypeDirectory(PARAMETER_TEMPLATE_DIR,
				"The freemarker template directory", false));

		params.add(new ParameterTypeFile(PARAMETER_TEMPLATE_MAIN,
				"The freemarker main template file", "ftl",
				PARAMETER_TEMPLATE_DEFAULT));

		params.add(new ParameterTypeString(PARAMETER_NULL_VALUE,
				"The value to replace the null values with in the output", "",
				false));

		params.add(new ParameterTypeBoolean(PARAMETER_QUOTE_NOMINAL,
				"Quote nominal values", false));

		params.add(new ParameterTypeBoolean(PARAMETER_QUOTE_NUMERICAL,
				"Quote numerical values", false));

		params.add(new ParameterTypeBoolean(PARAMETER_QUOTE_DATETIME,
				"Quote datetime values", false));

		params.add(new ParameterTypeString(PARAMETER_QUOTE,
				"The string to quote the values with", "\"", false));

		params.add(new ParameterTypeDateFormat(PARAMETER_DATE_FORMAT,
				"Default date format in the output", false));

		params.add(new ParameterTypeBoolean(PARAMETER_FORMAT_NUMBERS,
				"Format numbers by default in the output.", false));

		return params;
	}

	/**
	 * Initialize the report context based on the parameters.
	 *
	 * @return the report context.
	 * @throws UndefinedParameterError
	 *             if parameter has not defined.
	 */
	private final ReportContext getContext() throws UndefinedParameterError {

		final ReportContext context = new ReportContext();
		context.setNullValue(getParameterAsString(PARAMETER_NULL_VALUE));

		if (getParameterAsBoolean(PARAMETER_QUOTE_NOMINAL)) {

			context.setQuoteNominal(true);
		}

		if (getParameterAsBoolean(PARAMETER_QUOTE_NUMERICAL)) {

			context.setQuoteNumerical(true);
		}

		if (getParameterAsBoolean(PARAMETER_QUOTE_DATETIME)) {

			context.setQuoteDateTime(true);
		}
		context.setQuoteStr(getParameterAsString(PARAMETER_QUOTE));

		if (!StringUtils.isEmpty(getParameterAsString(PARAMETER_DATE_FORMAT))) {

			context.setDateFormat(new SimpleDateFormat(
					getParameterAsString(PARAMETER_DATE_FORMAT)));
		}

		context.setFormatNumbers(getParameterAsBoolean(PARAMETER_FORMAT_NUMBERS));

		return context;
	}
}
