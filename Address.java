import java.util.Scanner;
import java.io.*;

class Address {
	Scanner sc = new Scanner(System.in);
	String city = new String();
	String area = new String();
	String street = new String();
	int pincode;
	int choice[] = new int[3];

	File f1 = new File("trial1.txt");
	FileWriter f = new FileWriter(f1, true);
	PrintWriter pw = new PrintWriter(f);
	//RandomAccessFile rand = new RandomAccessFile("trial1.txt", "rw");

	Address() throws IOException {

	}

	void getAddress(PrintWriter pw1) throws IOException {
		pw = pw1;

		do {
			System.out.println("\n***************Enter Your Address****************\n");
			System.out.println("\n 1. Ahmedabad");
			System.out.println("\n 2. Rajkot");
			System.out.println("\n 3. Surat");

			System.out.print("\n Enter Your Choice for City name:  ");
			choice[0] = sc.nextInt();

			if (choice[0] < 1 || choice[0] > 3) {
				System.out.println("\nInvalid Choice for city");
			} else {
				System.out.println("\n 1. North");
				System.out.println("\n 2. East");
				System.out.println("\n 3. West");
				System.out.println("\n 4. South");
				System.out.print("\nEnter Your Choice for Area name:  ");
				choice[1] = sc.nextInt();
				if (choice[1] < 1 || choice[1] > 4) {
					System.out.println("\nInvalid Choice for area");
				}

			}

		} while (choice[0] < 1 || choice[0] > 3 || choice[1] < 1 || choice[1] > 4);
		
		if (choice[0] == 1) {
			city = "Ahmedabad";
		}

		else if (choice[0] == 2) {
			city = "Rajkot";
		}

		else if (choice[0] == 3) {
			city = "Surat";
		}
		area();
		sc.nextLine();
		System.out.print("\nEnter Street name:  ");
		street = sc.nextLine();
		sc.nextLine();

		System.out.print("\nEnter Pincode:");
		pincode = sc.nextInt();

		pw.println("Street: " + street);
		pw.println("Area: " + area);
		pw.println("City: " + city);
		pw.println("Pincode: " + pincode);

		pw.flush();
	}

	void area() throws IOException {
		if (choice[1] == 1) {
			area = "North";
		} else if (choice[1] == 2) {
			area = "East";
		} else if (choice[1] == 3) {
			area = "West";
		} else {
			area = "South";
		}

	}

	void displayAddress() {
		System.out.println("Address is:\n" + "\n" + street + "\n" + area + "\n" + city + "\n" + pincode);
	}

}