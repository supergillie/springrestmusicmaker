package org.test.demo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SongServiceTest {

    @Test
    void getNewSongTest(){
        SongService songser = new SongService();
        Song result = songser.getNewSong(20 );

        System.out.println(Arrays.toString(result.getSong()));

        System.out.println(result.toString());
        assertEquals(20, result.getSong().length);
    }
}