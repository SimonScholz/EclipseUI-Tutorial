package com.example.e4.rcp.widgets;

import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGBA;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class TextButton extends Composite {
	private Text text;
	private Button button;

	public TextButton(Composite parent, int style) {
		super(parent, style);
		text = new Text(this, SWT.NONE);
		button = new Button(parent, SWT.PUSH);
		RGBA rgba = new RGBA(255, 150, 0, 255);
		Color color = new Color(getDisplay(), rgba);
		button.setBackground(color);
		GridLayoutFactory.fillDefaults().numColumns(2).generateLayout(this);
	}
	
	public void setText(String text) {
		
		this.text.setText(text);
	}

	@Override
	public void dispose() {
		text.dispose();
		button.dispose();
		super.dispose();
	}
}
