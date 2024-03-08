#ifdef GL_ES
precision highp float;
#endif
varying vec2 vTextureCo;
varying vec2 vTextureMaskCo;

uniform sampler2D uTexture1;
uniform sampler2D uTexture2;
// 1-2 表示阈值，3表示十分反转
uniform vec3 uParam1;

void main() {
    vec4 mask = texture2D(uTexture1, vTextureMaskCo);
    vec4 origin = texture2D(uTexture2, vTextureCo);
    float t = smoothstep(uParam1.x, uParam1.y, mask.r);
    float c = step(uParam1.z, 0.5) * t + step(1.0 - uParam1.z, 0.5) * (1.0 - t);
    gl_FragColor = vec4(origin.r, origin.g, origin.b, origin.a * c);
}

