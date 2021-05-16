import { Component, OnInit } from '@angular/core';

import { ProductCategory } from '../../common/product-category';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'app-product-menu',
  templateUrl: './product-menu.component.html',
  styleUrls: ['./product-menu.component.css']
})
export class ProductMenuComponent implements OnInit {
  categories: ProductCategory[];

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.productService.getProductCategories().subscribe(
      data => {
        this.categories = data;
      }
    )
  }
}
