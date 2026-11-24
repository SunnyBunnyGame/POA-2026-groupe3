package Input;

/*
 * Stock les Handlers
 */
public class Input {
	
	public MouseHandler mouse;
	public KeyboardHandler keys;
	
	public Input() {
		mouse = new MouseHandler();
		keys = new KeyboardHandler();
	}
}
