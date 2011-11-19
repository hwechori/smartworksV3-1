package net.smartworks.model.filter;

public class ConditionOperator {

	public static final KeyMap EQUAL = new KeyMap("=", "filter.operator.title.equal");
	public static final KeyMap NOT_EQUAL = new KeyMap("!=", "filter.operator.title.not_equal");
	public static final KeyMap CONTAIN = new KeyMap("like", "filter.operator.title.contain");
	public static final KeyMap NOT_CONTAIN = new KeyMap("not like", "filter.operator.title.not_contain");
	public static final KeyMap SMALLER = new KeyMap("<", "filter.operator.title.smaller");
	public static final KeyMap SMALLER_EQUAL = new KeyMap("<=", "filter.operator.title.smaller_equal");
	public static final KeyMap GREATER = new KeyMap(">", "filter.operator.title.greater");
	public static final KeyMap GREATER_EQUAL = new KeyMap(">=", "filter.operator.title.greater_equal");
	public static final KeyMap AND = new KeyMap("and", "filter.operator.title.and");
	public static final KeyMap OR = new KeyMap("or", "filter.operator.title.or");

	public static final KeyMap[] connectorOperators = new KeyMap[] {
		AND,
		OR
	};
	
	public static final KeyMap[] stringOperators = new KeyMap[] {
		EQUAL,
		NOT_EQUAL,
		CONTAIN,
		NOT_CONTAIN
	};
	
	public static final KeyMap[] numberOperators = new KeyMap[] {
		EQUAL,
		NOT_EQUAL,
		SMALLER,
		SMALLER_EQUAL,
		GREATER,
		GREATER_EQUAL
	};
	
	public static final KeyMap[] dateOperators = new KeyMap[] {
		EQUAL,
		NOT_EQUAL,
		SMALLER,
		SMALLER_EQUAL,
		GREATER,
		GREATER_EQUAL
	};
	
	public static KeyMap[] generalOperators = new KeyMap[] {
		EQUAL,
		NOT_EQUAL
	};

}
