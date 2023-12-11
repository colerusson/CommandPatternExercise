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
                        insertInDoc();
                        break;
                    case 2:
                        deleteInDoc();
                        break;
                    case 3:
                        replaceInDoc();
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
    private void start() {
        _undoRedoManager.start();
    }

    private void open() {
        _undoRedoManager.open();
    }

    private void save() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Name of file: ");
        String saveFileName = scanner.next();
        _document.save(saveFileName);
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

    public void insertInDoc() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Start index: ");
        String insertionIndexInput = scanner.next();
        int insertionIndex = validateNumberInput(insertionIndexInput);
        if (insertionIndex != -1) {
            System.out.print("Sequence to insert: ");
            String sequenceInput = scanner.next();
            _undoRedoManager.insert(insertionIndex, sequenceInput);
        }
    }

    public void deleteInDoc() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Start index: ");
        String deletionIndexInput = scanner.next();
        int deletionIndex = validateNumberInput(deletionIndexInput);
        if (deletionIndex != -1) {
            System.out.print("Number of characters to delete: ");
            String deletionDistanceInput = scanner.next();
            int deletionDistance = validateNumberInput(deletionDistanceInput);
            if (deletionDistance != -1) {
                _undoRedoManager.delete(deletionIndex, deletionDistance);
            }
        }
    }

    public void replaceInDoc() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Start index: ");
        String replaceIndexInput = scanner.next();
        int replaceIndex = validateNumberInput(replaceIndexInput);
        if (replaceIndex != -1) {
            System.out.print("Number of characters to replace: ");
            String replaceDistanceInput = scanner.next();
            int replaceDistance = validateNumberInput(replaceDistanceInput);
            if (replaceDistance != -1) {
                System.out.print("Replacement string: ");
                String replacementString = scanner.next();
                _undoRedoManager.replace(replaceIndex, replaceDistance, replacementString);
            }
        }
    }

    public void openDoc() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Name of file to open: ");
        String openFileName = scanner.next();
        _document.open(openFileName);
    }

    public void startDoc() {
        _document.clear();
    }

    public void undo() {
        _undoRedoManager.undo();
    }

    public void redo() {
        _undoRedoManager.redo();
    }

    public void doInsert(int index, String sequence) {
        if (sequence == null) {
            sequence = _document.sequence().toString();
        }
        _document.insert(index, sequence);
    }

    public void doDelete(int index, int distance) {
        _document.delete(index, distance);
    }

    public void doReplace(int index, int distance, String sequence) {
        _document.delete(index, distance);
        _document.insert(index, sequence);
    }
    public void closeDoc() {
        System.exit(0);
    }
}
