package com.example.e4.rcp.parts;

import javax.annotation.PostConstruct;

import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.example.e4.rcp.widgets.Checkbox;
import com.example.e4.rcp.widgets.TriStateWidget;

public class SamplePart {

	@PostConstruct
	public void createComposite(Composite parent) {
		new TriStateWidget(parent, SWT.NONE);

		Checkbox checkbox = new Checkbox(parent, SWT.ARROW);
		checkbox.setText("Custom SWT check button");

		GridLayoutFactory.fillDefaults().generateLayout(parent);
	}
}
