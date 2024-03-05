# Environment setup

Using a Kali Vagrant box, we import the _PDF_Reader_File_Manager.zip_ file. This is done in order to easily isolate and replicate the testing environment so any finding are no corrupted or able to corrupt the host.

# Unzip

Unziping the file with `7za PDF_Reader_File_Manager.zip` results in an XAPK file and an _other_ directory.
With a little investigation we can discover that XAPK files are just a bundle of an APKs with other files. To retrieve these we can again use `7za` and run it with the XAPK file. E now have multiple APKs, a PNG and a JSON file.

![Extracted files](./imgs/Screenshot%20from%202024-03-05%2000-41-49.png)

From these files, we first look at the _manifest.json_ file, this gives us a few clues regarding **permissions and target SDK**.

![manifest.json](./imgs/Screenshot%20from%202024-03-05%2000-46-20.png)