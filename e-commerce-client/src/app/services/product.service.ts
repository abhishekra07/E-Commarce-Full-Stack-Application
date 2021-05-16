import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import  { Observable } from 'rxjs';
import { Product } from '../common/product';
import { ProductCategory } from '../common/product-category';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = "http://localhost:8081/api";

  constructor(private http: HttpClient) { }

  getProductList(categoryId: number): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.baseUrl}/products/category/${categoryId}`);
  }

  getProductCategories(): Observable<ProductCategory[]> {
    return this.http.get<ProductCategory[]>(`${this.baseUrl}/product-category`);
  }

  searchProducts(keyword: string): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.baseUrl}/products/search?name=${keyword}`);
  }
}
