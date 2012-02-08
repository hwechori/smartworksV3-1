package net.smartworks.server.engine.resource.model.hb;

import java.util.ArrayList;
import java.util.List;

import net.smartworks.server.engine.resource.model.IFormModel;
import net.smartworks.server.engine.resource.model.IFormModelList;

/**
 * IFormModelList 구현
 * 
 * @author jhnam
 * @version $Id: HbFormModelList.java,v 1.1 2011/11/08 03:15:02 kmyu Exp $
 */
public class HbFormModelList implements IFormModelList {

	/**
	 * 총 개수
	 */
	private int totalCount = 0;
	/**
	 * 패키지 모델 리스트
	 */
	private List<IFormModel> formModelList;
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormModelList#addFormModel(com.maninsoft.smart.server.model.IFormModel)
	 */
	public void addFormModel(IFormModel formModel) {
		
		if(this.formModelList == null)
			this.formModelList = new ArrayList<IFormModel>();
		
		this.formModelList.add(formModel);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormModelList#getFormModelList()
	 */
	public List<IFormModel> getFormModelList() {
		return this.formModelList;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormModelList#getTotalCount()
	 */
	public int getTotalCount() {
		return this.totalCount;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormModelList#setFormModelList(java.util.List)
	 */
	public void setFormModelList(List<IFormModel> formModelList) {
		this.formModelList = formModelList;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormModelList#setTotalCount(int)
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public String toString() {
		
		StringBuffer buffer = new StringBuffer("<Result status=\"OK\" totalCount=\"" + this.totalCount + "\">");
		
		try {
			if(this.formModelList != null)
				for(IFormModel frmModel : this.formModelList)
					buffer.append(frmModel);
			
		} catch (Exception e) {
			return "";
		}
		
		buffer.append("</Result>");
		return buffer.toString();
	}
	
}
