package com.example.myapp;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;

public class SpanArea extends Container {
	private Button actualButton;
	private List<TextField> textFields;
	
	private int index = 0;
    
    public SpanArea() {
    	textFields = new ArrayList<TextField>();
    	
    	setUIID("Button");
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        
        actualButton = new Button() {
    		@Override
			public void keyReleased(int keyCode) {
    			inputText(keyCode);
				Log.p("input fisico : " + keyCode);		
			}
    		@Override
			public void pointerPressed(int x, int y) {
			}
    		@Override
			public void pointerReleased(int x, int y) {
    			for(int i=0; i<textFields.size(); i++) {
    				TextField tmp = textFields.get(i);
    				// Ottieni le coordinate assolute del componente
    	            int cmpX = tmp.getAbsoluteX();
    	            int cmpY = tmp.getAbsoluteY();
    	            int cmpWidth = tmp.getWidth();
    	            int cmpHeight = tmp.getHeight();

    	            // Verifica se le coordinate (x, y) sono all'interno dei limiti del componente
    	            if (x >= cmpX && x < cmpX + cmpWidth && y >= cmpY && y < cmpY + cmpHeight) {
    	                index = i;
    	            }
    			}
    			
    			TextField text = textFields.get(index);
    			text.setCursorPosition(text.getText().length());
        		text.requestFocus();
			}
        };
        
        addComponent(actualButton);
        setLeadComponent(actualButton);
    }
    
    public void addTextField(String asText) {
    	TextField text = new TextField(asText) {
    	};
    	
        addComponent(text);
        textFields.add(text);
    }
    
    private void setText(String asText) {
    	TextField text = textFields.get(index);
    	if(text.getText().length() < text.getMaxSize())
    		text.setText(text.getText() + getUIManager().localize(asText, asText));

		text.setCursorPosition(text.getText().length());
//		text.requestFocus();
		text.stopEditing();
    }

    private void inputText(int keyCode) {
    	switch(keyCode) {		
		case KeyEvent.VK_0:
			setText("0");
			break;			
		case KeyEvent.VK_1:
			setText("1");
			break;			
		case KeyEvent.VK_2:
			setText("2");
			break;			
		case KeyEvent.VK_3:
			setText("3");
			break;			
		case KeyEvent.VK_4:
			setText("4");
			break;			
		case KeyEvent.VK_5:
			setText("5");
			break;			
		case KeyEvent.VK_6:
			setText("6");
			break;			
		case KeyEvent.VK_7:
			setText("7");
			break;			
		case KeyEvent.VK_8:
			setText("8");
			break;		
		case KeyEvent.VK_9:
			setText("9");
			break;
		case 8:
		case -23453:
	    	TextField text = textFields.get(index);
			if(text.getText().length() > 0)
				setText(text.getText().substring(0, text.getText().length() -1));
			break;	
		case -90:
		case 66:
			break;			
		case KeyEvent.VK_TAB:
			if(index < textFields.size() - 1)
				index++;
			else 
				index = 0;
			
			text = textFields.get(index);
			text.setCursor(text.getText().length());
    		text.requestFocus();
    		break;		
		}	
    }
    
}
