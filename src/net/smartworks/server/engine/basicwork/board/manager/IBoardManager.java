/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 16.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.engine.basicwork.board.manager;

import net.smartworks.server.engine.basicwork.board.exception.BoardException;
import net.smartworks.server.engine.basicwork.board.model.Board;
import net.smartworks.server.engine.basicwork.board.model.BoardCond;
import net.smartworks.server.engine.common.manager.IManager;

public interface IBoardManager extends IManager {

	public Board getBoard(String user, String id, String level) throws BoardException;
	public Board getBoard(String user, BoardCond cond, String level) throws BoardException;
	public void setBoard(String user, Board obj, String level) throws BoardException;
	public void createBoard(String user, Board obj) throws BoardException;
	public void removeBoard(String user, String id) throws BoardException;
	public void removeBoard(String user, BoardCond cond) throws BoardException;
	public long getBoardSize(String user, BoardCond cond) throws BoardException;
	public Board[] getBoards(String user, BoardCond cond, String level) throws BoardException;

}