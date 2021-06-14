package rareDiseasesMenu;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.List;

import rareDiseasesFx.JDBCManager;
import rareDiseasesIfaces.DBManager;
import rareDiseasesPojos.Disease;
import rareDiseasesPojos.Resources;


public class Menu {

	private static DBManager dbman =new JDBCManager();
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	

	public static void main(String[] args) throws Exception {
		dbman.connect();
		do {
		System.out.println("Choose an option:");
		System.out.println("1. Search a disease");
		System.out.println("2. Search resources of a particular disease");
		System.out.println("0. Exit");
		int choice = Integer.parseInt(reader.readLine());
		switch (choice) {
		case 1:
			searchDisease();
			break;
		case 2:
			searchResource();
			break;
		
		case 0:
			dbman.disconnect();
			System.exit(0);
			break;
		default:
			break;
		}
		} while (true);
		
	}
	
	
	
	private static void searchDisease() throws Exception {
		System.out.println("Please, input the disease name:");
		System.out.print("Name contains: ");
		String name = reader.readLine();
		List<Disease> diseases = dbman.searchDiseaseByName(name);
		if (diseases.isEmpty()) {
			System.out.println("No results.");
		}
		else {
			System.out.println(diseases);
		}
	}
	
	private static void searchResource() throws Exception {
		System.out.println("Please, input the name of the disease to get to its resources:");
		System.out.print("Name contains: ");
		String diseaseName = reader.readLine();
		List<Resources> resources=dbman.searchResourcesByDisease(diseaseName);
		if (resources.isEmpty()) {
			System.out.println("No results.");
		}
		else {
			System.out.println(resources);
		}
	}
	
	
	
	

}
