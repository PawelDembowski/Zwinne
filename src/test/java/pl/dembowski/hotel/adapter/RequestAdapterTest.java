package pl.dembowski.hotel.adapter;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;

import pl.dembowski.hotel.dto.GoscDto;

import static org.mockito.ArgumentMatchers.*;

import static org.mockito.Mockito.*;

public class RequestAdapterTest {


	@Test
	public void testToGosc() throws Exception {

		String pesel = "12345123451";
		String imie = "Jan";
		String nazwisko = "Kowalski";
		String data = "23-11-1990";
		HttpServletRequest request = buildRequestMock(pesel, imie, nazwisko, data);
		
		GoscDto gosc = RequestAdapter.toGosc(request);
		
		assertEquals(pesel, gosc.getPesel());
		assertEquals(imie, gosc.getImie());
		assertEquals(nazwisko, gosc.getNazwisko());
		assertEquals(buildDate(1990, 11, 23), gosc.getData());
	}
	
	private Date buildDate(int year, int month, int date) {
		Calendar c = Calendar.getInstance();
		// month is zero based (0-11)
		c.set(year, month-1, date, 0, 0, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}
	
	private HttpServletRequest buildRequestMock(String pesel, String imie, String nazwisko, String data)
	{
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getParameter(eq("pesel"))).thenReturn(pesel);
		when(request.getParameter(eq("imie"))).thenReturn(imie);
		when(request.getParameter(eq("nazwisko"))).thenReturn(nazwisko);
		when(request.getParameter(eq("data"))).thenReturn(data);
		return request;
	}

}
