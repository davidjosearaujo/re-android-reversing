attribute vec4 aVertexCo;
attribute vec2 aTextureCo;

uniform mat4 World;
uniform mat4 uMatMask;

varying vec2 vTextureCo;
varying vec2 vTextureMaskCo;

void main(){
    gl_Position = World * aVertexCo;
    vTextureCo = aTextureCo;
    vTextureMaskCo = (uMatMask * vec4(aTextureCo.xy - vec2(0.5, 0.5), 0., 1.)).xy + vec2(0.5, 0.5);
}