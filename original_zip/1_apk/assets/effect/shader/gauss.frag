#ifdef GL_ES
precision highp float;
#endif
varying vec2 textureCoordinate;

uniform float uWidthStep;
uniform float uHeightStep;
//mask
uniform sampler2D inputImageTexture;
vec2 blurCoordinates[17];

vec4 r(float x,float y){
    return texture2D(inputImageTexture ,textureCoordinate+vec2(x*uWidthStep,y*uHeightStep));
}

vec4 gauss3() {
    vec2 singleStepOffset = vec2(uWidthStep, uHeightStep);
    blurCoordinates[0] = textureCoordinate.xy;
    blurCoordinates[1] = textureCoordinate.xy + singleStepOffset * 1.182426;
    blurCoordinates[2] = textureCoordinate.xy - singleStepOffset * 1.182426;

    vec4 sum = vec4(0.0);
    sum += texture2D(inputImageTexture, blurCoordinates[0]) * 0.402620;
    sum += texture2D(inputImageTexture, blurCoordinates[1]) * 0.298690;
    sum += texture2D(inputImageTexture, blurCoordinates[2]) * 0.298690;
    return sum;
}

vec4 gauss11() {
    vec2 singleStepOffset = vec2(uWidthStep, uHeightStep);
    blurCoordinates[0] = textureCoordinate.xy;
    blurCoordinates[1] = textureCoordinate.xy + singleStepOffset * 1.489585;
    blurCoordinates[2] = textureCoordinate.xy - singleStepOffset * 1.489585;
    blurCoordinates[3] = textureCoordinate.xy + singleStepOffset * 3.475714;
    blurCoordinates[4] = textureCoordinate.xy - singleStepOffset * 3.475714;
    blurCoordinates[5] = textureCoordinate.xy + singleStepOffset * 5.461880;
    blurCoordinates[6] = textureCoordinate.xy - singleStepOffset * 5.461880;
    blurCoordinates[7] = textureCoordinate.xy + singleStepOffset * 7.448104;
    blurCoordinates[8] = textureCoordinate.xy - singleStepOffset * 7.448104;
    blurCoordinates[9] = textureCoordinate.xy + singleStepOffset * 9.434408;
    blurCoordinates[10] = textureCoordinate.xy - singleStepOffset * 9.434408;

    vec4 sum = vec4(0.0);
    sum += texture2D(inputImageTexture, blurCoordinates[0]) * 0.072254;
    sum += texture2D(inputImageTexture, blurCoordinates[1]) * 0.139607;
    sum += texture2D(inputImageTexture, blurCoordinates[2]) * 0.139607;
    sum += texture2D(inputImageTexture, blurCoordinates[3]) * 0.121620;
    sum += texture2D(inputImageTexture, blurCoordinates[4]) * 0.121620;
    sum += texture2D(inputImageTexture, blurCoordinates[5]) * 0.094882;
    sum += texture2D(inputImageTexture, blurCoordinates[6]) * 0.094882;
    sum += texture2D(inputImageTexture, blurCoordinates[7]) * 0.066289;
    sum += texture2D(inputImageTexture, blurCoordinates[8]) * 0.066289;
    sum += texture2D(inputImageTexture, blurCoordinates[9]) * 0.041474;
    sum += texture2D(inputImageTexture, blurCoordinates[10]) * 0.041474;
    return sum;
}

