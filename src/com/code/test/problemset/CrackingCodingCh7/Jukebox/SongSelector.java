package com.code.test.problemset.CrackingCodingCh7.Jukebox;

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
