import java.util.Random;

public class Episodes {
    private String episodesName;
    private boolean isStarted;
    private boolean isFinishToWatch;
    private int numOfminuteOfTheEpiodes;
    private int episodesNumber;
    private String summary;



    public Episodes(boolean isStarted, boolean isFinishToWatch, int numOfminuteOfTheEpiodes, int episodesNumber) {
        this.isStarted = isStarted;
        this.isFinishToWatch = isFinishToWatch;
        this.numOfminuteOfTheEpiodes = numOfminuteOfTheEpiodes;
        this.episodesNumber = episodesNumber;
        this.summary=" ";

    }
    public Episodes(){
        Random random=new Random();
        this.isStarted=false;
        this.isFinishToWatch=false;
        this.numOfminuteOfTheEpiodes=random.nextInt(100)+10;
        this.summary=" ";
    }

    public String getEpisodesName() {
        return episodesName;
    }

    public void setEpisodesName(String episodesName) {
        this.episodesName = episodesName;
    }

    public int getEpisodesNumber() {
        return episodesNumber;
    }

    public void setEpisodesNumber(int episodesNumber) {
        this.episodesNumber = episodesNumber;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }

    public int getNumOfminuteOfTheEpiodes() {
        return numOfminuteOfTheEpiodes;
    }

    public void setNumOfminuteOfTheEpiodes(int numOfminuteOfTheEpiodes) {
        this.numOfminuteOfTheEpiodes = numOfminuteOfTheEpiodes;
    }

    public boolean isFinishToWatch() {
        return isFinishToWatch;
    }

    public void setFinishToWatch(boolean finishToWatch) {
        isFinishToWatch = finishToWatch;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

//    public Episodes copyEpisodes (Episodes episodesToCopy){
//        Episodes newEpisodes= new Episodes();
//        newEpisodes.episodesName=episodesToCopy.episodesName;
//        newEpisodes.isStarted=episodesToCopy.isStarted;
//        newEpisodes.isFinishToWatch=episodesToCopy.isFinishToWatch;
//        newEpisodes.numOfminuteOfTheEpiodes=episodesToCopy.numOfminuteOfTheEpiodes;
//        newEpisodes.episodesNumber=episodesToCopy.episodesNumber;
//        newEpisodes.summary=episodesToCopy.summary;
//        return newEpisodes;
//    }
}
