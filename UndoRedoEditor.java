import java.util.*;

public class UndoRedoEditor {

    static Stack<String> undo = new Stack<>();
    static Stack<String> redo = new Stack<>();
    static String text = "";

    static void type(String str) {
        undo.push(text);
        text += str;
        redo.clear();
        System.out.println("Current Text: " + text);
    }

    static void undo() {
        if (!undo.isEmpty()) {
            redo.push(text);
            text = undo.pop();
        } else {
            System.out.println("Nothing to undo!");
        }
        System.out.println("Current Text: " + text);
    }

    static void redo() {
        if (!redo.isEmpty()) {
            undo.push(text);
            text = redo.pop();
        } else {
            System.out.println("Nothing to redo!");
        }
        System.out.println("Current Text: " + text);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Type 2.Undo 3.Redo 4.Exit");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter text: ");
                    String str = sc.next();
                    type(str);
                    break;
                case 2:
                    undo();
                    break;
                case 3:
                    redo();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid!");
            }
        }
    }
}
