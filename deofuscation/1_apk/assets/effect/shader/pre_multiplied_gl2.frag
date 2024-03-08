#ifdef GL_ES
precision highp float;
#endif
varying vec2 textureCoordinate;
uniform sampler2D inputImageTexture;
uniform float intensity;

void main() {
    vec4 color = texture2D(inputImageTexture, textureCoordinate);
    color.a = color.a * intensity;
    color.rgb = color.rgb * color.a;
    gl_FragColor = color;
}