package com.product.credentialUI;



import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class LoginUI extends VerticalLayout implements View {

	public LoginUI() {
	final VerticalLayout allLayout=new VerticalLayout();
		allLayout.setStyleName("OColor");
		Panel panel=new Panel();
		panel.setSizeUndefined();
		
		HorizontalLayout panelHori=new HorizontalLayout();
		
		VerticalLayout leftveri=new VerticalLayout();
		
//		Label leftlbl=new Label("<br><br><center><b><i>PRODUCT<small><sup> TM</sup></small></i></center></b><br>"
//				+ "<em>Product is anything that can be offered<br> "
//				+ "to a market that might satisfy a want or need</em>");
//		leftlbl.setContentMode(ContentMode.HTML);
		Label leftlbl=new Label("PRODUCT");
		leftveri.addComponent(leftlbl);
		
		leftlbl.setStyleName("ContentLbl");
		
		leftveri.setStyleName("prdtcontent");
		leftveri.setSizeFull();
		FormLayout form=new FormLayout();
		
		TextField username=new TextField();
//		username.setInputPrompt("Username");
		username.setIcon(VaadinIcons.USER);
		username.setStyleName("loginField");
		PasswordField password=new PasswordField();
//		password.setInputPrompt("Password");
		password.setIcon(VaadinIcons.KEY);
		password.setStyleName("loginField");
		Button process=new Button("LOGIN");
		process.setStyleName("loginbtn");
		process.addClickListener(loginprocessbtn);
		
		
		
		form.addComponent(username);
		form.addComponent(password);
		form.addComponent(process);
		form.setSizeUndefined();
		
		form.setStyleName("loginform");
		panelHori.addComponent(leftveri);
		panelHori.addComponent(form);
		panel.setContent(panelHori);
		
		allLayout.addComponent(panel);
		
		panel.setStyleName("loginpanel");
		allLayout.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
		
		addComponent(allLayout);
		
	}
	
	
	ClickListener loginprocessbtn=new ClickListener() {
		
		@Override
		public void buttonClick(ClickEvent event) {
			
			getUI().getNavigator().navigateTo("MainUI");
		}
	};
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
