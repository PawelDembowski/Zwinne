package pl.dembowski.hotel.converter;

import java.util.ArrayList;
import java.util.List;

import pl.dembowski.hotel.domain.Gosc;
import pl.dembowski.hotel.dto.GoscDto;

public class GoscConverter {

	public Gosc fromDto(GoscDto src) {
		if (src == null) {
			return null;
		}
		Gosc result = new Gosc();
		result.setPesel(src.getPesel());
		result.setImie(src.getImie());
		result.setNazwisko(src.getNazwisko());
		result.setData(src.getData());
		return result;
	}

	public GoscDto toDto(Gosc src) {
		if (src == null) {
			return null;
		}
		GoscDto result = new GoscDto();
		result.setPesel(src.getPesel());
		result.setImie(src.getImie());
		result.setNazwisko(src.getNazwisko());
		result.setData(src.getData());
		return result;
	}

	public List<GoscDto> toDto(List<Gosc> src) {
		if (src == null) {
			return null;
		}

		List<GoscDto> result = new ArrayList<>();
		for (Gosc entity : src) {
			result.add(toDto(entity));
		}
		return result;
	}
	
	public void apply (GoscDto src, Gosc dest)
	{
		dest.setImie(src.getImie());
		dest.setNazwisko(src.getNazwisko());
		dest.setData(src.getData());
	}

}
