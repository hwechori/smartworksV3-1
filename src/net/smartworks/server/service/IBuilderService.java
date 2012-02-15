package net.smartworks.server.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface IBuilderService {

	public abstract void startWorkService(String workId) throws Exception;

	public abstract void stopWorkService(String workId) throws Exception;

	public abstract void startWorkEditing(String workId) throws Exception;

	public abstract void stopWorkEditing(String workId) throws Exception;

	public abstract void setWorkSettings(Map<String, Object> requestBody, HttpServletRequest request) throws Exception;

	public abstract void publishWorkToStore(Map<String, Object> requestBody, HttpServletRequest request) throws Exception;
}