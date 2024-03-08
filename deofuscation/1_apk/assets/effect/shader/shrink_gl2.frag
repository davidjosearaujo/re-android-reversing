#ifdef GL_ES
precision highp float;
#endif
varying vec2 textureCoordinate;
uniform sampler2D inputImageTexture;
uniform float lineUp;
uniform float lineDown;
uniform float ratio; 

void main() {
    float y = textureCoordinate.y;
    float newLength = (lineDown - lineUp) * ratio + lineUp + (1.0 - lineDown);
    y = y * newLength;
    if (y < lineUp) {
       
    }
    else if (y >= lineUp && y < lineUp + (lineDown - lineUp)* ratio) {
        y = lineUp + (y-lineUp) / ratio;
    }
    else {
        y = lineDown + y - (lineUp + (lineDown - lineUp)* ratio);
    }

    //y = y / newLength;

    gl_FragColor = texture2D(inputImageTexture, vec2(textureCoordinate.x, y));
}
