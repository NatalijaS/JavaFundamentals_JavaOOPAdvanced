package _07_OpenClosedAndLiskovSubstitution_Lab._02_FileStream;

public class StreamProgressInfo {

    private BaseStream file;

    public StreamProgressInfo(BaseStream stream) {
        this.file = stream;
    }

    public int calculateCurrentPercent() {
        return (this.file.getBytesSent() * 100) / this.file.getLength();
    }
}
