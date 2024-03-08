attribute vec4 aVertexCo;
attribute vec2 aTextureCo;

varying vec2 vTextureCo;

void main()
{
    gl_Position = aVertexCo;
    vTextureCo = aTextureCo;
}