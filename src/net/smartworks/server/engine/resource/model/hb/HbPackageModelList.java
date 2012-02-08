package net.smartworks.server.engine.resource.model.hb;

import java.util.ArrayList;
import java.util.List;

import net.smartworks.server.engine.resource.model.IPackageModel;
import net.smartworks.server.engine.resource.model.IPackageModelList;

/**
 * IPackageModelList 구현
 * 
 * @author jhnam
 * @version $Id: HbPackageModelList.java,v 1.1 2011/11/08 03:15:02 kmyu Exp $
 */
public class HbPackageModelList implements IPackageModelList {

	/**
	 * 총 개수
	 */
	private int totalCount = 0;
	/**
	 * 패키지 모델 리스트
	 */
	private List<IPackageModel> packageModelList;
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IPackageModelList#addPackageModel(com.maninsoft.smart.server.model.IPackageModel)
	 */
	public void addPackageModel(IPackageModel packageModel) {
		
		if(this.packageModelList == null)
			this.packageModelList = new ArrayList<IPackageModel>();
		
		this.packageModelList.add(packageModel);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IPackageModelList#getPackageModelList()
	 */
	public List<IPackageModel> getPackageModelList() {
		return this.packageModelList;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IPackageModelList#getTotalCount()
	 */
	public int getTotalCount() {
		return this.totalCount;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IPackageModelList#setPackageModelList(java.util.List)
	 */
	public void setPackageModelList(List<IPackageModel> packageModelList) {
		this.packageModelList = packageModelList;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IPackageModelList#setTotalCount(int)
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
			if(this.packageModelList != null)
				for(IPackageModel pkgModel : this.packageModelList)
					buffer.append(pkgModel);
			
		} catch (Exception e) {
			return "";
		}
		
		buffer.append("</Result>");
		return buffer.toString();
	}
	
}
