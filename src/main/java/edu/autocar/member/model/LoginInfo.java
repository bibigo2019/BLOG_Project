package edu.autocar.member.model;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginInfo {
	@NotEmpty(message = "사용자 ID는 필수 항목입니다.")
	private String memberId;
	@NotEmpty(message = "비밀번호는 필수 항목입니다.")
	private String password;

	private String reason;
	private String target;
}