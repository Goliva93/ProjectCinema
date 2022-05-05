package pe.goliva.cinema.data;

import java.io.*;
import java.util.*;

import pe.goliva.cinema.bussines.Movie;
import pe.goliva.cinema.exceptions.*;

/*
 *
 * @author : Giomar Oliva
 * @date : 4 may 2022
 * 
 */
public class DataAccessImpl implements IDataAccess {

	@Override
	public boolean existsArchive(String nameArchive) throws DataAccessExc {
		File archive = new File(nameArchive);
		return archive.exists();
	}

	@Override
	public List<Movie> listMovie(String nameArchive) throws ReadDataExc {
		var archive = new File(nameArchive);
		List<Movie> movies = new ArrayList<>();
		try {
			BufferedReader entry = new BufferedReader(new FileReader(archive));
			String line = null;
			line = entry.readLine();
			while (line != null) {
				Movie movie = new Movie(line);
				movies.add(movie);
				line = entry.readLine();
			}
			entry.close();
		} catch (Exception e) {
			throw new ReadDataExc("Exception to list movies: " + e.getMessage());
		}

		return movies;
	}

	@Override
	public void writeMovie(Movie movie, String nameArchive, boolean anex) throws WriteDataExc {
		var archive = new File(nameArchive);
		try {
			var out = new PrintWriter(new FileWriter(archive, anex));
			out.println(movie.toString());
			out.close();
			System.out.println("Se añadió la película" + movie);
		} catch (Exception e) {
			throw new WriteDataExc("Exception to Write Movie : " + e.getMessage());
		}
	}

	@Override
	public String sarchMovie(String nameArchive, String search) throws DataAccessExc {
		var archive = new File(nameArchive);
		String result = null;
		try {
			var entry = new BufferedReader(new FileReader(archive));
			String line = null;
			line = entry.readLine();
			int indice = 1;
			while (line != null) {
				if (line.equalsIgnoreCase(search)) {
					result = "Pelicula: " + line + " - Indice: " + indice;
					break;
				} else {
					indice ++;
					line = entry.readLine();
					continue;
				}
			}
			entry.close();
		} catch (Exception e) {
			throw new DataAccessExc("Archivo no encontrado" + e.getClass());
		}
		return result;
	}

	@Override
	public void createArchive(String nameArchive) throws DataAccessExc {
		var archive = new File(nameArchive);
		try {
			var out = new PrintWriter(new FileWriter(archive));
			out.println("");
			out.close();
			System.out.println("se creó el archivo");
		}catch(Exception e) {
			throw new DataAccessExc("Error: " + e.getMessage());
		}
	}

	@Override
	public void deleteArchive(String nameArchive){
		var archive = new File(nameArchive);
		if(archive.exists()) {
			archive.delete();
			System.out.println("Se eliminó el archivo");
		}else {
			System.out.println("no se encontró el archivo");
		}
	}

}
