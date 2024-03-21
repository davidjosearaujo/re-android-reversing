package a.a.a.a;

import a.a.a.a.h;
import a.a.a.a.m;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class n extends m implements a.a.a.e.e {
    private static short[] $ = {1316, 1283, 1305, 1288, 1311, 1283, 1292, 1281, 1357, 1288, 1311, 1311, 1282, 1311, 1357, 1306, 1284, 1305, 1285, 1357, 1305, 1285, 1288, 1357, 1295, 1292, 1294, 1286, 1357, 1310, 1305, 1292, 1294, 1286, 1357, 1311, 1288, 1294, 1282, 1311, 1289, 1310, 5190, 5234, 5217, 5223, 5229, 5221, 5230, 5236, 5197, 5217, 5230, 5217, 5223, 5221, 5234, 1280, 1313, 1284, 1310, 1305, 1288, 1283, 1288, 1311, 6221, 6255, 6240, 6240, 6241, 6266, 6190, 6255, 6253, 6253, 6251, 6269, 6269, 6190, 6223, 6240, 6247, 6243, 6255, 6266, 6247, 6241, 6240, 6185, 6269, 6190, 6243, 6210, 6247, 6269, 6266, 6251, 6240, 6251, 6268, 6190, 6248, 6247, 6251, 6242, 6250, 7947, 7978, 8037, 7971, 7980, 7968, 7977, 7969, 8037, 7986, 7980, 7985, 7981, 8037, 7985, 7981, 7968, 8037, 7979, 7972, 7976, 7968, 8037, 7976, 7945, 7980, 7990, 7985, 7968, 7979, 7968, 7991, 8037, 7980, 7990, 8037, 7971, 7978, 7984, 7979, 7969, 8037, 7980, 7979, 8037, 7940, 7979, 7980, 7976, 7972, 7985, 7980, 7978, 7979, 8037, 7974, 7977, 7972, 7990, 7990, 7522, 7510, 7493, 7491, 7497, 7489, 7498, 7504, 7529, 7493, 7498, 7493, 7491, 7489, 7510, 12, 46, 57, 36, 59, 36, 57, 52, 109, 62, 57, 44, 57, 40, 119, 7823, 7848, 7840, 7845, 7852, 7853, 7913, 7853, 7868, 7844, 7865, 7840, 7847, 7854, 7913, 7866, 7869, 7848, 7869, 7852, 10569, 10569, 6671, 6711, 6705, 6710, 6754, 6688, 6695, 6754, 6689, 6691, 6702, 6702, 6695, 6694, 6754, 6692, 6704, 6701, 6703, 6754, 6703, 6691, 6699, 6700, 6754, 6710, 6698, 6704, 6695, 6691, 6694, 6754, 6701, 6692, 6754, 6692, 6704, 6691, 6693, 6703, 6695, 6700, 6710, 6754, 6698, 6701, 6705, 6710, 988, 1000, 1019, 1021, 1015, 1023, 1012, 1006, 983, 1019, 1012, 1019, 1021, 1023, 1000, 954, 1011, 1001, 954, 1019, 1014, 1000, 1023, 1019, 1022, 995, 954, 1023, 994, 1023, 1017, 1007, 1006, 1011, 1012, 1021, 954, 1006, 1000, 1019, 1012, 1001, 1019, 1017, 1006, 1011, 1013, 1012, 1001, 1614, 1644, 1635, 1581, 1635, 1634, 1657, 1581, 1661, 1640, 1663, 1643, 1634, 1663, 1632, 1581, 1657, 1637, 1636, 1662, 1581, 1644, 1646, 1657, 1636, 1634, 1635, 1581, 1636, 1635, 1662, 1636, 1641, 1640, 1581, 1634, 1643, 1581, 8392, 8426, 8421, 8363, 8421, 8420, 8447, 8363, 8443, 8430, 8441, 8429, 8420, 8441, 8422, 8363, 8447, 8419, 8418, 8440, 8363, 8426, 8424, 8447, 8418, 8420, 8421, 8363, 8426, 8429, 8447, 8430, 8441, 8363, 8420, 8421, 8408, 8426, 8445, 8430, 8386, 8421, 8440, 8447, 8426, 8421, 8424, 8430, 8408, 8447, 8426, 8447, 8430, 8161, 8149, 8134, 8128, 8138, 8130, 8137, 8147, 8071, 2435, 2506, 2512, 2435, 2509, 2508, 2519, 2435, 2496, 2518, 2513, 2513, 2502, 2509, 2519, 2511, 2522, 2435, 2506, 2509, 2435, 2519, 2507, 2502, 2435, 2533, 2513, 2498, 2500, 2510, 2502, 2509, 2519, 2542, 2498, 2509, 2498, 2500, 2502, 2513, 3103, 3080, 3072, 3074, 3099, 3080, 3159, 3149, 11347, 11293, 11286, 11264, 11271, 11290, 11293, 11284, 11342, 11504, 11460, 11479, 11473, 11483, 11475, 11480, 11458, 11515, 11479, 11480, 11479, 11473, 11475, 11460, 4867, 4919, 4900, 4898, 4904, 4896, 4907, 4913, 4872, 4900, 4907, 4900, 4898, 4896, 4919, 10620, 10603, 10621, 10618, 10593, 10620, 10603, 10575, 10594, 10594, 10589, 10618, 10607, 10618, 10603, 10548, 10542, 10620, 10603, 10531, 10607, 10618, 10618, 10607, 10605, 10598, 10599, 10592, 10601, 10542, 10620, 10603, 10618, 10607, 10599, 10592, 10603, 10602, 10542, 7681, 7694, 7684, 7698, 7695, 7689, 7684, 7770, 7702, 7689, 7685, 7703, 7743, 7699, 7700, 7681, 7700, 7685, 4884, 4878, 7397, 7410, 7396, 7395, 7416, 7397, 7410, 7382, 7419, 7419, 7364, 7395, 7414, 7395, 7410, 7341, 7351, 7414, 7412, 7395, 7422, 7393, 7410, 7351, 7348, 7419, 7404, 7418, 7421, 7398, 7419, 7404, 7368, 7397, 7397, 7386, 7421, 7400, 7421, 7404, 7347, 7337, 7400, 7423, 7400, 7392, 7397, 7337, 7338, 4894, 4905, 4961, 4909, 4920, 4920, 4909, 4911, 4900, 4901, 4898, 4907, 4972, 4926, 4905, 4920, 4909, 4901, 4898, 4905, 4904, 4972, 4906, 4926, 4909, 4907, 4897, 4905, 4898, 4920, 4972, 7050, 7134, 7115, 7128, 7117, 7119, 7134, 7050, 7108, 7109, 7050, 7110, 7109, 7108, 7117, 7119, 7128, 7050, 7119, 7122, 7107, 7129, 7134, 7129, 7056, 7050, 1960, 1983, 1961, 1966, 1973, 1960, 1983, 1947, 1974, 1974, 1929, 1966, 1979, 1966, 1983, 2016, 2042, 1979, 1982, 1982, 1983, 1982, 2042, 2041, 1958, 1931, 1941, 1922, 1926, 1923, 1950, 1991, 1926, 1923, 1923, 1922, 1923, 1990, 11362, 11331, 11276, 11333, 11330, 11359, 11352, 11341, 11330, 11352, 11333, 11341, 11352, 11337, 11336, 11276, 11338, 11358, 11341, 11339, 11329, 11337, 11330, 11352, 11276, 11338, 11331, 11358, 11276, 11333, 11330, 11336, 11337, 11348, 11276, 11279, 12036, 12051, 12037, 12034, 12057, 12036, 12051, 12087, 12058, 12058, 12069, 12034, 12055, 12034, 12051, 12108, 12118, 12052, 12055, 12053, 12061, 12118, 12037, 12034, 12055, 12053, 12061, 12118, 12117, 4929, 4937, 4872, 4879, 4869, 4868, 4889, 4929, 1342, 1325, 1335, 2459, 2459, 11389, 11370, 11387, 11374, 11366, 11361, 11329, 11360, 11361, 11340, 11360, 11361, 11369, 11366, 11368, 11317, 11311, 11364, 11370, 11370, 11391, 11366, 11361, 11368, 11311, 11389, 11370, 11387, 11374, 11366, 11361, 11370, 11371, 11311, 3125, 3073, 3090, 3092, 3102, 3094, 3101, 3079, 3134, 3090, 3101, 3090, 3092, 3094, 3073, 3072, 3144, 3137, 3155, 3072, 3139, 3148, 3141, 3137, 3154, 3141, 3140, 3072, 3145, 3150, 3140, 3141, 3160, 3098, 3072, 4962, 4933, 4941, 4936, 4945, 4950, 4929, 4868, 4951, 4933, 4946, 4941, 4938, 4931, 4868, 4951, 4944, 4933, 4944, 4929, 4894, 4868, 4933, 4935, 4944, 4941, 4946, 4929, 4868, 18, 8, 7205, 7185, 7170, 7172, 7182, 7174, 7181, 7191, 7214, 7170, 7181, 7170, 7172, 7174, 7185, 3450, 3445, 3455, 3433, 3444, 3442, 3455, 3361, 3439, 3450, 3433, 3452, 3454, 3439, 3396, 3432, 3439, 3450, 3439, 3454, 5921, 5934, 5924, 5938, 5935, 5929, 5924, 6010, 5940, 5921, 5938, 5927, 5925, 5940, 5919, 5938, 5925, 5937, 5919, 5939, 5940, 5921, 5940, 5925, 5736, 5711, 5703, 5698, 5723, 5724, 5707, 5646, 5725, 5711, 5720, 5703, 5696, 5705, 5646, 5725, 5722, 5711, 5722, 5707, 5652, 5646, 11102, 11030, 11039, 11021, 11102, 11018, 11039, 11020, 11033, 11035, 11018, 11102, 11024, 11025, 11018, 11102, 11031, 11024, 11102, 11032, 11020, 11039, 11033, 11027, 11035, 11024, 11018, 11102, 11027, 11039, 11024, 11039, 11033, 11035, 11020, 
    11076, 11102, 4817, 4835, 4852, 4839, 4838, 4770, 4849, 4854, 4835, 4854, 4839, 4770, 4845, 4836, 4770, 1452, 1470, 1449, 1466, 1438, 1459, 1459, 1420, 1451, 1470, 1451, 1466, 1509, 1535, 1457, 1456, 1535, 1465, 1453, 1470, 1464, 1458, 1466, 1457, 1451, 1452, 1534, 6009, 5995, 6012, 5999, 5963, 5990, 5990, 5977, 6014, 5995, 6014, 5999, 5936, 5930, 5995, 5998, 5998, 5987, 5988, 5997, 5930, 5996, 6008, 5995, 5997, 5991, 5999, 5988, 6014, 5930, 5929, 6264, 6250, 6269, 6254, 6218, 6247, 6247, 6232, 6271, 6250, 6271, 6254, 6193, 6187, 6250, 6255, 6255, 6242, 6245, 6252, 6187, 6249, 6250, 6248, 6240, 6187, 6264, 6271, 6250, 6248, 6240, 6187, 6184, 228, 235, 225, 247, 234, 236, 225, 191, 243, 236, 224, 242, 218, 246, 241, 228, 241, 224, 4019, 4028, 4022, 4000, 4029, 4027, 4022, 4072, 4007, 4001, 4023, 4000, 3981, 4004, 4027, 4001, 4027, 4016, 4030, 4023, 3981, 4026, 4027, 4028, 4006, 4806, 4850, 4833, 4839, 4845, 4837, 4846, 4852, 4813, 4833, 4846, 4833, 4839, 4837, 4850, 5967, 6009, 5992, 5992, 6005, 6002, 6011, 5948, 6014, 6013, 6015, 6007, 5948, 5999, 5992, 6013, 6015, 6007, 5948, 6005, 6002, 6008, 6009, 5988, 5948, 7400, 7356, 7335, 7400, 6867, 6887, 6900, 6898, 6904, 6896, 6907, 6881, 6872, 6900, 6907, 6900, 6898, 6896, 6887, 786, 823, 823, 826, 829, 820, 883, 818, 805, 818, 826, 831, 818, 817, 831, 822, 883, 817, 818, 816, 824, 883, 800, 807, 818, 816, 824, 883, 826, 829, 823, 822, 811, 883, 6544, 6564, 6583, 6577, 6587, 6579, 6584, 6562, 6555, 6583, 6584, 6583, 6577, 6579, 6564, 6169, 6204, 6204, 6193, 6198, 6207, 6264, 6202, 6201, 6203, 6195, 6264, 6187, 6188, 6201, 6203, 6195, 6264, 6193, 6198, 6204, 6205, 6176, 6264, 7088, 7143, 7161, 7140, 7160, 7088, 5476, 5503, 5496, 5472, 5421, 5431, 4828, 4840, 4859, 4861, 4855, 4863, 4852, 4846, 4823, 4859, 4852, 4859, 4861, 4863, 4840, 2474, 2440, 2463, 2434, 2461, 2434, 2463, 2450, 2507, 2435, 2442, 2456, 2507, 2441, 2446, 2446, 2437, 2507, 2447, 2446, 2456, 2463, 2457, 2436, 2450, 2446, 2447, 7155, 7155, 7155, 7155, 788, 822, 801, 828, 803, 816, 885, 787, 807, 820, 818, 824, 816, 827, 801, 806, 885, 828, 827, 885, 1450, 1844, 1844, 1847, 1557, 1551, 5364, 5329, 5329, 5328, 5329, 5269, 5363, 5319, 5332, 5330, 5336, 5328, 5339, 5313, 5318, 5263, 3941, 3941, 3942, 6404, 6430, 9265, 9221, 9238, 9232, 9242, 9234, 9241, 9219, 9220, 9303, 9268, 9221, 9234, 9238, 9219, 9234, 9235, 9303, 9274, 9234, 9241, 9218, 9220, 9293, 958, 958, 957, 2009, 1987, 8552, 8523, 8521, 8513, 8458, 8569, 8542, 8523, 8521, 8513, 8464, 1048, 1048, 1051, 7537, 7531, 7205, 7174, 7172, 7180, 7239, 7220, 7187, 7174, 7172, 7180, 7239, 7214, 7177, 7171, 7182, 7172, 7170, 7188, 7261, 6348, 6348, 6351, 6394, 6368, 4715, 4679, 4720, 4711, 4719, 4714, 4676, 4711, 4709, 4717, 4693, 4722, 4711, 4709, 4717, 4687, 4712, 4706, 4719, 4709, 4707, 4725, 4668, 4646, 9452, 9433, 9426, 9432, 9429, 9426, 9435, 9372, 9469, 9439, 9416, 9429, 9427, 9426, 9423, 9350, 8087, 8087, 8084, 5981, 5959, 192, 244, 231, 225, 235, 227, 232, 242, 203, 231, 232, 231, 225, 227, 244, 166, 235, 239, 245, 229, 166, 245, 242, 231, 242, 227, 188, 105, 105, 36, 1, 38, 58, 61, 116, 583, 583, 522, 548, 520, 521, 531, 518, 526, 521, 514, 533, 602, 6527, 6527, 6450, 6415, 6462, 6445, 6458, 6449, 6443, 6498, 569, 569, 628, 602, 620, 619, 586, 621, 632, 621, 636, 548, 7151, 7074, 7068, 7099, 7086, 7099, 7082, 7068, 7086, 7097, 7082, 7083, 7154, 9772, 9825, 9800, 9833, 9855, 9848, 9854, 9827, 9845, 9833, 9832, 9777, 6275, 6275, 6350, 6381, 6342, 6342, 6343, 6382, 6342, 6349, 6358, 6378, 6349, 6357, 6338, 6351, 6346, 6343, 6338, 6359, 6342, 6302, 2080, 2080, 2157, 2126, 2159, 2132, 2162, 2145, 2158, 2163, 2145, 2147, 2164, 2153, 2159, 2158, 2163, 2114, 2149, 2147, 2145, 2165, 2163, 2149, 2109, 5841, 5841, 5788, 5808, 5767, 5776, 5784, 5789, 5816, 5791, 5781, 5784, 5778, 5780, 5762, 5835, 5841, 3189, 3158, 3155, 3095, 3166, 3155, 3085, 3095, 8694, 8691, 8691, 8621, 8631, 6234, 6254, 6269, 6267, 6257, 6265, 6258, 6248, 6225, 6269, 6258, 6269, 6267, 6265, 6254, 456, 508, 495, 489, 483, 491, 480, 506, 430, 495, 482, 508, 491, 495, 490, 503, 430, 495, 490, 490, 491, 490, 436, 430, 254, 202, 217, 223, 213, 221, 214, 204, 245, 217, 214, 217, 223, 221, 202, 8961, 8996, 8996, 9001, 9006, 8999, 9056, 8994, 8993, 8995, 9003, 9056, 9011, 9012, 8993, 8995, 9003, 9056, 9001, 9006, 8996, 8997, 9016, 9056, 9857, 9942, 9928, 9941, 9929, 9857, 5368, 5324, 5343, 5337, 5331, 5339, 5328, 5322, 5363, 5343, 5328, 5343, 5337, 5339, 5324, 505, 463, 478, 478, 451, 452, 461, 394, 456, 459, 457, 449, 394, 473, 478, 459, 457, 449, 394, 451, 452, 462, 463, 466, 394, 8689, 8613, 8638, 8689, 5452, 5496, 5483, 5485, 5479, 5487, 5476, 5502, 5447, 5483, 5476, 5483, 5485, 5487, 5496, 12252, 12264, 12287, 12287, 12275, 12276, 12285, 12218, 12280, 12283, 12281, 12273, 12218, 12265, 12270, 12283, 12281, 12273, 12218, 12275, 12276, 12286, 12287, 12258, 12218, 5759, 5714, 5708, 5723, 5727, 5722, 5703, 5662, 5727, 5706, 5706, 5727, 5725, 5718, 5723, 5722, 8721, 8741, 8758, 8752, 8762, 8754, 8761, 8739, 8730, 8758, 8761, 8758, 8752, 8754, 8741, 3769, 3756, 3756, 3769, 3771, 3760, 3810, 3832, 9937, 9940, 9940, 9872, 9942, 9922, 9951, 9949, 9872, 9937, 9924, 9924, 9937, 9939, 9944, 9866, 9872, 66, 118, 101, 99, 105, 97, 106, 112, 36, 101, 104, 118, 97, 101, 96, 125, 36, 101, 96, 96, 97, 96, 62, 36, 562, 552, 609, 614, 620, 621, 624, 552, 10502, 10546, 10529, 10535, 10541, 10533, 10542, 10548, 10592, 10542, 10543, 10592, 10540, 10543, 10542, 10535, 10533, 10546, 10592, 10533, 10552, 10537, 10547, 10548, 10547, 10592, 10534, 10543, 10546, 10592, 10539, 10533, 10553, 10592, 7699, 7698, 7711, 7710, 7745, 7771, 380, 328, 347, 349, 343, 351, 340, 334, 375, 347, 340, 347, 349, 351, 328, -4000, -3980, -3993, -3999, -3989, -3997, -3992, -3982, -16108, -16101, -16106, -16124, -16124, -16379, -16353, 
    -16270, -16310, -16308, -16309, -16353, -16308, -16305, -16294, -16292, -16298, -16295, -16314, -16353, -16310, -16303, -16298, -16306, -16310, -16294, -16353, -16290, -16303, -16293, -16307, -16304, -16298, -16293, -16379, -16298, -16293, -16365, -16353, -16290, -16303, -16293, -16307, -16304, -16298, -16293, -16379, -16309, -16290, -16296, -16365, -16353, -16304, -16307, -16353, -16297, -16290, -16311, -16294, -16353, -16290, -16353, -16305, -16290, -16307, -16294, -16303, -16309, -16353, -16312, -16298, -16309, -16297, -16353, -16290, -16303, -16353, -16298, -16293, -16353, -16295, -16304, -16307, -16353, -16180, -16179, -16160, -16175, -16186, -16190, -16169, -16186, -16139, -16182, -16186, -16172, -16231, -16253, -16182, -16185, -16226, -16237, -16165, -13315, -13381, -13389, -13380, -13392, -13384, -13344, -16149, -16210, -16205, -16222, -16200, -16193, -16222, -16219, -16212, -16138, -4044, -4096, -4077, -4075, -4065, -4073, -4068, -4090, -4033, -4077, -4068, -4077, -4075, -4073, -4096, -8973, -9017, -9004, -9006, -9000, -9008, -8997, -9023, -9067, -15086, -15018, -15013, -15018, -15086, -15012, -15011, -15034, -15086, -15023, -15040, -15017, -15021, -15034, -15017, -15086, -15021, -15086, -15036, -15013, -15017, -15035, -15076, -2176, -2150, -2050, -2097, -2102, -2090, -2093, -2087, -2085, -2098, -2081, -2150, -2093, -2082, -2150, -2166, -2110, -8623, -8611, -8695, -8676, -8678, -8611, -9365, -9369, -9432, -9419, -9369, -9417, -9434, -9419, -9438, -9431, -9421, -9369, -9426, -9437, -9369, -9353, -9409, -15785, -15872, -15842, -15869, -15841, -15785, -15850, -15847, -15848, -15869, -15841, -15854, -15867, -15785, -15855, -15867, -15850, -15856, -15846, -15854, -15847, -15869, -15785, -15855, -15848, -15867, -15785, 7388, 7400, 7419, 7421, 7415, 7423, 7412, 7406, 7383, 7419, 7412, 7419, 7421, 7423, 7400, 4785, 4784, 4769, 4788, 4790, 4797, 4847, 4853, 5937, 5926, 5934, 5932, 5941, 5926, 5987, 5925, 5937, 5932, 5934, 5987, 5927, 5926, 5943, 5922, 5920, 5931, 6009, 5987, 11583, 11538, 11538, 11537, 11549, 11551, 11530, 11547, 11546, 11614, 11544, 11532, 11551, 11545, 11539, 11547, 11536, 11530, 11614, 11543, 11536, 11546, 11547, 11526, 11614, 2780, 2792, 2811, 2813, 2807, 2815, 2804, 2798, 2775, 2811, 2804, 2811, 2813, 2815, 2792, 5618, 5574, 5585, 5585, 5597, 5594, 5587, 5524, 5586, 5574, 5589, 5587, 5593, 5585, 5594, 5568, 5524, 5597, 5594, 5584, 5585, 5580, 5524, 2840, 2860, 2879, 2873, 2867, 2875, 2864, 2858, 2835, 2879, 2864, 2879, 2873, 2875, 2860, 20314, 20334, 20349, 20347, 20337, 20345, 20338, 20328, 20305, 20349, 20338, 20349, 20347, 20345, 20334, 20327, 19184, 19129, 19134, 19184, 21776, 21776, 4280, 4249, 4310, 4247, 4245, 4226, 4255, 4224, 4255, 4226, 4239, 3515, 3471, 3484, 3482, 3472, 3480, 3475, 3465, 3504, 3484, 3475, 3484, 3482, 3480, 3471, 3845, 3847, 3870, 3853, 3868, 3847, 3912, 3883, 3898, 3885, 3881, 3900, 3885, 3884, 3922, 3912, 7086, 7073, 7083, 7101, 7072, 7078, 7083, 7157, 7097, 7078, 7082, 7096, 7056, 7100, 7099, 7086, 7099, 7082, 3489, 3502, 3492, 3506, 3503, 3497, 3492, 3578, 3508, 3489, 3506, 3495, 3493, 3508, 3487, 3507, 3508, 3489, 3508, 3493, 3013, 3018, 3008, 3030, 3019, 3021, 3008, 2974, 3024, 3013, 3030, 3011, 3009, 3024, 3067, 3030, 3009, 3029, 3067, 3031, 3024, 3013, 3024, 3009, 5907, 5916, 5910, 5888, 5917, 5915, 5910, 5960, 5895, 5889, 5911, 5888, 5933, 5892, 5915, 5889, 5915, 5904, 5918, 5911, 5933, 5914, 5915, 5916, 5894, 4967, 4965, 4988, 4975, 4990, 4965, 4906, 4939, 4937, 4958, 4931, 4956, 4931, 4958, 4947, 4949, 4937, 4952, 4943, 4939, 4958, 4943, 4942, 4912, 4906, 1397, 1390, 1387, 1390, 1391, 1399, 1390, 7581, 7612, 7667, 7589, 7610, 7606, 7588, 7667, 7605, 7612, 7590, 7613, 7607, 7667, 7605, 7612, 7585, 7667, 7610, 7607, 7667, 7651, 7595, 6956, 6948, 2483, 2490, 2556, 2549, 2536, 2490, 2556, 2536, 2555, 2557, 2551, 2559, 2548, 2542, 2490, 7881, 7915, 7908, 7908, 7909, 7934, 7850, 7913, 7928, 7919, 7915, 7934, 7919, 7850, 7916, 7928, 7915, 7917, 7911, 7919, 7908, 7934, 7850, 11420, 11482, 11475, 11470, 11420, 11485, 11420, 11487, 11475, 11474, 11464, 11485, 11477, 11474, 11481, 11470, 11420, 11466, 11477, 11481, 11467, 11420, 11467, 11477, 11464, 11476, 11420, 11474, 11475, 11420, 11477, 11480, 304, 306, 299, 312, 297, 306, 381, 270, 265, 284, 271, 265, 280, 281, 359, 381, 6090, 6088, 6097, 6082, 6099, 6088, 6023, 6133, 6114, 6132, 6130, 6122, 6114, 6115, 6045, 6023, 2949, 2993, 2978, 2980, 2990, 2982, 2989, 2999, 3043, 11136, 11204, 11209, 11204, 11136, 11214, 11215, 11220, 11136, 11203, 11201, 11212, 11212, 11136, 11220, 11208, 11218, 11215, 11221, 11207, 11208, 11136, 11220, 11215, 11136, 11219, 11221, 11216, 11205, 11218, 11150, 11215, 11214, 11233, 11220, 11220, 11201, 11203, 11208, 11144, 11145, 7292, 7294, 7271, 7284, 7287, 7267, 7294, 7292, 7217, 7235, 7252, 7234, 7236, 7260, 7252, 7253, 7211, 7217, 965, 967, 990, 973, 974, 986, 967, 965, 904, 1019, 1020, 1001, 1018, 1020, 1005, 1004, 914, 904, 10467, 10465, 10488, 10475, 10472, 10492, 10465, 10467, 10414, 10461, 10458, 10433, 10462, 10462, 10443, 10442, 10420, 10414, 120, 122, 99, 112, 115, 103, 122, 120, 53, 84, 86, 65, 92, 67, 92, 65, 76, 74, 86, 71, 80, 84, 65, 80, 81, 47, 53, 1395, 1393, 1384, 1403, 1400, 1388, 1393, 1395, 1342, 1373, 1356, 1371, 1375, 1354, 1371, 1370, 1316, 1342, 5209, 5211, 5186, 5201, 5216, 5211, 5223, 5184, 5205, 5184, 5201, 5134, 5140, 5234, 5190, 5205, 5203, 5209, 5201, 5210, 5184, 5140, 5191, 5184, 5205, 5184, 5201, 5140, 5202, 5211, 5190, 5140, 12165, 12235, 12234, 12241, 12165, 12240, 12245, 12225, 12228, 12241, 12224, 12225, 12165, 12236, 12235, 12233, 12236, 12235, 12224, 12190, 12165, 7971, 7998, 7990, 7971, 7973, 7986, 7971, 7970, 8038, 7989, 7986, 7975, 7986, 7971, 8038, 4882, 4948, 4957, 4935, 4956, 4950, 4882};
    static boolean B;
    static final boolean C;
    static Field D;
    static final Interpolator E;
    static final Interpolator F;

    /* renamed from: a */
    ArrayList<e> f35a;

    /* renamed from: b */
    boolean f36b;
    ArrayList<h> c;
    ArrayList<h> d;
    ArrayList<Integer> e;
    ArrayList<b> f;
    ArrayList<h> g;
    ArrayList<b> h;
    ArrayList<Integer> i;
    ArrayList<m.b> j;
    private CopyOnWriteArrayList<a.a.a.d.g<m.a, Boolean>> k;
    l m;
    j n;
    h o;
    boolean p;
    boolean q;
    boolean r;
    String s;
    boolean t;
    ArrayList<b> u;
    ArrayList<Boolean> v;
    ArrayList<h> w;
    ArrayList<g> z;
    int l = 0;
    Bundle x = null;
    SparseArray<Parcelable> y = null;
    Runnable A = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public class a implements Runnable {
        a() {
            n.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.this.a0();
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public class b extends c {
        final /* synthetic */ h d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(View view, Animation animation, h hVar) {
            super(view, animation);
            n.this = r1;
            this.d = hVar;
        }

        @Override // a.a.a.a.n.c, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            super.onAnimationEnd(animation);
            if (this.d.i() != null) {
                this.d.J0(null);
                n nVar = n.this;
                h hVar = this.d;
                nVar.z0(hVar, hVar.y(), 0, 0, false);
            }
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static class c implements Animation.AnimationListener {

        /* renamed from: a */
        private Animation.AnimationListener f38a;

        /* renamed from: b */
        private boolean f39b;
        View c;

        /* loaded from: /home/remnux/decompressedMalicious.dex */
        public class a implements Runnable {
            a() {
                c.this = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.a.a.e.f.e(c.this.c, 0, null);
            }
        }

        public c(View view, Animation animation) {
            if (view != null && animation != null) {
                this.c = view;
            }
        }

        public c(View view, Animation animation, Animation.AnimationListener animationListener) {
            if (view != null && animation != null) {
                this.f38a = animationListener;
                this.c = view;
                this.f39b = true;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view = this.c;
            if (view != null && this.f39b) {
                if (a.a.a.e.f.d(view) || a.a.a.c.a.a()) {
                    this.c.post(new a());
                } else {
                    a.a.a.e.f.e(this.c, 0, null);
                }
            }
            Animation.AnimationListener animationListener = this.f38a;
            if (animationListener != null) {
                animationListener.onAnimationEnd(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Animation.AnimationListener animationListener = this.f38a;
            if (animationListener != null) {
                animationListener.onAnimationRepeat(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Animation.AnimationListener animationListener = this.f38a;
            if (animationListener != null) {
                animationListener.onAnimationStart(animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static class d {

        /* renamed from: a */
        public static final int[] f41a = {16842755, 16842960, 16842961};
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public interface e {
        boolean a(ArrayList<b> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    private class f implements e {

        /* renamed from: a */
        final String f42a;

        /* renamed from: b */
        final int f43b;
        final int c;

        f(String str, int i, int i2) {
            n.this = r1;
            this.f42a = str;
            this.f43b = i;
            this.c = i2;
        }

        @Override // a.a.a.a.n.e
        public boolean a(ArrayList<b> arrayList, ArrayList<Boolean> arrayList2) {
            return n.this.E0(arrayList, arrayList2, this.f42a, this.f43b, this.c);
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static class g implements h.e {

        /* renamed from: a */
        private final boolean f44a;

        /* renamed from: b */
        private final b f45b;
        private int c;

        g(b bVar, boolean z) {
            this.f44a = z;
            this.f45b = bVar;
        }

        @Override // a.a.a.a.h.e
        public void a() {
            int i = this.c - 1;
            this.c = i;
            if (i == 0) {
                this.f45b.f2a.P0();
            }
        }

        @Override // a.a.a.a.h.e
        public void b() {
            this.c++;
        }

        public void e() {
            b bVar = this.f45b;
            bVar.f2a.o(bVar, this.f44a, false, false);
        }

        public void f() {
            boolean z = this.c > 0;
            n nVar = this.f45b.f2a;
            int size = nVar.d.size();
            for (int i = 0; i < size; i++) {
                h hVar = nVar.d.get(i);
                hVar.O0(null);
                if (z && hVar.G()) {
                    hVar.Q0();
                }
            }
            b bVar = this.f45b;
            bVar.f2a.o(bVar, this.f44a, !z, true);
        }

        public boolean g() {
            return this.c == 0;
        }
    }

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    static {
        C = Build.VERSION.SDK_INT >= 11;
        D = null;
        E = new DecelerateInterpolator(2.5f);
        F = new DecelerateInterpolator(1.5f);
        new AccelerateInterpolator(2.5f);
        new AccelerateInterpolator(1.5f);
    }

    private void B0(ArrayList<b> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
                throw new IllegalStateException($(0, 42, 1389));
            }
            d0(arrayList, arrayList2);
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                if (!arrayList.get(i).s) {
                    if (i2 != i) {
                        c0(arrayList, arrayList2, i2, i);
                    }
                    i2 = i + 1;
                    if (arrayList2.get(i).booleanValue()) {
                        while (i2 < size && arrayList2.get(i2).booleanValue() && !arrayList.get(i2).s) {
                            i2++;
                        }
                    }
                    c0(arrayList, arrayList2, i, i2);
                    i = i2 - 1;
                }
                i++;
            }
            if (i2 != size) {
                c0(arrayList, arrayList2, i2, size);
            }
        }
    }

    private boolean D0(String str, int i, int i2) {
        a0();
        Z(true);
        boolean E0 = E0(this.u, this.v, str, i, i2);
        if (E0) {
            this.f36b = true;
            try {
                B0(this.u, this.v);
            } finally {
                n();
            }
        }
        W();
        return E0;
    }

    private int F0(ArrayList<b> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, a.a.a.d.b<h> bVar) {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i; i4--) {
            b bVar2 = arrayList.get(i4);
            boolean booleanValue = arrayList2.get(i4).booleanValue();
            if (bVar2.s() && !bVar2.q(arrayList, i4 + 1, i2)) {
                if (this.z == null) {
                    this.z = new ArrayList<>();
                }
                g gVar = new g(bVar2, booleanValue);
                this.z.add(gVar);
                bVar2.t(gVar);
                if (booleanValue) {
                    bVar2.l();
                } else {
                    bVar2.m();
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, bVar2);
                }
                g(bVar);
            }
        }
        return i3;
    }

    public static int L0(int i) {
        if (i == 4097) {
            return 8194;
        }
        if (i != 4099) {
            return i != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    public void P0() {
        synchronized (this) {
            boolean z = false;
            boolean z2 = this.z != null && !this.z.isEmpty();
            if (this.f35a != null && this.f35a.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.m.j().removeCallbacks(this.A);
                this.m.j().post(this.A);
            }
        }
    }

    private void R0(View view, Animation animation) {
        Animation.AnimationListener animationListener;
        String str;
        Throwable e2;
        String $2 = $(42, 57, 5120);
        if (view != null && animation != null && S0(view, animation)) {
            try {
                if (D == null) {
                    Field declaredField = Animation.class.getDeclaredField($(57, 66, 1389));
                    D = declaredField;
                    declaredField.setAccessible(true);
                }
                animationListener = (Animation.AnimationListener) D.get(animation);
            } catch (IllegalAccessException e3) {
                e2 = e3;
                str = $(66, 107, 6158);
                Log.e($2, str, e2);
                animationListener = null;
                a.a.a.e.f.e(view, 2, null);
                animation.setAnimationListener(new c(view, animation, animationListener));
            } catch (NoSuchFieldException e4) {
                e2 = e4;
                str = $(107, 167, 8005);
                Log.e($2, str, e2);
                animationListener = null;
                a.a.a.e.f.e(view, 2, null);
                animation.setAnimationListener(new c(view, animation, animationListener));
            }
            a.a.a.e.f.e(view, 2, null);
            animation.setAnimationListener(new c(view, animation, animationListener));
        }
    }

    static boolean S0(View view, Animation animation) {
        return Build.VERSION.SDK_INT >= 19 && a.a.a.e.f.a(view) == 0 && a.a.a.e.f.c(view) && v0(animation);
    }

    private void V0(RuntimeException runtimeException) {
        String message = runtimeException.getMessage();
        String $2 = $(167, 182, 7460);
        Log.e($2, message);
        Log.e($2, $(182, 197, 77));
        PrintWriter printWriter = new PrintWriter(new a.a.a.d.e($2));
        l lVar = this.m;
        String $3 = $(197, 217, 7881);
        String $4 = $(217, 219, 10601);
        try {
            if (lVar != null) {
                lVar.o($4, null, printWriter, new String[0]);
            } else {
                b($4, null, printWriter, new String[0]);
            }
        } catch (Exception e2) {
            Log.e($2, $3, e2);
        }
        throw runtimeException;
    }

    public static int W0(int i, boolean z) {
        if (i == 4097) {
            return z ? 1 : 2;
        }
        if (i == 4099) {
            return z ? 5 : 6;
        }
        if (i != 8194) {
            return -1;
        }
        return z ? 3 : 4;
    }

    private void X() {
        ArrayList<h> arrayList = this.c;
        int size = arrayList == null ? 0 : arrayList.size();
        for (int i = 0; i < size; i++) {
            h hVar = this.c.get(i);
            if (!(hVar == null || hVar.i() == null)) {
                int y = hVar.y();
                View i2 = hVar.i();
                hVar.J0(null);
                Animation animation = i2.getAnimation();
                if (animation != null) {
                    animation.cancel();
                }
                z0(hVar, y, 0, 0, false);
            }
        }
    }

    private void Z(boolean z) {
        if (this.f36b) {
            throw new IllegalStateException($(267, 316, 922));
        } else if (Looper.myLooper() == this.m.j().getLooper()) {
            if (!z) {
                m();
            }
            if (this.u == null) {
                this.u = new ArrayList<>();
                this.v = new ArrayList<>();
            }
            d0(null, null);
        } else {
            throw new IllegalStateException($(219, 267, 6722));
        }
    }

    private static void b0(ArrayList<b> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        for (int i3 = i; i3 < i2; i3++) {
            b bVar = arrayList.get(i3);
            if (arrayList2.get(i3).booleanValue()) {
                bVar.m();
            } else {
                bVar.l();
            }
        }
    }

    private void c0(ArrayList<b> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int i3;
        int i4;
        int i5 = i;
        boolean z = arrayList.get(i5).s;
        ArrayList<h> arrayList3 = this.w;
        if (arrayList3 == null) {
            this.w = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        ArrayList<h> arrayList4 = this.d;
        if (arrayList4 != null) {
            this.w.addAll(arrayList4);
        }
        boolean z2 = false;
        int i6 = i5;
        while (true) {
            int i7 = -1;
            if (i6 >= i2) {
                break;
            }
            b bVar = arrayList.get(i6);
            boolean booleanValue = arrayList2.get(i6).booleanValue();
            ArrayList<h> arrayList5 = this.w;
            if (!booleanValue) {
                bVar.n(arrayList5);
            } else {
                bVar.u(arrayList5);
            }
            if (!booleanValue) {
                i7 = 1;
            }
            bVar.g(i7);
            z2 = z2 || bVar.i;
            i6++;
        }
        this.w.clear();
        if (!z) {
            s.E(this, arrayList, arrayList2, i, i2, false);
        }
        b0(arrayList, arrayList2, i, i2);
        if (z) {
            a.a.a.d.b<h> bVar2 = new a.a.a.d.b<>();
            g(bVar2);
            i3 = F0(arrayList, arrayList2, i, i2, bVar2);
            u0(bVar2);
        } else {
            i3 = i2;
        }
        if (i3 != i5 && z) {
            s.E(this, arrayList, arrayList2, i, i3, true);
            x0(this.l, true);
        }
        while (i5 < i2) {
            b bVar3 = arrayList.get(i5);
            if (arrayList2.get(i5).booleanValue() && (i4 = bVar3.l) >= 0) {
                j0(i4);
                bVar3.l = -1;
            }
            i5++;
        }
        if (z2) {
            I0();
        }
    }

    private void d0(ArrayList<b> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<g> arrayList3 = this.z;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i = 0;
        while (i < size) {
            g gVar = this.z.get(i);
            if (arrayList == null || gVar.f44a || (indexOf2 = arrayList.indexOf(gVar.f45b)) == -1 || !arrayList2.get(indexOf2).booleanValue()) {
                if (gVar.g() || (arrayList != null && gVar.f45b.q(arrayList, 0, arrayList.size()))) {
                    this.z.remove(i);
                    i--;
                    size--;
                    if (arrayList == null || gVar.f44a || (indexOf = arrayList.indexOf(gVar.f45b)) == -1 || !arrayList2.get(indexOf).booleanValue()) {
                        gVar.f();
                    }
                }
                i++;
            }
            gVar.e();
            i++;
        }
    }

    private void g(a.a.a.d.b<h> bVar) {
        int i = this.l;
        if (i >= 1) {
            int min = Math.min(i, 4);
            ArrayList<h> arrayList = this.d;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                h hVar = this.d.get(i2);
                if (hVar.f19a < min) {
                    z0(hVar, min, hVar.q(), hVar.r(), false);
                    if (hVar.F != null && !hVar.x && hVar.N) {
                        bVar.add(hVar);
                    }
                }
            }
        }
    }

    private h h0(h hVar) {
        ViewGroup viewGroup = hVar.E;
        View view = hVar.F;
        if (!(viewGroup == null || view == null)) {
            for (int indexOf = this.d.indexOf(hVar) - 1; indexOf >= 0; indexOf--) {
                h hVar2 = this.d.get(indexOf);
                if (hVar2.E == viewGroup && hVar2.F != null) {
                    return hVar2;
                }
            }
        }
        return null;
    }

    private void i0() {
        if (this.z != null) {
            while (!this.z.isEmpty()) {
                this.z.remove(0).f();
            }
        }
    }

    private boolean k0(ArrayList<b> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this) {
            if (!(this.f35a == null || this.f35a.size() == 0)) {
                int size = this.f35a.size();
                for (int i = 0; i < size; i++) {
                    this.f35a.get(i).a(arrayList, arrayList2);
                }
                this.f35a.clear();
                this.m.j().removeCallbacks(this.A);
                return size > 0;
            }
            return false;
        }
    }

    private void m() {
        if (this.q) {
            throw new IllegalStateException($(354, 407, 8331));
        } else if (this.s != null) {
            throw new IllegalStateException($(316, 354, 1549) + this.s);
        }
    }

    private void n() {
        this.f36b = false;
        this.v.clear();
        this.u.clear();
    }

    public void o(b bVar, boolean z, boolean z2, boolean z3) {
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(bVar);
        arrayList2.add(Boolean.valueOf(z));
        b0(arrayList, arrayList2, 0, 1);
        if (z2) {
            s.E(this, arrayList, arrayList2, 0, 1, true);
        }
        if (z3) {
            x0(this.l, true);
        }
        ArrayList<h> arrayList3 = this.c;
        if (arrayList3 != null) {
            int size = arrayList3.size();
            for (int i = 0; i < size; i++) {
                h hVar = this.c.get(i);
                if (hVar != null && hVar.F != null && hVar.N && bVar.p(hVar.v)) {
                    if (Build.VERSION.SDK_INT >= 11) {
                        float f2 = hVar.P;
                        if (f2 > 0.0f) {
                            hVar.F.setAlpha(f2);
                        }
                    }
                    if (z3) {
                        hVar.P = 0.0f;
                    } else {
                        hVar.P = -1.0f;
                        hVar.N = false;
                    }
                }
            }
        }
    }

    static Animation r0(Context context, float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setInterpolator(F);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    static Animation t0(Context context, float f2, float f3, float f4, float f5) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(E);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(F);
        alphaAnimation.setDuration(220);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }

    private void u0(a.a.a.d.b<h> bVar) {
        int size = bVar.size();
        for (int i = 0; i < size; i++) {
            h i2 = bVar.i(i);
            if (!i2.j) {
                View z = i2.z();
                if (Build.VERSION.SDK_INT < 11) {
                    i2.z().setVisibility(4);
                } else {
                    i2.P = z.getAlpha();
                    z.setAlpha(0.0f);
                }
            }
        }
    }

    static boolean v0(Animation animation) {
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (animation instanceof AnimationSet) {
            List<Animation> animations = ((AnimationSet) animation).getAnimations();
            for (int i = 0; i < animations.size(); i++) {
                if (animations.get(i) instanceof AlphaAnimation) {
                    return true;
                }
            }
        }
        return false;
    }

    void A(h hVar, Bundle bundle, boolean z) {
        h hVar2 = this.o;
        if (hVar2 != null) {
            m o = hVar2.o();
            if (o instanceof n) {
                ((n) o).A(hVar, bundle, true);
            }
        }
        CopyOnWriteArrayList<a.a.a.d.g<m.a, Boolean>> copyOnWriteArrayList = this.k;
        if (copyOnWriteArrayList != null) {
            Iterator<a.a.a.d.g<m.a, Boolean>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                a.a.a.d.g<m.a, Boolean> next = it.next();
                if (!z || next.f103b.booleanValue()) {
                    next.f102a.a(this, hVar, bundle);
                }
            }
        }
    }

    public void A0() {
        this.q = false;
    }

    void B(h hVar, Context context, boolean z) {
        h hVar2 = this.o;
        if (hVar2 != null) {
            m o = hVar2.o();
            if (o instanceof n) {
                ((n) o).B(hVar, context, true);
            }
        }
        CopyOnWriteArrayList<a.a.a.d.g<m.a, Boolean>> copyOnWriteArrayList = this.k;
        if (copyOnWriteArrayList != null) {
            Iterator<a.a.a.d.g<m.a, Boolean>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                a.a.a.d.g<m.a, Boolean> next = it.next();
                if (!z || next.f103b.booleanValue()) {
                    next.f102a.b(this, hVar, context);
                }
            }
        }
    }

    void C(h hVar, Bundle bundle, boolean z) {
        h hVar2 = this.o;
        if (hVar2 != null) {
            m o = hVar2.o();
            if (o instanceof n) {
                ((n) o).C(hVar, bundle, true);
            }
        }
        CopyOnWriteArrayList<a.a.a.d.g<m.a, Boolean>> copyOnWriteArrayList = this.k;
        if (copyOnWriteArrayList != null) {
            Iterator<a.a.a.d.g<m.a, Boolean>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                a.a.a.d.g<m.a, Boolean> next = it.next();
                if (!z || next.f103b.booleanValue()) {
                    next.f102a.c(this, hVar, bundle);
                }
            }
        }
    }

    public void C0(h hVar) {
        if (!hVar.H) {
            return;
        }
        if (this.f36b) {
            this.t = true;
            return;
        }
        hVar.H = false;
        z0(hVar, this.l, 0, 0, false);
    }

    void D(h hVar, boolean z) {
        h hVar2 = this.o;
        if (hVar2 != null) {
            m o = hVar2.o();
            if (o instanceof n) {
                ((n) o).D(hVar, true);
            }
        }
        CopyOnWriteArrayList<a.a.a.d.g<m.a, Boolean>> copyOnWriteArrayList = this.k;
        if (copyOnWriteArrayList != null) {
            Iterator<a.a.a.d.g<m.a, Boolean>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                a.a.a.d.g<m.a, Boolean> next = it.next();
                if (!z || next.f103b.booleanValue()) {
                    next.f102a.d(this, hVar);
                }
            }
        }
    }

    void E(h hVar, boolean z) {
        h hVar2 = this.o;
        if (hVar2 != null) {
            m o = hVar2.o();
            if (o instanceof n) {
                ((n) o).E(hVar, true);
            }
        }
        CopyOnWriteArrayList<a.a.a.d.g<m.a, Boolean>> copyOnWriteArrayList = this.k;
        if (copyOnWriteArrayList != null) {
            Iterator<a.a.a.d.g<m.a, Boolean>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                a.a.a.d.g<m.a, Boolean> next = it.next();
                if (!z || next.f103b.booleanValue()) {
                    next.f102a.e(this, hVar);
                }
            }
        }
    }

    boolean E0(ArrayList<b> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        int i3;
        ArrayList<b> arrayList3 = this.f;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i >= 0) {
                i3 = this.f.size() - 1;
                while (i3 >= 0) {
                    b bVar = this.f.get(i3);
                    if ((str != null && str.equals(bVar.o())) || (i >= 0 && i == bVar.l)) {
                        break;
                    }
                    i3--;
                }
                if (i3 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    while (true) {
                        i3--;
                        if (i3 < 0) {
                            break;
                        }
                        b bVar2 = this.f.get(i3);
                        if (str == null || !str.equals(bVar2.o())) {
                            if (i < 0 || i != bVar2.l) {
                                break;
                            }
                        }
                    }
                }
            } else {
                i3 = -1;
            }
            if (i3 == this.f.size() - 1) {
                return false;
            }
            for (int size2 = this.f.size() - 1; size2 > i3; size2--) {
                arrayList.add(this.f.remove(size2));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    void F(h hVar, boolean z) {
        h hVar2 = this.o;
        if (hVar2 != null) {
            m o = hVar2.o();
            if (o instanceof n) {
                ((n) o).F(hVar, true);
            }
        }
        CopyOnWriteArrayList<a.a.a.d.g<m.a, Boolean>> copyOnWriteArrayList = this.k;
        if (copyOnWriteArrayList != null) {
            Iterator<a.a.a.d.g<m.a, Boolean>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                a.a.a.d.g<m.a, Boolean> next = it.next();
                if (!z || next.f103b.booleanValue()) {
                    next.f102a.f(this, hVar);
                }
            }
        }
    }

    void G(h hVar, Context context, boolean z) {
        h hVar2 = this.o;
        if (hVar2 != null) {
            m o = hVar2.o();
            if (o instanceof n) {
                ((n) o).G(hVar, context, true);
            }
        }
        CopyOnWriteArrayList<a.a.a.d.g<m.a, Boolean>> copyOnWriteArrayList = this.k;
        if (copyOnWriteArrayList != null) {
            Iterator<a.a.a.d.g<m.a, Boolean>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                a.a.a.d.g<m.a, Boolean> next = it.next();
                if (!z || next.f103b.booleanValue()) {
                    next.f102a.g(this, hVar, context);
                }
            }
        }
    }

    public void G0(Bundle bundle, String str, h hVar) {
        int i = hVar.d;
        if (i >= 0) {
            bundle.putInt(str, i);
            return;
        }
        V0(new IllegalStateException($(407, 416, 8103) + hVar + $(416, 456, 2467)));
        throw null;
    }

    void H(h hVar, boolean z) {
        h hVar2 = this.o;
        if (hVar2 != null) {
            m o = hVar2.o();
            if (o instanceof n) {
                ((n) o).H(hVar, true);
            }
        }
        CopyOnWriteArrayList<a.a.a.d.g<m.a, Boolean>> copyOnWriteArrayList = this.k;
        if (copyOnWriteArrayList != null) {
            Iterator<a.a.a.d.g<m.a, Boolean>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                a.a.a.d.g<m.a, Boolean> next = it.next();
                if (!z || next.f103b.booleanValue()) {
                    next.f102a.h(this, hVar);
                }
            }
        }
    }

    public void H0(h hVar) {
        if (B) {
            Log.v($(473, 488, 11446), $(456, 464, 3181) + hVar + $(464, 473, 11379) + hVar.o);
        }
        boolean z = !hVar.F();
        if (!hVar.y || z) {
            ArrayList<h> arrayList = this.d;
            if (arrayList != null) {
                arrayList.remove(hVar);
            }
            if (hVar.B && hVar.C) {
                this.p = true;
            }
            hVar.j = false;
            hVar.k = true;
        }
    }

    void I(h hVar, Bundle bundle, boolean z) {
        h hVar2 = this.o;
        if (hVar2 != null) {
            m o = hVar2.o();
            if (o instanceof n) {
                ((n) o).I(hVar, bundle, true);
            }
        }
        CopyOnWriteArrayList<a.a.a.d.g<m.a, Boolean>> copyOnWriteArrayList = this.k;
        if (copyOnWriteArrayList != null) {
            Iterator<a.a.a.d.g<m.a, Boolean>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                a.a.a.d.g<m.a, Boolean> next = it.next();
                if (!z || next.f103b.booleanValue()) {
                    next.f102a.i(this, hVar, bundle);
                }
            }
        }
    }

    void I0() {
        if (this.j != null) {
            for (int i = 0; i < this.j.size(); i++) {
                this.j.get(i).a();
            }
        }
    }

    void J(h hVar, boolean z) {
        h hVar2 = this.o;
        if (hVar2 != null) {
            m o = hVar2.o();
            if (o instanceof n) {
                ((n) o).J(hVar, true);
            }
        }
        CopyOnWriteArrayList<a.a.a.d.g<m.a, Boolean>> copyOnWriteArrayList = this.k;
        if (copyOnWriteArrayList != null) {
            Iterator<a.a.a.d.g<m.a, Boolean>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                a.a.a.d.g<m.a, Boolean> next = it.next();
                if (!z || next.f103b.booleanValue()) {
                    next.f102a.j(this, hVar);
                }
            }
        }
    }

    public void J0(Parcelable parcelable, o oVar) {
        List<o> list;
        String $2;
        if (parcelable != null) {
            p pVar = (p) parcelable;
            if (pVar.f48a != null) {
                String $3 = $(488, 503, 4933);
                if (oVar != null) {
                    List<h> b2 = oVar.b();
                    list = oVar.a();
                    int size = b2 != null ? b2.size() : 0;
                    for (int i = 0; i < size; i++) {
                        h hVar = b2.get(i);
                        if (B) {
                            Log.v($3, $(503, 542, 10510) + hVar);
                        }
                        q qVar = pVar.f48a[hVar.d];
                        qVar.l = hVar;
                        hVar.c = null;
                        hVar.o = 0;
                        hVar.m = false;
                        hVar.j = false;
                        hVar.g = null;
                        Bundle bundle = qVar.k;
                        if (bundle != null) {
                            bundle.setClassLoader(this.m.h().getClassLoader());
                            hVar.c = qVar.k.getSparseParcelableArray($(542, 560, 7776));
                            hVar.f20b = qVar.k;
                        }
                    }
                } else {
                    list = null;
                }
                this.c = new ArrayList<>(pVar.f48a.length);
                ArrayList<Integer> arrayList = this.e;
                if (arrayList != null) {
                    arrayList.clear();
                }
                int i2 = 0;
                while (true) {
                    q[] qVarArr = pVar.f48a;
                    int length = qVarArr.length;
                    $2 = $(560, 562, 4910);
                    if (i2 >= length) {
                        break;
                    }
                    q qVar2 = qVarArr[i2];
                    if (qVar2 != null) {
                        h a2 = qVar2.a(this.m, this.o, (list == null || i2 >= list.size()) ? null : list.get(i2));
                        if (B) {
                            Log.v($3, $(562, 587, 7319) + i2 + $2 + a2);
                        }
                        this.c.add(a2);
                        qVar2.l = null;
                    } else {
                        this.c.add(null);
                        if (this.e == null) {
                            this.e = new ArrayList<>();
                        }
                        if (B) {
                            Log.v($3, $(587, 611, 7305) + i2);
                        }
                        this.e.add(Integer.valueOf(i2));
                    }
                    i2++;
                }
                if (oVar != null) {
                    List<h> b3 = oVar.b();
                    int size2 = b3 != null ? b3.size() : 0;
                    for (int i3 = 0; i3 < size2; i3++) {
                        h hVar2 = b3.get(i3);
                        int i4 = hVar2.h;
                        if (i4 >= 0) {
                            if (i4 < this.c.size()) {
                                hVar2.g = this.c.get(hVar2.h);
                            } else {
                                Log.w($3, $(611, 642, 4940) + hVar2 + $(642, 668, 7082) + hVar2.h);
                                hVar2.g = null;
                            }
                        }
                    }
                }
                if (pVar.f49b != null) {
                    this.d = new ArrayList<>(pVar.f49b.length);
                    int i5 = 0;
                    while (true) {
                        int[] iArr = pVar.f49b;
                        if (i5 >= iArr.length) {
                            break;
                        }
                        h hVar3 = this.c.get(iArr[i5]);
                        if (hVar3 != null) {
                            hVar3.j = true;
                            if (B) {
                                Log.v($3, $(668, 692, 2010) + i5 + $2 + hVar3);
                            }
                            if (!this.d.contains(hVar3)) {
                                this.d.add(hVar3);
                                i5++;
                            } else {
                                throw new IllegalStateException($(692, 706, 2023));
                            }
                        } else {
                            V0(new IllegalStateException($(706, 742, 11308) + pVar.f49b[i5]));
                            throw null;
                        }
                    }
                } else {
                    this.d = null;
                }
                if (pVar.c != null) {
                    this.f = new ArrayList<>(pVar.c.length);
                    int i6 = 0;
                    while (true) {
                        c[] cVarArr = pVar.c;
                        if (i6 < cVarArr.length) {
                            b a3 = cVarArr[i6].a(this);
                            if (B) {
                                Log.v($3, $(742, 771, 12150) + i6 + $(771, 779, 4961) + a3.l + $(779, 782, 1303) + a3);
                                a3.k($(782, 784, 2491), new PrintWriter(new a.a.a.d.e($3)), false);
                            }
                            this.f.add(a3);
                            int i7 = a3.l;
                            if (i7 >= 0) {
                                Q0(i7, a3);
                            }
                            i6++;
                        } else {
                            return;
                        }
                    }
                } else {
                    this.f = null;
                }
            }
        }
    }

    void K(h hVar, boolean z) {
        h hVar2 = this.o;
        if (hVar2 != null) {
            m o = hVar2.o();
            if (o instanceof n) {
                ((n) o).K(hVar, true);
            }
        }
        CopyOnWriteArrayList<a.a.a.d.g<m.a, Boolean>> copyOnWriteArrayList = this.k;
        if (copyOnWriteArrayList != null) {
            Iterator<a.a.a.d.g<m.a, Boolean>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                a.a.a.d.g<m.a, Boolean> next = it.next();
                if (!z || next.f103b.booleanValue()) {
                    next.f102a.k(this, hVar);
                }
            }
        }
    }

    public o K0() {
        ArrayList arrayList;
        ArrayList arrayList2;
        o K0;
        if (this.c != null) {
            arrayList2 = null;
            arrayList = null;
            for (int i = 0; i < this.c.size(); i++) {
                h hVar = this.c.get(i);
                if (hVar != null) {
                    boolean z = true;
                    if (hVar.z) {
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(hVar);
                        hVar.A = true;
                        h hVar2 = hVar.g;
                        hVar.h = hVar2 != null ? hVar2.d : -1;
                        if (B) {
                            Log.v($(818, 833, 3187), $(784, 818, 11279) + hVar);
                        }
                    }
                    n nVar = hVar.r;
                    if (nVar == null || (K0 = nVar.K0()) == null) {
                        z = false;
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            for (int i2 = 0; i2 < i; i2++) {
                                arrayList.add(null);
                            }
                        }
                        arrayList.add(K0);
                    }
                    if (arrayList != null && !z) {
                        arrayList.add(null);
                    }
                }
            }
        } else {
            arrayList2 = null;
            arrayList = null;
        }
        if (arrayList2 == null && arrayList == null) {
            return null;
        }
        return new o(arrayList2, arrayList);
    }

    void L(h hVar, View view, Bundle bundle, boolean z) {
        h hVar2 = this.o;
        if (hVar2 != null) {
            m o = hVar2.o();
            if (o instanceof n) {
                ((n) o).L(hVar, view, bundle, true);
            }
        }
        CopyOnWriteArrayList<a.a.a.d.g<m.a, Boolean>> copyOnWriteArrayList = this.k;
        if (copyOnWriteArrayList != null) {
            Iterator<a.a.a.d.g<m.a, Boolean>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                a.a.a.d.g<m.a, Boolean> next = it.next();
                if (!z || next.f103b.booleanValue()) {
                    next.f102a.l(this, hVar, view, bundle);
                }
            }
        }
    }

    void M(h hVar, boolean z) {
        h hVar2 = this.o;
        if (hVar2 != null) {
            m o = hVar2.o();
            if (o instanceof n) {
                ((n) o).M(hVar, true);
            }
        }
        CopyOnWriteArrayList<a.a.a.d.g<m.a, Boolean>> copyOnWriteArrayList = this.k;
        if (copyOnWriteArrayList != null) {
            Iterator<a.a.a.d.g<m.a, Boolean>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                a.a.a.d.g<m.a, Boolean> next = it.next();
                if (!z || next.f103b.booleanValue()) {
                    next.f102a.m(this, hVar);
                }
            }
        }
    }

    public Parcelable M0() {
        int[] iArr;
        int size;
        int size2;
        i0();
        X();
        a0();
        if (C) {
            this.q = true;
        }
        ArrayList<h> arrayList = this.c;
        c[] cVarArr = null;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        int size3 = this.c.size();
        q[] qVarArr = new q[size3];
        int i = 0;
        boolean z = false;
        while (true) {
            String $2 = $(833, 853, 3104);
            String $3 = $(853, 882, 4900);
            String $4 = $(882, 884, 40);
            String $5 = $(884, 899, 7267);
            if (i < size3) {
                h hVar = this.c.get(i);
                if (hVar != null) {
                    if (hVar.d >= 0) {
                        q qVar = new q(hVar);
                        qVarArr[i] = qVar;
                        if (hVar.f19a <= 0 || qVar.k != null) {
                            qVar.k = hVar.f20b;
                        } else {
                            Bundle N0 = N0(hVar);
                            qVar.k = N0;
                            h hVar2 = hVar.g;
                            if (hVar2 != null) {
                                if (hVar2.d >= 0) {
                                    if (N0 == null) {
                                        qVar.k = new Bundle();
                                    }
                                    G0(qVar.k, $(899, 919, 3355), hVar.g);
                                    int i2 = hVar.i;
                                    if (i2 != 0) {
                                        qVar.k.putInt($(919, 943, 5952), i2);
                                    }
                                } else {
                                    V0(new IllegalStateException($(943, 965, 5678) + hVar + $(965, 1002, 11134) + hVar.g));
                                    throw null;
                                }
                            }
                        }
                        if (B) {
                            Log.v($5, $(1002, 1017, 4738) + hVar + $4 + qVar.k);
                        }
                        z = true;
                    } else {
                        V0(new IllegalStateException($3 + hVar + $2 + hVar.d));
                        throw null;
                    }
                }
                i++;
            } else if (!z) {
                if (B) {
                    Log.v($5, $(1017, 1044, 1503));
                }
                return null;
            } else {
                ArrayList<h> arrayList2 = this.d;
                if (arrayList2 == null || (size2 = arrayList2.size()) <= 0) {
                    iArr = null;
                } else {
                    iArr = new int[size2];
                    for (int i3 = 0; i3 < size2; i3++) {
                        iArr[i3] = this.d.get(i3).d;
                        if (iArr[i3] >= 0) {
                            if (B) {
                                Log.v($5, $(1044, 1075, 5898) + i3 + $4 + this.d.get(i3));
                            }
                        } else {
                            V0(new IllegalStateException($3 + this.d.get(i3) + $2 + iArr[i3]));
                            throw null;
                        }
                    }
                }
                ArrayList<b> arrayList3 = this.f;
                if (arrayList3 != null && (size = arrayList3.size()) > 0) {
                    cVarArr = new c[size];
                    for (int i4 = 0; i4 < size; i4++) {
                        cVarArr[i4] = new c(this.f.get(i4));
                        if (B) {
                            Log.v($5, $(1075, 1108, 6155) + i4 + $4 + this.f.get(i4));
                        }
                    }
                }
                p pVar = new p();
                pVar.f48a = qVarArr;
                pVar.f49b = iArr;
                pVar.c = cVarArr;
                return pVar;
            }
        }
    }

    public boolean N(MenuItem menuItem) {
        if (this.d != null) {
            for (int i = 0; i < this.d.size(); i++) {
                h hVar = this.d.get(i);
                if (hVar != null && hVar.x0(menuItem)) {
                    return true;
                }
            }
        }
        return false;
    }

    Bundle N0(h hVar) {
        if (this.x == null) {
            this.x = new Bundle();
        }
        hVar.E0(this.x);
        I(hVar, this.x, false);
        Bundle bundle = null;
        if (!this.x.isEmpty()) {
            bundle = this.x;
            this.x = null;
        }
        if (hVar.F != null) {
            O0(hVar);
        }
        if (hVar.c != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray($(1108, 1126, 133), hVar.c);
        }
        if (!hVar.I) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean($(1126, 1151, 4050), hVar.I);
        }
        return bundle;
    }

    public void O(Menu menu) {
        if (this.d != null) {
            for (int i = 0; i < this.d.size(); i++) {
                h hVar = this.d.get(i);
                if (hVar != null) {
                    hVar.y0(menu);
                }
            }
        }
    }

    void O0(h hVar) {
        if (hVar.G != null) {
            SparseArray<Parcelable> sparseArray = this.y;
            if (sparseArray == null) {
                this.y = new SparseArray<>();
            } else {
                sparseArray.clear();
            }
            hVar.G.saveHierarchyState(this.y);
            if (this.y.size() > 0) {
                hVar.c = this.y;
                this.y = null;
            }
        }
    }

    public void P() {
        x0(4, false);
    }

    public void Q(boolean z) {
        ArrayList<h> arrayList = this.d;
        if (arrayList != null) {
            int size = arrayList.size();
            while (true) {
                size--;
                if (size >= 0) {
                    h hVar = this.d.get(size);
                    if (hVar != null) {
                        hVar.A0(z);
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void Q0(int i, b bVar) {
        synchronized (this) {
            if (this.h == null) {
                this.h = new ArrayList<>();
            }
            int size = this.h.size();
            if (i < size) {
                if (B) {
                    String $2 = $(1151, 1166, 4736);
                    Log.v($2, $(1166, 1191, 5916) + i + $(1191, 1195, 7368) + bVar);
                }
                this.h.set(i, bVar);
            } else {
                while (size < i) {
                    this.h.add(null);
                    if (this.i == null) {
                        this.i = new ArrayList<>();
                    }
                    if (B) {
                        String $3 = $(1195, 1210, 6805);
                        Log.v($3, $(1210, 1244, 851) + size);
                    }
                    this.i.add(Integer.valueOf(size));
                    size++;
                }
                if (B) {
                    String $4 = $(1244, 1259, 6614);
                    Log.v($4, $(1259, 1283, 6232) + i + $(1283, 1289, 7056) + bVar);
                }
                this.h.add(bVar);
            }
        }
    }

    public boolean R(Menu menu) {
        if (this.d == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.d.size(); i++) {
            h hVar = this.d.get(i);
            if (hVar != null && hVar.B0(menu)) {
                z = true;
            }
        }
        return z;
    }

    public void S() {
        x0(2, false);
    }

    public void T() {
        this.q = false;
        x0(5, false);
    }

    public void T0(h hVar) {
        if (B) {
            Log.v($(1295, 1310, 4762), $(1289, 1295, 5399) + hVar);
        }
        if (hVar.x) {
            hVar.x = false;
            hVar.O = !hVar.O;
        }
    }

    public void U() {
        this.q = false;
        x0(4, false);
    }

    void U0() {
        if (this.c != null) {
            for (int i = 0; i < this.c.size(); i++) {
                h hVar = this.c.get(i);
                if (hVar != null) {
                    C0(hVar);
                }
            }
        }
    }

    public void V() {
        this.q = true;
        x0(3, false);
    }

    void W() {
        v vVar;
        if (this.t) {
            boolean z = false;
            for (int i = 0; i < this.c.size(); i++) {
                h hVar = this.c.get(i);
                if (!(hVar == null || (vVar = hVar.J) == null)) {
                    z |= vVar.i();
                }
            }
            if (!z) {
                this.t = false;
                U0();
            }
        }
    }

    public void Y(e eVar, boolean z) {
        if (!z) {
            m();
        }
        synchronized (this) {
            if (this.r || this.m == null) {
                throw new IllegalStateException($(1310, 1337, 2539));
            }
            if (this.f35a == null) {
                this.f35a = new ArrayList<>();
            }
            this.f35a.add(eVar);
            P0();
        }
    }

    @Override // a.a.a.a.m
    public r a() {
        return new b(this);
    }

    /* JADX WARN: Finally extract failed */
    public boolean a0() {
        Z(true);
        boolean z = false;
        while (k0(this.u, this.v)) {
            this.f36b = true;
            try {
                B0(this.u, this.v);
                n();
                z = true;
            } catch (Throwable th) {
                n();
                throw th;
            }
        }
        W();
        return z;
    }

    @Override // a.a.a.a.m
    public void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        int size6;
        String str2 = str + $(1337, 1341, 7123);
        ArrayList<h> arrayList = this.c;
        if (arrayList != null && (size6 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.print($(1341, 1361, 853));
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println($(1361, 1362, 1424));
            for (int i = 0; i < size6; i++) {
                h hVar = this.c.get(i);
                printWriter.print(str);
                printWriter.print($(1362, 1365, 1812));
                printWriter.print(i);
                printWriter.print($(1365, 1367, 1583));
                printWriter.println(hVar);
                if (hVar != null) {
                    hVar.c(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        ArrayList<h> arrayList2 = this.d;
        if (arrayList2 != null && (size5 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println($(1367, 1383, 5301));
            for (int i2 = 0; i2 < size5; i2++) {
                printWriter.print(str);
                printWriter.print($(1383, 1386, 3909));
                printWriter.print(i2);
                printWriter.print($(1386, 1388, 6462));
                printWriter.println(this.d.get(i2).toString());
            }
        }
        ArrayList<h> arrayList3 = this.g;
        if (arrayList3 != null && (size4 = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println($(1388, 1412, 9335));
            for (int i3 = 0; i3 < size4; i3++) {
                printWriter.print(str);
                printWriter.print($(1412, 1415, 926));
                printWriter.print(i3);
                printWriter.print($(1415, 1417, 2019));
                printWriter.println(this.g.get(i3).toString());
            }
        }
        ArrayList<b> arrayList4 = this.f;
        if (arrayList4 != null && (size3 = arrayList4.size()) > 0) {
            printWriter.print(str);
            printWriter.println($(1417, 1428, 8490));
            for (int i4 = 0; i4 < size3; i4++) {
                b bVar = this.f.get(i4);
                printWriter.print(str);
                printWriter.print($(1428, 1431, 1080));
                printWriter.print(i4);
                printWriter.print($(1431, 1433, 7499));
                printWriter.println(bVar.toString());
                bVar.j(str2, fileDescriptor, printWriter, strArr);
            }
        }
        synchronized (this) {
            if (this.h != null && (size2 = this.h.size()) > 0) {
                printWriter.print(str);
                printWriter.println($(1433, 1452, 7271));
                for (int i5 = 0; i5 < size2; i5++) {
                    printWriter.print(str);
                    printWriter.print($(1452, 1455, 6380));
                    printWriter.print(i5);
                    printWriter.print($(1455, 1457, 6336));
                    printWriter.println((b) this.h.get(i5));
                }
            }
            if (this.i != null && this.i.size() > 0) {
                printWriter.print(str);
                printWriter.print($(1457, 1481, 4614));
                printWriter.println(Arrays.toString(this.i.toArray()));
            }
        }
        ArrayList<e> arrayList5 = this.f35a;
        if (arrayList5 != null && (size = arrayList5.size()) > 0) {
            printWriter.print(str);
            printWriter.println($(1481, 1497, 9404));
            for (int i6 = 0; i6 < size; i6++) {
                printWriter.print(str);
                printWriter.print($(1497, 1500, 8119));
                printWriter.print(i6);
                printWriter.print($(1500, 1502, 5991));
                printWriter.println((e) this.f35a.get(i6));
            }
        }
        printWriter.print(str);
        printWriter.println($(1502, 1529, 134));
        printWriter.print(str);
        printWriter.print($(1529, 1537, 73));
        printWriter.println(this.m);
        printWriter.print(str);
        printWriter.print($(1537, 1550, 615));
        printWriter.println(this.n);
        if (this.o != null) {
            printWriter.print(str);
            printWriter.print($(1550, 1560, 6495));
            printWriter.println(this.o);
        }
        printWriter.print(str);
        printWriter.print($(1560, 1572, 537));
        printWriter.print(this.l);
        printWriter.print($(1572, 1585, 7119));
        printWriter.print(this.q);
        printWriter.print($(1585, 1597, 9740));
        printWriter.println(this.r);
        if (this.p) {
            printWriter.print(str);
            printWriter.print($(1597, 1619, 6307));
            printWriter.println(this.p);
        }
        if (this.s != null) {
            printWriter.print(str);
            printWriter.print($(1619, 1644, 2048));
            printWriter.println(this.s);
        }
        ArrayList<Integer> arrayList6 = this.e;
        if (arrayList6 != null && arrayList6.size() > 0) {
            printWriter.print(str);
            printWriter.print($(1644, 1661, 5873));
            printWriter.println(Arrays.toString(this.e.toArray()));
        }
    }

    @Override // a.a.a.a.m
    public void c(int i, int i2) {
        if (i >= 0) {
            Y(new f(null, i, i2), false);
            return;
        }
        throw new IllegalArgumentException($(1661, 1669, 3127) + i);
    }

    @Override // a.a.a.a.m
    public boolean d() {
        m();
        return D0(null, -1, 0);
    }

    public h e0(int i) {
        ArrayList<h> arrayList = this.d;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                h hVar = this.d.get(size);
                if (hVar != null && hVar.u == i) {
                    return hVar;
                }
            }
        }
        ArrayList<h> arrayList2 = this.c;
        if (arrayList2 == null) {
            return null;
        }
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            h hVar2 = this.c.get(size2);
            if (hVar2 != null && hVar2.u == i) {
                return hVar2;
            }
        }
        return null;
    }

    public h f0(String str) {
        ArrayList<h> arrayList = this.d;
        if (!(arrayList == null || str == null)) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                h hVar = this.d.get(size);
                if (hVar != null && str.equals(hVar.w)) {
                    return hVar;
                }
            }
        }
        ArrayList<h> arrayList2 = this.c;
        if (arrayList2 == null || str == null) {
            return null;
        }
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            h hVar2 = this.c.get(size2);
            if (hVar2 != null && str.equals(hVar2.w)) {
                return hVar2;
            }
        }
        return null;
    }

    public h g0(String str) {
        h e2;
        ArrayList<h> arrayList = this.c;
        if (arrayList == null || str == null) {
            return null;
        }
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                return null;
            }
            h hVar = this.c.get(size);
            if (hVar != null && (e2 = hVar.e(str)) != null) {
                return e2;
            }
        }
    }

    public void h(b bVar) {
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        this.f.add(bVar);
        I0();
    }

    public void i(h hVar, boolean z) {
        if (this.d == null) {
            this.d = new ArrayList<>();
        }
        if (B) {
            Log.v($(1674, 1689, 6172), $(1669, 1674, 8599) + hVar);
        }
        q0(hVar);
        if (hVar.y) {
            return;
        }
        if (!this.d.contains(hVar)) {
            this.d.add(hVar);
            hVar.j = true;
            hVar.k = false;
            if (hVar.F == null) {
                hVar.O = false;
            }
            if (hVar.B && hVar.C) {
                this.p = true;
            }
            if (z) {
                y0(hVar);
                return;
            }
            return;
        }
        throw new IllegalStateException($(1689, 1713, 398) + hVar);
    }

    public int j(b bVar) {
        synchronized (this) {
            if (this.i != null && this.i.size() > 0) {
                int intValue = this.i.remove(this.i.size() - 1).intValue();
                if (B) {
                    String $2 = $(1713, 1728, 184);
                    Log.v($2, $(1728, 1752, 9024) + intValue + $(1752, 1758, 9889) + bVar);
                }
                this.h.set(intValue, bVar);
                return intValue;
            }
            if (this.h == null) {
                this.h = new ArrayList<>();
            }
            int size = this.h.size();
            if (B) {
                String $3 = $(1758, 1773, 5310);
                Log.v($3, $(1773, 1798, 426) + size + $(1798, 1802, 8657) + bVar);
            }
            this.h.add(bVar);
            return size;
        }
    }

    public void j0(int i) {
        synchronized (this) {
            this.h.set(i, null);
            if (this.i == null) {
                this.i = new ArrayList<>();
            }
            if (B) {
                String $2 = $(1802, 1817, 5386);
                Log.v($2, $(1817, 1842, 12186) + i);
            }
            this.i.add(Integer.valueOf(i));
        }
    }

    public void k(l lVar, j jVar, h hVar) {
        if (this.m == null) {
            this.m = lVar;
            this.n = jVar;
            this.o = hVar;
            return;
        }
        throw new IllegalStateException($(1842, 1858, 5694));
    }

    public void l(h hVar) {
        boolean z = B;
        String $2 = $(1858, 1873, 8791);
        if (z) {
            Log.v($2, $(1873, 1881, 3800) + hVar);
        }
        if (hVar.y) {
            hVar.y = false;
            if (!hVar.j) {
                if (this.d == null) {
                    this.d = new ArrayList<>();
                }
                if (!this.d.contains(hVar)) {
                    if (B) {
                        Log.v($2, $(1881, 1898, 9904) + hVar);
                    }
                    this.d.add(hVar);
                    hVar.j = true;
                    if (hVar.B && hVar.C) {
                        this.p = true;
                        return;
                    }
                    return;
                }
                throw new IllegalStateException($(1898, 1922, 4) + hVar);
            }
        }
    }

    public h l0(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        int size = this.c.size();
        String $2 = $(1922, 1930, 520);
        String $3 = $(1930, 1964, 10560);
        if (i < size) {
            h hVar = this.c.get(i);
            if (hVar != null) {
                return hVar;
            }
            V0(new IllegalStateException($3 + str + $2 + i));
            throw null;
        }
        V0(new IllegalStateException($3 + str + $2 + i));
        throw null;
    }

    public a.a.a.e.e m0() {
        return this;
    }

    public void n0(h hVar) {
        if (B) {
            Log.v($(1970, 1985, 314), $(1964, 1970, 7803) + hVar);
        }
        if (!hVar.x) {
            hVar.x = true;
            hVar.O = true ^ hVar.O;
        }
    }

    public boolean o0(int i) {
        return this.l >= i;
    }

    @Override // a.a.a.e.e
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        h hVar = null;
        if (!$(1985, 1993, -4090).equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, $(1993, 1998, -16009));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.f41a);
        int i = 0;
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!h.H(this.m.h(), attributeValue)) {
            return null;
        }
        if (view != null) {
            i = view.getId();
        }
        if (i == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + $(1998, 2077, -16321) + attributeValue);
        }
        if (resourceId != -1) {
            hVar = e0(resourceId);
        }
        if (hVar == null && string != null) {
            hVar = f0(string);
        }
        if (hVar == null && i != -1) {
            hVar = e0(i);
        }
        if (B) {
            Log.v($(2113, 2128, -3982), $(2077, 2096, -16221) + Integer.toHexString(resourceId) + $(2096, 2103, -13347) + attributeValue + $(2103, 2113, -16181) + hVar);
        }
        if (hVar == null) {
            hVar = h.B(context, attributeValue);
            hVar.l = true;
            hVar.u = resourceId != 0 ? resourceId : i;
            hVar.v = i;
            hVar.w = string;
            hVar.m = true;
            hVar.p = this;
            l lVar = this.m;
            hVar.q = lVar;
            hVar.Y(lVar.h(), attributeSet, hVar.f20b);
            i(hVar, true);
        } else if (!hVar.m) {
            hVar.m = true;
            l lVar2 = this.m;
            hVar.q = lVar2;
            if (!hVar.A) {
                hVar.Y(lVar2.h(), attributeSet, hVar.f20b);
            }
        } else {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + $(2160, 2177, -2118) + Integer.toHexString(resourceId) + $(2177, 2183, -8579) + string + $(2183, 2200, -9401) + Integer.toHexString(i) + $(2200, 2227, -15753) + attributeValue);
        }
        if (this.l >= 1 || !hVar.l) {
            y0(hVar);
        } else {
            z0(hVar, 1, 0, 0, false);
        }
        View view2 = hVar.F;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (hVar.F.getTag() == null) {
                hVar.F.setTag(string);
            }
            return hVar.F;
        }
        throw new IllegalStateException($(2128, 2137, -9035) + attributeValue + $(2137, 2160, -15054));
    }

    void p(h hVar) {
        if (hVar.F != null) {
            Animation p0 = p0(hVar, hVar.r(), !hVar.x, hVar.s());
            if (p0 != null) {
                R0(hVar.F, p0);
                hVar.F.startAnimation(p0);
                R0(hVar.F, p0);
                p0.start();
            }
            hVar.F.setVisibility((!hVar.x || hVar.E()) ? 0 : 8);
            if (hVar.E()) {
                hVar.K0(false);
            }
        }
        if (hVar.j && hVar.B && hVar.C) {
            this.p = true;
        }
        hVar.O = false;
        hVar.W(hVar.x);
    }

    Animation p0(h hVar, int i, boolean z, int i2) {
        int W0;
        Animation loadAnimation;
        Animation P = hVar.P(i, z, hVar.q());
        if (P != null) {
            return P;
        }
        if (hVar.q() != 0 && (loadAnimation = AnimationUtils.loadAnimation(this.m.h(), hVar.q())) != null) {
            return loadAnimation;
        }
        if (i == 0 || (W0 = W0(i, z)) < 0) {
            return null;
        }
        switch (W0) {
            case 1:
                return t0(this.m.h(), 1.125f, 1.0f, 0.0f, 1.0f);
            case ModuleDescriptor.MODULE_VERSION /* 2 */:
                return t0(this.m.h(), 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return t0(this.m.h(), 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return t0(this.m.h(), 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return r0(this.m.h(), 0.0f, 1.0f);
            case 6:
                return r0(this.m.h(), 1.0f, 0.0f);
            default:
                if (i2 != 0 || !this.m.r()) {
                    return null;
                }
                this.m.q();
                return null;
        }
    }

    public void q(h hVar) {
        boolean z = B;
        String $2 = $(2227, 2242, 7322);
        if (z) {
            Log.v($2, $(2242, 2250, 4821) + hVar);
        }
        if (!hVar.y) {
            hVar.y = true;
            if (hVar.j) {
                if (this.d != null) {
                    if (B) {
                        Log.v($2, $(2250, 2270, 5955) + hVar);
                    }
                    this.d.remove(hVar);
                }
                if (hVar.B && hVar.C) {
                    this.p = true;
                }
                hVar.j = false;
            }
        }
    }

    public void q0(h hVar) {
        if (hVar.d < 0) {
            ArrayList<Integer> arrayList = this.e;
            if (arrayList == null || arrayList.size() <= 0) {
                if (this.c == null) {
                    this.c = new ArrayList<>();
                }
                hVar.L0(this.c.size(), this.o);
                this.c.add(hVar);
            } else {
                ArrayList<Integer> arrayList2 = this.e;
                hVar.L0(arrayList2.remove(arrayList2.size() - 1).intValue(), this.o);
                this.c.set(hVar.d, hVar);
            }
            if (B) {
                Log.v($(2295, 2310, 2714), $(2270, 2295, 11646) + hVar);
            }
        }
    }

    public void r() {
        this.q = false;
        x0(2, false);
    }

    public void s(Configuration configuration) {
        if (this.d != null) {
            for (int i = 0; i < this.d.size(); i++) {
                h hVar = this.d.get(i);
                if (hVar != null) {
                    hVar.n0(configuration);
                }
            }
        }
    }

    void s0(h hVar) {
        if (hVar.d >= 0) {
            if (B) {
                Log.v($(2333, 2348, 2910), $(2310, 2333, 5556) + hVar);
            }
            this.c.set(hVar.d, null);
            if (this.e == null) {
                this.e = new ArrayList<>();
            }
            this.e.add(Integer.valueOf(hVar.d));
            this.m.m(hVar.e);
            hVar.A();
        }
    }

    public boolean t(MenuItem menuItem) {
        if (this.d != null) {
            for (int i = 0; i < this.d.size(); i++) {
                h hVar = this.d.get(i);
                if (hVar != null && hVar.o0(menuItem)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append($(2348, 2364, 20252));
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append($(2364, 2368, 19152));
        Object obj = this.o;
        if (obj == null) {
            obj = this.m;
        }
        a.a.a.d.d.a(obj, sb);
        sb.append($(2368, 2370, 21869));
        return sb.toString();
    }

    public void u() {
        this.q = false;
        x0(1, false);
    }

    public boolean v(Menu menu, MenuInflater menuInflater) {
        boolean z;
        ArrayList<h> arrayList = null;
        if (this.d != null) {
            z = false;
            for (int i = 0; i < this.d.size(); i++) {
                h hVar = this.d.get(i);
                if (hVar != null && hVar.q0(menu, menuInflater)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(hVar);
                    z = true;
                }
            }
        } else {
            z = false;
        }
        if (this.g != null) {
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                h hVar2 = this.g.get(i2);
                if (arrayList == null || !arrayList.contains(hVar2)) {
                    hVar2.T();
                }
            }
        }
        this.g = arrayList;
        return z;
    }

    public void w() {
        this.r = true;
        a0();
        x0(0, false);
        this.m = null;
        this.n = null;
        this.o = null;
    }

    public void w0(h hVar) {
        ViewGroup viewGroup;
        int indexOfChild;
        int indexOfChild2;
        if (hVar != null) {
            int i = this.l;
            if (hVar.k) {
                i = hVar.F() ? Math.min(i, 1) : Math.min(i, 0);
            }
            z0(hVar, i, hVar.r(), hVar.s(), false);
            if (hVar.F != null) {
                h h0 = h0(hVar);
                if (h0 != null && (indexOfChild2 = viewGroup.indexOfChild(hVar.F)) < (indexOfChild = (viewGroup = hVar.E).indexOfChild(h0.F))) {
                    viewGroup.removeViewAt(indexOfChild2);
                    viewGroup.addView(hVar.F, indexOfChild);
                }
                if (hVar.N && hVar.E != null) {
                    if (Build.VERSION.SDK_INT < 11) {
                        hVar.F.setVisibility(0);
                    } else {
                        float f2 = hVar.P;
                        if (f2 > 0.0f) {
                            hVar.F.setAlpha(f2);
                        }
                    }
                    hVar.P = 0.0f;
                    hVar.N = false;
                    Animation p0 = p0(hVar, hVar.r(), true, hVar.s());
                    if (p0 != null) {
                        R0(hVar.F, p0);
                        hVar.F.startAnimation(p0);
                    }
                }
            }
            if (hVar.O) {
                p(hVar);
            }
        }
    }

    public void x() {
        x0(1, false);
    }

    public void x0(int i, boolean z) {
        boolean z2;
        l lVar;
        if (this.m == null && i != 0) {
            throw new IllegalStateException($(2370, 2381, 4342));
        } else if (z || i != this.l) {
            this.l = i;
            if (this.c != null) {
                ArrayList<h> arrayList = this.d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    z2 = false;
                    for (int i2 = 0; i2 < size; i2++) {
                        h hVar = this.d.get(i2);
                        w0(hVar);
                        v vVar = hVar.J;
                        if (vVar != null) {
                            z2 |= vVar.i();
                        }
                    }
                } else {
                    z2 = false;
                }
                int size2 = this.c.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    h hVar2 = this.c.get(i3);
                    if (hVar2 != null && ((hVar2.k || hVar2.y) && !hVar2.N)) {
                        w0(hVar2);
                        v vVar2 = hVar2.J;
                        if (vVar2 != null) {
                            z2 |= vVar2.i();
                        }
                    }
                }
                if (!z2) {
                    U0();
                }
                if (this.p && (lVar = this.m) != null && this.l == 5) {
                    lVar.t();
                    this.p = false;
                }
            }
        }
    }

    public void y() {
        if (this.d != null) {
            for (int i = 0; i < this.d.size(); i++) {
                h hVar = this.d.get(i);
                if (hVar != null) {
                    hVar.v0();
                }
            }
        }
    }

    void y0(h hVar) {
        z0(hVar, this.l, 0, 0, false);
    }

    public void z(boolean z) {
        ArrayList<h> arrayList = this.d;
        if (arrayList != null) {
            int size = arrayList.size();
            while (true) {
                size--;
                if (size >= 0) {
                    h hVar = this.d.get(size);
                    if (hVar != null) {
                        hVar.w0(z);
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x007c, code lost:
        if (r0 != 4) goto L_0x0501;
     */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0506  */
    /* JADX WARN: Removed duplicated region for block: B:216:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void z0(a.a.a.a.h r21, int r22, int r23, int r24, boolean r25) {
        /*
            Method dump skipped, instructions count: 1376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.n.z0(a.a.a.a.h, int, int, int, boolean):void");
    }
}
