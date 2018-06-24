package pl.dembowski.hotel.service;

import java.util.List;

import pl.dembowski.hotel.dao.GoscDao;
import pl.dembowski.hotel.dto.GoscDto;

public class GoscService {

	private final GoscDao goscDao;

	public GoscService() {
		this.goscDao = new GoscDao();
	}

	public GoscDto find(String pesel) {
		return goscDao.find(pesel);
	}

	public List<GoscDto> findAll() {
		return goscDao.findAll();
	}

	public void save(GoscDto gosc) {
		goscDao.save(gosc);
	}

	public void delete(String pesel) {
		goscDao.delete(pesel);
	}

}
