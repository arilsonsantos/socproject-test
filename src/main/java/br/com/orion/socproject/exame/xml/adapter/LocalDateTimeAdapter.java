package br.com.orion.socproject.exame.xml.adapter;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.commons.lang3.StringUtils;

import br.com.orion.socproject.utils.DateUtils;


public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

	@Override
	public String marshal(LocalDateTime dateTime) {
		return DateUtils.format(dateTime, DateUtils.DATE_PATTERN_YYYYMMDD);
	}

	@Override
	public LocalDateTime unmarshal(String str) {
		if (StringUtils.isBlank(str) || str.length() != 8 || !StringUtils.isNumeric(str) || Integer.parseInt(str) == 0) {
			return null;
		}

		return DateUtils.parseLocalDateTime(str);
	}

}
