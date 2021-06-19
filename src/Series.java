public class Series {
    private String name;
    private Episodes [] episodes;
    private boolean isStarted;
    private int numOfEpisodes;
    private boolean isFinishToWatch;
    private Episodes lastEpisodesWatch;

    public Series(String name, Episodes[] episodes, boolean isStarted, int numOfEpisodes, boolean isFinishToWatch) {
        this.name = name;
        this.episodes = episodes;
        this.isStarted = isStarted;
        this.numOfEpisodes = numOfEpisodes;
        this.isFinishToWatch = isFinishToWatch;
        this.lastEpisodesWatch=null;
    }

    public Series(Series theOldSery) {

    }


    public boolean isFinishToWatch() {
        return isFinishToWatch;
    }

    public void setFinishToWatch(boolean finishToWatch) {
        isFinishToWatch = finishToWatch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Series() {
        this.isStarted=false;
    }

    public Episodes[] getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Episodes[] episodes) {
        this.episodes = episodes;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }

    public int getNumOfEpisodes() {
        return numOfEpisodes;
    }

    public void setNumOfEpisodes(int numOfEpisodes) {
        this.numOfEpisodes = numOfEpisodes;
    }

    public Episodes getLastEpisodesWatch() {
        return lastEpisodesWatch;
    }

    public void setLastEpisodesWatch(Episodes lastEpisodesWatch) {
        this.lastEpisodesWatch = lastEpisodesWatch;
    }

//    public Series copySeries (Series seriesToCopy, Episodes[] episodes){
//        Series copiedSeries=new Series();
//        copiedSeries.isStarted=seriesToCopy.isStarted;
//        copiedSeries.name=(seriesToCopy.name);
//        copiedSeries.numOfEpisodes=seriesToCopy.numOfEpisodes;
//        copiedSeries.isFinishToWatch=seriesToCopy.isFinishToWatch;
//        for (int i =0; i<seriesToCopy.getEpisodes().length;i++){
//            episodes[i].copyEpisodes(seriesToCopy.getEpisodes()[i]);
//        }
//        //copiedSeries.setEpisodes(episodes);
//        copiedSeries.episodes=new Episodes[episodes.length];
//        for (int i = 0; i< episodes.length; i++){
//            copiedSeries.episodes[i]=new Episodes();
//            copiedSeries.episodes[i].copyEpisodes(episodes[i]);
//        }
//        return copiedSeries;
//    }
}
