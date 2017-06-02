/**
 * Generic response class used to return an object from a Rest request.
 * It is composed by two fields, the data, that contains the information requested,
 * and the erros, that contais all the error messages if any.
 * 
 * @author Marcio C. de Souza<m4rcio.souza@gmail.com>
 * @since 1.0.0
 */
package co.uk.sky.api.response;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {
	
	private T data;
	private List<String> errors = new ArrayList<String>();
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public List<String> getErrors() {
		return errors;
	}
	
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
