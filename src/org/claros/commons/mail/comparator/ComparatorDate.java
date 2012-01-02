package org.claros.commons.mail.comparator;

import java.util.Comparator;
import java.util.Date;

import org.claros.commons.mail.models.EmailHeader;

/**
 * @author Umut Gokbayrak
 */
public class ComparatorDate implements Comparator {
	private int left = 1;
	private int right = -1;
	
	public ComparatorDate(boolean ascending) {
		if (ascending) {
			left = -1;
			right = 1;
		}
	}

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(Object arg0, Object arg1) {
		if (arg0 != null && arg1 != null && arg0 instanceof EmailHeader && arg1 instanceof EmailHeader) {
			EmailHeader h1 = (EmailHeader)arg0;
			EmailHeader h2 = (EmailHeader)arg1;
			Date dt1 = h1.getDate();
			Date dt2 = h2.getDate();

			if (dt1 == null) {
				return right;
			} else if (dt2 == null) {
				return left;
			} else if (dt1.after(dt2)) {
				return right;
			} else if (dt1.before(dt2)) {
				return left;
			} else {
				return 0;
			}
		}
		return right;
	}
}
