package com.example.e4.rcp.renderer;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabFolderRenderer;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;

public class CustomTabFolderRenderer extends CTabFolderRenderer {

	private static final int UNDERLINE_TRIM_HEIGHT = 5;
	private ResourceManager resourceManager;

	public CustomTabFolderRenderer(CTabFolder parent) {
		super(parent);
		resourceManager = new LocalResourceManager(JFaceResources.getResources(), parent);
	}

	@Override
	protected Point computeSize(int part, int state, GC gc, int wHint, int hHint) {
		Point computeSize = super.computeSize(part, state, gc, wHint, hHint);

		if (0 <= part && part < parent.getItemCount()) {
			computeSize.x += 20;
		}

		return new Point(computeSize.x, 50);
	}

	@Override
	protected void draw(int part, int state, Rectangle bounds, GC gc) {
		super.draw(part, state, bounds, gc);

		adjustSelectedTab(part, state, bounds, gc);
	}

	private void adjustSelectedTab(int part, int state, Rectangle bounds, GC gc) {
		if (0 <= part && part < parent.getItemCount()) {
			if (bounds.width == 0 || bounds.height == 0)
				return;
			if ((state & SWT.SELECTED) != 0) {
				drawHeaderTrim(bounds, gc);
			}
		}
	}

	private void drawHeaderTrim(Rectangle bounds, GC gc) {
		Color origBg = gc.getBackground();
		Color bgColor = resourceManager.createColor(new RGB(0, 132, 180));
		gc.setBackground(bgColor);
		gc.fillRectangle(bounds.x, bounds.y + bounds.height - UNDERLINE_TRIM_HEIGHT, bounds.width, UNDERLINE_TRIM_HEIGHT);
		gc.setBackground(origBg);
	}

}
