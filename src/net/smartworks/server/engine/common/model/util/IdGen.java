package net.smartworks.server.engine.common.model.util;

import java.io.Serializable;

import net.smartworks.server.engine.common.model.ClassObject;
import net.smartworks.server.engine.infowork.domain.model.SwdObject;
import net.smartworks.server.engine.organization.model.SwoObject;

import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.UUIDHexGenerator;

public class IdGen extends UUIDHexGenerator {
	public IdGen() {
		super();
	}

	public Serializable generate(SessionImplementor session, Object obj) {
		if (obj instanceof SwdObject) {
			SwdObject swdObj = (SwdObject) obj;
			String objId = swdObj.getId();
			if (objId != null && objId.length() != 0)
				return objId;
		}
		if (obj instanceof SwoObject) {
			SwoObject swoObj = (SwoObject) obj;
			String objId = swoObj.getId();
			if (objId != null && objId.length() != 0)
				return objId;
		}
		if (obj instanceof ClassObject) {
			ClassObject clsObj = (ClassObject) obj;
			String objId = clsObj.getObjId();
			if (objId != null && objId.length() != 0)
				return objId;
		}
		return super.generate(session, obj);
	}
}
