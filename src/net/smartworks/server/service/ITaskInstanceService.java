package net.smartworks.server.service;

import net.smartworks.model.instance.Instance;

public interface ITaskInstanceService {

	Instance[] getMyRunningInstances() throws Exception;
}
