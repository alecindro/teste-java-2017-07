package br.com.involves.model;

public class Cidade {

	@Propriedade(name = "ibge_id")
	private String ibgeId;
	@Propriedade(name = "uf")
	private String uf;
	@Propriedade(name = "name")
	private String name;
	@Propriedade(name = "capital")
	private String capital;
	@Propriedade(name = "lon")
	private String longitude;
	@Propriedade(name = "lat")
	private String latitude;
	@Propriedade(name = "no_accents")
	private String noAccents;
	@Propriedade(name = "alternative_names")	
	private String alternativeNames;
	@Propriedade(name = "microregion")	
	private String microregion;
	@Propriedade(name = "mesoregion")	
	private String mesoregion;
	
	public String getIbgeId() {
		return ibgeId;
	}
	
	public void setIbgeId(String ibgeId) {
		this.ibgeId = ibgeId;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getNoAccents() {
		return noAccents;
	}
	public void setNoAccents(String noAccents) {
		this.noAccents = noAccents;
	}
	public String getAlternativeNames() {
		return alternativeNames;
	}
	public void setAlternativeNames(String alternativeNames) {
		this.alternativeNames = alternativeNames;
	}
	public String getMicroregion() {
		return microregion;
	}
	public void setMicroregion(String microregion) {
		this.microregion = microregion;
	}
	public String getMesoregion() {
		return mesoregion;
	}
	public void setMesoregion(String mesoregion) {
		this.mesoregion = mesoregion;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ibgeId == null) ? 0 : ibgeId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (ibgeId == null) {
			if (other.ibgeId != null)
				return false;
		} else if (!ibgeId.equals(other.ibgeId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return  ibgeId + "," + uf + "," + name + "," + capital + ","
				+ longitude + "," + latitude + "," + noAccents + ","
				+ alternativeNames + "," + microregion + "," + mesoregion;
	}
	
	
	
	
	
}
