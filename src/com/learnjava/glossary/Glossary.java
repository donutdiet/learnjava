package com.learnjava.glossary;

import java.util.Comparator;

import components.map.Map;
import components.map.Map1L;
import components.queue.Queue;
import components.queue.Queue1L;
import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Program that takes in a text file and creates an HTML glossary file.
 *
 * @author Jerry Wang
 *
 */
public final class Glossary {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Glossary() {
    }

    /**
     * Compare strings in alphabetical order.
     */
    private static class CompareStrings implements Comparator<String> {
        @Override
        public int compare(String str1, String str2) {
            return str1.compareTo(str2);
        }

    }

    /**
     * Outputs the "opening" tags in the generated HTML file.
     *
     * @param out
     *            the output stream; the main glossary page
     * @updates out.content
     * @requires out.is_open
     * @ensures out.content = #out.content * [the HTML "opening" tags]
     */
    public static void createHTMLHeader(SimpleWriter out) {
        assert out != null : "Violation of: out is not null";
        assert out.isOpen() : "Violation of: out.is_open";

        // print the HTML opening tags for the main glossary page.
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Glossary</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Glossary</h2>");
        out.println("<hr>");
        out.println("<h3>Index</h3>");
        out.println("<ul>");
    }

    /**
     * Reads text file and stores term and definition as key value pairs in map.
     *
     * @param in
     *            file that is read
     * @return map w/ terms and definitions
     * @requires in.is_open and [a correctly formatted text file is input]
     * @ensures [creates a map w/ the terms and definitions found in text file]
     */
    public static Map<String, String> generateMap(SimpleReader in) {
        Map<String, String> termToDefinition = new Map1L<String, String>();

        String term = "";
        String definition = "";

        // Continue reading the input text file until end of stream has been reached.
        while (!in.atEOS()) {
            String line = in.nextLine();
            if (!line.isEmpty() && !line.contains(" ")) {
                // A line containing a term will have no spaces.
                term = line;
            } else if (!line.isEmpty()) {
                // A line containing a definition will have spaces
                definition += line;
            } else {
                /*
                 * Adds the term and definition in the map as a key value pair
                 * once an empty line is found.
                 */
                if (term.length() > 0 && definition.length() > 0) {
                    termToDefinition.add(term, definition);
                    term = "";
                    definition = "";
                }
            }
        }
        // Add the final term and definition read from the text file.
        if (termToDefinition.size() > 0) {
            termToDefinition.add(term, definition);
        }
        return termToDefinition;
    }

    /**
     * Creates a queue w/ all the keys of a map.
     *
     * @param map
     *            containing the term:definition pairs
     * @return queue w/ all the terms
     */
    public static Queue<String> generateQueue(Map<String, String> map) {
        Queue<String> queue = new Queue1L<String>();
        for (Map.Pair<String, String> pair : map) {
            String term = pair.key();
            queue.enqueue(term);
        }
        return queue;
    }

    /**
     * Sorts a queue alphabetically.
     *
     * @param queue
     *            queue to be sorted
     */
    public static void sortQueue(Queue<String> queue) {
        // Utilize the comparator to sort alphabetically.
        Comparator<String> alphabetize = new CompareStrings();
        queue.sort(alphabetize);
    }

    /**
     * Print the HTML code for the alphabetical list of the terms w/ links to
     * their individual pages.
     *
     * @param out
     *            the output stream
     * @param queue
     *            queue of terms
     */
    public static void createListOfTerms(SimpleWriter out,
            Queue<String> queue) {
        // Create a copy of the queue of terms so the original is unchanged.
        Queue<String> copy = new Queue1L<String>();
        // Loop through entire queue.
        while (queue.length() != 0) {
            // Pops the terms in alphabetical order.
            String term = queue.dequeue();
            String link = "<a href=\"" + term + ".html\">";
            out.println("<li>" + link + term + "</a></li>");
            // Create copy as a replica of the original queue.
            copy.enqueue(term);
        }
        // Transfer contents of the copy back to the original queue.
        queue.transferFrom(copy);
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
    }

