import java.io.*;
import java.util.*;

public class ChildrenBank {

    // Helper method to read bank_info.csv into a list of string arrays
    public static List<String[]> readCSV(String fileName) {
        List<String[]> rows = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) {
            return rows;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    rows.add(line.split(","));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return rows;
    }

    public static void writeCSV(String fileName, List<String[]> rows) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (String[] row : rows) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public static void appendCSV(String fileName, String[] row) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write(String.join(",", row));
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }
    }

    public static String formatNumber(double value) {
        if (value == (long) value) {
            return String.valueOf((long) value);
        }
        return String.valueOf(value);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String csvFileName = "bank_info.csv";

        System.out.println("{For using this banking code} \nUse this demo account details\n\nUsername:kartavya\nAccount number:715394129614\nCurrent Balance ₹10000\nOr create you can a new account\n(NOTE:If 'sign in' is not working then go for 'create new account')");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("       WELCOME TO CHILDREN BANK");

        System.out.print("(Choose 1 or 2) 1. Sign in to existing account\n                2. Create a new account\n               :");
        String ask = scanner.nextLine().trim();

        String name = "";
        long account_number = 0;

        if (ask.equals("2")) {
            while (true) {
                System.out.print("Enter your name:");
                name = scanner.nextLine().trim();
                if (name.length() > 0) {
                    break;
                } else {
                    System.out.println("Enter valid name");
                }
            }

            while (true) {
                System.out.print("Enter your address:");
                String address = scanner.nextLine().trim();
                if (address.length() >= 5) {
                    break;
                } else {
                    System.out.println("Enter valid address");
                }
            }

            while (true) {
                System.out.print("Enter your month of birth (in digits):");
                try {
                    int month = Integer.parseInt(scanner.nextLine().trim());
                    if (month >= 1 && month <= 12) {
                        break;
                    } else {
                        System.out.println("Invalid month");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid month");
                }
            }

            while (true) {
                System.out.print("Enter your date of birth (in digits):");
                try {
                    int date = Integer.parseInt(scanner.nextLine().trim());
                    if (date >= 1 && date <= 31) {
                        break;
                    } else {
                        System.out.println("Invalid date");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid date");
                }
            }

            while (true) {
                System.out.print("Enter your year of birth (20XX syntax):");
                try {
                    int year = Integer.parseInt(scanner.nextLine().trim());
                    if (year <= 2007) {
                        break;
                    } else {
                        System.out.println("You are minor");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid year");
                }
            }

            while (true) {
                System.out.print("Enter your 12 digit Aadhaar number:");
                try {
                    long aadhar = Long.parseLong(scanner.nextLine().trim());
                    if (aadhar > 100000000000L && aadhar < 999999999999L) {
                        break;
                    } else {
                        System.out.println("Invalid Aadhaar number");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Aadhaar number");
                }
            }

            while (true) {
                System.out.print("Enter your 10 digit PAN card number:");
                String pan = scanner.nextLine().trim();
                if (pan.length() == 10) {
                    break;
                } else {
                    System.out.println("Invalid PAN number");
                }
            }

            while (true) {
                System.out.print("Enter your 10 digit Phone number:");
                try {
                    long phone = Long.parseLong(scanner.nextLine().trim());
                    if (phone > 1000000000L && phone < 9999999999L) {
                        break;
                    } else {
                        System.out.println("Invalid phone number");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid phone number");
                }
            }

            System.out.print("Enter your Email ID:");
            String email = scanner.nextLine().trim();
            System.out.println("Please pay minimum ₹500 for creating an account");

            double amount = 0;
            while (true) {
                System.out.print("Pay your amount :");
                try {
                    amount = Double.parseDouble(scanner.nextLine().trim());
                    if (amount < 500) {
                        System.out.println("Payment failed\nMinimum amount is ₹500\n(repay)");
                    } else {
                        System.out.println("Payment received\n");
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Payment failed\nMinimum amount is ₹500\n(repay)");
                }
            }

            // Generate 12-digit random account number
            Random random = new Random();
            long minAcc = 100000000000L;
            long maxAcc = 999999999999L;
            account_number = minAcc + (long) (random.nextDouble() * (maxAcc - minAcc + 1));

            System.out.println("THANK YOU FOR CHOOSING OUR BANK\n\nHere is your account number: " + account_number);
            System.out.println("Please make sure to remember this Account number");

            String[] new_account = new String[] {
                name,
                String.valueOf(account_number),
                formatNumber(amount),
                "0",
                "0"
            };

            appendCSV(csvFileName, new_account);

        } else if (ask.equals("1")) {

            List<String[]> rows = readCSV(csvFileName);
            List<String> usernames = new ArrayList<>();
            for (String[] row : rows) {
                if (row.length > 0) {
                    usernames.add(row[0]);
                }
            }

            while (true) {
                System.out.print("Enter your username*: ");
                name = scanner.nextLine().trim();
                if (usernames.contains(name)) {
                    break;
                } else {
                    System.out.println("Invalid username");
                }
            }

            int v = -1;
            for (int i = 0; i < rows.size(); i++) {
                String[] row = rows.get(i);
                for (String col : row) {
                    if (col.equals(name)) {
                        v = i + 1;
                        break;
                    }
                }
                if (v != -1) {
                    break;
                }
            }

            String x = rows.get(v - 1)[1];

            while (true) {
                System.out.print("Enter 12 digit account number*:");
                try {
                    account_number = Long.parseLong(scanner.nextLine().trim());
                    if (account_number == Long.parseLong(x.trim())) {
                        break;
                    } else {
                        System.out.println("Invalid account number");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid account number");
                }
            }
        }

        System.out.println(name);
        System.out.println(account_number);

        System.out.print("What do you want to do?\n          1.Debit.\n          2.Credit.\n          3.Fixed Deposit.\n          4.Apply for loan.\n          5.Check my Account balance.\n          6.Check FD status.\n          7.Check loan status.\n          8.Exit\n          :");
        String m = scanner.nextLine().trim();

        List<String[]> rows = readCSV(csvFileName);
        int u = -1;
        for (int line = 0; line < rows.size(); line++) {
            String[] row = rows.get(line);
            for (String col : row) {
                if (col.equals(name)) {
                    u = line + 1;
                    break;
                }
            }
            if (u != -1) {
                break;
            }
        }

        String t = rows.get(u - 1)[2];
        double o = Double.parseDouble(t.trim());

        if (m.equals("5")) {
            System.out.println("Current balance is: ₹ " + formatNumber(o));

        } else if (m.equals("1")) {
            while (true) {
                System.out.print("Enter the amount to be debited: ₹");
                try {
                    double e = Double.parseDouble(scanner.nextLine().trim());
                    if (e < o) {
                        System.out.println("Your amount is debited successfully.");
                        o = o - e;

                        rows = readCSV(csvFileName);
                        for (String[] row : rows) {
                            if (row[0].equals(name)) {
                                row[2] = formatNumber(o);
                                break;
                            }
                        }
                        writeCSV(csvFileName, rows);
                        break;
                    } else {
                        System.out.println("Your account doesn't have sufficient balance:\n(Transaction failed)");
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid amount. Please enter a valid number.");
                }
            }

        } else if (m.equals("2")) {
            System.out.print("Enter the amount to be credited: ₹");
            double e = Double.parseDouble(scanner.nextLine().trim());
            System.out.println("Your amount is credited successfully.");
            o = o + e;

            rows = readCSV(csvFileName);
            for (String[] row : rows) {
                if (row[0].equals(name)) {
                    row[2] = formatNumber(o);
                    break;
                }
            }
            writeCSV(csvFileName, rows);

        } else if (m.equals("3")) {
            System.out.println("Our bank provides only Simple Interest on FD\n(terms and conditions are given below)");
            System.out.println("1.Minimum amount for FD is ₹5 lakhs\n2.You cannot close your account during FD period\n3.You can create only one FD for an account.");

            System.out.print("Choose your FD plan.\n  Time Period        Interest\n1) 1 year            7%\n2) 2 year            7.2%\n3) 3 year            7.3%\n4) 5 year            7.5%\n:");
            String g = scanner.nextLine().trim();

            if (g.equals("1")) {
                double p = 0;
                while (true) {
                    System.out.print("Enter your principal amount: ₹");
                    p = Double.parseDouble(scanner.nextLine().trim());
                    if (p >= 500000) {
                        break;
                    } else {
                        System.out.println("Minimum amount should be ₹5 lakh\n(payment failed)");
                    }
                }

                double i = (p * 7 * 1) / 100.0;
                double f = p + i;

                rows = readCSV(csvFileName);
                for (String[] row : rows) {
                    if (row[0].equals(name)) {
                        row[4] = formatNumber(f);
                        break;
                    }
                }
                writeCSV(csvFileName, rows);

            } else if (g.equals("2")) {
                double p = 0;
                while (true) {
                    System.out.print("Enter your principal amount: ₹");
                    p = Double.parseDouble(scanner.nextLine().trim());
                    if (p >= 500000) {
                        break;
                    } else {
                        System.out.println("Minimum amount should be ₹5 lakh\n(payment failed)");
                    }
                }

                double i = (p * 7.2 * 2) / 100.0;
                double f = p + i;

                rows = readCSV(csvFileName);
                for (String[] row : rows) {
                    if (row[0].equals(name)) {
                        row[4] = formatNumber(f);
                        break;
                    }
                }
                writeCSV(csvFileName, rows);

            } else if (g.equals("3")) {
                double p = 0;
                while (true) {
                    System.out.print("Enter your principal amount: ₹");
                    p = Double.parseDouble(scanner.nextLine().trim());
                    if (p >= 500000) {
                        break;
                    } else {
                        System.out.println("Minimum amount should be ₹5 lakh\n(payment failed)");
                    }
                }

                double i = (p * 7.3 * 3) / 100.0;
                double f = p + i;

                rows = readCSV(csvFileName);
                for (String[] row : rows) {
                    if (row[0].equals(name)) {
                        row[4] = formatNumber(f);
                        break;
                    }
                }
                writeCSV(csvFileName, rows);

            } else {
                double p = 0;
                while (true) {
                    System.out.print("Enter your principal amount: ₹");
                    p = Double.parseDouble(scanner.nextLine().trim());
                    if (p >= 500000) {
                        break;
                    } else {
                        System.out.println("Minimum amount should be ₹5 lakh\n(payment failed)");
                    }
                }

                double i = (p * 7.5 * 5) / 100.0;
                double f = p + i;

                rows = readCSV(csvFileName);
                for (String[] row : rows) {
                    if (row[0].equals(name)) {
                        row[4] = formatNumber(f);
                        break;
                    }
                }
                writeCSV(csvFileName, rows);
            }

        } else if (m.equals("4")) {
            System.out.println("Our bank only provides one type of loan (personal loan)\nWith Interest of 8.7%");
            System.out.print("Enter in how many years you will pay the amount of loan with interest (in digits):");
            double tYears = Double.parseDouble(scanner.nextLine().trim());
            System.out.println("\nNOTE:If you do not return your amount on time, you will be Bankrupt");
            System.out.println("You can apply only for amount under ₹50 lakh");

            double l = 0;
            while (true) {
                System.out.print("Enter loan amount you are applying for: ₹");
                l = Double.parseDouble(scanner.nextLine().trim());
                if (l > 0 && l <= 5000000) {
                    break;
                } else {
                    System.out.println("Application rejected");
                }
            }

            double i = (l * 8.7 * tYears) / 100.0;
            double a = l + i;

            System.out.println("After " + formatNumber(tYears) + " years you have to pay amount of: ₹ " + formatNumber(a));

            rows = readCSV(csvFileName);
            for (String[] row : rows) {
                if (row[0].equals(name)) {
                    row[3] = formatNumber(a);
                    break;
                }
            }
            writeCSV(csvFileName, rows);

        } else if (m.equals("6")) {
            System.out.println("Your FD is safe");
            rows = readCSV(csvFileName);
            int lineU = -1;
            for (int idx = 0; idx < rows.size(); idx++) {
                String[] row = rows.get(idx);
                for (String col : row) {
                    if (col.equals(name)) {
                        lineU = idx + 1;
                        break;
                    }
                }
                if (lineU != -1) {
                    break;
                }
            }

            String fdAmount = rows.get(lineU - 1)[4];
            System.out.println("Your FD amount is: ₹ " + fdAmount);

        } else if (m.equals("7")) {
            rows = readCSV(csvFileName);
            int lineU = -1;
            for (int idx = 0; idx < rows.size(); idx++) {
                String[] row = rows.get(idx);
                for (String col : row) {
                    if (col.equals(name)) {
                        lineU = idx + 1;
                        break;
                    }
                }
                if (lineU != -1) {
                    break;
                }
            }

            String loanStr = rows.get(lineU - 1)[3];
            double loanAmount = Double.parseDouble(loanStr.trim());

            System.out.println("Your current loan amount is: ₹ " + loanStr);

            if (loanAmount != 0) {
                System.out.print("Do you want to pay this amount?\n(NOTE:you have to pay entire amount at once.)\n1.Yes\n2.No\n:");
                String r = scanner.nextLine().trim();

                if (r.equals("1")) {
                    while (true) {
                        System.out.print("Enter the amount to pay: ₹");
                        double w = Double.parseDouble(scanner.nextLine().trim());
                        if (w == loanAmount) {
                            System.out.println("Payment received");

                            rows = readCSV(csvFileName);
                            for (String[] row : rows) {
                                if (row[0].equals(name)) {
                                    row[3] = "0";
                                    break;
                                }
                            }
                            writeCSV(csvFileName, rows);
                            break;
                        } else {
                            System.out.println("(Payment failed)\nPay exact amount.");
                        }
                    }
                } else {
                    System.out.println("Hope you will pay it on time");
                }
            }
        }

        System.out.println("Thank you!!");
        scanner.close();
    }
}
