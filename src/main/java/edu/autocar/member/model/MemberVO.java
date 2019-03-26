package edu.autocar.member.model;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberVO {
	@NotEmpty(message="사용자 ID는 필수 항목입니다.")
	private String memberId;
	@NotEmpty(message="비밀번호는 필수 항목입니다.")
	private String password;
	@NotEmpty(message="이름은 필수 항목입니다.")
	private String name;
	private String admin;
	private String address;
	private String phone;
	@NotEmpty(message="Email은 필수 항목입니다.")
	@Email(message="Email 형식이 아닙니다.")
	private String email;
	private String salt;
	private int blogId;
	byte[] avata;
	private Date regDate;
	private Date updateDate;
	
	public MemberVO() {
		admin = "N";
	}
	
	public boolean adminIs() {
		return admin == "Y";}

}