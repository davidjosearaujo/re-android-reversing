#ifdef GL_ES
precision highp float;
#endif
varying vec2 textureCoordinate;
uniform sampler2D inputImageTexture;
uniform float intensity;
uniform bool preMultiplied;

void main() {
    vec4 color = texture2D(inputImageTexture, textureCoordinate);
    color.a = color.a * intensity;
    gl_FragColor = color;
    if (preMultiplied) {
        gl_FragColor.rgb = gl_FragColor.rgb / mix(gl_FragColor.a, 1.0, step(gl_FragColor.a, 0.0));
    }
}