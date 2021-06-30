import javax.swing.*;
import static com.jogamp.opengl.GL4.*;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;


public class FirstInterface extends JFrame implements GLEventListener{
	

	private static final long serialVersionUID = -2849267648720710584L;
	private GLCanvas glCanvas;
	
	public static void main(String[] args) {
		new FirstInterface();
	}
	
	public FirstInterface() {
		setTitle("First interface");
		setSize(800, 400);
		setLocation(200,200);
		glCanvas = new GLCanvas();
		glCanvas.addGLEventListener(this);
		this.add(glCanvas);
		this.setVisible(true);
	}

	@Override
	public void display(GLAutoDrawable arg0) {
		
		GL4 gl = (GL4) GLContext.getCurrentGL();
		gl.glClearColor(1.0f, 0.0f, 0.0f, 1.0f);
		gl.glClear(GL_COLOR_BUFFER_BIT);
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {	}
	@Override
	public void init(GLAutoDrawable arg0) {	}
	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {	}
	
	

}
