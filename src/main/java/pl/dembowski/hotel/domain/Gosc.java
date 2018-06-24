package pl.dembowski.hotel.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "goscie")
@NamedQueries(value = {
		@NamedQuery(name = Gosc.FIND_ALL_QUERY, query = "select g from Gosc g order by g.nazwisko, g.imie")		
})
public class Gosc {
	
	public static final String FIND_ALL_QUERY = "findAllGosc";

	private String pesel;
	private String imie;
	private String nazwisko;
	private Date data;

	@Id
	@Column(name = "PESEL")
	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	@Column(name = "IMIE")
	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	@Column(name = "NAZWISKO")
	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA")
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
