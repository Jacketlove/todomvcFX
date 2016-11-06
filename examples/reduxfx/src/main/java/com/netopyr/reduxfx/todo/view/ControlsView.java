package com.netopyr.reduxfx.todo.view;

import com.netopyr.reduxfx.todo.state.AppModel;
import com.netopyr.reduxfx.todo.state.Filter;
import com.netopyr.reduxfx.vscenegraph.VNode;
import javafx.geometry.Pos;
import javafx.scene.layout.Region;
import com.netopyr.reduxfx.todo.actions.Action;
import com.netopyr.reduxfx.todo.actions.Actions;

import static com.netopyr.reduxfx.vscenegraph.VScenegraphFactory.*;

class ControlsView {

    static VNode<Action> ControlsView(AppModel state) {
        final int countActive = state.getTodos().count(todoEntry -> !todoEntry.isCompleted());
        return HBox(
                alignment(Pos.CENTER),
                spacing(20.0),
                padding(5.0),
                Label(
                        id("itemsLeftLabel"),
                        text(String.format("%d %s left",
                                countActive,
                                countActive == 1? "item" : "items"
                        ))
                ),
                HBox(
                        minWidth(Region.USE_PREF_SIZE),
                        minHeight(Region.USE_PREF_SIZE),
                        maxWidth(Region.USE_PREF_SIZE),
                        maxHeight(Region.USE_PREF_SIZE),
                        spacing(10.0),
                        padding(5.0),
                        ToggleButton(
                                id("showAll"),
                                text("All"),
                                selected(state.getFilter() == Filter.ALL),
                                toggleGroup("FILTER_BUTTON_GROUP"),
                                onAction(e -> Actions.setFilter(Filter.ALL))
                        ),
                        ToggleButton(
                                id("showActive"),
                                text("Active"),
                                selected(state.getFilter() == Filter.ACTIVE),
                                toggleGroup("FILTER_BUTTON_GROUP"),
                                onAction(e -> Actions.setFilter(Filter.ACTIVE))
                        ),
                        ToggleButton(
                                id("showCompleted"),
                                text("Completed"),
                                selected(state.getFilter() == Filter.COMPLETED),
                                toggleGroup("FILTER_BUTTON_GROUP"),
                                onAction(e -> Actions.setFilter(Filter.COMPLETED))
                        )
                )
        );
    }
}
