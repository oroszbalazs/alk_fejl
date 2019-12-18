import { Component, OnInit } from '@angular/core';
import { Product } from "../product";
import { ProductService } from '../product.service';
import { BasketService } from '../basket.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[] = []
  selectedProduct = null;

  constructor(
    private productService: ProductService,
    private basketService: BasketService,
    private authService: AuthService
  ) { }

  async ngOnInit() {
    this.products = await this.productService.getProducts();
  }

  async toBasket(product: Product) {
    await this.basketService.addToBasket(product);
  }

}
