package com.code.test.problemset.CrackingCodingInterview6.ch7.Q3_Jukebox;

/**
 * Created by aliismail on 30/11/2017.
 */
public class SongSelector {
    private Song currentSong;

    public SongSelector(Song s) {
        currentSong = s;
    }

    public void setSong(Song s) {
        currentSong = s;
    }

    public Song getCurrentSong() {
        return currentSong;
    }
}
