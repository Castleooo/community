package com.txx.demo.controller;

import com.txx.demo.dto.AcessTokenDto;
import com.txx.demo.dto.GithubUser;
import com.txx.demo.entity.User;
import com.txx.demo.mapper.UserMapper;
import com.txx.demo.utils.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthrizeController {
     @Autowired
     private GitHubProvider gitHubProvider;
     @Autowired
     private UserMapper userMapper;

    @RequestMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state){
        AcessTokenDto acessTokenDto=new AcessTokenDto();
         acessTokenDto.setClient_id("b79f62cb35784eb3d84b");
         acessTokenDto.setClient_secret("05a532f517d8006b08ae58245f867873343123ea");
         acessTokenDto.setCode(code);
         acessTokenDto.setRedirect_uri("http://localhost:8080/callback");
         acessTokenDto.setState(state);
         gitHubProvider.getAccessToken(acessTokenDto);
        return "index";
    }

  /*  public GithubUser getUser(String access_token){

    }*/
}
