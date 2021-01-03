package pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetMyResponse {
	@JsonIgnore
	private MRData MRData;
		
	public MRData getMRData() {
		return MRData;
	}

	public void setMRData(MRData mRData) {
		MRData = mRData;
	}

	public GetMyResponse() {

	}

	public GetMyResponse(MRData mRData) {
		this.MRData = mRData;
	}

	

}
