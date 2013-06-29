package com.vocabist.rest;

import com.vocabist.client.WordnikClient;
import com.wordnik.client.model.Definition;

import javax.ejb.Singleton;
import javax.ws.rs.PathParam;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/**
 * Created with IntelliJ IDEA.
 * User: jn
 * Date: 6/28/13
 * Time: 5:29 PM
 * To change this template use File | Settings | File Templates.
 */

@Singleton
@Path("voc")
public class VocabService {

    public VocabService() {
    }

    @GET
    @Path("word/definition/{word}")
    @Produces("application/json")
    public Definition getWordDefinition(@PathParam("word") String word) {
        return WordnikClient.getWordDefinition(word);
    }

    public static class WordDefJson
    {
        public java.lang.String extendedText;
        public java.lang.String text;
        public java.lang.String sourceDictionary;
//        public java.util.List<com.wordnik.client.model.Citation> citations;
//        public java.util.List<com.wordnik.client.model.Label> labels;
        public java.lang.Float score;
//        public java.util.List<com.wordnik.client.model.ExampleUsage> exampleUses;
        public java.lang.String attributionUrl;
        public java.lang.String seqString;
        public java.lang.String attributionText;
//        public java.util.List<com.wordnik.client.model.Related> relatedWords;
        public java.lang.String sequence;
        public java.lang.String word;
//        public java.util.List<com.wordnik.client.model.Note> notes;
//        public java.util.List<com.wordnik.client.model.TextPron> textProns;
        public java.lang.String partOfSpeech;

        public WordDefJson(String sourceDictionary, String text, String word) {
            this.sourceDictionary = sourceDictionary;
            this.text = text;
            this.word = word;
        }

        public WordDefJson(Definition def){
            this(def.getSourceDictionary(),def.getText(),def.getWord());
        }

        @Override
        public String toString() {
            return "WordDefJson{" +
                    "extendedText='" + extendedText + '\'' +
                    ", text='" + text + '\'' +
                    ", sourceDictionary='" + sourceDictionary + '\'' +
                    ", score=" + score +
                    ", attributionUrl='" + attributionUrl + '\'' +
                    ", seqString='" + seqString + '\'' +
                    ", attributionText='" + attributionText + '\'' +
                    ", sequence='" + sequence + '\'' +
                    ", word='" + word + '\'' +
                    ", partOfSpeech='" + partOfSpeech + '\'' +
                    '}';
        }
    }

}
