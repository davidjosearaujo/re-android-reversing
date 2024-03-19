
#ifdef GL_ES
precision highp float;
#endif
//正常
vec3 blendNormal(vec4 base, vec4 blend){
    return blend.rgb;
}

// 暗系
//变暗
vec3 blendDarken(vec4 base, vec4 blend){
    return min(base.rgb, blend.rgb);
}

//正片叠底
vec3 blendMultiply(vec4 base, vec4 blend) {
    return base.rgb * blend.rgb;
}

//颜色加深
vec3 blendColorBurn(vec4 base, vec4 blend){
    return 1.0 - (1.0 - blend.rgb)/base.rgb;
}

//线性加深
vec3 blendLinearBurn(vec4 base, vec4 blend){
    return base.rgb + blend.rgb - 1.0;
}

//深色
vec3 blendDarkerColor(vec4 base, vec4 blend){
    vec3 d = vec3(0.299, 0.578, 0.114);
    float info = step(0.0 ,dot(base.rgb, d) - dot(blend.rgb, d));
    return mix(base.rgb, blend.rgb, info);
}

//亮系
//变亮
vec3 blendLighten(vec4 base, vec4 blend){
    return max(base.rgb, blend.rgb);
}

//滤色
vec3 blendScreen(vec4 base, vec4 blend){
    return 1.0 - (1.0 - base.rgb) * (1.0 - blend.rgb);
}

//颜色减淡
vec3 blendColorDodge(vec4 base, vec4 blend){
    return blend.rgb/(1.0 - base.rgb);
}

//线性减淡
vec3 blendLinearDodge(vec4 base, vec4 blend){
    return clamp(blend.rgb + base.rgb, 0.0, 1.0);
}

//浅色
vec3 blendLighterColor(vec4 base, vec4 blend){
    vec3 d = vec3(0.299, 0.578, 0.114);
    float info = step(0.0 ,dot(blend.rgb, d) - dot(base.rgb, d));
    return mix(base.rgb, blend.rgb, info);
}


//对比类
//叠加
vec3 blendOverlay(vec4 base, vec4 blend){
    vec3 info = step(0.5, blend.rgb);
    return mix(1.0 - 2.0 * (1.0 - base.rgb) * (1.0 - blend.rgb), 2.0 * base.rgb * blend.rgb, info);
}

//柔光
vec3 blendSoftLight(vec4 base, vec4 blend){
    vec3 info = step(0.5, base.rgb);
    vec3 left = 2.0 * base.rgb * (1.0 - blend.rgb) + sqrt(base.rgb) * (2.0 * blend.rgb - 1.0);
    vec3 right = 2.0 * base.rgb * blend.rgb + base.rgb * base.rgb * (1.0 - 2.0 * blend.rgb);
    return mix(left, right, info);
}

//强光
vec3 blendHardLight(vec4 base, vec4 blend){
    vec3 info = step(0.5, base.rgb);
    vec3 left = 1.0 - 2.0 * (1.0 - base.rgb) * (1.0 - blend.rgb);
    vec3 right = 2.0 * base.rgb * blend.rgb;
    return mix(left, right, info);
}

//亮光
vec3 blendVividLight(vec4 base, vec4 blend){
    vec3 info = step(0.5, base.rgb);
    vec3 left = 1.0 - (1.0 - blend.rgb) / (2.0 * base.rgb);
    vec3 right = blend.rgb / (2.0 * (1.0 - base.rgb));
    return mix(left, right, info);
}

//线性光
vec3 blendLinearLight(vec4 base, vec4 blend){
    return clamp(base.rgb + 2.0 * blend.rgb - 1.0, 0.0, 1.0);
}

//点光
vec3 blendPinLight(vec4 base, vec4 blend){
    return min(2.0 * blend.rgb, max(2.0 * blend.rgb - 1.0, base.rgb));
}

//实色混合
vec3 blendHardMix(vec4 base, vec4 blend){
    return step(1.0,  base.rgb + blend.rgb);
}


//差集
//差值
vec3 blendDifference(vec4 base, vec4 blend){
    return abs(blend.rgb - base.rgb);
}

//排除
vec3 blendExclusion(vec4 base, vec4 blend){
    return blend.rgb + base.rgb - 2.0 * base.rgb * blend.rgb;
}

//减去
vec3 blendSubtract(vec4 base, vec4 blend){
    return clamp(base.rgb - blend.rgb, 0.0, 1.0);
}

//划分
vec3 blendDivide(vec4 base, vec4 blend){
    return clamp(base.rgb / blend.rgb, 0.0, 1.0);
}

//色相
vec3 rgb2hsv(vec3 c){
    vec4 K = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);
    vec4 p = mix(vec4(c.bg, K.wz), vec4(c.gb, K.xy), step(c.b, c.g));
    vec4 q = mix(vec4(p.xyw, c.r), vec4(c.r, p.yzx), step(p.x, c.r));

    float d = q.x - min(q.w, q.y);
    float e = 1.0e-10;
    return vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), d / (q.x + e), q.x);
}

vec3 hsv2rgb(vec3 c){
    vec4 K = vec4(1.0, 2.0 / 3.0, 1.0 / 3.0, 3.0);
    vec3 p = abs(fract(c.xxx + K.xyz) * 6.0 - K.www);
    return c.z * mix(K.xxx, clamp(p - K.xxx, 0.0, 1.0), c.y);
}

//色相
vec3 blendHue(vec4 base, vec4 blend){
    vec3 c1 = rgb2hsv(blend.rgb);
    vec3 c2 = rgb2hsv(base.rgb);
    vec3 c3 = vec3(c1.r, c2.g, c2.b);
    return hsv2rgb(c3);
}

//饱和度
vec3 blendSaturation(vec4 base, vec4 blend){
    vec3 c1 = rgb2hsv(blend.rgb);
    vec3 c2 = rgb2hsv(base.rgb);
    vec3 c3 = vec3(c2.r, c1.g, c2.b);
    return hsv2rgb(c3);
}

//颜色
vec3 blendColor(vec4 base, vec4 blend){
    vec3 c1 = rgb2hsv(blend.rgb);
    vec3 c2 = rgb2hsv(base.rgb);
    vec3 c3 = vec3(c1.r, c1.g, c2.b);
    return hsv2rgb(c3);
}

//明度
vec3 blendLuminosity(vec4 base, vec4 blend){
    vec3 c1 = rgb2hsv(blend.rgb);
    vec3 c2 = rgb2hsv(base.rgb);
    vec3 c3 = vec3(c2.r, c2.g, c1.b);
    return hsv2rgb(c3);
}

uniform sampler2D 	tex0;
uniform sampler2D   tex1;
varying vec2 UV;
varying vec2 vBaseUV;
uniform bool premultiplied;

void main() {
    vec4 baseTex = texture2D(tex1, vBaseUV);
    vec4 uvTex = texture2D(tex0, UV);
    vec3 color = blendFunction(baseTex, uvTex);
    if (premultiplied) {
        color = baseTex.rgb * (1.0-uvTex.a) * baseTex.a + color;
    }
    else {
        color = uvTex.a * color + (1.0-uvTex.a) * baseTex.rgb * baseTex.a;
    }
    float alpha = uvTex.a + (1.0-uvTex.a) * baseTex.a;
    gl_FragColor = vec4(color, alpha);
    gl_FragColor.rgb = gl_FragColor.rgb / mix(gl_FragColor.a, 1.0, step(gl_FragColor.a, 0.0));
}