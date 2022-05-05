package pe.goliva.cinema.bussines;

/**
 *
 * @author : Giomar Oliva
 * @date : 4 may 2022
 * 
 */
public class Movie {
	private String nameMovie;

	public Movie() {
		super();
	}

	public Movie(String nameMovie) {
		super();
		this.nameMovie = nameMovie;
	}

	public String getNameMovie() {
		return nameMovie;
	}

	public void setNameMovie(String nameMovie) {
		this.nameMovie = nameMovie;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Movie [ nameMovie = ");
		builder.append(nameMovie);
		builder.append(" ]");
		return builder.toString();
	}

}
