#ifdef GL_ES
precision highp float;
#endif

uniform sampler2D uTexture;
uniform sampler2D uTexture1;
varying vec2 vTextureCo;

uniform float uIntensity;
uniform float uGird;
uniform float uFlip;

//lookup table 为大小为64*64，个数为4*4的格子表
void main()
{
    vec4 textureColor = texture2D(uTexture, vTextureCo);
    //根据当前颜色的蓝色通道查找所在格子
    float blueColor = textureColor.b * (uGird * uGird - 1.0);
    vec2 quad1;
    quad1.y = floor(floor(blueColor) / uGird);
    quad1.x = floor(blueColor) - (quad1.y * uGird);
    vec2 quad2;
    quad2.y = floor(ceil(blueColor) / uGird);
    quad2.x = ceil(blueColor) - (quad2.y * uGird);

    float girdDiv = 1.0 / uGird;
    float girdCube = uGird * uGird * uGird;
    vec2 texPos1;
    float cubeCeil = 0.5 / girdCube;
    float girdDivSub = girdDiv - 1.0/girdCube;
    float cubeCeilR = cubeCeil + (girdDivSub * textureColor.r);
    float cubeCeilG = cubeCeil + (girdDivSub * textureColor.g);
    texPos1.x = (quad1.x * girdDiv) + cubeCeilR;
    texPos1.y = (quad1.y * girdDiv) + cubeCeilG;
    vec2 texPos2;
    texPos2.x = (quad2.x * girdDiv) + cubeCeilR;
    texPos2.y = (quad2.y * girdDiv) + cubeCeilG;
    if (uFlip > 0.5) {
        texPos1.y = 1.0 - texPos1.y;
        texPos2.y = 1.0 - texPos2.y;
    }
    vec4 newColor1 = texture2D(uTexture1, texPos1);
    vec4 newColor2 = texture2D(uTexture1, texPos2);
    vec4 newColor = mix(newColor1, newColor2, fract(blueColor));
    gl_FragColor = mix(textureColor, vec4(newColor.rgb, textureColor.w), uIntensity);
}