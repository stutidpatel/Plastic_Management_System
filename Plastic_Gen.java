import java.io.*;
import java.util.Scanner;

class Plastic_Gen extends Login_User {
    Scanner sc = new Scanner(System.in);
    String plast_types[] = { "Transparent", "Translucent", "Black" };
    float w[] = new float[3];
    float weight;

    FileWriter f = new FileWriter("PlasticArea.txt", true);
    BufferedReader br = new BufferedReader(new FileReader("trial1.txt"));
    PrintWriter pw = new PrintWriter(f);

    Plastic_Gen() throws IOException {
        weight = 0.0f;
    }

    void plasticType() throws IOException // throws IOException
    {
        // input();
        System.out.println("---------------------Welcome to plastic Section ----------------------------------");

        int ch;
        do {

            System.out.println(" 1. " + plast_types[0]);
            System.out.println(" 2. " + plast_types[1]);
            System.out.println(" 3. " + plast_types[2]);

            System.out.print("\nSelect Your Plastic Type: ");
            ch = sc.nextInt();
            
            if (ch == 1 || ch == 2 || ch == 3) {
                System.out.print("\nEnter your estimated weight in \"grams\" (Only Numbers) ");
                weight = sc.nextFloat();
            }
            switch (ch) {
                case 1:
                    w[0] += weight;
                    break;

                case 2:
                    w[1] += weight;
                    break;

                case 3:
                    w[2] += weight;
                    break;
                default:
                    System.out.println("Invalid Type");

            }

            System.out.print("\nPress \"0\" to End else any other key To add more plastic type weight ");
            ch = sc.nextInt();

        } while (ch != 0);
        writeFile();

    }

    void writeFile() throws IOException {
        pw.println("Name: " + name);
        
        String line = br.readLine();
        while (!(("Name: " + name).equals(line))) {
            line = br.readLine();
        }
        line = br.readLine();// for password
        line = br.readLine();// for security answer

        pw.println(br.readLine()); // Street
        area = br.readLine();
        pw.println(br.readLine()); // City
        pw.println(area); // Area
        pw.println(br.readLine()); // Pincode

        pw.print("Transparent: ");
        pw.println(w[0]);
        pw.println("Transclusent: " + w[1]);
        pw.println("Black: " + w[2]);
        pw.println("_____________________________________________________");
        pw.flush();
        pw.close();

    }

    void displayWeight() {
        System.out.println("Final Weight\n");
        System.out.println("Transparent: " + w[0]);
        System.out.println("Transclusent: " + w[1]);
        System.out.println("Black: " + w[2]);
        System.out.println("Your entry has been taken wait for our staff to collect it");

    }

}
