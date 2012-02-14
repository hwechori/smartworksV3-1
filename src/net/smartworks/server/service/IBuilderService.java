package net.smartworks.server.service;

public interface IBuilderService {

	public abstract void startWorkService(String workId) throws Exception;

	public abstract void stopWorkService(String workId) throws Exception;

	public abstract void startWorkEditing(String workId) throws Exception;

	public abstract void stopWorkEditing(String workId) throws Exception;

}