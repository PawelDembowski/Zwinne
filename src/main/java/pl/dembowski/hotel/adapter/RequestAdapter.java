package pl.dembowski.hotel.adapter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import pl.dembowski.hotel.domain.Gosc;
import pl.dembowski.hotel.dto.GoscDto;

public class RequestAdapter {

	private static final String DATE_PATTERN = "dd-MM-yyyy";
	
	public static GoscDto toGosc(HttpServletRequest request) throws ParseException
	{	
		GoscDto gosc = new GoscDto();
		gosc.setPesel(request.getParameter("pesel"));
		gosc.setImie(request.getParameter("imie"));
		gosc.setNazwisko(request.getParameter("nazwisko"));
		gosc.setData(formatDate(request.getParameter("data")));
		return gosc;
	}
	
	private static Date formatDate (String val) throws ParseException
	{
		if (val == null || val.length() == 0)
		{
			return null;
		}

		DateFormat format = new SimpleDateFormat(DATE_PATTERN);
		return format.parse(val);
		
	}
}
