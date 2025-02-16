

import model.FileManagerModel;
import view.FileManagerView;
import controller.FileManagerController;

/**
 *
 * @author Thomas Burla
 * @version 1.0
 */

public class FileManager {
    public static void main(String[] args) {
        //creo oggetto di classe Model
        FileManagerModel model = new FileManagerModel();
        
        //creo oggetto di classe View
        FileManagerView view = new FileManagerView();
        
        //creo oggetto di classe Controller che unisce i primi due
        new FileManagerController(model, view);
    }
}
