package com.vocabist.entity.info;

import com.wordnik.client.model.Bigram;
import com.wordnik.client.model.Definition;
import com.wordnik.client.model.Example;
import com.wordnik.client.model.Related;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jn
 * Date: 7/4/13
 * Time: 4:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class VocabWord implements Serializable {
    public List<Definition> definitions;
    public List<Example> examples;
    public List<String> etymologies;
    public List<String> synonyms;
}
