package Ex1;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Functions_GUI implements functions{

	 ArrayList<function> allFunctions;

	public Functions_GUI() {
		this.allFunctions = new ArrayList<>();
	}


	@Override
	public boolean add(function arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends function> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<function> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	//BufferReader code from: https://stackoverflow.com/questions/4716503/reading-a-plain-text-file-in-java
	public void initFromFile(String file) throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = br.readLine();

			while (line != null) {
				String[] functions = line.split("\n");
				for (int i = 0; i < functions.length; i++) 
					this.allFunctions.add(new ComplexFunction().initFromString(functions[i]));
			}
		}	
	}

	@Override
	public void saveToFile(String file) throws IOException {
		String content = "";
		for (int i = 0; i < allFunctions.size(); i++) {
			content += allFunctions.get(i).toString() + "\n";
		}
		System.out.println(content);
		FileOutputStream fos = new FileOutputStream(file);
		DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
		outStream.writeUTF(content);
		outStream.close();
	}

	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawFunctions(String json_file) {
		// TODO Auto-generated method stub

	}

	
	public static void main(String[] args) throws IOException {
		Functions_GUI a = new Functions_GUI();
		a.allFunctions.add(new Polynom("3.1 +2.4x^2 -x^4"));
		a.saveToFile("/home/dor/file.txt");
	}


}
