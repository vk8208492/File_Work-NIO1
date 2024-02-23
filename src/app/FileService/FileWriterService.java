package app.FileService;

import app.utils.Constants;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileWriterService {

    private String filePath;

    private File file;
    public void fileWriterMethod(String fileName, String myText) throws IOException {

        filePath = Constants.BASE_PATH + fileName ;
        file = new File(filePath);
        getOutPut(writeToFile(myText));
    }

    public String writeToFile(String content) throws IOException {

        FileChannel writer;

        try (FileOutputStream fileOutputStream = new FileOutputStream(file,true)) {
            byte[] contentBytes = content.getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(contentBytes.length);
            buffer.put(contentBytes);
            writer = fileOutputStream.getChannel();
            buffer.flip();
            writer.write(buffer);
        } catch (FileNotFoundException e) {
            return e.getMessage();
        }
        writer.close();
        return "The content has been written.";
    }

    public void getOutPut(String outPut) {
        System.out.println(outPut);
    }
}
