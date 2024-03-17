package cn.com.custommma.mobile.tracking.util;

import android.util.Xml;
import cn.com.custommma.mobile.tracking.api.Constant;
import cn.com.custommma.mobile.tracking.bean.Applist;
import cn.com.custommma.mobile.tracking.bean.Argument;
import cn.com.custommma.mobile.tracking.bean.Company;
import cn.com.custommma.mobile.tracking.bean.Config;
import cn.com.custommma.mobile.tracking.bean.Domain;
import cn.com.custommma.mobile.tracking.bean.Event;
import cn.com.custommma.mobile.tracking.bean.OfflineCache;
import cn.com.custommma.mobile.tracking.bean.SDK;
import cn.com.custommma.mobile.tracking.bean.Signature;
import cn.com.custommma.mobile.tracking.bean.Switch;
import cn.com.custommma.mobile.tracking.bean.ViewAbility;
import cn.com.custommma.mobile.tracking.viewability.origin.ViewAbilityStats;
import com.alipay.sdk.data.a;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class XmlUtil {
    public static final String XMLFILE = "sdkconfig.xml";

    public static SDK doParser(InputStream inputStream) {
        SDK sdk;
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(inputStream, "UTF-8");
            SDK sdk2 = null;
            Company company = null;
            boolean z = false;
            boolean z2 = false;
            Argument argument = null;
            Event event = null;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 0) {
                    sdk2 = new SDK();
                } else if (eventType == 2) {
                    String name = newPullParser.getName();
                    if ("offlineCache".equals(name)) {
                        sdk2.offlineCache = new OfflineCache();
                    }
                    if (sdk2.offlineCache != null) {
                        if ("length".equals(name)) {
                            sdk2.offlineCache.length = newPullParser.nextText();
                        }
                        if ("queueExpirationSecs".equals(name)) {
                            sdk2.offlineCache.queueExpirationSecs = newPullParser.nextText();
                        }
                        if (a.Q.equals(name)) {
                            sdk2.offlineCache.timeout = newPullParser.nextText();
                        }
                    }
                    if (name.equals("viewability")) {
                        sdk2.viewAbility = new ViewAbility();
                    }
                    if (name.equals("intervalTime")) {
                        sdk2.viewAbility.intervalTime = Integer.valueOf(newPullParser.nextText()).intValue();
                    }
                    if (name.equals("viewabilityFrame")) {
                        sdk2.viewAbility.viewabilityFrame = Integer.valueOf(newPullParser.nextText()).intValue();
                    }
                    if (name.equals("viewabilityTime")) {
                        sdk2.viewAbility.viewabilityTime = Integer.valueOf(newPullParser.nextText()).intValue();
                    }
                    if (name.equals("viewabilityVideoTime")) {
                        sdk2.viewAbility.viewabilityVideoTime = Integer.valueOf(newPullParser.nextText()).intValue();
                    }
                    if (name.equals("maxExpirationSecs")) {
                        sdk2.viewAbility.maxExpirationSecs = Integer.valueOf(newPullParser.nextText()).intValue();
                    }
                    if (name.equals("maxAmount")) {
                        sdk2.viewAbility.maxAmount = Integer.valueOf(newPullParser.nextText()).intValue();
                    }
                    if ("companies".equals(name)) {
                        sdk2.companies = new ArrayList();
                    }
                    if (sdk2.companies != null && "company".equals(name)) {
                        company = new Company();
                    }
                    if (company != null) {
                        if ("name".equals(name) && company.name == null) {
                            company.name = newPullParser.nextText();
                        }
                        if ("jsurl".equals(name) && company.jsurl == null) {
                            company.jsurl = newPullParser.nextText();
                        }
                        if ("jsname".equals(name) && company.jsname == null) {
                            company.jsname = newPullParser.nextText();
                        }
                        if ("domain".equals(name)) {
                            company.domain = new Domain();
                        }
                        if (company.domain != null && "url".equals(name)) {
                            company.domain.url = newPullParser.nextText();
                        }
                        if ("signature".equals(name)) {
                            company.signature = new Signature();
                        }
                        if (company.signature != null) {
                            if ("publicKey".equals(name)) {
                                company.signature.publicKey = newPullParser.nextText();
                            }
                            if ("paramKey".equals(name)) {
                                company.signature.paramKey = newPullParser.nextText();
                            }
                        }
                        if ("switch".equals(name)) {
                            company.sswitch = new Switch();
                        }
                        if (company.sswitch != null) {
                            if ("isTrackLocation".equals(name)) {
                                company.sswitch.isTrackLocation = Boolean.parseBoolean(newPullParser.nextText());
                            }
                            if ("offlineCacheExpiration".equals(name)) {
                                company.sswitch.offlineCacheExpiration = newPullParser.nextText();
                            }
                            if ("viewabilityTrackPolicy".equals(name)) {
                                company.sswitch.viewabilityTrackPolicy = Integer.parseInt(newPullParser.nextText());
                            }
                            if ("encrypt".equals(name)) {
                                company.sswitch.encrypt = new HashMap();
                            }
                            if (company.sswitch.encrypt != null && (Constant.TRACKING_MAC.equals(name) || "IDA".equals(name) || Constant.TRACKING_IMEI.equals(name) || Constant.TRACKING_ANDROIDID.equals(name))) {
                                company.sswitch.encrypt.put(name, newPullParser.nextText());
                            }
                        }
                        if ("applist".equals(name)) {
                            company.applist = new Applist();
                        }
                        if (company.applist != null) {
                            if ("uploadUrl".equals(name)) {
                                company.applist.uploadUrl = newPullParser.nextText();
                            }
                            if ("uploadTime".equals(name)) {
                                company.applist.uploadTime = Integer.parseInt(newPullParser.nextText());
                            }
                            if ("usegzip".equals(name)) {
                                company.applist.useGzip = Boolean.parseBoolean(newPullParser.nextText());
                            }
                        }
                        if ("config".equals(name)) {
                            company.config = new Config();
                        }
                        if (company.config != null) {
                            if ("arguments".equals(name)) {
                                company.config.arguments = new ArrayList();
                            }
                            if ("argument".equals(name)) {
                                argument = new Argument();
                            }
                            if (argument != null) {
                                if (SDKConstants.PARAM_KEY.equals(name)) {
                                    argument.key = newPullParser.nextText();
                                }
                                if (SDKConstants.PARAM_VALUE.equals(name)) {
                                    argument.value = newPullParser.nextText();
                                }
                                if ("urlEncode".equals(name)) {
                                    argument.urlEncode = Boolean.parseBoolean(newPullParser.nextText());
                                }
                                if ("isRequired".equals(name)) {
                                    argument.isRequired = Boolean.parseBoolean(newPullParser.nextText());
                                }
                            }
                            if ("events".equals(name)) {
                                company.config.events = new ArrayList();
                            }
                            if (company.config.events != null && "event".equals(name)) {
                                event = new Event();
                            }
                            if (event != null) {
                                if (SDKConstants.PARAM_KEY.equals(name)) {
                                    event.key = newPullParser.nextText();
                                }
                                if (SDKConstants.PARAM_VALUE.equals(name)) {
                                    event.value = newPullParser.nextText();
                                }
                                if ("urlEncode".equals(name)) {
                                    event.urlEncode = Boolean.parseBoolean(newPullParser.nextText());
                                }
                            }
                            if (name.equals(ViewAbilityStats.ADPLACEMENT)) {
                                company.config.adplacements = new HashMap<>();
                                z = true;
                            }
                            if (name.equals("viewabilityarguments")) {
                                company.config.viewabilityarguments = new HashMap<>();
                                z2 = true;
                            }
                        }
                        if ("separator".equals(name)) {
                            company.separator = newPullParser.nextText();
                        }
                        if ("adidurl".equals(name)) {
                            company.adidurl = newPullParser.nextText();
                        }
                        if ("equalizer".equals(name)) {
                            company.equalizer = newPullParser.nextText();
                        }
                        if ("timeStampUseSecond".equals(name)) {
                            company.timeStampUseSecond = Boolean.parseBoolean(newPullParser.nextText());
                        }
                    }
                } else if (eventType != 3) {
                    continue;
                } else {
                    try {
                        String name2 = newPullParser.getName();
                        if ("company".equals(name2)) {
                            sdk2.companies.add(company);
                            company = null;
                        }
                        if ("argument".equals(name2)) {
                            if (z) {
                                company.config.adplacements.put(argument.key, argument);
                            } else if (z2) {
                                company.config.viewabilityarguments.put(argument.key, argument);
                            } else {
                                company.config.arguments.add(argument);
                            }
                            argument = null;
                        }
                        if (name2.equals(ViewAbilityStats.ADPLACEMENT)) {
                            z = false;
                            argument = null;
                        }
                        if (name2.equals("viewabilityarguments")) {
                            z2 = false;
                            argument = null;
                        }
                        if ("event".equals(name2)) {
                            company.config.events.add(event);
                            event = null;
                        }
                    } catch (Exception e) {
                        e = e;
                        sdk = sdk2;
                        e.printStackTrace();
                        return sdk;
                    }
                }
            }
            return sdk2;
        } catch (Exception e2) {
            e = e2;
            sdk = null;
        }
    }
}
