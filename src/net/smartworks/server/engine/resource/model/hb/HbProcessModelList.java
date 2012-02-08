package net.smartworks.server.engine.resource.model.hb;

import java.util.ArrayList;
import java.util.List;

import net.smartworks.server.engine.resource.model.IProcessModel;
import net.smartworks.server.engine.resource.model.IProcessModelList;

/**
 * IProcessModelList 구현
 * 
 * @author jhnam
 * @version $Id: HbProcessModelList.java,v 1.1 2011/11/08 03:15:04 kmyu Exp $
 */
public class HbProcessModelList implements IProcessModelList {

	/**
	 * 총 개수
	 */
	private int totalCount = 0;
	/**
	 * 패키지 모델 리스트
	 */
	private List<IProcessModel> processModelList;
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IProcessModelList#addProcessModel(com.maninsoft.smart.server.model.IProcessModel)
	 */
	public void addProcessModel(IProcessModel processModel) {
		
		if(this.processModelList == null)
			this.processModelList = new ArrayList<IProcessModel>();
		
		this.processModelList.add(processModel);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IProcessModelList#getProcessModelList()
	 */
	public List<IProcessModel> getProcessModelList() {
		return this.processModelList;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IProcessModelList#getTotalCount()
	 */
	public int getTotalCount() {
		return this.totalCount;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IProcessModelList#setProcessModelList(java.util.List)
	 */
	public void setProcessModelList(List<IProcessModel> processModelList) {
		this.processModelList = processModelList;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IProcessModelList#setTotalCount(int)
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
			if(this.processModelList != null)
				for(IProcessModel prcModel : this.processModelList)
					buffer.append(prcModel);
			
		} catch (Exception e) {
			return "";
		}
		
		buffer.append("</Result>");
		return buffer.toString();
	}
	
}
