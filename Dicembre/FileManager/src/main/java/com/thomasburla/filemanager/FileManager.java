package com.thomasburla.filemanager;

/**
 *
 * @author 20164
 */

//importo gestore eventi
import java.awt.event.*;

public class FileManager {
    //creo oggetto model
    private FileManagerModel model;
    //creo oggetto view
    private FileManagerView view;
    
    //costruttore che assegna classe model e classe view all'istanza di filemanager avviata
    public FileManager(FileManagerModel model, FileManagerView view){
        //assegno model
        this.model = model;
        //assegno parte grafica
        this.view = view;
        
        //evoco metodo per inizializzare l'oggetto
        initialize();
    }

    //metodo che inizializza l'istanza di file manager
    private void initialize() {
        view.getLoadButton().addActionListener(e -> loadDirectory());

        view.getFileList().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = view.getFileList().locationToIndex(e.getPoint());
                    if (index != -1) {
                        String selectedItem = view.getFileList().getModel().getElementAt(index);
                        handleFileSelection(selectedItem);
                    }
                }
            }
        });
    }

    private void loadDirectory() {
        String path = view.getPathField().getText();
        try {
            String[] files = model.getFiles(path);
            view.updateFileList(files);
        } catch (IOException ex) {
            view.showError(ex.getMessage());
        }
    }

    private void handleFileSelection(String selectedItem) {
        String currentPath = view.getPathField().getText();
        File selectedFile = new File(currentPath, selectedItem);

        if (selectedFile.isDirectory()) {
            view.getPathField().setText(selectedFile.getAbsolutePath());
            loadDirectory();
        } else {
            try {
                model.openFile(selectedFile.getAbsolutePath());
            } catch (IOException ex) {
                view.showError("Impossibile aprire il file: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        FileManagerModel model = new FileManagerModel();
        FileManagerView view = new FileManagerView();
        new FileManagerController(model, view);
    }
}

}
