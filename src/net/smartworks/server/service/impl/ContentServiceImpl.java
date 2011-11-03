package net.smartworks.server.service.impl;

import net.smartworks.model.instance.Instance;
import net.smartworks.server.service.IContentService;
import net.smartworks.util.SmartTest;

import org.springframework.stereotype.Service;

@Service
public class ContentServiceImpl implements IContentService {

	@Override
	public Instance getInstanceById(String instanceId) throws Exception {
		Instance[] instances = new Instance[] { SmartTest.getWorkInstance1(), SmartTest.getWorkInstance2(), SmartTest.getWorkInstance3(),
				SmartTest.getWorkInstance4(), SmartTest.getWorkInstance5(), SmartTest.getTaskInstanceIA(), SmartTest.getTaskInstanceIF(),
				SmartTest.getTaskInstancePA(), SmartTest.getTaskInstancePF(), SmartTest.getTaskInstanceSA(), SmartTest.getTaskInstanceSF(),
				SmartTest.getTaskInstanceAA(), SmartTest.getTaskInstanceAF() };
		for (Instance instance : instances) {
			if (instance.getId().equals(instanceId))
				return instance;
		}
		return null;
	}

}
