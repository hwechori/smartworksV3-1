package net.smartworks.server.engine.resource.model;

import java.util.List;

/**
 * 프로세스 검색시 리턴값에 사용될 프로세스 리스트 
 * 
 * @author jhnam
 * @version $Id: IProcessModelList.java,v 1.1 2011/11/08 03:15:07 kmyu Exp $
 */
public interface IProcessModelList {

	/**
	 * 검색 조건에 맞는 총 프로세스 개수를 리턴한다.
	 * 
	 * @return
	 */
	public int getTotalCount();
	
	/**
	 * 검색 조건에 맞는 총 프로세스 개수를 설정한다.
	 * 
	 * @param totalCount
	 */
	public void setTotalCount(int totalCount);
	
	/**
	 * 검색 조건에 맞는 프로세스 리스트를 리턴한다.
	 * 
	 * @return
	 */
	public List<IProcessModel> getProcessModelList();
	
	/**
	 * 검색 조건에 맞는 프로세스 리스트를 설정한다.
	 * 
	 * @param processModelList
	 */
	public void setProcessModelList(List<IProcessModel> processModelList);
	
	/**
	 * 프로세스를 추가한다.
	 * 
	 * @param processModel
	 */
	public void addProcessModel(IProcessModel processModel);
	
}
