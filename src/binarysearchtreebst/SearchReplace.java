
package binarysearchtreebst;
import java.io.*;
import java.util.Scanner;

/**
 * Implements search and replace functionality using a BST.
 */
public class SearchReplace {
    private BinarySearchTree bst;

    public SearchReplace() {
        this.bst = new BinarySearchTree();
    }

    /**
     * Reads the input file, processes each word, and stores them in the BST.
     * @param filePath Path to the input file.
     */
    public void loadFileIntoBST(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split words by spaces
                for (String word : words) {
                    bst.insert(word);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * Reads a file, replaces occurrences of a target word with a replacement, and writes to a new file.
     * @param inputFilePath Path to the input file.
     * @param outputFilePath Path to the output file.
     * @param targetWord Word to be replaced.
     * @param replacementWord Replacement word.
     */
    public void searchAndReplace(String inputFilePath, String outputFilePath, String targetWord, String replacementWord) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                StringBuilder newLine = new StringBuilder();

                for (String word : words) {
                    if (bst.search(word) && word.equals(targetWord)) {
                        newLine.append(replacementWord).append(" ");
                    } else {
                        newLine.append(word).append(" ");
                    }
                }
                writer.write(newLine.toString().trim() + "\n");
            }
            System.out.println("Text replaced successfully. Check: " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}
