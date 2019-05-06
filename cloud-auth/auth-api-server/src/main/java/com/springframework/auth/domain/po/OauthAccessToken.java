package com.springframework.auth.domain.po;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author summer
 * @since 2019-05-06
 */
@TableName("oauth_access_token")
public class OauthAccessToken implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableField("token_id")
	private String tokenId;
	private byte[] token;
    @TableId("authentication_id")
	private String authenticationId;
	@TableField("user_name")
	private String userName;
	@TableField("client_id")
	private String clientId;
	private byte[] authentication;
	@TableField("refresh_token")
	private String refreshToken;


	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public byte[] getToken() {
		return token;
	}

	public void setToken(byte[] token) {
		this.token = token;
	}

	public String getAuthenticationId() {
		return authenticationId;
	}

	public void setAuthenticationId(String authenticationId) {
		this.authenticationId = authenticationId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public byte[] getAuthentication() {
		return authentication;
	}

	public void setAuthentication(byte[] authentication) {
		this.authentication = authentication;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public static final String TOKEN_ID = "token_id";

	public static final String TOKEN = "token";

	public static final String AUTHENTICATION_ID = "authentication_id";

	public static final String USER_NAME = "user_name";

	public static final String CLIENT_ID = "client_id";

	public static final String AUTHENTICATION = "authentication";

	public static final String REFRESH_TOKEN = "refresh_token";

}
