import java.util.Scanner;

class TextEditor {
    private final IDocument _document;
    private final UndoRedoManager _undoRedoManager;

    TextEditor(IDocument document) {
        _document = document;
        _undoRedoManager = new UndoRedoManager(this);
    }

    void run() {
        while (true) {
            printOptions();

            Scanner scanner = new Scanner(System.in);
            String optionInput = scanner.next();
            int option = validateNumberInput(optionInput);

            if (option != -1) {
                switch (option) {
                    case 1:
                        insert();
                        break;
                    case 2:
                        delete();
                        break;
                    case 3:
                        replace();
                        break;
                    case 4:
                        _document.display();
                        break;
                    case 5:
                        save();
                        break;
                    case 6:
                        open();
                        break;
                    case 7:
                        start();
                        break;
                    case 8:
                        undo();
                        break;
                    case 9:
                        redo();
                        break;
                    case 10:
                        return;
                }
            }

            System.out.println();
        }
    }

    private void printOptions() {
        System.out.println("SELECT AN OPTION (1 - 10):");
        System.out.println("1. Insert a string at a specified index in the document");
        System.out.println("2. Delete a sequence of characters at a specified index");
        System.out.println("3. Replace a sequence of characters at a specified index with a new string");
        System.out.println("4. Display the current contents of the document");
        System.out.println("5. Save the document to a file");
        System.out.println("6. Open a document from a file");
        System.out.println("7. Start a new, empty document");
        System.out.println("8. Undo");
        System.out.println("9. Redo");
        System.out.println("10. Quit");

        System.out.println();
        System.out.print("Your selection: ");
    }

    private void insert() {
        _undoRedoManager.insert();
    }

    private void delete() {
        _undoRedoManager.delete();
    }

    private void replace() {
        _undoRedoManager.replace();
    }

    private void start() {
        _undoRedoManager.start();
    }

    private void save() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Name of file: ");
        String saveFileName = scanner.next();
        _document.save(saveFileName);
    }

    private void open() {
        _undoRedoManager.open();
    }

    public int validateNumberInput(String input) {
        int selection = -1;
        try {
            selection = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }

        return selection;
    }

    public void insertInDoc(int insertionIndex, String sequenceInput) {
        _document.insert(insertionIndex, sequenceInput);
    }

    public String deleteInDoc(int deletionIndex, int deletionDistance) {
        return _document.delete(deletionIndex, deletionDistance);
    }

    public void openFile(String openFileName) {
        _document.open(openFileName);
    }

    public void clear() {
        _document.clear();
    }

    public void undo() {
        _undoRedoManager.undo();
    }

    public void redo() {
        _undoRedoManager.redo();
    }
}
