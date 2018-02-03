package com.product.DasboardUI;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class MainUI extends VerticalLayout implements View {

	public MainUI() {
		final VerticalLayout allLayout=new VerticalLayout();
		
		VerticalLayout masterHead=new VerticalLayout();
		
		
		MasterHeadUI head=new MasterHeadUI(masterHead);
		
		
		
		allLayout.addComponent(masterHead);
		allLayout.setStyleName("OAll");
		
		
		
		
		addComponent(allLayout);
	}
	
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
