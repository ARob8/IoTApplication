package beans;

import java.util.List;

public class DataFactory {
	public ResponseDataModel createDTO(int status, String message,List<Weather> data) {
		if(data == null) return null;
		else
		return new ResponseDataModel(status, message,data);
		
	}
}
