#ifdef GL_ES
precision highp float;
#endif
#extension GL_OES_EGL_image_external : require
varying vec2 textureCoordinate;
uniform vec4 inputColor;
uniform samplerExternalOES sTexture;
void main() {
    vec4 tc = texture2D(sTexture, textureCoordinate);
    gl_FragColor = vec4(tc.r, tc.g, tc.b, tc.a);
}