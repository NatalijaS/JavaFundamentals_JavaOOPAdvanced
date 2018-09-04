package _07_OpenClosedAndLiskovSubstitution_Lab._02_FileStream;

public class File extends BaseStream {

    private String name;
    private int length;
    private int bytesSent;

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public int getBytesSent() {
        return bytesSent;
    }
}
