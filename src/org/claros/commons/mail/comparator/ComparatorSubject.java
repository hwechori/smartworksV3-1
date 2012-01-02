package org.claros.commons.mail.comparator;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

import org.claros.commons.mail.models.EmailHeader;

public class ComparatorSubject implements Comparator {
	private int left = 1;
	private int right = -1;
	private Collator coll;
	
	public ComparatorSubject(boolean ascending, Locale loc) {
		if (ascending) {
			left = -1;
			right = 1;
		}
		coll = Collator.getInstance(loc);
	}

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(Object arg0, Object arg1) {
		if (arg0 != null && arg1 != null && arg0 instanceof EmailHeader && arg1 instanceof EmailHeader) {
			EmailHeader h1 = (EmailHeader)arg0;
			EmailHeader h2 = (EmailHeader)arg1;
			String str1 = h1.getSubject();
			String str2 = h2.getSubject();
			
			if (str1 == null) {
				return right;
			} else if (str2 == null) {
				return left;
			} else if (coll.compare(str1, str2) > 0) {
				return right;
			} else if (coll.compare(str1, str2) < 0) {
				return left;
			} else {
				return 0;
			}
		}
		return right;
	}
}
