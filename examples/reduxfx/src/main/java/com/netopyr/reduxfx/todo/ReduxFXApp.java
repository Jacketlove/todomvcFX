package com.netopyr.reduxfx.todo;

import com.netopyr.reduxfx.ReduxFX;
import com.netopyr.reduxfx.todo.state.AppModel;
import com.netopyr.reduxfx.todo.state.Filter;
import com.netopyr.reduxfx.todo.updater.Todos;
import javafx.application.Application;
import javafx.stage.Stage;
import javaslang.collection.Array;
import com.netopyr.reduxfx.todo.view.MainView;

public class ReduxFXApp extends Application {

    public void start(Stage primaryStage) throws Exception {

        final AppModel initialState = new AppModel("", Array.empty(), Filter.ALL);

        ReduxFX.start(initialState, Todos::update, MainView::view, primaryStage);

        primaryStage.setTitle("TodoMVCFX - ReduxFX");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