vec4 gauss15() {
    vec2 singleStepOffset = vec2(uWidthStep, uHeightStep);
    blurCoordinates[0] = textureCoordinate.xy;
    blurCoordinates[1] = textureCoordinate.xy + singleStepOffset * 1.496250;
    blurCoordinates[2] = textureCoordinate.xy - singleStepOffset * 1.496250;
    blurCoordinates[3] = textureCoordinate.xy + singleStepOffset * 3.491251;
    blurCoordinates[4] = textureCoordinate.xy - singleStepOffset * 3.491251;
    blurCoordinates[5] = textureCoordinate.xy + singleStepOffset * 5.486253;
    blurCoordinates[6] = textureCoordinate.xy - singleStepOffset * 5.486253;
    blurCoordinates[7] = textureCoordinate.xy + singleStepOffset * 7.481259;
    blurCoordinates[8] = textureCoordinate.xy - singleStepOffset * 7.481259;
    blurCoordinates[9] = textureCoordinate.xy + singleStepOffset * 9.476268;
    blurCoordinates[10] = textureCoordinate.xy - singleStepOffset * 9.476268;
    blurCoordinates[11] = textureCoordinate.xy + singleStepOffset * 11.471282;
    blurCoordinates[12] = textureCoordinate.xy - singleStepOffset * 11.471282;
    blurCoordinates[13] = textureCoordinate.xy + singleStepOffset * 13.466301;
    blurCoordinates[14] = textureCoordinate.xy - singleStepOffset * 13.466301;

    vec4 sum = vec4(0.0);
    sum += texture2D(inputImageTexture, blurCoordinates[0]) * 0.046763;
    sum += texture2D(inputImageTexture, blurCoordinates[1]) * 0.092367;
    sum += texture2D(inputImageTexture, blurCoordinates[2]) * 0.092367;
    sum += texture2D(inputImageTexture, blurCoordinates[3]) * 0.087874;
    sum += texture2D(inputImageTexture, blurCoordinates[4]) * 0.087874;
    sum += texture2D(inputImageTexture, blurCoordinates[5]) * 0.080328;
    sum += texture2D(inputImageTexture, blurCoordinates[6]) * 0.080328;
    sum += texture2D(inputImageTexture, blurCoordinates[7]) * 0.070559;
    sum += texture2D(inputImageTexture, blurCoordinates[8]) * 0.070559;
    sum += texture2D(inputImageTexture, blurCoordinates[9]) * 0.059553;
    sum += texture2D(inputImageTexture, blurCoordinates[10]) * 0.059553;
    sum += texture2D(inputImageTexture, blurCoordinates[11]) * 0.048298;
    sum += texture2D(inputImageTexture, blurCoordinates[12]) * 0.048298;
    sum += texture2D(inputImageTexture, blurCoordinates[13]) * 0.037638;
    sum += texture2D(inputImageTexture, blurCoordinates[14]) * 0.037638;
    return sum;
}

vec4 gauss17() {
    vec2 singleStepOffset = vec2(uWidthStep, uHeightStep);
    blurCoordinates[0] = textureCoordinate.xy;
    blurCoordinates[1] = textureCoordinate.xy + singleStepOffset * 1.498087;
    blurCoordinates[2] = textureCoordinate.xy - singleStepOffset * 1.498087;
    blurCoordinates[3] = textureCoordinate.xy + singleStepOffset * 3.495536;
    blurCoordinates[4] = textureCoordinate.xy - singleStepOffset * 3.495536;
    blurCoordinates[5] = textureCoordinate.xy + singleStepOffset * 5.492985;
    blurCoordinates[6] = textureCoordinate.xy - singleStepOffset * 5.492985;
    blurCoordinates[7] = textureCoordinate.xy + singleStepOffset * 7.490435;
    blurCoordinates[8] = textureCoordinate.xy - singleStepOffset * 7.490435;
    blurCoordinates[9] = textureCoordinate.xy + singleStepOffset * 9.487885;
    blurCoordinates[10] = textureCoordinate.xy - singleStepOffset * 9.487885;
    blurCoordinates[11] = textureCoordinate.xy + singleStepOffset * 11.485336;
    blurCoordinates[12] = textureCoordinate.xy - singleStepOffset * 11.485336;
    blurCoordinates[13] = textureCoordinate.xy + singleStepOffset * 13.482787;
    blurCoordinates[14] = textureCoordinate.xy - singleStepOffset * 13.482787;
    blurCoordinates[15] = textureCoordinate.xy + singleStepOffset * 15.480240;
    blurCoordinates[16] = textureCoordinate.xy - singleStepOffset * 15.480240;

    vec4 sum = vec4(0.0);
    sum += texture2D(inputImageTexture, blurCoordinates[0]) * 0.037419;
    sum += texture2D(inputImageTexture, blurCoordinates[1]) * 0.074363;
    sum += texture2D(inputImageTexture, blurCoordinates[2]) * 0.074363;
    sum += texture2D(inputImageTexture, blurCoordinates[3]) * 0.072493;
    sum += texture2D(inputImageTexture, blurCoordinates[4]) * 0.072493;
    sum += texture2D(inputImageTexture, blurCoordinates[5]) * 0.069243;
    sum += texture2D(inputImageTexture, blurCoordinates[6]) * 0.069243;
    sum += texture2D(inputImageTexture, blurCoordinates[7]) * 0.064805;
    sum += texture2D(inputImageTexture, blurCoordinates[8]) * 0.064805;
    sum += texture2D(inputImageTexture, blurCoordinates[9]) * 0.059428;
    sum += texture2D(inputImageTexture, blurCoordinates[10]) * 0.059428;
    sum += texture2D(inputImageTexture, blurCoordinates[11]) * 0.053397;
    sum += texture2D(inputImageTexture, blurCoordinates[12]) * 0.053397;
    sum += texture2D(inputImageTexture, blurCoordinates[13]) * 0.047010;
    sum += texture2D(inputImageTexture, blurCoordinates[14]) * 0.047010;
    sum += texture2D(inputImageTexture, blurCoordinates[15]) * 0.040552;
    sum += texture2D(inputImageTexture, blurCoordinates[16]) * 0.040552;
    return sum;
}

void main() {
    gl_FragColor = gauss();
}