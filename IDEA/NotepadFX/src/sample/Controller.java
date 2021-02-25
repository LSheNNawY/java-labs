package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.FileChooser;

public class Controller {

    private File openedFile = null;

    @FXML
    private TextArea textArea;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    /**
     * close file action
     * @param event
     */
    @FXML
    void closeFileAction(ActionEvent event) {
        if (openedFile != null ) {
            String fileContent = getFileContect(openedFile);

            if (!fileContent.equals(textArea.getText())) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Save");
                alert.setHeaderText("Save before quit?");
                alert.setGraphic(null);
                Optional<ButtonType> result = alert.showAndWait();

                if(result.get() == ButtonType.OK)
                    saveTextToFile(textArea.getText(), openedFile);
            }
            openedFile = null;
        }
        Main.stage.close();
    }

    /**
     * new file action
     * @param event
     */
    @FXML
    void newFileAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        //Show save file dialog
        File file = fileChooser.showSaveDialog(Main.stage);

        if (file != null) {
            openedFile = file;
        }
    }

    /**
     * save to file action
     * @param event
     */
    @FXML
    void saveFileAction(ActionEvent event) {
        if (openedFile != null) {
            saveTextToFile(textArea.getText(), openedFile);
        } else {
            FileChooser fileChooser = new FileChooser();
            //Set extension filter for text files
//            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
//            fileChooser.getExtensionFilters().add(extFilter);

            File file = fileChooser.showSaveDialog(Main.stage);

            if (file != null) {
                saveTextToFile(textArea.getText(), file);
            }
        }
    }

    /**
     * open file action
     * @param event
     */
    @FXML
    void openFileAction(ActionEvent event) {
        System.out.println(event.getClass());
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(Main.stage);

        if (file != null) {
            openedFile = file;
            String fileContent = getFileContect(file);
            if (!fileContent.equals(""))
                textArea.setText(fileContent);
        }
    }

    /**
     * copy action
     * @param event
     */
    @FXML
    void copyAction(ActionEvent event) {
        String selectedText = textArea.getSelectedText();
        if (!selectedText.equals("")) {
            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent content = new ClipboardContent();
            content.putString(selectedText);
            clipboard.setContent(content);
        }
    }

    /**
     * paste action
     * @param event
     */
    @FXML
    void pasteAction(ActionEvent event) {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        String copied = clipboard.getString();
        Integer caretPos = textArea.getCaretPosition();
        textArea.insertText(caretPos, copied);
    }

    /**
     * cut action
     * @param event
     */
    @FXML
    void cutAction(ActionEvent event) {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        String selectedText = textArea.getSelectedText(),
                originalText = textArea.getText();
        int lastPos = textArea.getCaretPosition();
        int startPos = lastPos - selectedText.length();

        String newTextAreaContent = originalText.substring(0, startPos).concat(originalText.substring(lastPos, originalText.length()));
        content.putString(selectedText);
        clipboard.setContent(content);
        textArea.setText(newTextAreaContent);
        textArea.positionCaret(startPos);
    }

    /**
     * delete action
     * @param event
     */
    @FXML
    void deleteAction(ActionEvent event) {
        String selectedText = textArea.getSelectedText(),
                originalText = textArea.getText();
        int lastPos = textArea.getCaretPosition();
        int startPos = lastPos - selectedText.length();

        String newTextAreaContent = originalText.substring(0, startPos).concat(originalText.substring(lastPos, originalText.length()));
        textArea.setText(newTextAreaContent);
        textArea.positionCaret(startPos);
    }

    /**
     * select all action
     * @param event
     */
    @FXML
    void selectAllAction(ActionEvent event) {
        textArea.selectAll();
    }

    /**
     * about action
     * @param event
     */
    @FXML
    void aboutAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About notepadFX");
        alert.setHeaderText("About us");
        alert.setContentText("copyrights 2021 @shennawy");
        alert.show();
    }

    /**
     * save textarea content to file
     * @param content
     * @param file
     */
    private void saveTextToFile(String content, File file) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    /**
     * get file content method
     * @param file
     * @return
     */
    private String getFileContect(File file) {
        String fileContent = "";
        try{
            FileInputStream fin = new FileInputStream(file.getAbsolutePath());
            int i = 0;
            while((i = fin.read()) != -1){
                fileContent += (char) i;
            }
            fin.close();
        } catch(Exception e){
            System.out.println(e);
        }

        return fileContent;
    }

    @FXML
    void initialize() {

    }
}
