package ru.alexnov.spacer;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import ru.alexnov.spacer.*;

public class MyFocusListener implements FocusListener {

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		Prog.win.mudWeight.getText();
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub

	}

}
