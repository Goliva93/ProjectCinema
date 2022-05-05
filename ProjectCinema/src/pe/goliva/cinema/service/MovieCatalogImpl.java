package pe.goliva.cinema.service;

import pe.goliva.cinema.bussines.Movie;
import pe.goliva.cinema.data.*;
import pe.goliva.cinema.exceptions.*;

/**
 *
 * @author	: Giomar Oliva
 * @date	: 5 may 2022
 * 
 */
public class MovieCatalogImpl implements IMovieCatalog{
	
	private final IDataAccess data;

	public MovieCatalogImpl() {
		this.data = new DataAccessImpl();
	}

	@Override
	public void insertMovie(String nameMovie) {
		var movie = new Movie(nameMovie);
		boolean anex = false;
		try {
			anex = data.existsArchive(NAME_RECEARCH);
			data.writeMovie(movie, NAME_RECEARCH, anex);
		} catch (DataAccessExc e) {
			System.out.println("Error Data Access: " + e.getMessage());
		}
		
	}

	@Override
	public void listMovie() {
		try {
			var movies = data.listMovie(NAME_RECEARCH);
			movies.forEach(e ->{
				System.out.println(e.getNameMovie());
			});
		} catch (ReadDataExc e) {
			System.out.println("Error con el archivo : " + e.getMessage());
		}
		
	}

	@Override
	public void searchMovie(String search) {
		String result = null;
		try {
			result = data.searchMovie(NAME_RECEARCH, search);
		} catch (DataAccessExc e) {
			System.out.println("Error con el archivo : " + e.getMessage());
		}
		System.out.println("Pelicula : " + result);
		
	}

	@Override
	public void createMovieCatalog() {
	try {
		if(data.existsArchive(NAME_RECEARCH)) {
			data.deleteArchive(NAME_RECEARCH);
			data.createArchive(NAME_RECEARCH);
		}else {
			data.createArchive(NAME_RECEARCH);
		}
	} catch (DataAccessExc e) {
		System.out.println("Error al iniciar el Catalogo: " + e.getMessage());
	}
	}

}
