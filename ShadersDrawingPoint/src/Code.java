import javax.swing.*;
import static com.jogamp.opengl.GL4.*;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;


public class Code extends JFrame implements GLEventListener{

	private static final long serialVersionUID = 2669408841475008468L;

	private int renderingProgram;
	private int [] vao = new int[1];
	private GLCanvas glCanvas;

	public Code() {
		
		setTitle("Shaders");
		setLocation(200, 200);
		setSize(800,400);
		glCanvas = new GLCanvas();
		glCanvas.addGLEventListener(this);
		this.add(glCanvas);
		this.setVisible(true);
		
		
	};


	@Override
	public void init(GLAutoDrawable drawable) {
		
		GL4 gl = (GL4) GLContext.getCurrentGL();
		renderingProgram = createShaderProgram();
		gl.glGenVertexArrays(vao.length, vao, 0);
		gl.glBindVertexArray(vao[0]);

	}


	@Override
	public void display(GLAutoDrawable drawable) {

		GL4 gl = (GL4) GLContext.getCurrentGL();
		gl.glUseProgram(renderingProgram);
		gl.glDrawArrays(GL_POINTS, 0, 1);
		
	}
	
	
	public int createShaderProgram() {
		GL4 gl = (GL4) GLContext.getCurrentGL();
		
		String vshaderSource[] = {
				"#version 430 \n",
				"void main(void) \n",
				"{gl_Position = vec4(0.0, 0.0, 0.0, 1.0); } \n"
		};
		
		String fshaderSource[] = {
			"#version 430 \n",
			"out vec4 color; \n",
			"void main(void) \n",
			"{ color = vec4(0.0, 0.0, 1.0, 1.0); } \n"
		};
		
		int vShader = gl.glCreateShader(GL_VERTEX_SHADER);
		gl.glShaderSource(vShader, 3, vshaderSource, null, 0); //3 Lunghezza array
		gl.glCompileShader(vShader);
		
		int fShader = gl.glCreateShader(GL_FRAGMENT_SHADER);
		gl.glShaderSource(fShader, 4, fshaderSource, null, 0); //4 Lunghezza array
		gl.glCompileShader(fShader);
		
		int vfProgram = gl.glCreateProgram();
		gl.glAttachShader(vfProgram, vShader);
		gl.glAttachShader(vfProgram, fShader);
		gl.glLinkProgram(vfProgram);
		
		gl.glDeleteShader(vShader);
		gl.glDeleteShader(fShader);
		
		return vfProgram;
	}


	@Override
	public void dispose(GLAutoDrawable drawable) {}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {}
	
	public static void main(String [] args) {
		new Code();
	}

}
