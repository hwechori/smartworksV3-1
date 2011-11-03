package net.smartworks.server.service;

import net.smartworks.model.instance.Instance;

public interface IContentService {

	Instance getInstanceById(String instanceId) throws Exception;

}
