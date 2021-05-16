import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { ProductService } from './services/product.service';
import { ProductMenuComponent } from './components/product-menu/product-menu.component';
import { SearchComponent } from './components/search/search.component';

const routes : Routes = [
  { path : 'category/:id', component : ProductListComponent },
  { path : 'search/:keyword', component : ProductListComponent },
  { path : 'category', component : ProductListComponent },
  { path : 'products', component : ProductListComponent },
  { path : '', redirectTo : '/products', pathMatch : 'full' },
  { path : '**', redirectTo : '/products', pathMatch : 'full' }
]

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    ProductMenuComponent,
    SearchComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
  ],
  providers: [ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
