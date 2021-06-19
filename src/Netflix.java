import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Netflix {
    private Account[] accounts;


    public Netflix(Account[] accounts) {

        this.accounts = accounts;
    }

    public Account[] getAccounts() {

        return accounts;
    }

    public void setAccounts(Account[] accounts) {

        this.accounts = accounts;
    }

    public Account[] addAccount(Account[] accounts, Series[] series)  {
        Scanner in = new Scanner(System.in);
        Account[] newArray = new Account[accounts.length + 1];
        if (accounts.length != 0) {
            for (int i = 0; i < accounts.length; i++) {
                newArray[i]= new Account();
                newArray[i]= accounts[i];
            }
        }

        newArray[newArray.length - 1] = new Account(series);
        System.out.println("Please enter user name :");
        String userName = null;
        try {
            userName = in.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Your input is incorrect, please try again");
            userName = in.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (checkIsUserNameExist(accounts, userName) == true) {
            System.out.println("This user name is not available, please try another user name : ");
            userName = in.nextLine();
        }
        newArray[newArray.length - 1].setUserName(userName);
        System.out.println("Please enter a strong password :");
        String password = in.nextLine();
        newArray[newArray.length - 1].setPassword(password);
        newArray[newArray.length - 1].setLocalDate(java.time.LocalDate.now());
        newArray[newArray.length - 1].setEndedDate(java.time.LocalDate.now().plusYears(1));
        //Series[] newSeriesArray = new Series[series.length];
        //newSeriesArray = addNewArraySeriesToNewAccount(series);
        //newArray[newArray.length - 1].setSeries(series.clone());
        return newArray;
    }


    public static boolean checkIsUserNameExist(Account[] accounts, String userName) {
        Scanner in = new Scanner(System.in);
        boolean exist = false;
        if (accounts.length >= 1) {// Check if there is more than one user.
            for (int i = 0; i < accounts.length; i++) {
                String nameToCheck = accounts[i].getUserName();
                if (userName.equals(nameToCheck)) {
                    exist = true;
                    }
                }
            }
            return exist;
     }

    public static Account logIn(Account[] accounts) {
        Scanner scanner = new Scanner(System.in);
        boolean found = false;
        int numOfMistake = 0;
        int indexOfAccount = 0;
        boolean flagException =false;
        System.out.println("Please enter your user name :");
        String userName = null;
        while (flagException==false){
            try {
                userName = scanner.nextLine();
                flagException=true;
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Your input is incorrect, please press again :");
            }
        }
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getUserName().equals(userName)) {
                indexOfAccount = i;
                found = true;
            }
        }
        if (found == false) {
            System.out.println("Your user name is does not exist ");
            return null;
        }
        System.out.println("Please enter your password ");
        String password = scanner.nextLine();
        while (!password.equals(accounts[indexOfAccount].getPassword()) && numOfMistake < 4) {
            numOfMistake++;
            System.out.println("Your Password is incorrect, please enter your password again :");
            password = scanner.nextLine();
        }
        if (numOfMistake >= 4) {
            System.out.println("Sorry, there is a mistake ");
            return null;
        }
        return accounts[indexOfAccount];
    }
}