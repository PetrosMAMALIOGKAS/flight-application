package co.simplon.model;

public class Vol {

	private String vol_id;
	private int avion;
	private int pilote;
	private int ville_depart;
	private int ville_arriver;

	private Vol(Builder builder) {
		this.vol_id = builder.vol_id;
		this.avion = builder.avion;
		this.pilote = builder.pilote;
		this.ville_depart = builder.ville_depart;
		this.ville_arriver = builder.ville_arriver;
	}
	
	

	public String getVol_id() {
		return vol_id;
	}

	public void setVol_id(String vol_id) {
		this.vol_id = vol_id;
	}


	public int getAvion() {
		return avion;
	}

	public void setAvion(int avion) {
		this.avion = avion;
	}

	public int getPilote() {
		return pilote;
	}

	public void setPilote(int pilote) {
		this.pilote = pilote;
	}


	public int getVille_depart() {
		return ville_depart;
	}


	public void setVille_depart(int ville_depart) {
		this.ville_depart = ville_depart;
	}


	public int getVille_arriver() {
		return ville_arriver;
	}

	public void setVille_arriver(int ville_arriver) {
		this.ville_arriver = ville_arriver;
	}


	public static class Builder {
		private String vol_id;
		private int avion;
		private int pilote;
		private int ville_depart;
		private int ville_arriver;

		public Builder vol_id(String vol_id) {
			this.vol_id = vol_id;
			return this;
		}

		public Builder avion(int avion) {
			this.avion = avion;
			return this;
		}

		public Builder pilote(int pilote) {
			this.pilote = pilote;
			return this;
		}

		public Builder ville_depart(int ville_depart) {
			this.ville_depart = ville_depart;
			return this;
		}

		public Builder ville_arriver(int ville_arriver) {
			this.ville_arriver = ville_arriver;
			return this;
		}

		public Vol build() {
			return new Vol(this);
		}
	}
	
}
