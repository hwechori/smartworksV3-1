package net.smartworks.server.service.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.smartworks.model.community.User;
import net.smartworks.server.engine.authority.manager.ISwaManager;
import net.smartworks.server.engine.authority.model.SwaResource;
import net.smartworks.server.engine.authority.model.SwaResourceCond;
import net.smartworks.server.engine.category.manager.ICtgManager;
import net.smartworks.server.engine.category.model.CtgCategory;
import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.infowork.domain.manager.ISwdManager;
import net.smartworks.server.engine.infowork.form.manager.ISwfManager;
import net.smartworks.server.engine.infowork.form.model.SwfForm;
import net.smartworks.server.engine.infowork.form.model.SwfFormCond;
import net.smartworks.server.engine.pkg.manager.IPkgManager;
import net.smartworks.server.engine.pkg.model.PkgPackage;
import net.smartworks.server.engine.pkg.model.PkgPackageCond;
import net.smartworks.server.engine.resource.manager.IResourceDesigntimeManager;
import net.smartworks.server.engine.resource.manager.SmartServerManager;
import net.smartworks.server.engine.resource.model.IProcessModel;
import net.smartworks.server.service.IBuilderService;
import net.smartworks.util.LocalDate;
import net.smartworks.util.SmartUtil;

import org.springframework.stereotype.Service;

@Service
public class BuilderServiceImpl implements IBuilderService {

	private ISwdManager getSwdManager() {
		return SwManagerFactory.getInstance().getSwdManager();
	}
	private IPkgManager getPkgManager() {
		return SwManagerFactory.getInstance().getPkgManager();
	}
	@Override
	public void startWorkService(String workId) throws Exception {

		try{
			User cuser = SmartUtil.getCurrentUser();
			String userId = null;
			String compId = null;
			if (cuser != null) {
				userId = cuser.getId();
				compId = cuser.getCompanyId();
			}	
			String packageId = workId;
			
			PkgPackageCond pkgCond = new PkgPackageCond();
			pkgCond.setPackageId(packageId);
			PkgPackage pkg = getPkgManager().getPackage(userId, pkgCond, IManager.LEVEL_LITE);
			if (pkg == null)
				throw new Exception("Not Exist Package(Work) - workId : " + workId);
			
			String type = pkg.getType();
			
			//default 권한
			String receId = null;
			LocalDate date = new LocalDate();
			if (packageId != null) {
				if (type.equals("SINGLE")){
					ISwfManager swfMgr = SwManagerFactory.getInstance().getSwfManager();
					SwfFormCond swfCond = new SwfFormCond();
					swfCond.setPackageId(packageId);
					SwfForm[] swfObj = swfMgr.getForms(userId, swfCond, "all");
					if (swfObj != null) {
					receId = swfObj[0].getId();
					}
				} else {
					IResourceDesigntimeManager rscMgr1 = SwManagerFactory.getInstance().getDesigntimeManager();
					IProcessModel prcModel = rscMgr1.retrieveProcessByPackage(userId, packageId, 1);
					if (prcModel != null) {
					receId = prcModel.getProcessId();
					}
				}
				if (receId != null) {
					ISwaManager swaMgr = SwManagerFactory.getInstance().getSwaManager();
					SwaResourceCond swaCond = new SwaResourceCond();
					swaCond.setResourceId(receId);
					SwaResource[] swaObj = swaMgr.getResources(userId, swaCond, "all");
					if (swaObj == null){
						SwaResource swaobjs = new SwaResource();
						//R
						swaobjs.setResourceId(receId);
						swaobjs.setType(0);
						swaobjs.setMode("R");
						swaobjs.setPermission("PUB_ALL");
						swaobjs.setCreationUser(userId);
						swaobjs.setModificationUser(userId);
						swaobjs.setCompanyId(compId);
						swaobjs.setCreationDate(date);
						swaobjs.setModificationDate(date);
						SwManagerFactory.getInstance().getSwaManager().setResource(userId, swaobjs, null);
						//W
						SwaResource swaobjs1 = new SwaResource();
						swaobjs1.setResourceId(receId);
						swaobjs1.setType(0);
						swaobjs1.setMode("W");
						swaobjs1.setPermission("PUB_ALL");
						swaobjs1.setCreationUser(userId);
						swaobjs1.setModificationUser(userId);
						swaobjs1.setCompanyId(compId);
						swaobjs1.setCreationDate(date);
						swaobjs1.setModificationDate(date);
						SwManagerFactory.getInstance().getSwaManager().setResource(userId, swaobjs1, null);
						//M
						SwaResource swaobjs2 = new SwaResource();
						swaobjs2.setResourceId(receId);
						swaobjs2.setType(0);
						swaobjs2.setMode("M");
						swaobjs2.setPermission("PUB_NO");
						swaobjs2.setCreationUser(userId);
						swaobjs2.setModificationUser(userId);
						swaobjs2.setCompanyId(compId);
						swaobjs2.setCreationDate(date);
						swaobjs2.setModificationDate(date);
						SwManagerFactory.getInstance().getSwaManager().setResource(userId, swaobjs2, null);
						//D
						SwaResource swaobjs3 = new SwaResource();
						swaobjs3.setResourceId(receId);
						swaobjs3.setType(0);
						swaobjs3.setMode("D");
						swaobjs3.setPermission("PUB_NO");
						swaobjs3.setCreationUser(userId);
						swaobjs3.setModificationUser(userId);
						swaobjs3.setCompanyId(compId);
						swaobjs3.setCreationDate(date);
						swaobjs3.setModificationDate(date);
						SwManagerFactory.getInstance().getSwaManager().setResource(userId, swaobjs3, null);
					}
				}
			}
			SwManagerFactory.getInstance().getDesigntimeManager().deployPackage(userId, compId, packageId, 1);
			
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}		
	}

