import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.WeakHashMap;

public class Main {
    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

        Series [] series= new Series[4];
        for (int i=0;i<series.length;i++){
            series[i]=new Series();
        }
        series[0].setName("The Last Dance");
        series[1].setName("Breaking Bad");
        series[2].setName("Lupin");
        series[3].setName("Who Killed Sara");
        Summary summary= new Summary();

        Episodes [] TheLastDance= new Episodes[3];
        Episodes [] BreakingBad= new Episodes[3];
        Episodes [] Lupin= new Episodes[3];
        Episodes [] WhoKilledSara= new Episodes[3];

        for (int i =0; i<Lupin.length;i++){
            TheLastDance[i]=new Episodes();
            TheLastDance[i].setEpisodesNumber(i+1);
            TheLastDance[i].setEpisodesName("The Last Dance "+(i+1));
            BreakingBad[i]=new Episodes();
            BreakingBad[i].setEpisodesNumber(i+1);
            BreakingBad[i].setEpisodesName("BreakingBad "+(i+1));
            Lupin[i]=new Episodes();
            Lupin[i].setEpisodesNumber(i+1);
            Lupin[i].setEpisodesName("Lupin "+(i+1));
            WhoKilledSara[i]=new Episodes();
            WhoKilledSara[i].setEpisodesNumber(i+1);
            WhoKilledSara[i].setEpisodesName("WhoKilledSara "+(i+1));
        }
        TheLastDance[0].setSummary(summary.getTheLastDanceSummary1());
        TheLastDance[1].setSummary(summary.getTheLastDanceSummary2());
        TheLastDance[2].setSummary(summary.getTheLastDanceSummary3());

        BreakingBad[0].setSummary(summary.getBreakingBadSummary1());
        BreakingBad[1].setSummary(summary.getBreakingBadSummary2());
        BreakingBad[2].setSummary(summary.getBreakingBadSummary3());

        Lupin[0].setSummary(summary.getLupinSummary1());
        Lupin[1].setSummary(summary.getLupinSummary2());
        Lupin[2].setSummary(summary.getLupinSummary3());

        WhoKilledSara[0].setSummary(summary.getWhoKilledSaraSummary1());
        WhoKilledSara[1].setSummary(summary.getWhoKilledSaraSummary2());
        WhoKilledSara[2].setSummary(summary.getWhoKilledSaraSummary3());

        series[0].setEpisodes(TheLastDance);
        series[1].setEpisodes(BreakingBad);
        series[2].setEpisodes(Lupin);
        series[3].setEpisodes(WhoKilledSara);

        Account [] accounts = new Account[0];
        Netflix netflix = new Netflix(accounts);

//        accounts[0]= new Account(series);
//        netflix.getAccounts()[0].setUserName("Tzions888");
//        netflix.getAccounts()[0].setPassword("tzion123");
//        netflix.getAccounts()[0].setSeries(series);
//        netflix.getAccounts()[0].setLocalDate(java.time.LocalDate.now());
        boolean isContinue = true;

