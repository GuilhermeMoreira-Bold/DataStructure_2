#version 330 core

layout(location = 0) in vec2 inPosition;
out vec2 vertexPosition;

void main() {
    gl_Position = vec4(inPosition,0.0,1.0f);
    gl_PointSize = 0.5;
    vertexPosition = inPosition;
}
