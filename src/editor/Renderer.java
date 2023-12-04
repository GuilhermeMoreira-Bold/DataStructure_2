//package src.editor;
//
//import src.Tree.AVLNode;
//import src.Tree.AVLTree;
//import src.editor.Shader.ShaderProgram;
//
//import static org.lwjgl.opengl.GL11.*;
//import static org.lwjgl.opengl.GL30.*;
//
//
//public class Renderer<T> {
//    public static int renderNode(AVLNode node, ShaderProgram shaderProgram){
//        float[] nodePositon = {node.x, node.y};
//        int vaoId;
//        vaoId = glGenVertexArrays();
//        glBindVertexArray(vaoId);
//
//        int vbo = glGenBuffers();
//        glBindBuffer(GL_ARRAY_BUFFER, vbo);
//        glBufferData(GL_ARRAY_BUFFER, nodePositon, GL_STATIC_DRAW);
//
//        int positionAttribute = glGetAttribLocation(shaderProgram.getShaderProgram(), "inPosition");
//        glVertexAttribPointer(positionAttribute, 2, GL_FLOAT, false, 0, 0);
//        glEnableVertexAttribArray(positionAttribute);
//        return vaoId;
//    }
//    public static void renderEdege(float x1,float x2, float y1, float y2){
//       glDrawArrays(GL_LINE,0, 2);
//    }
//    public static void renderPoint(){
//        glDrawArrays(GL_POINTS, 0,1);
//        glPointSize(50.0f);
//    }
//}
