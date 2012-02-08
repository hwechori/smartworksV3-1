package net.smartworks.server.engine.resource.model;

import java.util.List;

/**
 * 폼 검색시 리턴값에 사용될 폼 리스트
 * 
 * @author jhnam
 * @version $Id: IFormModelList.java,v 1.1 2011/11/08 03:15:10 kmyu Exp $
 */
public interface IFormModelList {

	/**
	 * 검색 조건에 맞는 총 폼 개수를 리턴한다.
	 * 
	 * @return
	 */
	public int getTotalCount();
	
	/**
	 * 검색 조건에 맞는 총 폼 개수를 설정한다.
	 * 
	 * @param totalCount
	 */
	public void setTotalCount(int totalCount);
	
	/**
	 * 검색 조건에 맞는 폼 리스트를 리턴한다.
	 * 
	 * @return
	 */
	public List<IFormModel> getFormModelList();
	
	/**
	 * 검색 조건에 맞는 폼 리스트를 설정한다.
	 * 
	 * @param formModelList
	 */
	public void setFormModelList(List<IFormModel> formModelList);
	
	/**
	 * 폼을 추가한다.
	 * 
	 * @param formModel
	 */
	public void addFormModel(IFormModel formModel);
	
}
