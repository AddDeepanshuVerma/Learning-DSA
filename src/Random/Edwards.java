package Random;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Edwards {
    static final String SOURCE = "D:\\Random\\Edwards.txt";

    public static void main(String[] args) {
        try {
            String text = getTextFromFile();
            String str = updateText(text);
            copyDataToClipBoard(str);
            updateTextFile(str);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static String getTextFromFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(SOURCE));
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNext()) sb.append(scanner.nextLine()).append("\n");
        scanner.close();
        return sb.toString();
    }

    private static String updateText(String str) {
        try {
            int idx = str.indexOf(':');
            int i = idx;
            while (!Character.isDigit(str.charAt(i))) i++;

            StringBuilder num = new StringBuilder();
            while (Character.isDigit(str.charAt(i))) num.append(str.charAt(i++));

            int day = Integer.parseInt(String.valueOf(num)) + 1;
            str = str.substring(0, idx + 1) + " " + day + str.substring(str.indexOf("\n"));
            System.out.println("day = " + day);
            return str;
        } catch (NumberFormatException e) {
            System.err.println("An error occurred while updating the text: ");
            throw e;
        }
    }

    private static void copyDataToClipBoard(String str) {
        try {
            str = str.replace("day :", "day : x +");
            StringSelection selection = new StringSelection(str);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(selection, selection);
            System.out.println("copied to clipboard");
        } catch (Exception e) {
            System.err.println("An error occurred while copying to clipboard");
            throw e;
        }
    }

    private static void updateTextFile(String str) {
        try (FileWriter fileWriter = new FileWriter(SOURCE)) {
            fileWriter.write(str);
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
