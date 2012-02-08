package net.smartworks.server.engine.resource.model;

import java.util.List;

/**
 * 패키지 검색시 리턴값에 사용될 패키지 리스트
 * 
 * @author jhnam
 * @version $Id: IPackageModelList.java,v 1.1 2011/11/08 03:15:07 kmyu Exp $
 */
public interface IPackageModelList {

	/**
	 * 검색 조건에 맞는 총 패키지 개수를 리턴한다.
	 * 
	 * @return
	 */
	public int getTotalCount();
	
	/**
	 * 검색 조건에 맞는 총 패키지 개수를 설정한다.
	 * 
	 * @param totalCount
	 */
	public void setTotalCount(int totalCount);
	
	/**
	 * 검색 조건에 맞는 패키지 리스트를 리턴한다.
	 * 
	 * @return
	 */
	public List<IPackageModel> getPackageModelList();
	
	/**
	 * 검색 조건에 맞는 패키지 리스트를 설정한다.
	 * 
	 * @param packageModelList
	 */
	public void setPackageModelList(List<IPackageModel> packageModelList);
	
	/**
	 * 패키지를 추가한다.
	 * 
	 * @param packageModel
	 */
	public void addPackageModel(IPackageModel packageModel);
	
}
