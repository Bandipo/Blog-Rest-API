package com.bandipo.blog_rest_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @JoinColumn(name = "user_id")
    @ManyToOne()
    @JsonIgnore
    private User user;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;
    @JsonIgnore
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostLike> likes;
    @JsonIgnore
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Favourite> favourites;
}
