import java.io.*;
import java.util.*;

public class DataObject implements Serializable{

	protected String message;

	DataObject(){
		message = "";
	}

	public String getMessage(){
		return message;
	}

	public void setMessage(String inMessage){
		message = inMessage;
	}
}
