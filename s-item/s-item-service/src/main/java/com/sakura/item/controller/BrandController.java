package com.sakura.item.controller;

import com.sakura.common.PageResult;
import com.sakura.item.po.Brand;
import com.sakura.item.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author chenpingping
 * @version 1.0
 * @date 2021/4/14 10:38
 */
@RestController
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("page")
    public ResponseEntity<PageResult<Brand>> queryBrandByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", defaultValue = "false") Boolean desc,
            @RequestParam(value = "key", required = false) String key) {
        PageResult<Brand> result = this.brandService.queryBrandByPageAndSort(page,rows,sortBy,desc, key);
        if (result == null || result.getItems().size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }

    /**
     * 保存商品信息
     * @param brand
     * @param cids
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> saveBrand(Brand brand, @RequestParam("cids") List<Long> cids){
        this.brandService.saveBrand(brand, cids);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    /**
     * 删除商品信息
     * @return
     */
    @DeleteMapping("id/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable("id") Long id){
        System.out.println(id);

        int i = this.brandService.deleteBrand(id);
        if (i>0)
            return ResponseEntity.status(HttpStatus.OK).build();
        else return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }
}
