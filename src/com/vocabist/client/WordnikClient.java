package com.vocabist.client;

import com.sun.jersey.spi.resource.Singleton;
import com.wordnik.client.api.WordApi;
import com.wordnik.client.common.ApiException;
import com.wordnik.client.model.Definition;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: jn
 * Date: 6/28/13
 * Time: 5:34 PM
 * To change this template use File | Settings | File Templates.
 */

public class WordnikClient {
    private static Logger log = Logger.getLogger(WordnikClient.class.getName());

    private static WordApi api = new WordApi();
    private static final String key = "f530b641c90ed605cc6170268b90d99d44abd898847f05e2d";

    public static void init() {
        api.getInvoker().addDefaultHeader("api_key", key);
        log.log(Level.INFO,"Init");
    }

    public static Definition getWordDefinition(String word) {
        List<Definition> definitions = null;
        Definition definition= null;

        try {
            init();
            definitions = api.getDefinitions(
                    word, //  word
                    "", //  only get definitions which are "nouns"
                    "", //  use wiktionary
                    1, //  fetch only 3 results max
                    "true", //  return related words
                    "true", //  fetch the canonical version of this word (Cat => cat)
                    "false" //  return XML mark-up in response
            );

//            definition = definitions != null && definitions.size() > 0 ? definitions.get(0).getText(): null;
            definition = definitions != null && definitions.size() > 0 ? definitions.get(0) : null;
        } catch (ApiException ex) {
            Logger.getLogger(WordnikClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        return definition;
    }
}
