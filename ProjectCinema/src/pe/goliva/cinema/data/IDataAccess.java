package pe.goliva.cinema.data;

import java.util.List;

import pe.goliva.cinema.bussines.Movie;
import pe.goliva.cinema.exceptions.*;

/**
 *
 * @author : Giomar Oliva
 * @date : 4 may 2022
 * 
 */
public interface IDataAccess {
	boolean existsArchive(String nameArchive) throws DataAccessExc;

	List<Movie> listMovie(String nameArchive) throws ReadDataExc;

	void writeMovie(Movie movie, String nameArchive, boolean anex) throws WriteDataExc;

	String sarchMovie(String nameArchive, String search) throws DataAccessExc;

	void createArchive(String nameArchive) throws DataAccessExc;

	void deleteArchive(String nameArchive) throws DataAccessExc;
}
