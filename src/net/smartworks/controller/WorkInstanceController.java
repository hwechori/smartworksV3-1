/*	
 * $Id: WorkInstanceController.java,v 1.1 2011/10/29 00:34:23 ysjung Exp $
 * created by    : SHIN HYUN SEONG
 * creation-date : 2011. 10. 15.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.smartworks.model.community.Group;
import net.smartworks.service.ISmartWorks;
import net.smartworks.util.SmartUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WorkInstanceController {

	ISmartWorks smartworks;

	@Autowired
	public void setSmartworks(ISmartWorks smartworks) {
		this.smartworks = smartworks;
	}

	@RequestMapping("/iwork_space")
	public ModelAndView iworkSpace(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request,
				"jsp/content/work/space/iwork_space.jsp", "iwork_space.tiles");
	}

	@RequestMapping("/pwork_space")
	public ModelAndView pworkSpace(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request,
				"jsp/content/work/space/pwork_space.jsp", "pwork_space.tiles");
	}

	@RequestMapping("/swork_space")
	public ModelAndView sworkSpace(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request,
				"jsp/content/work/space/swork_space.jsp", "swork_space.tiles");
	}

	@RequestMapping("/board_space")
	public ModelAndView boardSpace(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request,
				"jsp/content/work/space/board_space.jsp", "board_space.tiles");
	}

	@RequestMapping("/event_space")
	public ModelAndView eventSpace(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request,
				"jsp/content/work/space/event_space.jsp", "event_space.tiles");
	}

	@RequestMapping("/file_space")
	public ModelAndView fileSpace(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request,
				"jsp/content/work/space/file_space.jsp", "file_space.tiles");
	}

	@RequestMapping("/image_space")
	public ModelAndView imageSpace(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request,
				"jsp/content/work/space/image_space.jsp", "image_space.tiles");
	}

	@RequestMapping("/memo_space")
	public ModelAndView memoSpace(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request,
				"jsp/content/work/space/memo_space.jsp", "memo_space.tiles");
	}

	@RequestMapping("/mail_space")
	public ModelAndView mailSpace(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request,
				"jsp/content/work/space/mail_space.jsp", "mail_space.tiles");
	}

	@RequestMapping("/new_file")
	public ModelAndView newFile(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request,
				"jsp/content/work/start/new_file.jsp", "");
	}

	@RequestMapping("/new_event")
	public ModelAndView newEvent(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request,
				"jsp/content/work/start/new_event.jsp", "");
	}

	@RequestMapping("/new_memo")
	public ModelAndView newMemo(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request,
				"jsp/content/work/start/new_memo.jsp", "");
	}

	@RequestMapping("/new_board")
	public ModelAndView newBoard(HttpServletRequest request,
			HttpServletResponse response) {

		return SmartUtil.returnMnv(request,
				"jsp/content/work/start/new_board.jsp", "");
	}

	@RequestMapping("/create_new_iwork")
	public ModelAndView createNewIwork(HttpServletRequest request, HttpServletResponse response) {
		try {
			smartworks.setInformationWorkInstance(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("");
	}

	@RequestMapping("/start_new_pwork")
	public ModelAndView startNewPwork(HttpServletRequest request, HttpServletResponse response) {
		try {
			smartworks.startProcessWorkInstance(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("");
	}

	@RequestMapping("/upload_new_file")
	public ModelAndView uploadNewFile(HttpServletRequest request, HttpServletResponse response) {
		try {
			smartworks.setFileInstance(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("");
	}

	@RequestMapping("/create_new_event")
	public ModelAndView createNewEvent(HttpServletRequest request, HttpServletResponse response) {
		try {
			smartworks.setEventInstance(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("");
	}

	@RequestMapping("/create_new_memo")
	public ModelAndView createNewMemo(HttpServletRequest request, HttpServletResponse response) {
		try {
			smartworks.setMemoInstance(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("");
	}

	@RequestMapping("/create_new_board")
	public ModelAndView createNewBoard(HttpServletRequest request, HttpServletResponse response) {
		try {
			smartworks.setBoardInstance(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("");
	}

}