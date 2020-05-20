package com.zeriter.controller;


import com.zeriter.entity.Result;
import com.zeriter.entity.domin.Menu;
import com.zeriter.service.IMenuService;
import com.zeriter.util.Sequence;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zeriter Zhang
 * @since 2020-05-20
 */
@RestController
@RequestMapping("/menu")
@Slf4j
public class MenuController {
    @Resource
    private IMenuService menuService;

    @PutMapping("/menu")
    public Result save(Menu menu){
        try {
            menu.setMenuId(Sequence.getMenuIdSeq());
            menu.setMenuCode(Sequence.getMenuCodeSeq());
            menuService.save(menu);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
