import java.io.*;

class Plastic_Com extends Login_Com {

    // FileWriter f=new FileWriter("PlasticArea.txt",true);
    BufferedReader br = new BufferedReader(new FileReader("PlasticArea.txt"));
    // PrintWriter pw=new PrintWriter(f);
    double transpWeight = 0.0f, translucentWeight = 0.0f, blackWeight = 0.0f;

    int collected;

    Plastic_Com() throws IOException {

    }

    void readCity() throws IOException {
        br = new BufferedReader(new FileReader("ComMember.txt"));
        String line = br.readLine();

        while (!("Name: " + name).equalsIgnoreCase(line)) {
            // System.out.println("Name: "+name);

            line = br.readLine();
        }
        br.readLine(); // password
        br.readLine(); // security ans
        city = br.readLine(); // city
        area = br.readLine(); // area
        area = area.substring(6);
        city = city.substring(6);
        // System.out.println("Area of com "+area +" city: "+city);
        areaWise();
        br.close();

    }

    void areaWise() throws IOException {
        // to bring the pointer back
        br = new BufferedReader(new FileReader("PlasticArea.txt"));
        // System.out.println("here in area wise ");
        String line = br.readLine();
        // System.out.println("before while "+line);
        while (line != null) {
            // System.out.println(line);

            if (("City: " + city).equalsIgnoreCase(line)) {
                // System.out.println(2);
                line = br.readLine(); // Area
                // System.out.println(line);

                if (("Area: " + area).equalsIgnoreCase(line)) {

                    line = br.readLine();

                    line = br.readLine();

                    // System.out.println( Double.parseDouble(line.substring(13)));
                    transpWeight += Double.parseDouble(line.substring(13));
                    // System.out.println(transpWeight);
                    translucentWeight += Float.valueOf(br.readLine().substring(14)).floatValue();
                    // System.out.println(translucentWeight);
                    blackWeight += Float.valueOf(br.readLine().substring(7)).floatValue();
                    // System.out.println(blackWeight);
                }

            }
            line = br.readLine();
        }

        if (transpWeight >= 500 || translucentWeight >= 500 || blackWeight >= 500) {
            System.out.println("You have Successfully been allotted to collect plastic from the following households in your area");
            System.out.println("\nTotal Weight to be collected is");
            System.out.println("1.Transparent: " + transpWeight);
            System.out.println("2.Transcluscent: " + translucentWeight);
            System.out.println("3.Black: " + blackWeight);
            dsiplayHouse();
        } else {
            System.out.println("Not enough weight to be collected! \nKindly check after some time");

        }

    }

    void dsiplayHouse() throws IOException {
        br = new BufferedReader(new FileReader("PlasticArea.txt"));
        String line = br.readLine();
        String collectName, collectStreet;

        while (line != null) {
            // System.out.println(line);

            collectName = line;

            collectStreet = line = br.readLine(); // street

            line = br.readLine(); // city
            if (("City: " + city).equalsIgnoreCase(line)) {

                line = br.readLine(); // area
                if (("Area: " + area).equalsIgnoreCase(line)) {

                    System.out.println(collectName);
                    System.out.println(collectStreet);
                    System.out.println("_____________________________________________________");
                }
            } else
                line = br.readLine();

            for (int i = 1; i <= 5; i++)
                line = br.readLine(); // pin, plastics(3), line

            line = br.readLine();

        }
        br.close();

    }

}
