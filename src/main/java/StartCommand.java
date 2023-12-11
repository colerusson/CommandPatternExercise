public class StartCommand implements ICommand {
    private final TextEditor _editor;

    public StartCommand(TextEditor editor) {
        _editor = editor;
    }

    @Override
    public void execute() {
        _editor.startDoc();
    }

    @Override
    public void undo() {
        _editor.closeDoc();
    }

    @Override
    public void redo() {
        _editor.startDoc();
    }
}
