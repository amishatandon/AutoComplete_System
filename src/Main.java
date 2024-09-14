import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();

        // Insert some words into the Trie
        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");
        trie.insert("applet");
        trie.insert("bat");
        trie.insert("ball");
        trie.insert("batman");

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter prefix to autocomplete:");

        while (true) {
            String prefix = scanner.nextLine();
            if (prefix.equals("exit")) {
                break;
            }

            List<String> suggestions = trie.autocomplete(prefix);
            System.out.println("Suggestions: " + suggestions);
        }

        scanner.close();
    }
}

