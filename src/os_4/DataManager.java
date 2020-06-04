package os_4;

import java.util.ArrayList;

public class DataManager {
	public ArrayList<File> Files = new ArrayList<File>();
	private int chsize = 0;
	int fileId = -1;
	private int lastindex = 0;
	private int totalmemory = Block.n;
	private int freememory = Block.n;
	private ArrayList<Knot> knots = new ArrayList<Knot>();;

	public void CreateFile(int size) {
		chsize = 0;
		fileId = Files.size();
		if (lastindex + size > totalmemory) {
			Main.textAreaWindow.append("Невозможно добавить файл! \n");
			return;
		}
		File file = new File(fileId, size);

		int fileid = file.getId();
		for (int i = lastindex; i <= totalmemory; i++) {
			addKnot(Block.memory.get(i), fileid);
			chsize++;
			if (size == chsize) {
				lastindex += size;
				freememory = totalmemory - lastindex;
				Files.add(fileId, file);
				Main.textAreaWindow.append("Добавлен файл №" + fileId + "\n");
				Main.textAreaWindow.append("Свободно памяти:" + freememory + "\n");
				return;
			}
		}
	}

	public void DeleteFile(int id) {
		if (Files.get(id) == null) {
			Main.textAreaWindow.append("Данного файла не сущетвует! \n");
		} else {			
			int n = 0;
			removeKnots(id);
			for(int i = 0 ; i < knots.size();i++){
				if(knots.get(i).getId()!=-1){
					n = i+1;
				}
			}			
			if(knots.size() == n){
				lastindex = lastindex - Files.get(id).fileSize();
			}
			
			freememory = totalmemory - lastindex;
			
			Main.textAreaWindow.append("Удалён файл" + Main.textFieldId.getText() + "\n");
		}
		Main.textAreaWindow.append("Свободно памяти:" + freememory + "\n");

	}

	public void addKnot(Knot knot, int fileid) {
		knots.add(knot);
		knot.setFile(fileid);
	}

	public void removeKnots(int fileid) {
		for (Knot knot : knots) {
			if (knot.getId() == fileid) {
				knot.setFile(-1);
			}
		}
		knots.clear();
	}
}