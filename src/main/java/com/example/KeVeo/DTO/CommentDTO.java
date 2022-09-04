package com.example.KeVeo.DTO;

import com.example.KeVeo.data.entity.FilmEntity;
import com.example.KeVeo.data.entity.UserEntity;
import com.example.KeVeo.utils.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentDTO {

        private Integer id;
        private String content;
        private LocalDateTime creation = DateUtil.stringToDate(DateUtil.dateToString(LocalDateTime.now()));
        private FilmEntity film;
        private UserEntity user;

}
