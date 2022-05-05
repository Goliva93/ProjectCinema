package pe.goliva.cinema.view;

import java.util.*;

import pe.goliva.cinema.service.*;

/**
 *
 * @author : Giomar Oliva
 * @date : 5 may 2022
 * 
 */
public class ViewCatalog {

	public static void main(String[] args) {
		int option = -1;
		@SuppressWarnings("resource")
		var scan = new Scanner(System.in);
		IMovieCatalog catalog = new MovieCatalogImpl();
		while (option != 0) {
			System.out.println("Choose an option : " + "\n" + 
								"1 - Start movies catalog" + "\n" + 
								"2 - Agree movie" + "\n" + 
								"3 - List movie " + "\n" + 
								"4 - Search movie " + "\n" + 
								"5 - delete catalog");
			option = Integer.parseInt(scan.nextLine());

			switch (option) {
			case 1:
				catalog.createMovieCatalog();
				break;
			case 2:
				System.out.println("Enter movie name : ");
				var name = scan.nextLine();
				catalog.insertMovie(name);
				break;
			case 3:
				catalog.listMovie();
				System.out.println("");
				break;
			case 4:
				System.out.println("Enter movie name : ");
				var search = scan.nextLine();
				catalog.searchMovie(search);
				break;
			case 5:
				catalog.deleteCatalog();
				break;
			case 0:
				System.out.println("see you later, thanks for use this program");
				break;
			default:
				System.out.println("number is invalid");
				break;
			}
			
		}

	}

}
