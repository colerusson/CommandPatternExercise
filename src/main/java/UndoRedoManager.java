import java.util.ArrayDeque;
import java.util.Deque;

public class UndoRedoManager {
    private final Deque<ICommand> _undoStack;
    private final Deque<ICommand> _redoStack;
    private final TextEditor editor;

    public UndoRedoManager(TextEditor editor) {
        _undoStack = new ArrayDeque<>();
        _redoStack = new ArrayDeque<>();
        this.editor = editor;
    }

    public void start() {
        ICommand command = new StartCommand(editor);
        execute(command);
    }

    public void insert(int position, String text) {
        ICommand command = new InsertCommand(editor, position, text);
        execute(command);
    }

    public void delete(int position, int length) {
        ICommand command = new DeleteCommand(editor, position, length);
        execute(command);
    }

    public void replace(int position, int length, String text) {
        ICommand command = new ReplaceCommand(editor, position, length, text);
        execute(command);
    }

    public void open() {
        ICommand command = new OpenCommand(editor);
        execute(command);
    }

    public void execute(ICommand command) {
        command.execute();
        _undoStack.push(command);
        _redoStack.clear();
    }

    public void undo() {
        if (canUndo()) {
            ICommand command = _undoStack.pop();
            command.undo();
            _redoStack.push(command);
        }
    }

    public void redo() {
        if (canRedo()) {
            ICommand command = _redoStack.pop();
            command.redo();
            _undoStack.push(command);
        }
    }

    public boolean canUndo() {
        return !_undoStack.isEmpty();
    }

    public boolean canRedo() {
        return !_redoStack.isEmpty();
    }
}
