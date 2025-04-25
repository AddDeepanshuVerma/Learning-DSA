import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Scanner;

public class Braces {
    public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine();
        str = str.replace('[', '{');
        str = str.replace(']', '}');
        str = str.replace('\"', '\'');

        StringSelection selection = new StringSelection(str);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
        System.out.println("updated content is copied to clipboard");
    }
}
