import java.util.Scanner;

public class ReplaceCommand implements ICommand {
    private final TextEditor _editor;

    public ReplaceCommand(TextEditor editor) {
        _editor = editor;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Start index: ");
        String replaceIndexInput = scanner.next();
        int replaceIndex = _editor.validateNumberInput(replaceIndexInput);
        if (replaceIndex != -1) {
            System.out.print("Number of characters to replace: ");
            String replaceDistanceInput = scanner.next();
            int replaceDistance = _editor.validateNumberInput(replaceDistanceInput);
            if (replaceDistance != -1) {
                System.out.print("Replacement string: ");
                String replacementString = scanner.next();
                _editor.deleteInDoc(replaceIndex, replaceDistance);
                _editor.insertInDoc(replaceIndex, replacementString);
            }
        }
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
