package com.theory.io;

import org.apache.tools.zip.ZipEntry;

import java.io.*;
import java.util.zip.ZipOutputStream;

/**
 * 文件的最佳实践:文件复制和删除
 * Created by weideliang on 2017/3/16.
 */
public class FileBestPractice {
    public static void main(String[] args) throws Exception {
        //文件复制
//        FileBestPractice.copyFiles("D:\\io", "E:\\");
        //文件删除
//        FileBestPractice.deleteFile("D:\\log");

        //压缩和解压 绝对路径或相对路径(相对于zipOutputStream的路径)
        FileBestPractice.zipFile("D:\\io/aa.txt", "D:/", "E:/bb.zip");

        //图片复制和放大
    }

    /**
     * 压缩文件
     * @return
     */
    public static boolean zipFile(String sourcePath,String srouceParentDir,String desFileName)throws Exception{
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(new File(desFileName)));
        File sourceFile = new File(sourcePath);
        if(sourceFile.isFile()){
            FileBestPractice.zipSingleFile(sourceFile, srouceParentDir, zos);
        }else {
            FileBestPractice.zipSingleDir(sourcePath, srouceParentDir, zos);
        }
        return true;
    }

    /**
     * 压缩zip单个文件
     * @param zipOutputStream
     * @return
     * @throws Exception
     */
    public static boolean zipSingleFile(File sourceFile,String srouceParentDir,ZipOutputStream zipOutputStream) throws Exception {
        byte[] byteArr = new byte[1024];
        int length;
        FileInputStream fis = new FileInputStream(sourceFile);
        ZipEntry zipEntry = new ZipEntry(FileBestPractice.getEntryName(srouceParentDir,sourceFile));
        zipOutputStream.putNextEntry(zipEntry);
        while((length = fis.read(byteArr)) != -1){
            zipOutputStream.write(byteArr,0,length);
            zipOutputStream.flush();
        }
        zipOutputStream.closeEntry();
        fis.close();
        return true;
    }

    private static String getEntryName(String dirPath, File file) {
        String dirPaths = dirPath;
        if (!dirPaths.endsWith(File.separator)) {
            dirPaths = dirPaths + File.separator;
        }
        String filePath = file.getAbsolutePath();
        // 对于目录，必须在entry名字后面加上"/"，表示它将以目录项存储
        if (file.isDirectory()) {
            filePath += "/";
        }
        int index = filePath.indexOf(dirPaths);

        return filePath.substring(index + dirPaths.length());
    }


    public static boolean zipSingleDir(String sourcePath,String desParentDir,ZipOutputStream zipOutputStream) throws Exception {
        File sourceFile = new File(sourcePath);
        File[] files = sourceFile.listFiles();
        File desDirFile = new File(desParentDir, sourceFile.getName());
        if(files.length <= 0){//若当前文件没有子目录,则创建当前目录 bb/表示文件夹 bb表示文件
            zipOutputStream.putNextEntry(new ZipEntry(desDirFile.getName()+"/"));
            zipOutputStream.closeEntry();
        }else{
            for (File file : files) {
                String nextDesDir = desDirFile.getAbsolutePath();
                if(file.isFile()){//文件
                    FileBestPractice.zipSingleFile(file, desParentDir, zipOutputStream);
                }else {//目录
                    FileBestPractice.zipSingleDir(file.getAbsolutePath(), nextDesDir, zipOutputStream);
                }
            }
        }
        return true;
    }


    /**
     * 解压文件
     * @param filePath
     * @return
     */
    public static boolean unZipFile(String filePath){
        return true;
    }

    /**
     * 删除文件
     * @return
     */
    public static boolean deleteFile(String path){
        File curFile = new File(path);
        File[] childFiles = curFile.listFiles();
        for (File childFile : childFiles) {
            if(childFile.isFile()){
                childFile.delete();
            }else{
                deleteFile(childFile.getAbsolutePath());
            }
        }
        if(curFile.exists()){
            curFile.delete();
        }
        return true;
    }

    /**
     * 文件复制
     * @param sourcePath 源文件路径
     * @param desDir 目标文件路径
     * @return
     */
    public static boolean copyFiles(String sourcePath,String desDir) throws Exception {
        File sourceFile = new File(sourcePath);
        if(sourceFile.isFile()){
            return FileBestPractice.copySingleFile(sourceFile, desDir);
        }else {
            return FileBestPractice.copySingleDir(sourcePath, desDir);
        }
    }

    /**
     * 复制单个文件
     * @param sourceFile 源文件
     * @param desDir 目标文件的目录
     * @return
     */
    private static boolean copySingleFile(File sourceFile,String desDir) throws Exception {
        //若父目录不存在,则创建父目录
        File desDirFile = new File(desDir);
        if(!desDirFile.exists()){
            desDirFile.mkdirs();
        }
        //文件复制
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(desDirFile,sourceFile.getName())));
        byte[] byteArr = new byte[1024];
        int len;
        while((len = bis.read(byteArr)) != -1){
            bos.write(byteArr,0,len);
            bos.flush();
        }
        return true;
    }

    /**
     * 复制目录
     * @param sourcePath
     * @param desDir
     * @return
     * @throws Exception
     */
    private static boolean copySingleDir(String sourcePath,String desDir) throws Exception {
        File sourceFile = new File(sourcePath);
        File desDirFile = new File(desDir, sourceFile.getName());
        File[] files = sourceFile.listFiles();
        if(files.length <= 0){//若当前文件没有子目录,则创建当前目录
            desDirFile.mkdirs();
        }else{
            for (File file : files) {
                String nextDesDir = desDirFile.getAbsolutePath();
                if(file.isFile()){//文件
                    FileBestPractice.copySingleFile(file, nextDesDir);
                }else {//目录
                    FileBestPractice.copySingleDir(file.getAbsolutePath(), nextDesDir);
                }
            }
        }
        return true;
    }

}
