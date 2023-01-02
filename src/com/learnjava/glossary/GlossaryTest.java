package com.learnjava.glossary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.map.Map;
import components.map.Map1L;
import components.queue.Queue;
import components.queue.Queue1L;
import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * @author Jerry Wang
 *
 */
public class GlossaryTest {

    /*
     * Tests for generateMap method.
     *
     * Base Test: inputFile is empty
     *
     * Routine Test 1: terms w/ dashes
     *
     * Routine Test 2: terms w/ numbers , definitions w/o letters
     *
     */
    @Test
    public void testGenerateMapBase() {
        SimpleReader inputFile = new SimpleReader1L("data/testEmpty.txt");
        Map<String, String> map = Glossary.generateMap(inputFile);

        Map<String, String> mapExpected = new Map1L<String, String>();

        assertEquals(map, mapExpected);
    }

    @Test
    public void testGenerateMapRoutine1() {
        SimpleReader inputFile = new SimpleReader1L("data/testRoutine1.txt");
        SimpleWriter out = new SimpleWriter1L();

        Map<String, String> map = Glossary.generateMap(inputFile);

        Map<String, String> mapExpected = new Map1L<String, String>();
        mapExpected.add("Bing-chilling",
                "good morning china, right now I have");
        mapExpected.add("Ohio-Boss", "made in Ohio!");
        mapExpected.add("Idk", "I don't know");

        assertEquals(map, mapExpected);
    }

    @Test
    public void testGenerateMapRoutine2() {
        SimpleReader inputFile = new SimpleReader1L("data/testRoutine2.txt");
        SimpleWriter out = new SimpleWriter1L();

        Map<String, String> map = Glossary.generateMap(inputFile);

        Map<String, String> mapExpected = new Map1L<String, String>();
        mapExpected.add("....", "!!!! !! !!");
        mapExpected.add("8374", "883837 737");

        assertEquals(map, mapExpected);
    }

    /*
     * Tests for generateQueue method.
     *
     * Base Test: map is empty
     *
     * Routine Test 1: same map from generateMap Routine Test 1
     *
     * Routine Test 2: same map from generateMap Routine Test 2
     */
    @Test
    public void testGenerateQueueBase() {
        Map<String, String> map = new Map1L<String, String>();
        Queue<String> queue = new Queue1L<String>();

        Queue<String> queueExpected = Glossary.generateQueue(map);

        assertEquals(queue, queueExpected);
    }

    @Test
    public void testGenerateQueueRoutine1() {
        Map<String, String> map = new Map1L<String, String>();
        map.add("Bing-chilling", "good morning china, right now I have");
        map.add("Ohio-Boss", "made in Ohio!");
        map.add("Idk", "I don't know");
        Queue<String> queue = new Queue1L<String>();
        queue.enqueue("Bing-chilling");
        queue.enqueue("Ohio-Boss");
        queue.enqueue("Idk");

        Queue<String> queueExpected = Glossary.generateQueue(map);

        assertEquals(queue, queueExpected);
    }

    @Test
    public void testGenerateQueueRoutine2() {
        Map<String, String> map = new Map1L<String, String>();
        map.add("....", "!!!! !! !!");
        map.add("8374", "883837 737");
        Queue<String> queue = new Queue1L<String>();
        queue.enqueue("8374");
        queue.enqueue("....");

        Queue<String> queueExpected = Glossary.generateQueue(map);

        assertEquals(queue, queueExpected);
    }

    /*
     * Tests for nextWordOrSeparator method.
     *
     * Base Test: empty sentence
     *
     * Routine Test 1: definition of the first term from generateMap Routine 1
     */
    @Test
    public void testNextWordOrSeparatorBase() {
        String sentence = "";
        int position = 0;
        Set<Character> separators = new Set1L<Character>();
        separators.add(' ');
        separators.add(',');
        separators.add('.');
        separators.add('?');
        separators.add('!');
        separators.add(';');
        separators.add(':');
        separators.add('/');
        separators.add('-');

        Sequence<String> allWords = new Sequence1L<String>();
        int index = 0;

        while (position < sentence.length()) {
            String word = Glossary.nextWordOrSeparator(sentence, position,
                    separators);
            allWords.add(index, word);
            position += word.length();
        }

        Sequence<String> allWordsExpected = new Sequence1L<String>();

        assertEquals(allWords, allWordsExpected);
    }

    @Test
    public void testNextWordOrSeparatorRoutine1() {
        String sentence = "good morning china, right now I have";
        int position = 0;
        Set<Character> separators = new Set1L<Character>();
        separators.add(' ');
        separators.add(',');
        separators.add('.');
        separators.add('?');
        separators.add('!');
        separators.add(';');
        separators.add(':');
        separators.add('/');
        separators.add('-');

        Sequence<String> allWords = new Sequence1L<String>();

        int index = 0;
        while (position < sentence.length()) {
            String word = Glossary.nextWordOrSeparator(sentence, position,
                    separators);
            allWords.add(index, word);
            position += word.length();
            index++;
        }

        Sequence<String> allWordsExpected = new Sequence1L<String>();
        allWordsExpected.add(0, "good");
        allWordsExpected.add(1, " ");
        allWordsExpected.add(2, "morning");
        allWordsExpected.add(3, " ");
        allWordsExpected.add(4, "china");
        allWordsExpected.add(5, ", ");
        allWordsExpected.add(6, "right");
        allWordsExpected.add(7, " ");
        allWordsExpected.add(8, "now");
        allWordsExpected.add(9, " ");
        allWordsExpected.add(10, "I");
        allWordsExpected.add(11, " ");
        allWordsExpected.add(12, "have");

        assertEquals(allWords, allWordsExpected);
    }

}
