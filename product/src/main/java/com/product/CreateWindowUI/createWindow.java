package com.product.CreateWindowUI;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.data.HasValue.ValueChangeEvent;
import com.vaadin.data.HasValue.ValueChangeListener;
import com.vaadin.data.TreeData;
import com.vaadin.data.provider.InMemoryDataProvider;
import com.vaadin.data.provider.TreeDataProvider;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ui.dnd.EffectAllowed;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.dnd.DragSourceExtension;
import com.vaadin.ui.dnd.event.DragStartEvent;
import com.vaadin.ui.dnd.event.DragStartListener;

/**
 * @author mohan
 *
 */
public class createWindow extends VerticalLayout {

	VerticalLayout allLayout;
	public createWindow(VerticalLayout allLayout) {
	this.allLayout=allLayout;
	allLayout.removeAllComponents();
	designStructure();
	}
	
	VerticalLayout grid=new VerticalLayout();
	
	/**Designing the Structure wat we want to show in the window creation ui*/
	private void designStructure() {

		VaadinSession.getCurrent().setAttribute("Window Tab", true);
		Panel panel=new Panel("Create Window");
		
		HorizontalLayout panelLayout=new HorizontalLayout();
		
		VerticalLayout viewType=new VerticalLayout();
		
		viewType.addComponent(combolistType());
/**Adding Right Side Type Grid**/		
		viewType.addComponent(grid);
		
		Button btnSave=new Button("Save");
//		panelLayout.addComponent(treeView());
/**Adding left side Components*/		
		panelLayout.addComponent(leftSideView());
		
		
		
		panelLayout.addComponent(viewType);
		panel.setContent(panelLayout);
		allLayout.addComponent(panel);
	}
	
	
	/**Left Side View Added Component*/
	private FormLayout leftSideView() {
		FormLayout layout=new FormLayout();
		layout.setDescription("Components");
		
		ArrayList<String>list=new ArrayList<String>();
		list.add("Textfield");
		list.add("Combobox");
		list.add("Checkbox");
		
		
		for(String s : list) {
			Label l=new Label(s);
			l.setData(s);
			DragSourceExtension<Label>drag=new DragSourceExtension<Label>(l);
			drag.setEffectAllowed(EffectAllowed.MOVE);
			drag.setDataTransferText("Moving");
			layout.addComponent(l);
		}
		
		
		return layout;
	}
	
	/**Temporar;y stop this functionality because of Drag and Drop Component Issue for tree in vaadin 8
	 * Left Side Tree View With Drag and Drop Component*/
	private VerticalLayout treeView() {
		VerticalLayout layout=new VerticalLayout();
		layout.setSizeUndefined();
		Tree<String>tree=new Tree<String>();
		TreeData<String>data=new TreeData<String>();
		
		String comp="Component";
		data.addItem(null,comp);
		data.addItem(comp,"TextField");
		data.addItem(comp,"ComboBox");
		data.addItem(comp,"CheckBox");
		
		InMemoryDataProvider InMemoryDataProvider=new TreeDataProvider<>(data);
		tree.setDataProvider(InMemoryDataProvider);
		tree.expand(comp);
	

		DragSourceExtension<Tree>drag=new DragSourceExtension<Tree>(tree);
		drag.setDataTransferText("Moving");
		drag.setEffectAllowed(EffectAllowed.MOVE);
		
		
		drag.addDragStartListener(new DragStartListener<Tree>() {
			
			@Override
			public void dragStart(DragStartEvent<Tree> event) {
				System.out.println("Drag");
				
			}
		});
		layout.addComponent(tree);
		return layout;
	}
	
	/**List type of Component View*/
	private ComboBox<Integer> combolistType() {
		List<Integer>list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		ComboBox<Integer>combo=new ComboBox<Integer>();
		combo.setItems(list);
		combo.addValueChangeListener(combochange);
		
		return combo;
	}
	
	
	ValueChangeListener<Integer> combochange=new ValueChangeListener<Integer>() {
		
		@Override
		public void valueChange(ValueChangeEvent<Integer> event) {
			// TODO Auto-generated method stub
			System.out.println(event.getSource().getValue());
			grid.removeAllComponents();
			
			GridLayout gridView=new GridView(event.getSource().getValue());
			grid.addComponent(gridView);
			
		}
	};
	

	
	
	
}
