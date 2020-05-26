package com.txx.demo.dto;

/*请求令牌时要提供的参数*/
public class AcessTokenDto {
    private  String client_id;//客户端的 ID
    private  String client_secret;//客户端的密钥
    private  String code;//授权码
    private  String redirect_uri;//令牌颁发后的回调网址
    private  String state;

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
