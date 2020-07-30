import java.io.Serializable;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;


class SampleObject implements Serializable {
	private Integer id;
//    public Integer pubIntField = 33;
	private Integer privIntField = 22;
    public String str = "HelloWorld";
	
	public SampleObject(Integer id) {
		this.id = id;
	}
	public Integer gerPrivateIntField() {
	    return privIntField;
	}
}
class AnotherSampleObject implements Serializable {
//    public String str = "HelloWorld";
	private String strtr = "HelloAisekle";
	
	public String getStrtr() {
	    return strtr;
	}
}

public class First {
	
    public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("File2DifferentObjects.data");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(new SampleObject(1));
//		oos.write(1);
		oos.writeObject(new AnotherSampleObject());		
		oos.flush();
		oos.close();
	}
}