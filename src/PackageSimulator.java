import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class PackageSimulator {
    private ArrayList<Package> packages;

    public PackageSimulator() {
        this.packages = new ArrayList<Package>();
    }

    public void generatePackages(int num) throws FileNotFoundException        // importing a file that contains all possible zip codes within the US
    {
        File zipCodes = new File("Data/zip_codes");
        int i = 0;

        while (i < num) {
            Scanner s1 = null;
            Scanner s2 = null;
            try {
                s1 = new Scanner(zipCodes);
                s2 = new Scanner(zipCodes);
            } catch (FileNotFoundException e) {
                System.exit(1);
            }

            // generates two random indexes to represent line number in zip codes file
            int ranIdx1 = (int) (Math.random() * 42735) + 1;
            String zipCode1 = null;
            for (int j = 0; j < ranIdx1; j++) {
                zipCode1 = s1.nextLine();
            }

            int ranIdx2 = (int) (Math.random() * 42735) + 1;
            String zipCode2 = null;
            for (int k = 0; k < ranIdx2; k++) {
                zipCode2 = s2.nextLine();
            }


            Address ad1 = new Address("2006 Fake Street Apt 2B, City, State " + zipCode1);
            Address ad2 = new Address("2006 Fake Street Apt 2B, City, State " + zipCode2);
            double weight = Math.random() * 100 + 1;
            double length = Math.random() * 21.5 + 4;
            double width = Math.random() * 14.75 + 4;
            double height = Math.random() * 22.25 + 4;

            Package p = new Package (ad1, ad2, weight, length, width, height);
            packages.add(p);
            i++;
        }
    }

    public double generateTotalCost() {
        double tc = 0;
        for (int i = 0; i < packages.size(); i++) {
            tc += PostageCalculator.calculatePostage(packages.get(i));
        }
        return tc;
    }

    public String getSimulationInfo() {
        DecimalFormat df = new DecimalFormat("##.00");
        String info = "Randomly Generated Packages Info: \n";
        for (int i = 0; i < packages.size(); i++) {
            info += "Package " + (i + 1) + ": ------------------------------------------------------------------\n";
            info += "Origin address: " + packages.get(i).getOrigin() + "\n";
            info += "Destination address: " + packages.get(i).getDestination() + "\n";
            info += "Weight: " + packages.get(i).getWeight() + "\n";
            info += "Length: " + packages.get(i).getLength() + "\n";
            info += "Width: " + packages.get(i).getWidth() + "\n";
            info += "Height: " + packages.get(i).getHeight() + "\n";
            info += "Cost: " + df.format(PostageCalculator.calculatePostage(packages.get(i))) + "\n";
        }

        info += "------------------------------------------------------------------\n";
        info += "Total Cost of all packages: " + df.format(generateTotalCost());

        return info;
    }

    public void resetSimulation() {
        packages.clear();
    }

    public void menu()
    {
        Scanner scanner = new Scanner(System.in);
        String menuOption = "";

        System.out.println("What would you like to do?");

        while (!menuOption.equals("5"))
        {
            System.out.println("------------ Main Menu ----------");
            System.out.println("1. Calculate the cost of one package");
            System.out.println("2. Simulate package");
            System.out.println("3. Clear previous simulation");
            System.out.println("4. How package costs are calculated");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            menuOption = scanner.nextLine();

            if (!menuOption.equals("5"))
            {
                processOption(menuOption);
            }
        }

        scanner.close();
    }

    private void processOption(String option) {
        Scanner s = new Scanner(System.in);

        if (option.equals("1")) {
            System.out.println("Enter the zip code of the origin package; ");
            int oriZipCode = Integer.parseInt(s.nextLine());

            System.out.println("Enter the zip code of the destination package: ");
            int desZipCode = Integer.parseInt(s.nextLine());

            System.out.println("Enter the weight of the package: ");
            double weight = Double.parseDouble(s.nextLine());

            System.out.println("Enter the length of the package: ");
            double length = Double.parseDouble(s.nextLine());

            System.out.println("Enter the width of the package: ");
            double width = Double.parseDouble(s.nextLine());

            System.out.println("Enter the height of the package: ");
            double height = Double.parseDouble(s.nextLine());

            DecimalFormat df = new DecimalFormat("##.00");
            System.out.println("Cost: " + df.format(PostageCalculator.calculatePostage(oriZipCode, desZipCode, weight, length, width, height)));
        } else if (option.equals("2")) {
            System.out.println("----------------------------------------------------------------");
            System.out.println("How many packages would you like to simulate?");
            int num = Integer.parseInt(s.nextLine());

            try {
                generatePackages(num);
            } catch (FileNotFoundException e) {
                System.exit(1);
            }

            System.out.println(getSimulationInfo());
        } else if (option.equals("3")) {
            resetSimulation();
        } else if (option.equals("4")) {
            String info = "How costs are calculated: \n";
            info += "Base Cost: $3.75\n";
            info += "Cost per one tenth of a pound: $0.05\n";
            info += "Cost calculated by dividing the difference of county codes by 100\n";
            info += "Additional inches (combined dimensions) exceeding 36 inches are $0.10 per inch\n";
            info += "Additional weight over 40 pounds are $0.10 per tenth of a pound\n";
            System.out.println(info);
        }
    }
}
