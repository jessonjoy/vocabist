package com.vocabist.web;

import com.wordnik.client.api.*;
import com.wordnik.client.model.*;

import com.wordnik.client.common.ApiException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jn
 * Date: 6/28/13
 * Time: 3:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class Test {

    public static void main(String[] args) {
//        if(args.length == 0) {
//            System.out.println("Pass your API key as an argument");
//            System.exit(0);
//        }


        try {
            String key = "f530b641c90ed605cc6170268b90d99d44abd898847f05e2d";
            WordApi api = new WordApi();
            api.getInvoker().addDefaultHeader("api_key", key);
            List<Definition> definitions = api.getDefinitions(
                    "Cat",         //  word
                    "noun",        //  only get definitions which are "nouns"
                    "wiktionary",  //  use wiktionary
                    1,             //  fetch only 3 results max
                    "true",        //  return related words
                    "true",        //  fetch the canonical version of this word (Cat => cat)
                    "false"        //  return XML mark-up in response
            );

            for(Definition def : definitions) {
                System.out.print(def);
            }

            api.getExamples("vacillate", "false", "false", 0,5);

            //get Word
            WordObject word = api.getWord("Lexicon","true","true");
            System.out.print(word);

            //get Word
//            WordObject word = api.getPhrases("Lexicon","true","true");
//            System.out.print(word);
        }
        catch (ApiException e) {
            e.printStackTrace();
        }
    }

}
