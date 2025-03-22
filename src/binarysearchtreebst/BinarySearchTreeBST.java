
package binarysearchtreebst;

import java.util.Scanner;

public class BinarySearchTreeBST {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SearchReplace searchReplace = new SearchReplace();

        // Get file paths and words from user
        System.out.print("Enter input file path: ");
        String inputFilePath = scanner.nextLine();
        System.out.print("Enter output file path: ");
        String outputFilePath = scanner.nextLine();
        System.out.print("Enter word to search: ");
        String targetWord = scanner.nextLine();
        System.out.print("Enter replacement word: ");
        String replacementWord = scanner.nextLine();

        // Load file and process search & replace
        searchReplace.loadFileIntoBST(inputFilePath);
        searchReplace.searchAndReplace(inputFilePath, outputFilePath, targetWord, replacementWord);
    }
}
