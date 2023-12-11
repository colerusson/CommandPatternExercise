public class OpenCommand implements ICommand {
    private final TextEditor _editor;

    public OpenCommand(TextEditor editor) {
        _editor = editor;
    }

    @Override
    public void execute() {
        _editor.openDoc();
    }

    @Override
    public void undo() {
        _editor.closeDoc();
    }

    @Override
    public void redo() {
        _editor.openDoc();
    }
}
