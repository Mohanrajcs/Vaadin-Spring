package com.product.CreateWindowUI;

import java.util.LinkedHashMap;
import java.util.Optional;

import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ui.dnd.DropEffect;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.Tree;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.dnd.DropTargetExtension;
import com.vaadin.ui.dnd.event.DropEvent;
import com.vaadin.ui.dnd.event.DropListener;

/**
 * @author mohan
 *
 */
public class GridView extends GridLayout {

	
	public GridView(int type) {
		boolean maintab=(boolean)VaadinSession.getCurrent().getAttribute("Window Tab");
		
		LinkedHashMap<String, Integer>list=getGridRows(type);
		int x=list.get("x");
		int y=list.get("y");
		GridLayout grid=new GridLayout(y,x);
	for(int i=0;i<y;i++) {
		for(int j=0;j<x;j++) {
			VerticalLayout layout=new VerticalLayout();
			layout.setWidth("150");
			layout.setHeight("150");
			
			
/**Adding Button With open Window configuration Setting*/			
			Button btn=new Button("|", new Button.ClickListener() {
				
				@Override
				public void buttonClick(ClickEvent event) {
					VaadinSession.getCurrent().setAttribute("CurrentLayout", layout);
				new subWindowConfiguration().createWindow();;
				}
			});
			
			if(i+j == 0 && maintab) {
				new subWindowConfiguration().saveComponentConfiguration(layout, "Name", "Textfield");
			}
			layout.addComponent(btn);
			layout.setData(i+j);
			DropTargetExtension<VerticalLayout>droptarget=new DropTargetExtension<VerticalLayout>(layout);
			droptarget.setDropEffect(DropEffect.MOVE);
			droptarget.addDropListener(dropContent);
			grid.addComponent(layout,i,j);
		}	
	}
	
	this.addComponent(grid);
	}

	public LinkedHashMap<String, Integer> getGridRows(int type) {
		LinkedHashMap<String, Integer>list=new LinkedHashMap<String,Integer>();
		int x=0;
		int y=0;
		
		switch (type) {
		case 2:
			x=2;
			y=1;
			break;
		case 3:
			x=2;
			y=0;
			break;
		case 4:
			x=3;
			y=0;
			break;	
			
			
		default:
			break;
		}
		
		list.put("x",x);
		list.put("y",y);
		return list;
	}

	
/**Drop the Component in Configuration Layout to Configure the column */	
	DropListener<VerticalLayout>dropContent=new DropListener<VerticalLayout>() {

		@Override
		public void drop(DropEvent<VerticalLayout> event) {
			// TODO Auto-generated method stub
			Optional<AbstractComponent>dragsource=event.getDragSourceComponent();
			
			if(dragsource.get() instanceof Label) {
				Label component=(Label) dragsource.get();
			VaadinSession.getCurrent().setAttribute("CurrentLayout", event.getComponent());
				new subWindowConfiguration().createWindow();;
			}
			
			
		}
	};
	
}
