attribute vec4 aVertexCo;
attribute vec2 aTextureCo;
uniform mat4 World;

varying vec2 textureCoordinate;

void main() {
    gl_Position = World * vec4(aVertexCo.xyz, 1.);
    textureCoordinate = aTextureCo;
}