public class DeleteCommand implements ICommand {
    private final TextEditor _editor;
    private final int _index;
    private final int _length;

    public DeleteCommand(TextEditor editor, int index, int length) {
        _editor = editor;
        _index = index;
        _length = length;
    }

    @Override
    public void execute() {
        _editor.doDelete(_index, _length);
    }

    @Override
    public void undo() {
        _editor.doInsert(_index, null);
    }

    @Override
    public void redo() {
        _editor.doDelete(_index, _length);
    }
}
