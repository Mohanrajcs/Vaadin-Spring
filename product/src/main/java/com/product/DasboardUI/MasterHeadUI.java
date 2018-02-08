package com.product.DasboardUI;

import com.product.CreateWindowUI.createWindow;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.VerticalLayout;

/**
 * @author mohan
 *
 */
public class MasterHeadUI extends VerticalLayout{

	VerticalLayout centerpart;
	public MasterHeadUI(VerticalLayout layout,VerticalLayout centerpart) {
	this.centerpart=centerpart;
		layout.setSizeFull();
		layout.setStyleName("masterhead");
		
		HorizontalLayout line=new HorizontalLayout();
		
		MenuBar bar=new MenuBar();
		bar.setStyleName("menubar");
		
		MenuBar.MenuItem humanresource=bar.addItem("Human Resource", null);
		humanresource.addItem("Employee", null,null);
		
		MenuBar.MenuItem production=bar.addItem("Production", null);
		MenuBar.MenuItem products= production.addItem("Product", null);
		
		
		Button create=new Button("Create");
		create.setStyleName("ContentLbl");
		create.addClickListener(createbtn);
		
		MenuBar userbar=new MenuBar();
		userbar.setStyleName("logbar");
		
		MenuBar.MenuItem useritem= userbar.addItem("M", null);
		useritem.addItem("Profile",null,null);
		useritem.addItem("Setting",null,null);
		useritem.addItem("logout",null,null);
		
		line.addComponent(bar);
		line.addComponent(create);
		line.addComponent(userbar);
		line.setStyleName("masterhori");
		layout.addComponent(line);
	}
	
	
	ClickListener createbtn=new ClickListener() {
		
		@Override
		public void buttonClick(ClickEvent event) {
			new createWindow(centerpart);
			
		}
	};
	
}
