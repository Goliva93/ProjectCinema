package pe.goliva.cinema.bussines;

/**
 *
 * @author	: Giomar Oliva
 * @date	: 4 may 2022
 * 
 */
public class Movie {
	String nameMovie;
	String genreMovie;
	
	public Movie() {
		super();
	}

	public Movie(String nameMovie, String genreMovie) {
		super();
		this.nameMovie = nameMovie;
		this.genreMovie = genreMovie;
	}

	public String getNameMovie() {
		return nameMovie;
	}

	public void setNameMovie(String nameMovie) {
		this.nameMovie = nameMovie;
	}

	public String getGenreMovie() {
		return genreMovie;
	}

	public void setGenreMovie(String genreMovie) {
		this.genreMovie = genreMovie;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Movie [ nameMovie = ");
		builder.append(nameMovie);
		builder.append(", genreMovie = ");
		builder.append(genreMovie);
		builder.append(" ]");
		return builder.toString();
	}
	
	
	
}
