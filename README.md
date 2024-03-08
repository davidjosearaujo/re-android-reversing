# Authors
- Tiago Silvestre
- David Araujo

# Introduction
For our reverse engineering course, we have decided to analyze and reverse engineer the "PDF Reader File Manager" application, which was known for being removed from the Play Store earlier this year. It was developed to steal data from Android users, as explained in this article [here](https://www.tomsguide.com/computing/malware-adware/these-malicious-android-malware-apps-were-downloaded-150000-times-from-the-play-store-delete-them-right-now).


# Methodology

## Environment setup

Using a Kali Vagrant box, we import the _PDF_Reader_File_Manager.zip_ file. This is done in order to easily isolate and replicate the testing environment so any finding are no corrupted or able to corrupt the host.

## Unziping XAPK

Unziping the file with `7za PDF_Reader_File_Manager.zip` results in an XAPK file and an _other_ directory.
With a little investigation we can discover that XAPK files are just a bundle of an APKs with other files. To retrieve these we can again use `7za` and run it with the XAPK file. E now have multiple APKs, a PNG and a JSON file.

![Extracted files](./docs/imgs/Screenshot%20from%202024-03-05%2000-41-49.png)

From these files, we first look at the _manifest.json_ file, this gives us a few clues regarding **permissions and target SDK**.

![manifest.json](./docs/imgs/Screenshot%20from%202024-03-05%2000-46-20.png)

[TBD]
1. Apktool to open XAPK
2. Check permissions on _manifest.xml_
3. JADX deofuscated
3. run `apktool d -r -s com.tragisoap.fileandpdfmanager.apk`
4. run `jadx -d out classes.dex`

# PDF Reader Structure
[TBD]

# Deobfuscation
- Falar do PDF Reader Files Manager_1.0.1
- Falar sobre a pasta other

# Findings
[TBD]
 