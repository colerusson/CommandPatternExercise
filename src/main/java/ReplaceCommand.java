public class ReplaceCommand implements ICommand {
    private final TextEditor _editor;
    private final int _index;
    private final int _length;
    private final String _text;

    public ReplaceCommand(TextEditor editor, int index, int length, String text) {
        _editor = editor;
        _index = index;
        _length = length;
        _text = text;
    }

    @Override
    public void execute() {
        _editor.doReplace(_index, _length, _text);
    }

    @Override
    public void undo() {
        _editor.doDelete(_index, _length);
        _editor.doInsert(_index, _text);
    }

    @Override
    public void redo() {
        _editor.doReplace(_index, _length, _text);
    }
}
