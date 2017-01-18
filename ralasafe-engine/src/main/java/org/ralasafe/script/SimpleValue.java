/**
 * Copyright (c) 2004-2011 Wang Jinbao(Julian Wong), http://www.ralasafe.com
 * Licensed under the MIT license: http://www.opensource.org/licenses/mit-license.php
 */
package org.ralasafe.script;

import org.ralasafe.RalasafeException;
import org.ralasafe.SystemConstant;

public class SimpleValue extends DefineVariable {
	private String type;
	private String value;

	/**
	 * Script likes: Object v = new Integer("value");
	 * SimpleValue type maybe: String, Integer, Float, Double, java.util.Date, Boolean
	 */
	public String toScript() {
		String v = getVariableName();
		String javaClass = null;
		if (type.equals(org.ralasafe.db.sql.SimpleValue.STRING)) {
			javaClass = "String";
		} else if (type.equals(org.ralasafe.db.sql.SimpleValue.INTEGER)) {
			javaClass = "Integer";
		} else if (type.equals(org.ralasafe.db.sql.SimpleValue.FLOAT)) {
			javaClass = "Float";
		} else if (type.equals(org.ralasafe.db.sql.SimpleValue.BOOLEAN)) {
			javaClass = "Boolean";
		} else if (type.equals(org.ralasafe.db.sql.SimpleValue.DATETIME)) {
			javaClass = "java.util.Date";
		} else if(type.equals(org.ralasafe.db.sql.SimpleValue.STRING_LIST) || type.equals(org.ralasafe.db.sql.SimpleValue.INTEGER_LIST)){
			javaClass = "java.util.List";
		}else {
			throw new RalasafeException("Not supported SimpleValue type '" + type + "'.");
		}
		StringBuffer buff = new StringBuffer();
		if (type.equals(org.ralasafe.db.sql.SimpleValue.DATETIME)) {
			buff.append(" " + javaClass + " ").append(v).append(" = ").append(
					SystemConstant.SIMPLE_DATE_FORMAT).append(".parse").append(
					"(\"").append(value).append("\"); ").append("\n");
		} else if(type.equals(org.ralasafe.db.sql.SimpleValue.STRING_LIST)){
			buff.append(" " + javaClass + " ").append(v).append(" = ").append("Arrays.asList(\"").append(value).append("\".split(\",\"));\n");
		}else if(type.equals(org.ralasafe.db.sql.SimpleValue.INTEGER_LIST)){
			String tempVar = "_$temp" + String.valueOf(System.currentTimeMillis()).substring(8);
			buff.append(" " + javaClass + " " + tempVar + " = new ArrayList();\n");
			buff.append("for(String val : \""+value+"\".split(\",\")){\n");
			buff.append(tempVar + ".add(Integer.valueOf(val.trim()));\n");
			buff.append("}\n");
			buff.append(" " + javaClass + " ").append(v).append(" = ").append(tempVar+ ";\n");
		}else {
			buff.append(" " + javaClass + " ").append(v).append(" = new ")
					.append(javaClass).append("(\"").append(value).append(
							"\"); ").append("\n");
		}

		return buff.toString();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
