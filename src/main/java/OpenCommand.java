import java.util.Scanner;

public class OpenCommand implements ICommand {
    private final TextEditor _editor;

    public OpenCommand(TextEditor editor) {
        _editor = editor;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Name of file to open: ");
        String openFileName = scanner.next();
        _editor.openFile(openFileName);
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
