package app.FileService;

import app.utils.Constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class FileReaderService {

    private String filePath;
    private File file;


    public void FileReaderMethod(String fileName) throws IOException{
        filePath = Constants.BASE_PATH + fileName ;
        file = new File(filePath);
        getOutPut(readFile());
    }

    public String readFile() throws IOException {

        FileChannel reader;
        StringBuilder builder;

        try (FileInputStream fileInputStream = new FileInputStream(file)) {
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
    public void getOutPut(String outPut){
        System.out.println(outPut);
    }
}

