package com.kosteklvp.transfermarkt.view.main;

import com.kosteklvp.transfermarkt.model.Person;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Transfermarkt")
@Route(value = "")
public class MainView extends VerticalLayout {

    Grid<Person> grid = new Grid<>(Person.class);
    TextField filterText = new TextField();

    public MainView() {
        addClassName("list-view");
        setSizeFull();
        configureGrid();



        add(getToolbar(), grid);


    }

    private void configureGrid() {
        grid.addClassNames("contact-grid");
        grid.setSizeFull();
//        grid.setColumns("firstName", "lastName");


        grid.addColumn(contact -> "jeden").setHeader("Status");


        grid.addColumn(contact -> "dwa").setHeader("Company");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));


    }

    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);



        Button addContactButton = new Button("Add contact");

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addContactButton);


        toolbar.addClassName("toolbar");
        return toolbar;
    }

}
