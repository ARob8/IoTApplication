package beans;

import java.util.List;

public class ResponseDataModel extends ResponseModel implements DataInterface {
	List<Weather> data;

	
	public ResponseDataModel(List<Weather> data) {
		super();
		this.data = data;
	}
	public ResponseDataModel(int status, String message, List<Weather> data) {
		super(status, message);
		this.data = data;
	}

	public List<Weather> getData() {
		return this.data;
	}

	public void setDatas(List<Weather> data) {
		this.data = data;
	}
}
