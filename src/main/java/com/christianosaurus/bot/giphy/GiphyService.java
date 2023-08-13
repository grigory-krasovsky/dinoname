package com.christianosaurus.bot.giphy;

import at.mukprojects.giphy4j.Giphy;
import at.mukprojects.giphy4j.entity.search.SearchFeed;
import at.mukprojects.giphy4j.exception.GiphyException;
import com.christianosaurus.bot.data.Dinosaur;

import java.util.concurrent.ThreadLocalRandom;

import static com.christianosaurus.bot.utils.PropertyService.getProperty;

public class GiphyService {
    public static String getGif(Dinosaur dinosaur) throws GiphyException {
        Giphy giphy = new Giphy(getProperty("giphy.token"));
        System.out.printf("Dino is %s\n", dinosaur.getName());
        SearchFeed feed;

        feed = giphy.search(dinosaur.getName(), 100, 0);
        if (feed.getDataList().isEmpty()) {
            feed = giphy.search(dinosaur.getAltName(), 100, 0);
            if (feed.getDataList().isEmpty()) {
                feed = giphy.search("dinosaur", 1000, 0);
            }
        }
        int r = ThreadLocalRandom.current().nextInt(0, feed.getDataList().size());

        return feed.getDataList().get(r).getBitlyUrl();
    }
}
