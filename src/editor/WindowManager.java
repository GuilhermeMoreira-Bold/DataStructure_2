//package src.editor;
//
//import org.lwjgl.opengl.GL;
//import src.Tree.AVLNode;
//import src.editor.Shader.ShaderProgram;
//
//import static org.lwjgl.glfw.GLFW.*;
//import static org.lwjgl.opengl.GL11.*;
//
//public class WindowManager<T> {
//    private long window;
//    private int width, height;
//    private ShaderProgram shaderProgram;
//   public WindowManager(){
//        this.width = 1600;
//        this.height = 900;
//    }
//    public void init(){
//        if(!glfwInit()){
//            throw new RuntimeException("Coudln't start glfw");
//        }
//        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
//        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
//        glfwDefaultWindowHints();
//
//        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
//        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
//
//        this.window = glfwCreateWindow(width, height, "Odernation", 0,0);
//        glfwMakeContextCurrent(window);
//        GL.createCapabilities();
//        glViewport(0,0,1600,900);
//        glfwSetFramebufferSizeCallback(this.window, (window, width, height) -> {
//            this.width = width;
//            this.height = height;
//            glViewport(0, 0, width, height);
//        });
//        glfwShowWindow(window);
//        this.shaderProgram = new ShaderProgram("src/editor/Shader/vertexShader.vs", "src/editor/Shader/fragmentShader.fs");
//    }
//    public void render(AVLNode<T> node){
//       while (!glfwWindowShouldClose(window)){
//           glClearColor(0.5f,0.2f,0.3f, 1f);
//           glEnable(GL_DEPTH_TEST);
//           glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
//           shaderProgram.use();
//
//           Renderer.renderNode(node,this.shaderProgram);
//           Renderer.renderPoint();
//           glfwSwapBuffers(window);
//           glfwPollEvents();
//       }
//    }
//}
