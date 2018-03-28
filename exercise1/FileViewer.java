package ttn.cloudwords.exercise1;

import java.io.File;
import java.util.*;

public class FileViewer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("please enter the directory path ->>");
        String directoryPath = in.next();
        FileViewer fileViewer = new FileViewer();
        List<File> fileList = fileViewer.printAllFiles(directoryPath);
        fileViewer.sortFileList(fileList);
    }

    private List<File> printAllFiles(String directoryPath) {
        List<File> files = new ArrayList<>();
        if (Objects.isNull(directoryPath) || directoryPath.equals("")) {
            System.out.println("Invalid path ..");
        } else {
            File file = new File(directoryPath);
            files = printAllFiles(file, files);
        }
        return files;
    }

    private List<File> printAllFiles(File file, List<File> fileList) {
        if (!file.isDirectory()) {
            fileList.add(file);
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                printAllFiles(file1, fileList);
            }
        }
        return fileList;
    }

    private void sortFileList(List<File> fileList) {
        fileList.sort(Comparator.comparingLong(File::length));
        fileList.forEach(file -> {
            System.out.println("file size :: " + file.length() + "::file name ::" + file.getName() + " :: path :: " + file.getAbsolutePath());
        });
    }
}
