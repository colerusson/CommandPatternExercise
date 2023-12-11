public class InsertCommand implements ICommand {
    private final TextEditor _editor;
    private final int _index;
    private final String _text;

    public InsertCommand(TextEditor editor, int index, String text) {
        _editor = editor;
        _index = index;
        _text = text;
    }

    @Override
    public void execute() {
        _editor.doInsert(_index, _text);
    }

    @Override
    public void undo() {
        _editor.doDelete(_index, _text.length());
    }

    @Override
    public void redo() {
        _editor.doInsert(_index, _text);
    }
}
