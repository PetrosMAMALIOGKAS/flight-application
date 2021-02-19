package co.simplon.model;

public class Site {
	private int site_id;
	private String ville;
	
	private Site(Builder builder) {
		this.site_id = builder.site_id;
		this.ville = builder.ville;
	}
	
	

	public int getSite_id() {
		return site_id;
	}

	public void setSite_id(int site_id) {
		this.site_id = site_id;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	
	
	public static class Builder {
		private int site_id;
		private String ville;

		public Builder site_id(int site_id) {
			this.site_id = site_id;
			return this;
		}

		public Builder ville(String ville) {
			this.ville = ville;
			return this;
		}

		public Site build() {
			return new Site(this);
		}
	}

	
}
