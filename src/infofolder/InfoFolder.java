package infofolder;

import java.io.File;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author HauNguyen
 */
public class InfoFolder {
    public static String convertSizeFile(float size){
        String[] units = {"B","KB","MB","GB","TB"};
        String unit = "";
        for (int i = 0;i < units.length; ++i)
        {
            if (size > 1024)
                size /= 1024;
            else
            {
                unit = units[i];
                break; // Exit loop and return result
            }
        }
        return  Math.round(size) + " " + unit;
    }
    public static void main(String[] args) {
       FileSystemView fileSystemView = FileSystemView.getFileSystemView();
       // Get some info of disk: drive name, total space, free space,...
       File[] file = File.listRoots();
       if (file != null && file.length > 0)
       {
           for(File drive: file)
           {
               System.out.println("Drive name: " + drive);
               System.out.println("\t\tType disk: " + fileSystemView.getSystemTypeDescription(drive));
               System.out.println("\t\tTotal disk: " + convertSizeFile(drive.getTotalSpace()));
               System.out.println("\t\tFree space: " + convertSizeFile(drive.getFreeSpace()));
           }
       } 
    }
}
