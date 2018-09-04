package _07_OpenClosedAndLiskovSubstitution_Lab._02_FileStream;

public class Music extends BaseStream {

    private String artist;
    private String album;
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