        while (isContinue==true){
            int userSelection = (firstMenu());
            if (userSelection==1){
                accounts=netflix.addAccount(accounts,series);
                netflix.setAccounts(accounts);
                System.out.println("Hi "+netflix.getAccounts()[accounts.length-1].getUserName());
                secondMenu(netflix.getAccounts()[accounts.length-1]);

            }
            if (userSelection==2 ){
                if(accounts.length>0){
                    Account currentAccount=new Account(series);
                    currentAccount=netflix.logIn(accounts);
                    int indexCurrentAccount=0;
                    if(currentAccount!=null){
                        for (int i=0;i<accounts.length;i++){
                            if (accounts[i].getUserName().equals(currentAccount.getUserName())){
                                indexCurrentAccount=i;
                            }
                        }
                        //netflix.getAccounts()[indexCurrentAccount]=currentAccount;
                        netflix.getAccounts()[indexCurrentAccount].setSeries(currentAccount.getSeries());
                        System.out.println("Hi "+netflix.getAccounts()[indexCurrentAccount].getUserName());
                        //netflix.setAccounts=secondMenu(netflix.getAccounts()[indexCurrentAccount]);
                        accounts[indexCurrentAccount]=currentAccount;
                        netflix.setAccounts(accounts);
                        secondMenu(netflix.getAccounts()[indexCurrentAccount]);
                    }
                }
                else {
                    System.out.println("There are currently no existing accounts, but you can be the first if you choose to open a new account");
                }
            }
        }
    }

    public static int firstMenu () {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to Netflix ");
        System.out.println("");
        System.out.println("For create a new account press 1 ");
        System.out.println("For connect to an existing account press 2 ");
        int userSelection = 0;
        boolean flagException=false;
        while (flagException==false){
            try {
                userSelection = in.nextInt();
                flagException=true;
            }catch (Exception e){
                in.nextLine();
                System.out.println("Your input is incorrect, please press again :");
            }
        }
        flagException=false;
        while (userSelection !=1 && userSelection !=2 && flagException==false){
            System.out.println("your selection needs to be number between 1 to 2, please press again :");
            try {
                userSelection=in.nextInt();
                if (userSelection>=1 && userSelection <=2)
                    flagException=true;
            }catch (Exception e){
                in.nextLine();
            }
        }
        return userSelection;
    }

    public static int secondMenu (Account account){
        Scanner in = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        boolean flagException=false;
        System.out.println("What you want to do?");
        System.out.println("(1) View the list of all series,\n" +
                "(2) View the list of series you started watching,\n" +
                "(3) View subscription details,\n" +
                "(4) Select the series to view,\n" +
                "(5) Disconnected.");
        int userSelection=0;
        while (flagException==false){
            try {
                userSelection=in.nextInt();
                flagException=true;
            }catch (Exception e){
                in.nextLine();
                System.out.println("Your input is incorrect, please try again :");
            }
        }
        switch (userSelection) {
            case 1:
                System.out.println("The series in Netflix are :");
                for (int i=0;i<account.getSeries().length;i++){
                    System.out.println((i+1)+". "+account.getSeries()[i].getName());
                }
                secondMenu(account);
                break;
            case 2:
                boolean isStartedToWatchSomething=false;
                for (int i=0;i<account.getSeries().length;i++) {
                    if (account.getSeries()[i].isStarted() == true) {
                        System.out.println((i+1 )+ ". " + account.getSeries()[i].getName());
                        isStartedToWatchSomething=true;
                    }
                    for (int j = 0; j < account.getSeries()[i].getEpisodes().length; j++) {
                     if (account.getSeries()[i].getEpisodes()[j].isStarted()==true) {
                         System.out.println(account.getSeries()[i].getName() +" Episodes number" + ":" + account.getSeries()[i].getEpisodes()[j].getEpisodesNumber()+":");
                         System.out.println("The last episodes you watch in this series is : " + account.getSeries()[i].getLastEpisodesWatch().getEpisodesName());
                         isStartedToWatchSomething=true;
                        }
                     }
                }
                if (isStartedToWatchSomething==false)
                    System.out.println("You dont started to watch anything yet ");
                secondMenu(account);
                break;
            case 3:
                System.out.println("Your account was create in "+account.getLocalDate());
                System.out.println("Your account will be ended in "+ account.getEndedDate());
                int countFinishSeries=0;
                int countStartedSeries=0;
                int countFinishEpisodes=0;
                for (int i=0; i<account.getSeries().length;i++){
                    if (account.getSeries()[i].isFinishToWatch()==true)
                        countFinishSeries++;
                    else if (account.getSeries()[i].isStarted()==true)
                        countStartedSeries++;
                    for (int j=0;j<account.getSeries()[i].getEpisodes().length;j++){
                        if (account.getSeries()[i].getEpisodes()[j].isFinishToWatch()==true)
                            countFinishEpisodes++;
                    }
                }
                System.out.println("You started to watch "+countStartedSeries +" series, and you finish to watch  "+countFinishSeries+ " series, and "+countFinishEpisodes+" episodes ");
                secondMenu(account);
                break;
            case 4:
                System.out.println("please enter the name of the series that you want to watch :");
                String seriesToWatch= null;
                flagException=false;
                while (flagException==false){
                    try {
                        seriesToWatch = scan.nextLine();
                        flagException=true;
                    } catch (Exception e) {
                        scan.nextLine();
                        e.printStackTrace();
                    }
                }
                boolean isSeriesExist=false;
                int indexOfTheEpisodes = 0;
                for (int i=0; i<account.getSeries().length;i++){
                    if (seriesToWatch.equals(account.getSeries()[i].getName())) {
                        isSeriesExist = true;
                        indexOfTheEpisodes=i;
                    }
                }
                if (isSeriesExist==false) {
                    System.out.println("This series is not exist ");
                    break;
                }
                    System.out.println("The episodes in "+seriesToWatch+" are :");
                    for (int i=0; i<account.getSeries()[indexOfTheEpisodes].getEpisodes().length;i++) {
                        System.out.println(account.getSeries()[indexOfTheEpisodes].getEpisodes()[i].getEpisodesName());
                        System.out.println(account.getSeries()[indexOfTheEpisodes].getEpisodes()[i].getSummary());
                        System.out.println("");
                        System.out.println("This episodes was uploaded to Netiflix in " + account.getLocalDate());
                        System.out.println("");
                    }
                    if (account.getSeries()[indexOfTheEpisodes].isStarted()==true) {
                        System.out.println("The last episodes you watched is : " + account.getSeries()[indexOfTheEpisodes].getLastEpisodesWatch());
                    }
                    System.out.println("Which episodes do you want to watch? please enter the number of the episodes : ");
                    flagException=false;
                    int numEpisodesToWatch= 0;
                    while (flagException==false){
                        try {
                            numEpisodesToWatch = in.nextInt();
                            flagException = true;
                        }catch (Exception e) {
                            scan.nextLine();
                            System.out.println("Your input is incorrect");
                        }
                    }
                    numEpisodesToWatch--;
                    if (numEpisodesToWatch<=account.getSeries()[indexOfTheEpisodes].getEpisodes().length-1 && numEpisodesToWatch>=0){
                        account.getSeries()[indexOfTheEpisodes].getEpisodes()[numEpisodesToWatch].setStarted(true);
                        account.getSeries()[indexOfTheEpisodes].getEpisodes()[numEpisodesToWatch].setFinishToWatch(true);
                        //account.getSeries()[indexOfTheEpisodes].setStarted(true);
                        account.getSeries()[indexOfTheEpisodes].setLastEpisodesWatch(account.getSeries()[indexOfTheEpisodes].getEpisodes()[numEpisodesToWatch]);
                    }
                    else {
                        System.out.println("Sorry, but there is no such episode");
                    }
                secondMenu(account);
                break;
            case 5:
                break;
            default:
                break;
        }
        return userSelection;
    }
}
