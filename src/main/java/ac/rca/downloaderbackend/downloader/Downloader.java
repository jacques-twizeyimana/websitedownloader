package ac.rca.downloaderbackend.downloader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Downloader {
    private String url;

    public Downloader(String url) {
        this.url = url;
    }

    public Long getFolderSize(String folderDir) throws IOException {
        Path folder = Paths.get(folderDir);
        long size = Files.walk(folder)
                .filter(p -> p.toFile().isFile())
                .mapToLong(p -> p.toFile().length())
                .sum();

       return size;
    }

    public long start() throws IOException {
        String domain;
        String name;
        LinkParser linkParser = new LinkParser();
        ExtractLinks extractLinks = new ExtractLinks();
        List<ArrayList> rootLinks = new ArrayList<ArrayList>();
        List<ArrayList> layerTwoLinks = new ArrayList<ArrayList>();
        List<ArrayList> layerThreeLinks = new ArrayList<ArrayList>();
        List<ArrayList> fileOnlyLinkOne = new ArrayList<ArrayList>();
        Mime mime = new Mime();
        FileClass fileClass = new FileClass();
        DownloadFile downloadObj1 = new DownloadFile();

        System.out.println("#####################");
        domain = url;

        String parseURL = new URL(url).getHost();
        String rootFolderName = "downloads/" + parseURL;

        //setting and getting for next iteration
        try {
            linkParser.setLink(domain, url);

            rootLinks = linkParser.getLink();
            System.out.println(rootLinks);

        } catch (NullPointerException | IOException rootExcep) {
            rootExcep.printStackTrace();
        }

        for (int counter = 0; counter < rootLinks.size(); counter++) {
            boolean flag = true;
            while (flag) {
                url = (String) rootLinks.get(counter).get(0);
                name = (String) rootLinks.get(counter).get(1);
                System.out.println("Extracting sub-link: " + url);
                // if a link mime type is a file, add to list and break the most inner loop to continue to check the next link
                if (mime.getMimeTypeIsFile(url)) {
                    fileOnlyLinkOne.add(rootLinks.get(counter));
                    break;
                }

                extractLinks.setLink(domain, url, name);
                //on loop getting more links
                try {
                    layerTwoLinks = extractLinks.getLink();
                } catch (NullPointerException | IOException l2Excp) {
                    l2Excp.printStackTrace();
                }
                //System.out.println("Scraped Array Links:  "+layerTwoLinks);
                //mime type coding
                try {
                    for (int counterTwo = 1; counterTwo < layerTwoLinks.size(); counterTwo++) {
                        //System.out.print(layerTwoLinks.get(counterTwo)); //printing list with location+name
                        boolean checkMime = mime.getMimeTypeIsFile((String) layerTwoLinks.get(counterTwo).get(0));
                        if (checkMime)
                            fileOnlyLinkOne.add(layerTwoLinks.get(counterTwo));
                        else
                            layerThreeLinks.add(layerTwoLinks.get(counterTwo));
                    }
                } catch (NullPointerException mimeExcp2) {
                    mimeExcp2.printStackTrace();
                    System.out.println("Error Occurred");
                }

                if (!layerThreeLinks.equals(0))
                    rootLinks.addAll(counter + 1, layerThreeLinks);
                layerThreeLinks = new ArrayList<>();
                //flag turns false and stops the loop if not before
                flag = false;
            }
        }
        System.out.println("");
        //System.out.println(fileOnlyLinkOne); //The full list of file links to create and download on the system

        //working with file
        for (int i = 0; i < fileOnlyLinkOne.size(); i++) {
            boolean checkFileExist;
            String addressSetter = rootFolderName + "/" + fileOnlyLinkOne.get(i).get(1);
            System.out.println("Link: " + fileOnlyLinkOne.get(i).get(0));
            System.out.println("File name: " + fileOnlyLinkOne.get(i).get(1));
            try {
                fileClass.setAddress(addressSetter);
                checkFileExist = fileClass.makeFolderFile();

                //Downloading part, Just enable in-case you want to download.
                if (checkFileExist) {
                    downloadObj1.setAddress(addressSetter, (String) fileOnlyLinkOne.get(i).get(0));
                    downloadObj1.downloadFileFromUrlUsingNio();
                } else {
                    System.out.println("Checking file size...");
                    if (!fileClass.isLocalMatchesRemote(addressSetter, (String) fileOnlyLinkOne.get(i).get(0))) {
                        downloadObj1.setAddress(addressSetter, (String) fileOnlyLinkOne.get(i).get(0));
                        downloadObj1.downloadFileFromUrlUsingNio();
                    } else
                        System.out.println("File already downloaded, skipping!");
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        System.out.println("#####################");
        //find total folder size
        return this.getFolderSize(rootFolderName);

    }

}
