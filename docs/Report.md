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

## Exploring readable files

TODO
1. muchaspuchas maybe a CSV type file
2. Based on 1., we look for split functions.


Going through the _1.apk_ files, we encountered a package named "juw.khdqwmf.xftkgphgq.fhyu" containing Chinese characters. After translating these strings using Google Translate, we determined that these characters formed simple Chinese sentences unrelated to the application's purpose. Further exploration revealed that **these strings were translated into package names when passed through a function**. This indicates that the original authors chose to obscure package names using Chinese strings.