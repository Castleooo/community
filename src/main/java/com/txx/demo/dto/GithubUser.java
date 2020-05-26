package com.txx.demo.dto;
/*
 *github用户
 */

public class GithubUser {
    private String name;//用户名
    private Long id;//用户id
    private  String bio;//个人描述
    public String getName() {

        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getBio() {

        return bio;
    }

    public void setBio(String bio) {

        this.bio = bio;
    }



}
