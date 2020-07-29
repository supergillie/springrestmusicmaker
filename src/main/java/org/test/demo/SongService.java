package org.test.demo;



import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




@ImportResource({ "classpath: x.txt"  })
public class SongService {

    public Song getNewSong(int antalOrd) {

        Song song = new Song();

        String oneWord = MovieLines.getAllWords();

        String[] totalwords = oneWord.split(", ");

        String[] words = reducewordlistWithRandomization(totalwords, antalOrd);

        song.setSong(words);
        song.title = words[1];
        song.setCreationDate(LocalDateTime.now());


        return song;
    }

    private String[] reducewordlistWithRandomization(String[] totalwords, int antalOrd) {
        String[] returnList = new String[antalOrd];
        for(int i = 0; i < antalOrd; i++) {
            int random = Double.valueOf(Math.random() * (totalwords.length)).intValue();
           // System.out.println(i + totalwords[random]);
            returnList[i] = totalwords[random];
            i++;

           // System.out.println(i + totalwords[random+1]);
            returnList[i] = totalwords[random + 1];

        }

       // System.out.println(Arrays.toString(returnList));
        return returnList;


    }
}
