import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';

import { ProductService } from '../../services/product.service';
import { Product } from '../../common/product';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[];
  currentCategoryId: number;
  searchMode: boolean = false;

  constructor(private productService: ProductService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe( () => {
        this.listProducts();
    })

  }

  listProducts() {
    this.searchMode = this.route.snapshot.paramMap.has('keyword');
    if(this.searchMode){
      this.handleSearchProducts();
    } else {
      this.handleProductList();
    }
  }

  handleProductList(){
    const hasCategoryId: boolean = this.route.snapshot.paramMap.has('id');
    if(hasCategoryId) {
        this.currentCategoryId = +this.route.snapshot.paramMap.get('id');
    } else{
        this.currentCategoryId = 1;
    }
    this.productService.getProductList(this.currentCategoryId).subscribe(
      data => {
        this.products = data;
      }
    )
  }

  handleSearchProducts() {
    const keyword = this.route.snapshot.paramMap.get('keyword');
      this.productService.searchProducts(keyword).subscribe(
        data => {
          console.log('data ' , data);
          this.products = data;
        }
      )
  }
}
