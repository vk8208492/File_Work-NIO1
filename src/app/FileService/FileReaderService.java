package app.FileService;

import app.utils.Constants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class FileReaderService {

    private static final String BASE_PATH = "files/";

    public void FileReaderMethod(String filePath) throws IOException{
        filePath = BASE_PATH + "Information";
        getOutPut(readFile(filePath));
    }

    public static String readFile(String filePath) throws IOException  {

        FileChannel reader;
        StringBuilder builder;

        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            reader = fileInputStream.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(360);
            builder = new StringBuilder();
            while (reader.read(buffer) != -1){
                buffer.flip();
                builder.append(Charset.defaultCharset().decode(buffer));
                buffer.clear();
            }
        } catch (FileNotFoundException e){
            return  e.getMessage();
        }
        reader.close();
        return builder.toString();
    }
    public static void getOutPut(String outPut){
        System.out.println(outPut);
    }
}

