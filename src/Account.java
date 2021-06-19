import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Account {
    private String userName;
    private String password;
    private LocalDate localDate;
    private LocalDate endedDate;
    private Series [] series;


    public Account(String userName, String password, Date date) {
        this.userName = userName;
        this.password = password;
        this.localDate=localDate;
        this.endedDate=java.time.LocalDate.now().plusYears(1);
    }

    public Account(Series [] theOldSeries) {
        this.userName="";
        this.password="";
        this.localDate=java.time.LocalDate.now();
        this.endedDate=java.time.LocalDate.now().plusYears(1);
        this.setSeries(new Series[theOldSeries.length]);
        Series [] myNewSeriesArray= new Series[theOldSeries.length];
        myNewSeriesArray=theOldSeries.clone();
        this.setSeries(myNewSeriesArray);
    }

    public Account(){

    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public LocalDate getEndedDate() {
        return endedDate;
    }

    public void setEndedDate(LocalDate endedDate) {
        this.endedDate = endedDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password=checkIsStrongPassword(password);
    }

    public Series[] getSeries() {
        return series;
    }

    public void setSeries(Series[] series) {
        this.series = series;
    }

    public static String checkIsStrongPassword (String password){
        Scanner in = new Scanner(System.in);
        boolean isStrong=false;
        int countChars=0;
        int countNumbers=0;
        int countLetters=0;
        while (isStrong==false){
            for (int i=0; i<password.length();i++){
                countChars++;
                if(Character.isDigit(password.charAt(i))){
                    countNumbers++;
                }
                else if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z' || password.charAt(i) >= 'A' && password.charAt(i) <= 'Z'){
                    countLetters++;
                }
            }
            if (countChars<6){
                System.out.println("the password need to be 6 chars at least, please enter new password : ");
                password=in.nextLine();
            }
            if (countChars>=6 && countLetters>=1 && countNumbers>=1){
                isStrong=true;
            }
            else {
                System.out.println("the password need to include 1 number and 1 letter in english at least, please enter new password : ");
                password=in.nextLine();
            }
        }
        return password;
    }

//    public Account copyAccount(Account account, Series [] seriesToCopy){
//        Account newAccount = new Account();
//        newAccount.userName= account.getUserName();
//        newAccount.password=account.getPassword();
//        newAccount.localDate=account.getLocalDate();
//        newAccount.endedDate=account.getEndedDate();
//        Series [] copiedSeries = new Series[seriesToCopy.length];
//        for (int i=0; i< account.getSeries().length;i++){
//            copiedSeries[i]= new Series();
//            copiedSeries[i].copySeries(seriesToCopy[i],seriesToCopy[i].getEpisodes());
//        }
//        newAccount.setSeries(copiedSeries);
//        return newAccount;
//    }

}
