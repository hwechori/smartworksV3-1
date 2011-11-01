package net.smartworks.server.service.impl;

import net.smartworks.model.instance.Instance;
import net.smartworks.server.service.ITaskInstanceService;
import net.smartworks.util.SmartTest;

import org.springframework.stereotype.Service;

@Service
public class TaskInstanceServiceImpl implements ITaskInstanceService {

	@Override
	public Instance[] getMyRunningInstances() throws Exception {
		return SmartTest.getRunningInstances();
	}

}
