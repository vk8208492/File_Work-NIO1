package app.FileService;

import app.utils.Constants;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileWriterService {

    static String content;
    static String filePath;

    public static void fileWriterMethod(String content, String filePath) throws IOException {
        content = "The capital of France is Paris.\n" +
                "The capital of the Great Britain is London.";
        filePath = Constants.BASE_PATH_IN + "Information";
        getOutPut(writeToFile(content, filePath));
    }

    public static String writeToFile(String content, String filePath) throws IOException {

        FileChannel writer;

        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
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

    public static void getOutPut(String outPut) {
        System.out.println(outPut);
    }
}
