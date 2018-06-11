package com.techlabs.html.dom.test;

import com.techlabs.html.dom.Control;
import com.techlabs.html.dom.ControlGroup;

public class TestHtmlDom {
	
	public static void main(String[] args) {
		
		ControlGroup html=new ControlGroup("HTML");
		
		Control title=new Control("TITLE");
		ControlGroup head=new ControlGroup("HEAD");
		head.addTag(title);
		
		html.addTag(head);
		
		Control input=new Control("INPUT");
		
		ControlGroup p=new ControlGroup("P");
		p.addTag(input);
		
		ControlGroup div=new ControlGroup("DIV");
		div.addTag(p);
		
		ControlGroup body=new ControlGroup("BODY");
		body.addTag(div);
		
		html.addTag(body);
		
		html.display(1);
		
	}

}
