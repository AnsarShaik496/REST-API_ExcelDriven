import java.io.IOException;
import java.util.ArrayList;

public class testSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

//		dataDrivenRahulShetty d=new dataDrivenRahulShetty();
		PracticeExcelAnsar d = new PracticeExcelAnsar();
//		DataValues cellData = new DataValues();
	ArrayList<String> data=d.getData("testdata","DeleteProfile");
	
	String data1_value = data.get(2);
	System.out.println("Printing Specified value == "+data1_value);
	
	System.out.println(data.get(0));
	System.out.println(data.get(1));
	System.out.println(data.get(2));
	System.out.println(data.get(3));

	
		
	}

}
