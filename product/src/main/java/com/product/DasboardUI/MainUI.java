package com.product.DasboardUI;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * @author mohan
 *
 */
public class MainUI extends VerticalLayout implements View {

	public MainUI() {
		final VerticalLayout allLayout=new VerticalLayout();
		
		VerticalLayout masterHead=new VerticalLayout();
		VerticalLayout centerPart=new VerticalLayout();
		
	/**Attching masterhead with Main UI*/	
		MasterHeadUI head=new MasterHeadUI(masterHead,centerPart);
		
		
		
		allLayout.addComponent(masterHead);
		allLayout.addComponent(centerPart);
		allLayout.setStyleName("OAll");
		
		
		
		
		addComponent(allLayout);
	}
	
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
