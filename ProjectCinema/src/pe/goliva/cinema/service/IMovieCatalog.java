package pe.goliva.cinema.service;

/**
 *
 * @author : Giomar Oliva
 * @date : 5 may 2022
 * 
 */
public interface IMovieCatalog {
	String NAME_RECEARCH = "movies.txt";

	void insertMovie(String nameMovie);

	void listMovie();

	void searchMovie(String search);

	void createMovieCatalog();
	
	void deleteCatalog();

}
