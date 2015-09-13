package com.glueball.rapidminer.report.freemarker.util;

import com.rapidminer.example.Attribute;

public final class ColumnType {

	public static String getType(final Attribute attr) {

		if (attr.isNominal()) {

			return "TEXT";
		}
		if (attr.isDateTime()) {

			return "DATETIME";
		}
		if (attr.isNumerical()) {

			return "NUMBER";
		}
		return "TEXT";
	}
}
