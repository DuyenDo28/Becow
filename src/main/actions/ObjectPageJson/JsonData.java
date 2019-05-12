
package ObjectPageJson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonData {

	@SerializedName("NewProductMsg")
	@Expose
	private NewProductMsg newProductMsg;

	public NewProductMsg NewProductMsgPageJson() {
		return newProductMsg;
	}
	
	@SerializedName("ExpectedNewProductMsg")
	@Expose
	private ExpectedNewProductMsg expectedMsg;

	public ExpectedNewProductMsg  NewProductExpectedMsgPage() {
		return expectedMsg;
	}

}
