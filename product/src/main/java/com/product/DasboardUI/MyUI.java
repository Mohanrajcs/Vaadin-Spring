package com.product.DasboardUI;

import com.product.credentialUI.LoginUI;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

@Theme("trialapp")
@SpringUI
public class MyUI extends UI {

	Navigator navigator;
	@Override
	protected void init(VaadinRequest request) {
	
		getPage().setTitle("Product");
		navigator=new Navigator(this, this);
		
		navigator.addView("",new LoginUI());
		navigator.addView("MainUI", new MainUI());
		
	
	}

}
