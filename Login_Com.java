import java.util.Scanner;
import java.io.*;

class Login_Com {
    String name;
    String customer_id;
    private String password;
    private String securityAns;
    String area;
    String city;
    Scanner sc = new Scanner(System.in);
    Scanner sc2 = new Scanner(System.in);

    int flag;// for successful login

    File f1 = new File("ComMember.txt");
    FileWriter f = new FileWriter(f1, true);
    PrintWriter pw = new PrintWriter(f);
    BufferedReader br = new BufferedReader(new FileReader(f1));
    BufferedReader br1 = new BufferedReader(new FileReader(f1));

    RandomAccessFile rand = new RandomAccessFile("ComMember.txt", "rw");

    Login_Com() throws IOException {
    }

    int input() throws IOException {
        int ch;
        // String temp;
        do {
            System.out.print("\n1.Login \n2.Sign-Up \n3.Go Back to Main Menu \nEnter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    f1 = new File("ComMember.txt");
                    f = new FileWriter(f1, true);
                    pw = new PrintWriter(f);
                    br = new BufferedReader(new FileReader(f1));
                    existingCom();
                    if (flag == 1) {
                        flag = 0;
                        return 1; // plastic section
                    }

                    break;

                case 2:

                    f1 = new File("ComMember.txt");
                    f = new FileWriter(f1, true);
                    pw = new PrintWriter(f);
                    br = new BufferedReader(new FileReader(f1));
                    System.out.println(rand.getFilePointer());
                    newCom();

                    break;

                case 3:
                    return -1; // main menu

                default:
                    System.out.println("\nEnter valid choice: ");

            }

            System.out.println("\nPress \"1\" for login/sign up page?");
            System.out.println("Press \"2\" for going to Plastic Section");
            System.out.println("Press \"0\" for exiting");
            System.out.print("Enter Your choice: ");
            ch = sc.nextInt();
            if (ch == 0)
                System.exit(0);

        } while (ch == 1);

        pw.flush();
        pw.close();
        br.close();
        return ch;
    }

    void existingCom() throws IOException {
        int ch, p = 0;
        String temp, temp2 = "", temp3 = "";
        sc.nextLine();

        System.out.print("\nEnter your name: ");
        name = sc.nextLine();
        sc2.nextLine();
        String line = br.readLine();
        while (line != null && p == 0) {
            if ("Name: ".equals(line.substring(0, 6))) {
                if (name.equalsIgnoreCase(line.substring(6))) {
                    temp2 = br.readLine();
                    p = 1;

                }
            }
            // to read the next line
            line = br.readLine();
            temp3 = line;
        }
        if (p == 0) {
            System.out.println("\nInvalid Name! ");
            System.out.println(temp3);
            input();
        } else {
            // temp2-> password
            temp2 = temp2.substring(10);
            // temp3=br.readLine();
            // ans
            temp3 = temp3.substring(17);
        }

        sc.nextLine();

        System.out.print("\nDo you remember your password \npress \"1\" for yes, else any other number ");
        System.out.print("\nEnter Your choice: ");
        ch = sc.nextInt();

        if (ch == 1) {
            sc.nextLine();
            System.out.print("\n------You Have 3 attempts!----\n");
            for (int i = 0; i <= 2; i++) {

                System.out.print("\nEnter your Password:  ");
                temp = sc.nextLine();
                sc.nextLine();

                // sc.nextLine();

                if (temp.trim().equals(temp2.trim())) {
                    flag = 1;
                    System.out.println("\n--------Login Successful------\n");

                    // return;
                    break;
                } else {
                    System.out.println("\nYour Password doesn't match try again! \n");
                    if (i == 2) {
                        System.out.println("\n--------You exceeded your attempts!-------\n");
                        System.exit(0);

                    }
                }

            }

        }

        else {
            System.out.print("\n----------You Have 3 attempts to enter correct Security Password!---------\n");

            for (int i = 0; i <= 2; i++) {
                sc.nextLine();
                System.out.println("\nEnter a Security answer to the question");
                System.out.println("\nQues- What is the name  of your first school? ");

                temp = sc.nextLine(); // entered security password
                sc.nextLine();

                if (temp.equals(temp3)) {
                    System.out.println("Your Password is: " + temp2);
                    break;

                }

                else {
                    sc.nextLine();
                    System.out.println("\n---------Your Security Answer doesn't match try again!------- \n");
                    if (i == 2) {
                        System.out.println("\n------------You exceeded your attempts!-----------------\n");
                        System.exit(0);
                    }
                }
                sc.nextLine();
            }
        }
        pw.flush();
        f.flush();

    }

    // same name
    void newCom() throws IOException {
        int p = 0;
        do {
            sc.nextLine();
            System.out.print("\nEnter your Username:  ");
            name = sc.nextLine();
            br = new BufferedReader(new FileReader("Plastic_Com.txt"));
            String line = br.readLine();
            while (line != null) {
                if (("Name: " + name).equalsIgnoreCase(line)) {
                    p = 0;
                    System.out.println("Username already exists");
                    break;
                } else {
                    pw.println("Name: " + name);
                    p = 1;
                }
                line = br.readLine();
            }
        } while (p == 0);

        System.out.print("Enter your Password:  ");
        password = sc.nextLine();
        pw.println("Password: " + password);
        sc2.nextLine();

        System.out.print(
                "\n\nEnter your Security answer (in case you forget your password) \n\nQues- What is the name  of your first school? : ");
        securityAns = sc.nextLine();
        pw.println("Security Answer: " + securityAns);
        sc2.nextLine();
        int ch[] = new int[2];
        do {
            System.out.println("\n 1. Ahmedabad");
            System.out.println("\n 2. Rajkot");
            System.out.println("\n 3. Surat");
            System.out.print("\n Enter Your Choice for City name:  ");
            ch[0] = sc.nextInt();
            if (ch[0] < 1 || ch[0] > 3) {
                System.out.println("\nInvalid Choice for city");
            } else {
                if (ch[0] == 1) {
                    city = "Ahmedabad";
                }

                else if (ch[0] == 2) {
                    city = "Rajkot";
                }

                else if (ch[0] == 3) {
                    city = "Surat";
                }
                System.out.println("\n1. North");
                System.out.println("\n2. East");
                System.out.println("\n3. West");
                System.out.println("\n4. South");
                System.out.print("\n\nEnter your Area ");
                ch[1] = sc.nextInt();
                if (ch[1] < 1 || ch[1] > 4) {
                    System.out.println("\nInvalid Choice for area");
                } else if (ch[1] == 1) {
                    area = "North";
                } else if (ch[1] == 2) {
                    area = "East";
                } else if (ch[1] == 3) {
                    area = "West";
                } else {
                    area = "South";
                }
            }
        } while (ch[0] < 1 || ch[0] > 3 || ch[1] < 1 || ch[1] > 4);

        pw.println("City: " + city);
        pw.println("Area: " + area);

        pw.println("______________________________");
        pw.flush();
    }

}
