package net.smartworks.server.engine.resource.model;

import java.util.List;

/**
 * 워크 타입 검색시 리턴값에 사용될 워크 타입 리스트 
 * 
 * @author jhnam
 * @version $Id: IWorkTypeModelList.java,v 1.1 2011/11/08 03:15:09 kmyu Exp $
 */
public interface IWorkTypeModelList {

	/**
	 * 검색 조건에 맞는 총 워크타입 개수를 리턴한다.
	 * 
	 * @return
	 */
	public int getTotalCount();
	
	/**
	 * 검색 조건에 맞는 총 워크타입 개수를 설정한다.
	 * 
	 * @param totalCount
	 */
	public void setTotalCount(int totalCount);
	
	/**
	 * 검색 조건에 맞는 워크타입 리스트를 리턴한다.
	 * 
	 * @return
	 */
	public List<IWorkTypeModel> getWokrTypeModelList();
	
	/**
	 * 검색 조건에 맞는 워크타입 리스트를 설정한다.
	 * 
	 * @param workTypeModelList
	 */
	public void setWorkTypeModelList(List<IWorkTypeModel> workTypeModelList);
	
	/**
	 * 워크타입을 추가한다.
	 * 
	 * @param workTypeModel
	 */
	public void addWorkTypeModel(IWorkTypeModel workTypeModel);
	
}
