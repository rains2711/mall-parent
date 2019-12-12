package com.wx.disparent.mallparent.entity;

import lombok.*;

import java.math.BigDecimal;

/**
 * @description 商品实体类
 * @author 刘杰龙
 * @version 1.0
 * @date 2019/12/9 18:34
 */
/**可以用@Data代替@Getter和@Setter*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    /**商品id*/
    private Integer id;

    /**商品名称*/
    private String name;

    /**商品图片*/
    private String image;

    /**商家id*/
    private Integer businessId;

    /**商品价钱*/
    private BigDecimal price;

    /**商品供应商分配比例*/
    private BigDecimal merRatio;

    /**推荐人分配比例*/
    private BigDecimal referRatio;

    /**商品介绍*/
    private String introduce;

    /**是否有效 0 新增，1 上架， 2 下架*/
    private Character isEffect;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getMerRatio() {
        return merRatio;
    }

    public BigDecimal getReferRatio() {
        return referRatio;
    }

    public String getIntroduce() {
        return introduce;
    }

    public Character getIsEffect() {
        return isEffect;
    }
}