	@Override
	public void stopWorkService(String workId) throws Exception {
		try{
			User cuser = SmartUtil.getCurrentUser();
			String userId = null;
			if (cuser != null)
				userId = cuser.getId();
			SwManagerFactory.getInstance().getDesigntimeManager().undeployPackage(userId, workId, 1);
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}		
	}

	@Override
	public void startWorkEditing(String workId) throws Exception {
		try{
			User cuser = SmartUtil.getCurrentUser();
			String userId = null;
			if (cuser != null)
				userId = cuser.getId();
			SwManagerFactory.getInstance().getDesigntimeManager().checkOutPackage(userId, workId, 1);
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}		
	}

	@Override
	public void stopWorkEditing(String workId) throws Exception {
		try{
			User cuser = SmartUtil.getCurrentUser();
			String userId = null;
			if (cuser != null)
				userId = cuser.getId();
			SwManagerFactory.getInstance().getDesigntimeManager().checkInPackage(userId, workId, 1);
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}		
	}

	@Override
	public void setWorkSettings(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {

		try{
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}
	}

	@Override
	public void publishWorkToStore(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {

		try{
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}
	}

	@Override
	public void createNewCategory(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		//{frmNewWorkCategroy={txtCategoryName=test, txtCategoryDesc=}}
		try{
			Map<String, Object> frmNewWorkCategory = (Map<String, Object>)requestBody.get("frmNewWorkCategroy");
			
			User cuser = SmartUtil.getCurrentUser();
			String userId = null;
			String compId = null;
			if (cuser != null) {
				userId = cuser.getId();
				compId = cuser.getCompanyId();
			}

			//String parentCategoryId = request.getParameter("parentCategoryId");
			String parentCategoryId = "_PKG_ROOT_";
			String name = (String)frmNewWorkCategory.get("txtCategoryName");
			String desc = (String)frmNewWorkCategory.get("txtCategoryDesc");
		
			CtgCategory ctg = new CtgCategory();
			ctg.setCompanyId(compId);
			ctg.setName(name);
			ctg.setDescription(desc);
			ctg.setParentId(parentCategoryId);
			ctg.setDisplayOrder(1);
			//ICategoryModel category = catMgr.createCategory(userId, parentCategoryId, name, desc);
			CtgCategory category = SwManagerFactory.getInstance().getCtgManager().createCategory(userId, ctg);
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}
	}

	@Override
	public void setCategory(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		//{categoryId=402880eb359835ed013598367d080001, frmNewWorkCategroy={txtCategoryName=test a, txtCategoryDesc=a}}
		try{
			Map<String, Object> frmNewWorkCategory = (Map<String, Object>)requestBody.get("frmNewWorkCategroy");
			
			User cuser = SmartUtil.getCurrentUser();
			String userId = null;
			String compId = null;
			if (cuser != null) {
				userId = cuser.getId();
				compId = cuser.getCompanyId();
			}

			String categoryId = (String)requestBody.get("categoryId");
			String name = (String)frmNewWorkCategory.get("txtCategoryName");
			String desc = (String)frmNewWorkCategory.get("txtCategoryDesc");
			
			ICtgManager categoryMgr = SwManagerFactory.getInstance().getCtgManager();
			CtgCategory category = categoryMgr.getCategory(userId, categoryId, IManager.LEVEL_ALL);
			if (category == null)
				return;
			category.setName(name);
			category.setDescription(desc);
			//ICategoryModel category = catMgr.createCategory(userId, parentCategoryId, name, desc);
			categoryMgr.setCategory(userId, category, IManager.LEVEL_ALL);
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}
	}

	@Override
	public void removeCategory(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		//{categoryId=402880eb359835ed013598367d080001}
		try{
			String categoryId = (String)requestBody.get("categoryId");
			User cuser = SmartUtil.getCurrentUser();
			String userId = null;
			String compId = null;
			if (cuser != null) {
				userId = cuser.getId();
				compId = cuser.getCompanyId();
			}
			
			//삭제하기 전에 실행되고 있는 패키지가 속한 카테고리는 삭제 할수 없다
			PkgPackageCond cond = new PkgPackageCond();
			cond.setCompanyId(compId);
			cond.setCategoryId(categoryId);
			long pkgCount = getPkgManager().getPackageSize(userId, cond);
			
			if (pkgCount > 0)
				throw new Exception("Delete Category(" +categoryId+ ") failed - Exist Sub Packages!" );
			
			ICtgManager categoryMgr = SwManagerFactory.getInstance().getCtgManager();
			categoryMgr.removeCategory(userId, categoryId);
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}
	}

	@Override
	public void createNewWorkDefinition(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		try{
			System.out.println(requestBody);
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}
	}

	@Override
	public void setWorkDefinition(Map<String, Object> requestBody, HttpServletRequest request) throws Exception {
		try{
			System.out.println(requestBody);
		}catch (Exception e){
			// Exception Handling Required
			e.printStackTrace();
			// Exception Handling Required			
		}
	}
}