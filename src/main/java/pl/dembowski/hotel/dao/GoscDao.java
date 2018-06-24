package pl.dembowski.hotel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import pl.dembowski.hotel.HibernateUtil;
import pl.dembowski.hotel.converter.GoscConverter;
import pl.dembowski.hotel.domain.Gosc;
import pl.dembowski.hotel.dto.GoscDto;

public class GoscDao {

	private final EntityManager em;
	private final GoscConverter goscConverter;

	public GoscDao() {
		this.em = HibernateUtil.getManager().createEntityManager();
		this.goscConverter = new GoscConverter();
	}

	public GoscDto find(String pesel) {
		Gosc result = em.find(Gosc.class, pesel);
		return goscConverter.toDto(result);
	}
	
	public List<GoscDto> findAll() {
		List<Gosc> result = em.createNamedQuery(Gosc.FIND_ALL_QUERY, Gosc.class).getResultList();
		return goscConverter.toDto(result);
	}

	public void save(GoscDto dto) {
		Gosc gosc = em.find(Gosc.class, dto.getPesel());
		if (gosc == null) {
			gosc = goscConverter.fromDto(dto);
		} else {
			goscConverter.apply(dto, gosc);
		}

		EntityTransaction tr = em.getTransaction();
		tr.begin();
		em.persist(gosc);
		tr.commit();
	}

	public void delete(String pesel) {
		Gosc gosc = em.find(Gosc.class, pesel);
		if (gosc != null) {
			EntityTransaction tr = em.getTransaction();
			tr.begin();
			em.remove(gosc);
			tr.commit();
		}
	}
}
