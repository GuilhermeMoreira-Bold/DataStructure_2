package src.editor.Shader;
import src.editor.Shader.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

public class ShaderProgram {
    public int vertexShader;
    public int fragmentShader;
    private int shaderProgram;

    public int getShaderProgram() {
        return shaderProgram;
    }

    public ShaderProgram(String vertexPath, String fragmentPath) {
        compile(vertexPath, fragmentPath);
        link();
    }

    private void link() {
        shaderProgram = GL20.glCreateProgram();
        GL20.glAttachShader(shaderProgram, vertexShader);
        GL20.glAttachShader(shaderProgram, fragmentShader);
        GL20.glLinkProgram(shaderProgram);

        GL20.glValidateProgram(shaderProgram);

        GL20.glDeleteShader(vertexShader);
        GL20.glDeleteShader(fragmentShader);

        int linkStatus = GL20.glGetProgrami(shaderProgram, GL20.GL_LINK_STATUS);
        if (linkStatus != GL11.GL_TRUE) {
            System.out.println("Shader error" + GL20.glGetProgramInfoLog(shaderProgram));
        }

    }

    public void use() {
        GL20.glUseProgram(shaderProgram);
    }

    public void unuse() {
        GL20.glUseProgram(0);
    }

    public void cleanup() {
        GL20.glDetachShader(shaderProgram, vertexShader);
        GL20.glDetachShader(shaderProgram, fragmentShader);
        GL20.glDeleteProgram(shaderProgram);
    }

    public void compile(String vertexPath, String fragmentPath) {
        try {
            final String vertexShaderCode = Util.readFile(Util.getResourceAsStream(vertexPath));

            vertexShader = GL20.glCreateShader(GL20.GL_VERTEX_SHADER);
            GL20.glShaderSource(vertexShader, vertexShaderCode);
            GL20.glCompileShader(vertexShader);

            int status = GL20.glGetShaderi(vertexShader, GL20.GL_COMPILE_STATUS);
            if (status != GL11.GL_TRUE) {
                System.out.println("Vertex shader compile error: \n " +  GL20.glGetShaderInfoLog(vertexShader));
            }
        } catch (Exception e) {
            System.out.println("Shader error" + e);
        }
        try {
            // final String fragmentShaderCode =
            // Util.readFile(Util.getResourceAsStream(fragmentPath));
            final String fragmentShaderCode = shaderSource(fragmentPath);

            fragmentShader = GL20.glCreateShader(GL20.GL_FRAGMENT_SHADER);
            GL20.glShaderSource(fragmentShader, fragmentShaderCode);
            GL20.glCompileShader(fragmentShader);

            int status = GL20.glGetShaderi(fragmentShader, GL20.GL_COMPILE_STATUS);
            if (status != GL11.GL_TRUE) {
                System.out.println("Fragment shader compile error: \n " +  GL20.glGetShaderInfoLog(fragmentShader));
            }
        } catch (Exception e) {
            System.out.println("Shader error" + e);
        }
    }

    public String shaderSource(String path) {

        StringBuilder sb = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }

            return sb.toString();

        } catch (IOException e) {
            return null;
        }
    }
}
