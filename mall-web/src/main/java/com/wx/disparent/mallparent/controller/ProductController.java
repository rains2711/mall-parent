package com.wx.disparent.mallparent.controller;

import com.wx.disparent.mallparent.entity.ProductEntity;
import com.wx.disparent.mallparent.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description 商品控制层
 * @author 刘杰龙
 * @version 1.0
 * @date 2019/12/10 10:28
 */
@RestController
@RequestMapping("/admin/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 新增商品
     * @param productEntity
     * @return 执行结果
     */
    @RequestMapping("/add")
    public String addUser(@RequestParam ProductEntity productEntity){
        String result;
        int insert = productService.insert(productEntity);
        if (insert > 0){
            result = "success";
        } else {
            result = "failure";
        }
        return result;
    }

    /**
     * 获取所有商品信息
     * @return 商品集合
     */
    @RequestMapping("/getAll")
    public ModelAndView getAll(){
        ModelAndView model = new ModelAndView();
        List<ProductEntity> entities = productService.findAll(null);
        model.addObject("products",entities);
        model.setViewName("web/goodsListPage");
        return model;
    }

    /**
     * 获取所有商品信息
     * @return 商品集合
     */
    @RequestMapping("/getAllByName")
    public List<ProductEntity> getAll(@RequestParam(value = "name") String productName){
        Map<String, Object> map = new HashMap<>();
        map.put("name",productName);
        List<ProductEntity> entities = productService.findAll(map);
        return entities;
    }

    /**
     * 修改商品状态（上架、下架）
     * @return 商品集合（更改后）
     */
    @RequestMapping("/sellOrSold")
    public ModelAndView sellOrSold(@RequestParam(value = "id") String productId,@RequestParam(value = "type") String type){
        if (type.equals("0")){
            productService.changeStatus(Integer.valueOf(productId),"sell");
        }else if (type.equals("1")){
            productService.changeStatus(Integer.valueOf(productId),"sold");
        }

        ModelAndView model = new ModelAndView();
        List<ProductEntity> entities = productService.findAll(null);
        model.addObject("products",entities);
        model.setViewName("web/goodsListPage");
        return model;
    }

    /**
     * 修改或添加商品信息
     * @return 商品信息
     */
    @RequestMapping("/addOrModify")
    public ModelAndView addOrModify(@RequestParam(value = "id",required = false) String productId){
        ModelAndView model = new ModelAndView();

        ProductEntity productEntity = null;
        if (productId != null && !productId.equals("")){
            productEntity = productService.findById(Integer.parseInt(productId));
//            Integer businessId = productEntity.getBusinessId();
        }

        model.addObject("product",productEntity);
//            model.addObject("userEntity",productEntity);
        model.setViewName("web/goodsInformationPage");
        return model;
    }
}
