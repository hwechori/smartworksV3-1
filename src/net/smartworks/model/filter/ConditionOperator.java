package net.smartworks.model.filter;

public class ConditionOperator {

	public static final String EQUAL = "=";
	public static final String NOT_EQUAL = "!=";
	public static final String CONTAIN = "like";
	public static final String NOT_CONTAIN = "not like";
	public static final String SMALLER = "<";
	public static final String SMALLER_EQUAL = "<=";
	public static final String GREATER = ">";
	public static final String GREATER_EQUAL = ">=";
	public static final String AND = "and";
	public static final String OR = "or";

	public static final String[] connectorOperators = new String[] {
		AND,
		OR
	};
	
	public static final String[] stringOperators = new String[] {
		EQUAL,
		NOT_EQUAL,
		CONTAIN,
		NOT_CONTAIN
	};
	
	public static final String[] numberOperators = new String[] {
		EQUAL,
		NOT_EQUAL,
		SMALLER,
		SMALLER_EQUAL,
		GREATER,
		GREATER_EQUAL
	};
	
	public static final String[] dateOperators = new String[] {
		EQUAL,
		NOT_EQUAL,
		SMALLER,
		SMALLER_EQUAL,
		GREATER,
		GREATER_EQUAL
	};
	
	public static String[] generalOperators = new String[] {
		EQUAL,
		NOT_EQUAL
	};

}
