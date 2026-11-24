package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardHandler implements KeyListener {
	/// Table ASCII
	private boolean [] keys;	

	public KeyboardHandler() {
		keys = new boolean[256];
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()>=keys.length)
			return;
		
		keys[e.getKeyCode()] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()>=keys.length)
			return;
		
		keys[e.getKeyCode()] = false;
		
	}
	
	public boolean pressed(int keyCode) {
		if(keyCode>=keys.length)
			return false;
		
		return keys[keyCode];
	}

}
