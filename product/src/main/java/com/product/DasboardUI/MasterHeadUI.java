package com.product.DasboardUI;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.VerticalLayout;

public class MasterHeadUI extends VerticalLayout{

	public MasterHeadUI(VerticalLayout layout) {
	
		layout.setSizeFull();
		layout.setStyleName("masterhead");
		
		HorizontalLayout line=new HorizontalLayout();
		
		MenuBar bar=new MenuBar();
		bar.setStyleName("menubar");
		
		MenuBar.MenuItem humanresource=bar.addItem("Human Resource", null);
		humanresource.addItem("Employee", null,null);
		
		MenuBar.MenuItem production=bar.addItem("Production", null);
		MenuBar.MenuItem products= production.addItem("Product", null);
		
		
		MenuBar userbar=new MenuBar();
		
		
		MenuBar.MenuItem useritem= userbar.addItem("M", null);
		useritem.addItem("Profile",null,null);
		useritem.addItem("Setting",null,null);
		useritem.addItem("logout",null,null);
		
	
		 

		
		userbar.setStyleName("logbar");
		line.addComponent(bar);
		line.addComponent(userbar);
		line.setStyleName("masterhori");
		layout.addComponent(line);
	}
}
