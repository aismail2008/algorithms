package com.code.test.problemset.CrackingCodingInterview6.ch7.Q3_Jukebox;

/**
 * Created by aliismail on 30/11/2017.
 */

import java.util.Queue;

public class Playlist {
    private Song song;
    private Queue<Song> queue;

    public Playlist(Song song, Queue<Song> queue) {
        super();
        this.song = song;
        this.queue = queue;
    }

    public Song getNextSongToPlay() {
        return queue.peek();
    }

    public void queueUpSong(Song s) {
        queue.add(s);
    }
}
