package _07_OpenClosedAndLiskovSubstitution_Lab._02_FileStream;

public abstract class BaseStream implements Streamable {

    private String name;
    private int length;
    private int bytesSent;
}
