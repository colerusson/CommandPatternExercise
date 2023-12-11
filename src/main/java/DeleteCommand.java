import java.util.Scanner;

public class DeleteCommand implements ICommand {
    private final TextEditor _editor;

    public DeleteCommand(TextEditor editor) {
        _editor = editor;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Start index: ");
        String deletionIndexInput = scanner.next();
        int deletionIndex = _editor.validateNumberInput(deletionIndexInput);
        if (deletionIndex != -1) {
            System.out.print("Number of characters to delete: ");
            String deletionDistanceInput = scanner.next();
            int deletionDistance = _editor.validateNumberInput(deletionDistanceInput);
            if (deletionDistance != -1) {
                if (_editor.deleteInDoc(deletionIndex, deletionDistance) == null) {
                    System.out.println("Deletion unsuccessful");
                }
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
