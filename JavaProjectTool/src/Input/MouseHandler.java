package Input;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
 * Utilisation si les informations de la souris sont important indépendament des ActionListeners ( pratique pour click droit et avoir les tables de configuration )
 */
public class MouseHandler extends MouseAdapter {

	private boolean[] mouse;
	public Point position;
	
	public MouseHandler() {
		mouse = new boolean[8];
		position = new Point();
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton()>=mouse.length)
			return;
		
		mouse[e.getButton()] = true;
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton()>=mouse.length)
			return;
		
		mouse[e.getButton()] = false;
	
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		position.setLocation(e.getPoint());
		
	}
	
	public boolean click(int mouseCode) {
		if(mouseCode >= mouse.length)
			return false;
		
		return mouse[mouseCode];
	}
	
}