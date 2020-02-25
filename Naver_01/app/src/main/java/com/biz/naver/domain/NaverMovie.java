package com.biz.naver.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class NaverMovie {

    @SerializedName("lastBuildDate")
    @Expose
    private String lastBuildDate;

    @SerializedName("total")
    @Expose
    private String total;

    @SerializedName("start")
    @Expose
    private String start;

    @SerializedName("display")
    @Expose
    private String display;

    @SerializedName("items")
    List<NaverMovieItem> items = null;

}
