import { Injectable } from '@angular/core';
import { Product } from './product';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { httpOptions } from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class BasketService {

  private url: string = "http://localhost:8080";

  constructor(
    private http: HttpClient
  ) { }


  addToBasket(product: Product): Promise<Product> {
    return this.http.post<Product>(
      this.url + "/addtobasket",
      product,
      httpOptions
    ).toPromise();
  }
}
