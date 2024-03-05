# Authors
- Tiago Silvestre
- David Araujo


# Introduction
For our reverse engineering course, we have decided to analyze and reverse engineer the "PDF Reader File Manager" application, which was known for being removed from the Play Store earlier this year. It was developed to steal data from Android users, as explained in this article [here](https://www.tomsguide.com/computing/malware-adware/these-malicious-android-malware-apps-were-downloaded-150000-times-from-the-play-store-delete-them-right-now).



# Methodology

## Environment setup
Using a Kali Vagrant box, we import the _PDF_Reader_File_Manager.zip_ file. This is done in order to easily isolate and replicate the testing environment so any finding are no corrupted or able to corrupt the host.

## Unzip
Unziping the file with `7za PDF_Reader_File_Manager.zip` results in an XAPK file and an _other_ directory.
With a little investigation we can discover that XAPK files are just a bundle of an APKs with other files. To retrieve these we can again use `7za` and run it with the XAPK file. E now have multiple APKs, a PNG and a JSON file.

![Extracted files](./imgs/Screenshot%20from%202024-03-05%2000-41-49.png)

From these files, we first look at the _manifest.json_ file, this gives us a few clues regarding **permissions and target SDK**.

![manifest.json](./imgs/Screenshot%20from%202024-03-05%2000-46-20.png)


# Findings
## 'Other' path
### Package name obfuscation
Upon discovery, we encountered a package named "jum.khdqwmf.xftkgphgq.fhyu" containing Chinese characters. After translating these strings using Google Translate, we determined that these characters formed simple Chinese sentences unrelated to the application's purpose. Further exploration revealed that these strings were translated into package names when passed through a function. This indicates that the original authors chose to obscure package names using Chinese strings.

(Falta colocar prints)