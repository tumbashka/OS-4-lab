package os_4;

import java.util.ArrayList;

public class File {
	private int fileSize;
	private int fileId;
	private Knot knots;

	public File(int fileId, int fileSize) {
		this.fileId = fileId;
		this.fileSize = fileSize;
	}

	public Knot getKnot() {
		return knots.nextKnot();
	}
	
	public int getId() {
		return fileId;
	}

	public int fileSize() {
		return fileSize;
	}
}