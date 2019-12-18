import { Injectable } from '@angular/core';

import { Product } from "./product";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { httpOptions } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private productUrl: string = "http://localhost:8080/products";

  constructor(
    private http: HttpClient
  ) { }

  getProducts(): Promise<Product[]> {
    return this.http.get<Product[]>(
      this.productUrl,
      httpOptions
    ).toPromise();
  }

}
