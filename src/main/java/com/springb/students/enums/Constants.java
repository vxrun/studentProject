package com.springb.students.enums;

public class Constants {
	public enum ROLES {
		ADMIN("admin"), STUDENT("student"), TEACHER("teacher"), GUEST("guest");

		private final String value;

		ROLES(final String value) {
			this.value = value;
		}

		public String value() {
			return this.value;
		}
	}
}
