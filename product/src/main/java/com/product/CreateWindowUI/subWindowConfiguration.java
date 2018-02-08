package com.product.CreateWindowUI;

import java.util.ArrayList;
import java.util.Optional;

import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

public class subWindowConfiguration extends Window {

	TextField field=new TextField("Field Name");
	ComboBox<String>comboType=new ComboBox<String>("Type");
	
	public subWindowConfiguration() {
		
	}
	
	void createWindow() {

		VerticalLayout currlayout=(VerticalLayout)VaadinSession.getCurrent().getAttribute("CurrentLayout");
		Window window=new Window("Configuration");
		FormLayout layout=new FormLayout();
		
		
		
		ArrayList<String>list=new ArrayList<String>();
		list.add("Textfield");
		list.add("ComboBox");
		list.add("Checkbox");
		
		comboType.setItems(list);
		comboType.setEmptySelectionAllowed(false);
		
		Button btnok=new Button("Ok",new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
			saveComponentConfiguration(currlayout,field.getValue(),comboType.getSelectedItem().get());
			window.close();
			}
		});
		
		
		layout.addComponent(field);
		layout.addComponent(comboType);
		layout.addComponent(btnok);
		layout.setMargin(true);
		
		preLoadedConfiguration(currlayout);
		
		window.setWidth("50%");
		window.center();
		window.setModal(true);
		window.setContent(layout);
		
		
		getUI().getCurrent().addWindow(window);
		
	}
	
	/**Saved Configuration Setup */
	void preLoadedConfiguration(VerticalLayout layout){
		
		for(int i=0;i<layout.getComponentCount();i++) {
			Component comp=layout.getComponent(i);
			
			if(comp instanceof Label) {
				Label l=(Label)comp;
				if(l.getDescription().equals("FieldName"))field.setValue(l.getData().toString());
				else if(l.getDescription().equals("Type"))comboType.setSelectedItem(l.getData().toString());
			}
			
		}
		
		if((Integer)layout.getData() ==0) {
			if((boolean)VaadinSession.getCurrent().getAttribute("Window Tab")) {
//				field.setReadOnly(true);
				comboType.setReadOnly(true);
				
			}
			
		}
		
	}
	
	/**Saving the configuration data in UI*/
	public void saveComponentConfiguration(VerticalLayout layout,String value,String selectedItem ) {
		
		for(int i=0;i<layout.getComponentCount();i++) {
			Component comp=layout.getComponent(i);
			
			if(comp instanceof Label) {
				layout.removeComponent(comp);
			}
			
		}
		
		Label fieldName=new Label(value);
		fieldName.setDescription("FieldName");
		fieldName.setData(value);
		
		Label type=new Label(selectedItem);
		type.setDescription("Type");
		type.setData(selectedItem);
		
		layout.addComponent(fieldName);
		layout.addComponent(type);
		
		
	}
	
}
