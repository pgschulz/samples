import javafx.application.Application;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.PopupFeatures;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Callback;


public class HelloFX extends Application {

	public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX WebView Example");

        WebView webView = new WebView();

		webView.getEngine().getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>()
        {
            @Override
            public void changed(final ObservableValue bObservable, final Worker.State oldValue, final Worker.State newValue)
            {
                if (((webView.getEngine() != null) && (webView.getEngine().getLoadWorker().getException() != null)) && (newValue == State.FAILED)) {
                    System.out.println(webView.getEngine().getLoadWorker().getException());
                }
            }
		});
		
		webView.getEngine().load("https://iconclass.org/20(%2B0)");
		// webView.getEngine().load("https://www.getty.edu/research/tools/vocabularies/ulan");
		// webView.getEngine().load(index.html);
		//webView.getEngine().load("https://webdbg.com/ua.aspx");

        VBox vBox = new VBox(webView);
        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
