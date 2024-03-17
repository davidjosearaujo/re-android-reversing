package cn.jpush.android.helper;

import android.util.SparseArray;
import com.alibaba.fastjson.JSONStreamContext;
import com.huawei.hms.support.api.entity.common.CommonConstant;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class f {
    private static final SparseArray<String> a;

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(1060, "need not show notification by foreground");
        sparseArray.put(1061, "need not show notification by isNeedShowNotification return false");
        sparseArray.put(1050, "ssp buildId error");
        sparseArray.put(1051, "ssp but no alert");
        sparseArray.put(1032, "MSG already cancle");
        sparseArray.put(1033, "overide msg already cancle");
        sparseArray.put(1034, "MSG already end");
        sparseArray.put(1035, "msg delay show");
        sparseArray.put(1036, "notification disabled");
        sparseArray.put(1037, "notification channel disabled");
        sparseArray.put(972, "Deep link set small icon failed");
        sparseArray.put(973, "Deep link set large icon failed");
        sparseArray.put(974, "Deep link- device in blacklist");
        sparseArray.put(975, "Deep link source error");
        sparseArray.put(976, "Deep link jump success");
        sparseArray.put(977, "Deep link jump failed");
        sparseArray.put(978, "Fail Deep link jump success");
        sparseArray.put(979, "Fail Deep link jump failed");
        sparseArray.put(981, "Deep link notify not show");
        sparseArray.put(980, "Deep link notify show");
        sparseArray.put(983, "wrong with resource file push_notification.xml");
        sparseArray.put(984, "unsupport night mode style, please check v21/push_notification.xml");
        sparseArray.put(993, "target app uninstall,not found target app small icon");
        sparseArray.put(985, "Deep link source is not empty and pkgname is empty but deeplink error");
        sparseArray.put(986, "Message is not in push time");
        sparseArray.put(988, "Deep link target app uninstalled");
        sparseArray.put(995, "Message JSON parsing succeed");
        sparseArray.put(996, "Message JSON parsing failed");
        sparseArray.put(997, "Message already received, give up");
        sparseArray.put(998, "Message already received, still process");
        sparseArray.put(1000, "User clicked and opened the Message");
        sparseArray.put(1028, "User clicked and opened the Message from JPushInterface.reportNotificationOpened");
        sparseArray.put(1068, "User clear the JPush Notification from JPushReportHelper.reportMsgResult");
        sparseArray.put(1069, "User clear the OS Push Notification from JPushReportHelper.reportThirdSDKMsgActionResult");
        sparseArray.put(1001, "Message download succeed");
        sparseArray.put(1002, "Message received succeed");
        sparseArray.put(JSONStreamContext.PropertyValue, "Message silence download succeed");
        sparseArray.put(JSONStreamContext.StartArray, "Video silence downlaod succeed");
        sparseArray.put(JSONStreamContext.ArrayValue, "User clicked video and jumped to url Message (browser)");
        sparseArray.put(1008, "Video is force closed by user");
        sparseArray.put(1007, "User clicked 'OK'");
        sparseArray.put(1006, "User clicked 'Cancel'");
        sparseArray.put(1011, "Download failed");
        sparseArray.put(1012, "User clicked to download again");
        sparseArray.put(1013, "The file already exist and same size. Don't download again.");
        sparseArray.put(1100, "Invalid param or unexpected result.");
        sparseArray.put(1014, "Failed to preload required resource");
        sparseArray.put(1015, "User clicked install alert on status bar after downloading finished.");
        sparseArray.put(1016, "User clicked the webview's url");
        sparseArray.put(1017, "User clicked call action");
        sparseArray.put(1018, "The Message show in the status bar");
        sparseArray.put(1019, "Click applist and show the Message");
        sparseArray.put(1020, "Down image failed");
        sparseArray.put(1021, "Down html failed");
        sparseArray.put(1022, "Down Message failed");
        sparseArray.put(1030, "Discard the message because it is not in the push time");
        sparseArray.put(1031, "Stop push service");
        sparseArray.put(1032, "Resume push service");
        sparseArray.put(1052, "Message count limit");
        sparseArray.put(1053, "Message interval limit");
        sparseArray.put(1070, "WX app is not original or not installed");
        sparseArray.put(1072, "WX appid does not match local");
        sparseArray.put(1071, "APP keystore sign not match");
        sparseArray.put(1073, "WX version too low to support mini");
        sparseArray.put(1074, "ssp wx miniprogram param error");
        sparseArray.put(1075, "Open WX miniprogram failed");
        sparseArray.put(1090, "User Click ssp notification Feedback -- button id is 1.");
        sparseArray.put(1091, "User Click ssp notification Feedback -- button id is 2.");
        sparseArray.put(1092, "User Click ssp notification Feedback -- button id is 3.");
        sparseArray.put(1093, "User Click ssp notification Feedback -- button id is 4.");
        sparseArray.put(1094, "User Click ssp notification Feedback - Show feed back");
        sparseArray.put(1096, "Current diy layout version is not support required ssp layout version");
        sparseArray.put(1100, "missing resource file push_notification_middle.xml");
        sparseArray.put(1101, "missing  resource file push_notification_large.xml");
        sparseArray.put(1102, "device is not support larger notification");
        sparseArray.put(1097, "Same content in-app message display recently, ssp notification need not show.");
        sparseArray.put(1098, "in-app message display recently, ssp need delay to show");
        sparseArray.put(1080, "show notification make unknown error");
        sparseArray.put(1105, "ssp notification will not show by user");
        sparseArray.put(1106, "the custom message show");
        sparseArray.put(1600, "notify in app message show");
        sparseArray.put(1601, "notify in app message click");
        sparseArray.put(1602, "notify in app message cancel");
        sparseArray.put(1603, "notify in app message is expired");
        sparseArray.put(1604, "notify in app message display failed");
        sparseArray.put(1605, "notify in app message deeplink jump succeed");
        sparseArray.put(1606, "notify in app message deeplink jump failed");
        sparseArray.put(1200, "in-app message not display background");
        sparseArray.put(1209, "in-app message build failed");
        sparseArray.put(1202, "in-app message count limit should not show");
        sparseArray.put(1203, "in-app message interval limit should not show");
        sparseArray.put(1204, "in-app message resource download failed, in app not display");
        sparseArray.put(1205, "in-app message json parse success");
        sparseArray.put(1206, "in-app message intercept by user");
        sparseArray.put(1210, "in-app message show success");
        sparseArray.put(1211, "in-app message show failed");
        sparseArray.put(1219, "in-app message click");
        sparseArray.put(1214, "in-app message deeplink jumped success");
        sparseArray.put(1215, "in-app message deeplink jump failed");
        sparseArray.put(CommonConstant.RETCODE.NEED_UPDATE_STATICKIT, "in-app message open wechat mini program success");
        sparseArray.put(1213, "in-app message open wechat mini program failed");
        sparseArray.put(1216, "in-app message open target app not install");
        sparseArray.put(1217, "in-app message fail-deeplink jump success");
        sparseArray.put(1218, "in-app message fail-deeplink jump failed");
        sparseArray.put(1220, "in-app message wechat mini program param error ");
        sparseArray.put(1221, "in-app message WX app is not original or not installed");
        sparseArray.put(1222, "in-app message WX version too low to support mini");
        sparseArray.put(1223, "in-app message wechat appid not match");
        sparseArray.put(1224, "in-app message wechat sign not match ");
        sparseArray.put(1207, "in-app message target packagename is empty");
        sparseArray.put(1208, "in-app message deeplink not show");
        sparseArray.put(1225, "in-app message  deeplink show");
        sparseArray.put(1226, "in-app message unsupport message style");
        sparseArray.put(1227, "in-app message not show, because has same ssp notification");
        sparseArray.put(1228, "in-app message layout not exists");
        sparseArray.put(1201, "in-app message not display background during delay time");
        sparseArray.put(1229, "in-app message delay to show for background to foreground");
        sparseArray.put(1230, "in-app message show failed for other display now.");
        sparseArray.put(1231, "in-app message html template download failed.");
        sparseArray.put(1232, "in-app message template image resource download failed.");
        sparseArray.put(1233, "in-app message template cache failed.");
        sparseArray.put(1234, "in-app message of h5 report data");
        sparseArray.put(1235, "in-app message new one override old display");
        sparseArray.put(1236, "in-app message h5 template load data failed");
        sparseArray.put(1237, "in-app message package installed not display");
        sparseArray.put(1238, "in-app message not show for url is empty or not start with http");
        sparseArray.put(1239, "in-app message start apk download");
        sparseArray.put(1240, "in-app message cancel apk download by data network");
        sparseArray.put(1241, "in-app message user pause apk download");
        sparseArray.put(1242, "in-app message user resume apk download");
        sparseArray.put(1243, "in-app message user swipe notification to stop apk download");
        sparseArray.put(1244, "in-app message apk download failed");
        sparseArray.put(1245, "in-app message apk download success");
        sparseArray.put(1246, "in-app message apk install failed");
        sparseArray.put(1247, "in-app message apk install success");
        sparseArray.put(1248, "in-app message apk installed already not download");
        sparseArray.put(1249, "in-app message user click close button");
        sparseArray.put(1250, "in-app message click jump failed for parse param");
        sparseArray.put(1251, "in-app message user click cancel");
        sparseArray.put(1252, "in-app message click h5 web content");
        sparseArray.put(1253, "in-app message activity param is null");
        sparseArray.put(1254, "in-app message occur unknown error");
        sparseArray.put(1255, "in-app message start apk install");
        sparseArray.put(1256, "in-app message start download apk no common service");
        sparseArray.put(1257, "in-app message param is null");
        sparseArray.put(1258, "in-app message progress notification build failed");
        sparseArray.put(1259, "in-app message progress notification display failed");
        sparseArray.put(1260, "in-app message get apk size failed");
        sparseArray.put(1261, "in-app message get apk size success");
        sparseArray.put(1262, "in-app message js load callback timeout");
        sparseArray.put(1263, "in-app message start ipc");
        sparseArray.put(1264, "in-app message apk install use cache file");
        sparseArray.put(1265, "in-app message service stop process exit");
        sparseArray.put(1266, "in-app message use local to replace template img failed");
        sparseArray.put(1267, "in-app message for new user link show");
        sparseArray.put(1268, "in-app message handle message unknown error");
        sparseArray.put(1269, "in-app message check frequency error");
        sparseArray.put(1270, "in-app message handle message display error");
        sparseArray.put(1271, "in-app message h5 template load data success to display message");
        sparseArray.put(1272, "in-app message display failed with win manager build");
        sparseArray.put(1273, "in-app message h5 template cache success");
        sparseArray.put(1274, "in-app message start install by browser failed");
        sparseArray.put(1275, "in-app message start install by browser success");
        sparseArray.put(1276, "in-app message unsupported install type");
        sparseArray.put(1277, "in-app message apk install condition unsupported");
        sparseArray.put(1278, "in-app message apk install condition supported");
        sparseArray.put(1279, "in-app message parse json failed");
        sparseArray.put(1280, "in-app message FileProvider or jpush_file_paths.xml not config");
        sparseArray.put(1281, "in-app message not config REQUEST_INSTALL_PACKAGES permission");
        sparseArray.put(1282, "in-app message receive message appId not match app package name");
        sparseArray.put(1283, "in-app message use local cache template resource");
        sparseArray.put(1284, "in-app message build webview failed");
        sparseArray.put(1285, "in-app message not permission of allowing unknown source app install");
        sparseArray.put(1286, "in-app message has permission of allowing unknown source app install");
        sparseArray.put(1287, "in-app message start apk download no network, add wait download task");
        sparseArray.put(1288, "in-app message install apk allow pop win to grant unknown source app install permission");
        sparseArray.put(1289, "in-app message no deeplink intent error, message not display");
        sparseArray.put(1290, "in-app message top activity not in main process, message not display");
        sparseArray.put(1291, "in-app message apk download path is null");
        sparseArray.put(1292, "in-app message build message failed-ex");
        sparseArray.put(1293, "in-app message jump failed for deeplink is null");
        sparseArray.put(1294, "in-app deeplink jump exception error");
        sparseArray.put(1295, "in-app message display by system alert");
        sparseArray.put(1296, "in-app message display failed by webview is null");
        sparseArray.put(1297, "in-app message display failed by win-manager is null");
        sparseArray.put(1298, "in-app message display failed by param is null");
        sparseArray.put(1299, "in-app message fail for new user link jumped");
        sparseArray.put(1300, "in-app message success for new user link jumped");
        sparseArray.put(1301, "in-app message not use fail url, fail action not 1");
        sparseArray.put(1302, "in-app message click not found action key");
        sparseArray.put(1303, "in-app message h5 template load image error(or timeout)");
        sparseArray.put(1304, "in-app message no wx intent error");
        sparseArray.put(1305, "in-app message wx origin id is empty");
        sparseArray.put(1306, "in-app message wx deeplink param error");
        sparseArray.put(1307, "in-app message parse wx param error");
        sparseArray.put(1308, "in-app message build download notification icon failed");
        sparseArray.put(1309, "in-app message recv duplicated message");
        sparseArray.put(1310, "in-app message is cached for notify in app displayed now");
        sparseArray.put(1311, "in-app message h5 activity on create");
        sparseArray.put(1312, "in-app message webview load h5 page started");
        sparseArray.put(1313, "in-app message h5 activity on destroy");
        sparseArray.put(1314, "in-app message h5 load error occur");
        sparseArray.put(1315, "in-app message dismiss manu slide");
        sparseArray.put(1316, "in-app message dismiss auto slide");
        sparseArray.put(1317, "in-app message dismiss on destroy");
        sparseArray.put(1318, "in-app message dismiss back to background");
        sparseArray.put(1319, "in-app message activity on paused");
        sparseArray.put(1320, "in-app message app back to background");
        sparseArray.put(1321, "in-app message app activity on resume");
        sparseArray.put(1322, "in-app message stop display to black page");
        sparseArray.put(1323, "in-app message expose end by process end");
        sparseArray.put(1324, "in-app message not display in black page");
        sparseArray.put(1325, "in-app message not request in black page");
        sparseArray.put(1326, "in-app h5 orientation and current orientation no same");
        sparseArray.put(1327, "in-app hb period set enable/disenable by user");
        sparseArray.put(1331, "in-app not display for new user in google play");
    }

    public static String a(int i) {
        SparseArray<String> sparseArray = a;
        if (sparseArray.get(i) == null) {
            Logger.d("StatusCode", "Unknown report code - " + i);
            return "";
        }
        return sparseArray.get(i);
    }
}
