package com.bandipo.blog_rest_api.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data@NoArgsConstructor
@Entity(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, columnDefinition = "int default 0")
    private int personDeactivated;
    @Column(nullable = false, columnDefinition = "int default 0")
    private int isDeleted;
    @Column(name = "removeDate")
    private String removeDate;


    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts;
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comments;
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PostLike> likes;
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Favourite> favourites;
    @JsonIgnore
    @OneToMany(mappedBy = "follower", cascade = CascadeType.ALL)
    private List<Follow> followers;
    @JsonIgnore
    @OneToMany(mappedBy = "followee", cascade = CascadeType.ALL)
    private List<Follow> followees;

}
