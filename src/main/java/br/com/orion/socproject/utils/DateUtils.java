package br.com.orion.socproject.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

public final class DateUtils extends org.apache.commons.lang3.time.DateUtils {

	public static final String DEFAULT_DATE_PATTERN = "dd/MM/yyyy";
	public static final String DEFAULT_TIMESTAMP_PATTERN = "dd/MM/yyyy HH:mm:ss";
	public static final String DATE_PATTERN_YYYYMMDD = "yyyyMMdd";

	private DateUtils() {
		super();
	}

	public static LocalDate toLocalDate(Date date) {
		if (date == null) {
			return null;
		}

		if (date instanceof java.sql.Date) {
			return ((java.sql.Date) date).toLocalDate();
		}

		return LocalDateTime.ofInstant(date.toInstant(), ZoneOffset.systemDefault()).toLocalDate();
	}

	public static LocalDateTime toLocalDateTime(Date date) {
		return LocalDateTime.ofInstant(date.toInstant(), ZoneOffset.systemDefault());
	}

	public static Date toDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay().atZone(ZoneOffset.systemDefault()).toInstant());
	}

	public static Date toDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneOffset.systemDefault()).toInstant());
	}


	public static String format(LocalDate localDate) {
		return format(localDate, DateUtils.DEFAULT_DATE_PATTERN);
	}

	public static String format(LocalDate localDate, String pattern) {
		if (localDate == null) {
			return null;
		}

		return localDate.format(DateTimeFormatter.ofPattern(pattern));
	}

	public static String format(YearMonth yearMonth, String pattern) {
		if (yearMonth == null) {
			return null;
		}

		return yearMonth.format(DateTimeFormatter.ofPattern(pattern));
	}

	public static String format(LocalDateTime localDateTime) {
		return format(localDateTime, DateUtils.DEFAULT_TIMESTAMP_PATTERN);
	}

	public static String format(LocalDateTime localDateTime, String pattern) {
		if (localDateTime == null) {
			return null;
		}

		return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
	}

	public static LocalDate parseLocalDate(final String source) {
		return parseLocalDate(source, DEFAULT_DATE_PATTERN);
	}

	public static LocalDate parseLocalDate(final String source, final String pattern) {
		return parseLocalDate(source, pattern, ResolverStyle.SMART);
	}

	public static LocalDate parseLocalDate(final String source, final String pattern, final ResolverStyle resolverStyle) {
		if (StringUtils.isBlank(source)) {
			return null;
		}

		LocalDate date = LocalDate.parse(source, DateTimeFormatter.ofPattern(pattern).withResolverStyle(resolverStyle));
		return date;
	}

	public static LocalDateTime parseLocalDateTime(final String source) {
		return parseLocalDateTime(source, DEFAULT_TIMESTAMP_PATTERN);
	}

	public static LocalDateTime parseLocalDateTime(final String source, final String pattern) {
		return parseLocalDateTime(source, pattern, ResolverStyle.SMART);
	}

	public static LocalDateTime parseLocalDateTime(final String source, final String pattern, final ResolverStyle resolverStyle) {
		if (StringUtils.isBlank(source)) {
			return null;
		}

		LocalDateTime date = LocalDateTime.parse(source, DateTimeFormatter.ofPattern(pattern).withResolverStyle(resolverStyle));
		return date;
	}


}
