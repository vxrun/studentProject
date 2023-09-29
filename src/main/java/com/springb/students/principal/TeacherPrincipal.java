package com.springb.students.principal;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.springb.students.entity.Teacher;

public class TeacherPrincipal implements UserDetails {
	private static final long serialVersionUID = 1L;
	private Teacher teacher;
	public TeacherPrincipal(Teacher teacher) {
		this.teacher = teacher;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(teacher.getRole());
		return Arrays.asList(grantedAuthority);
	}

	@Override
	public String getPassword() {
		return teacher.getPassword();
	}

	@Override
	public String getUsername() {
		return teacher.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
