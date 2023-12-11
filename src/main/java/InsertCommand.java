import java.util.Scanner;

public class InsertCommand implements ICommand {
    private final TextEditor _editor;

    public InsertCommand(TextEditor editor) {
        _editor = editor;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Start index: ");
        String insertionIndexInput = scanner.next();
        int insertionIndex = _editor.validateNumberInput(insertionIndexInput);
        if (insertionIndex != -1) {
            System.out.print("Sequence to insert: ");
            String sequenceInput = scanner.next();
            _editor.insertInDoc(insertionIndex, sequenceInput);
        }
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
