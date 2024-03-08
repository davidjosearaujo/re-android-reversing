attribute vec4 aVertexCo;
attribute vec2 aTextureCo;

uniform   mat4 uPosMtx;
uniform   mat4 uTexMtx;
varying   vec2 textureCoordinate;
void main() {
  gl_Position = uPosMtx * aVertexCo;
  textureCoordinate   = (uTexMtx * vec4(aTextureCo, 0.0, 1.0)).xy;
}