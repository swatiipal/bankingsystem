import java.sql.SQLException;
import java.util.Scanner;

import com.bank.Admin;
import com.bank.Customer;
import com.db.Database;

class BankInfo{
    String dbName="bankingsystem";
    String userName="root";
    String password="";
    void bankAddCustOrAdmin() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an option: ");
        System.out.println("1. Create admin");
        System.out.println("2. Create customer");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                Admin a = new Admin();
                a.displayAdmin();
                break;

            case 2:
                Customer c = new Customer();
                c.displayCustomer();
                break;

            default:
                break;
        }
    }
}
public class Bank {
    public static void main(String[] args) throws SQLException {
        BankInfo b = new BankInfo();
        b.bankAddCustOrAdmin();
    }
}
