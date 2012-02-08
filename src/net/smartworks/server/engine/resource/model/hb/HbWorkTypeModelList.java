package net.smartworks.server.engine.resource.model.hb;

import java.util.ArrayList;
import java.util.List;

import net.smartworks.server.engine.resource.model.IWorkTypeModel;
import net.smartworks.server.engine.resource.model.IWorkTypeModelList;

/**
 * IWorkTypeModelList
 * 
 * @author jhnam
 * @version $Id: HbWorkTypeModelList.java,v 1.1 2011/11/08 03:15:01 kmyu Exp $
 */
public class HbWorkTypeModelList implements IWorkTypeModelList {

	/**
	 * 총 개수
	 */
	private int totalCount = 0;
	/**
	 * 워크 타입 모델 리스트
	 */
	private List<IWorkTypeModel> workTypeModelList;
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IWorkTypeModelList#addWorkTypeModel(com.maninsoft.smart.server.model.IWorkTypeModel)
	 */
	public void addWorkTypeModel(IWorkTypeModel workTypeModel) {
		
		if(this.workTypeModelList == null)
			this.workTypeModelList = new ArrayList<IWorkTypeModel>();
		
		this.workTypeModelList.add(workTypeModel);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IWorkTypeModelList#getTotalCount()
	 */
	public int getTotalCount() {
		return this.totalCount;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IWorkTypeModelList#getWokrTypeModelList()
	 */
	public List<IWorkTypeModel> getWokrTypeModelList() {
		return this.workTypeModelList;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IWorkTypeModelList#setTotalCount(int)
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IWorkTypeModelList#setWorkTypeModelList(java.util.List)
	 */
	public void setWorkTypeModelList(List<IWorkTypeModel> workTypeModelList) {
		this.workTypeModelList = workTypeModelList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public String toString() {
		
		StringBuffer buffer = new StringBuffer("<Result status=\"OK\" totalCount=\"" + this.totalCount + "\">");
		
		try {
			if(this.workTypeModelList != null)
				for(IWorkTypeModel workModel : this.workTypeModelList)
					buffer.append(workModel);
			
		} catch (Exception e) {
			return "";
		}
		
		buffer.append("</Result>");
		return buffer.toString();
	}
}