    /**
     * Create the individual HTML pages for each term.
     *
     * @param location
     *            file where term HTML pages should be stored
     * @param queue
     *            contains the terms
     * @param map
     *            contains the terms and definitions as key value pairs
     */
    public static void createTermPages(String location, Queue<String> queue,
            Map<String, String> map) {
        /*
         * Create a set of characters that are considered separators, including
         * various special symbols and spaces.
         */
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

        // Loop until the queue of terms is empty.
        while (queue.length() != 0) {
            String term = queue.dequeue();
            String definition = map.value(term);
            SimpleWriter out = new SimpleWriter1L(
                    location + "/" + term + ".html");

            out.println("<html>");
            out.println("<head>");
            out.println("<title>" + term + "</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2><b><i><font color=\"red\">" + term
                    + "</font></i></b></h2>");
            out.println("<blockquote>");

            // Index to keep track of position within the definition string.
            int position = 0;
            // Loop until every character within the definition has been checked.
            while (position < definition.length()) {
                /*
                 * First word or separator within the definition ranging from
                 * the position index to the end of the string.
                 */
                String wordOrSeparator = nextWordOrSeparator(definition,
                        position, separators);
                // Check whether the word already exists as a term in the glossary.
                if (map.hasKey(wordOrSeparator)) {
                    // Create link to the term's individual HTML page.
                    out.println("<a href=\"" + wordOrSeparator + ".html\">"
                            + wordOrSeparator + "</a>");
                } else {
                    out.print(wordOrSeparator);
                }
                /*
                 * Increment position based on the length of the retrieved word
                 * or separator.
                 */
                position += wordOrSeparator.length();
            }

            out.println("</blockquote>");
            out.println("<hr />");
            out.println("<p>Return to <a href=\"index.html\">index</a>.</p>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }

    /**
     * Return next word or separator in sentence starting from given position.
     *
     * @param sentence
     *            definition of a term (consisting of letters, spaces, and
     *            special characters)
     * @param position
     *            starting index to begin iteration at
     * @param separators
     *            set of characters that divide words within the sentence
     * @return returns first found word or separator within the sentence
     */
    public static String nextWordOrSeparator(String sentence, int position,
            Set<Character> separators) {
        /*
         * Used to determine whether a word or separator is the next string
         * within the sentence.
         */
        char firstCharacter = sentence.charAt(position);
        String word = "";

        // Check whether the method should return a separator or word.
        if (!separators.contains(firstCharacter)) {
            /*
             * Loop through entire string while checking whether the next
             * character is also a letter until a separator is reached.
             */
            for (int i = position; i < sentence.length()
                    && !separators.contains(sentence.charAt(i)); i++) {
                // Add to word until separator is reached.
                word += sentence.charAt(i);
            }
        } else {
            /*
             * Loop through entire string while checking whether the next
             * character is also a separator until a letter is reached.
             */
            for (int i = position; i < sentence.length()
                    && separators.contains(sentence.charAt(i)); i++) {
                // Add to word until letter is reached.
                word += sentence.charAt(i);
            }
        }
        return word;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        // Get input text file from user.
        out.println("Enter name of text file: ");
        SimpleReader inputFile = new SimpleReader1L(in.nextLine());

        // Get the location of the glossary HTML files.
        out.println("Enter location for the glossary: ");
        String location = in.nextLine();

        // Get name of output glossary file from user.
        out.println("Enter name of the glossary file: ");
        String glossaryIndex = (in.nextLine());

        SimpleWriter outputFile = new SimpleWriter1L(
                location + "/" + glossaryIndex + ".html");

        /*
         * Create a map of the terms and definitions found in the input file
         * stored as key value pairs.
         */
        Map<String, String> mapOfTermsAndDefinitions = generateMap(inputFile);
        out.println(mapOfTermsAndDefinitions);

        // Create a queue of the terms.
        Queue<String> termsQueue = generateQueue(mapOfTermsAndDefinitions);
        out.println(termsQueue);

        // Sort the queue of terms alphabetically.
        sortQueue(termsQueue);
        out.println(termsQueue);

        /*
         * Create the header, list of terms w/ links, and footer for the main
         * Glossary page.
         */
        createHTMLHeader(outputFile);
        createListOfTerms(outputFile, termsQueue);

        // Create an individual HTML file page for each term.
        createTermPages(location, termsQueue, mapOfTermsAndDefinitions);

        in.close();
        out.close();
    }

}
