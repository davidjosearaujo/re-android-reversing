#ifdef GL_ES
precision highp float;
#endif

attribute vec4 aVertexCo;
attribute vec2 aTextureCo;

uniform mat4 World;
varying vec2 UV;
varying vec2 vBaseUV;

void main()
{
    vec4 vPos = World * vec4(aVertexCo.xyz, 1.0);
    UV = aTextureCo;
    vBaseUV = (vPos.xy + vec2(1.0))/2.0;
    gl_Position = vPos;
}