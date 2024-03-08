attribute vec4 aVertexCo;
attribute vec2 aTextureCo;
uniform mat4 World;

varying vec2 textureCoordinate;

void main() {
    gl_Position =  vec4(aVertexCo.xyz, 1.);
    vec2 center = aTextureCo * 2.0 - vec2(1.0, 1.0);
    textureCoordinate = ((World * vec4(center, 0.0, 1.0)).xy + vec2(1.0, 1.0)) / 2.0 ;
}