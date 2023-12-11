public class StartCommand implements ICommand {
    private final TextEditor _editor;

    public StartCommand(TextEditor editor) {
        _editor = editor;
    }

    @Override
    public void execute() {
        _editor.clear();
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
