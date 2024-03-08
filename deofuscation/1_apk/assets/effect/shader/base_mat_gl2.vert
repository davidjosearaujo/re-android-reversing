attribute vec4 aVertexCo;
attribute vec2 aTextureCo;

uniform mat4 uWorldMat;

varying vec2 vTextureCo;

void main(){
    gl_Position = uWorldMat * aVertexCo;
    vTextureCo = aTextureCo;
}