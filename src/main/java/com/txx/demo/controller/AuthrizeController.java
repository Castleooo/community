package com.txx.demo.controller;

import com.txx.demo.dto.AcessTokenDto;
import com.txx.demo.dto.GithubUser;
import com.txx.demo.entity.User;
import com.txx.demo.mapper.UserMapper;
import com.txx.demo.utils.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthrizeController {
     @Autowired
     private GitHubProvider gitHubProvider;
     //@Autowired
    // private UserMapper userMapper;
    @Value("github.client.id")
    private String client_id;
    @Value("github.client.secret")
    private String client_secret;
    @Value("github.redirect.uri")
    private String redirect_uri;

    /*
    在后台请求令牌
    */
    @RequestMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state){
        System.out.println("code"+code);
        System.out.println("state"+state);
    //封装请求参数
         AcessTokenDto acessTokenDto=new AcessTokenDto();
         acessTokenDto.setClient_id(client_id);
         acessTokenDto.setClient_secret(client_secret);
         acessTokenDto.setCode(code);
         acessTokenDto.setRedirect_uri(redirect_uri);
         acessTokenDto.setState(state);
         String  token= gitHubProvider.getAccessToken(acessTokenDto);
         GithubUser user=gitHubProvider.getGithubUer(token);
        System.out.println("name:"+user.getName());
        return "index";

    }

  /*  public GithubUser getUser(String access_token){

    }*/
}
