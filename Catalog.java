import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Catalog {
	Scanner sc = new Scanner(System.in);
	String[] telCatalogNames = new String[50];
	String[] telCatalogTels = new String[50];	


	public void loadTxt() {  		

		try{ 
			File f=new File("C:\\Users\\John\\Desktop\\CB6 files\\weekly 2\\telcatalog.txt");       

			BufferedReader br = new BufferedReader(new FileReader(f));

			String readLine="";       

			int index=0;

			while ((readLine = br.readLine()) != null) {		

				telCatalogNames[index]=readLine.substring(0,readLine.indexOf(","));
				telCatalogTels[index]=readLine.substring(readLine.indexOf(",")+1,readLine.length()).trim();
				index++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}


	}



	public void searchName() {
		int index = -1;
		System.out.println("Enter the name you are looking for: ");
		String name = sc.next().toUpperCase();
		boolean found = false;
		for (int i = 0; i < telCatalogNames.length; i++) {
			if(name.equals(telCatalogNames[i])) {
				found = true;
				index = i+1;
				break;
			}		
		}		
		if(found) {
			System.out.println( "The phone book contains the name " + name + " in position " + index);
		}else {
			System.out.println( "The phone book does not contain the name: " + name );			
		}
	}


	public void searchTel() {
		int index = -1;		
		System.out.println("Enter the telephone number you are looking for: ");
		String tel = sc.next();
		boolean found = false;
		for (int i = 0; i < telCatalogTels.length; i++) {
			if(tel.equals(telCatalogTels[i])) {
				found = true;
				index = i+1;
				break;
			}		
		}		
		if(found) {
			System.out.println( "The phone book contains the number " + tel + " in position " + index);
		}else {
			System.out.println( "The phone book does not contain the number: " + tel );			
		}
	}


	public void addName() {
		int items=0;
		System.out.println("Enter the name you want to add: ");
		String name = sc.next().toUpperCase();
		for(int i=0; i<telCatalogNames.length; i++) {
			if(telCatalogNames[i]!=null) {
				items++;				
			}			
		}
		telCatalogNames[items] = name;
	}

	public void addTel() {
		int items=0;
		System.out.println("Enter the number you want to add: ");
		String number = sc.next();
		for(int i=0; i<telCatalogTels.length; i++) {
			if(telCatalogTels[i]!=null) {
				items++;				
			}			
		}
		telCatalogTels[items] = number;
	}

	public boolean updateName() {
		System.out.println("Enter name to update ");
		String name1 = sc.next().toUpperCase();
		System.out.println("Enter new name ");
		String name2 = sc.next().toUpperCase();
		for(int i=0; i<telCatalogNames.length; i++) {
			if(telCatalogNames[i].equals(name1)) {
				telCatalogNames[i] = name2;
				System.out.println(name1 +" was replaced by " +name2);
				return true;					
			}
		}
		System.out.println("Update was unsuccessfull");
		return false;
	}


	public boolean updateTel() {
		System.out.println("Enter number to update ");
		String tel1 = sc.next();
		System.out.println("Enter new number ");
		String tel2 = sc.next();
		for(int i=0; i<telCatalogTels.length; i++) {
			if(telCatalogTels[i].equals(tel1)) {
				telCatalogTels[i] = tel2;
				System.out.println(tel1+ " was replaced by " +tel2);
				return true;					
			}
		}
		System.out.println("Update was unsuccessfull");
		return false;
	}



	public boolean deleteName() {
		System.out.println("Enter name to delete ");
		String name1 = sc.next().toUpperCase();
		for(int i=0; i<telCatalogNames.length; i++) {
			if(telCatalogNames[i].equals(name1)) {
				telCatalogNames[i] = null;
				System.out.println(name1 +" successfully deleted");
				return true;					
			}
		}
		System.out.println("Deletion was unsuccessfull");
		return false;
	}


	public boolean deleteTel() {
		System.out.println("Enter number to delete ");
		String tel = sc.next();
		for(int i=0; i<telCatalogTels.length; i++) {
			if(telCatalogTels[i].equals(tel)) {
				telCatalogTels[i] = null;
				System.out.println(tel +" successfully deleted");
				return true;					
			}
		}
		System.out.println("Deletion was unsuccessfull");
		return false;
	}

	public void printNames() {
		for (String s : telCatalogNames) {
			if(s != null) {
				System.out.println(s);
			}			
		}
	}

	public void printTels() {
		for (String s : telCatalogTels) {
			if(s != null) {
				System.out.println(s);
			}			
		}
	}


	public void exportNames() {
		try{
			PrintWriter pr = new PrintWriter("C:\\Users\\John\\Desktop\\CB6 files\\weekly 2\\names.txt");    

			for (int i=0; i<telCatalogNames.length ; i++){
				if(telCatalogNames[i] != null) {
					pr.println(telCatalogNames[i]);
				}
			}
			pr.close();
			System.out.println("Names exported successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("No such file exists.");
		}
	}

	public void exportTels() {
		try{
			PrintWriter pr = new PrintWriter("C:\\Users\\John\\Desktop\\CB6 files\\weekly 2\\tels.txt");    

			for (int i=0; i<telCatalogTels.length ; i++){
				if(telCatalogTels[i] != null) {
					pr.println(telCatalogTels[i]);
				}
			}
			pr.close();
			System.out.println("Telephone numbers exported successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("No such file exists.");
		}
	}

	public void startApp() {
		Scanner sc = new Scanner(System.in);
		boolean exit=false;


		printMenu();

		while(!exit) {

			String input = sc.next();

			switch(input) {
			case "load" :
				loadTxt();
				System.out.println("File 'telcatalog.txt' was read successfully");
				break;
			case "sn" :
				searchName();
				break;
			case "st" :
				searchTel();
				break;
			case "an" :
				addName();
				break;
			case "at" :
				addTel();
				break;
			case "un" :
				updateName();
				break;
			case "ut" :
				updateTel();
				break;
			case "dn" :
				deleteName();
				break;
			case "dt" :
				deleteTel();
				break;
			case "pn" :
				printNames();
				break;
			case "pt" :
				printTels();
				break;
			case "en" :
				exportNames();
				break;
			case "et" :
				exportTels();
				break;
			case "menu" :
				printMenu();
				break;
			case "q" :			
				System.out.println("Thank you for using our app. \n App terminated.");
				exit=true;
				break;
			default :
				System.out.println("Invalid command");
			}
		}

	}

	public void printMenu() {
		System.out.println("Welcome to the PhoneBook® app. How you want to procced? "
				+"\n========================================================"
				+ "\n1. Type 'load' to load the phone catalog. "
				+ "\n2. Type 'sn' to search for specific name. "
				+ "\n3. Type 'st' to search for specific telephone number. "
				+ "\n4. Type 'an' to add a name. " 
				+ "\n5. Type 'at' to add a telephone number. "
				+ "\n6. Type 'un' to update a name. "
				+ "\n7. Type 'ut' to update a telephone number. "
				+ "\n8. Type 'dn' to delete a name. "
				+ "\n9. Type 'dt' to delete a telephone number. "
				+ "\n10. Type 'pn' to print the names. "
				+ "\n11. Type 'pt' to print the telephone numbers. "
				+ "\n12. Type 'en' to export the names to a txt file. "
				+ "\n13. Type 'et' to export the telephone numbers to a txt file. "
				+ "\n14. Type 'q' to exit the programm. "
				+ "\n15. Type 'menu' to see the Menu again");
	}
}